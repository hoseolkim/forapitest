<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<table class="table table-bordered">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>제조사명</th>
			<th>분류</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>팩스</th>
			<th>메일</th>
		</tr>
	</thead>
	<tbody id="listBody">
		
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">
				<span id="pagingArea"></span>
				<div id="searchUI"  class="row g-3 d-flex justify-content-center">
					<div class="col-auto">
						<select name="buyerLgu" class="form-select">
							<option value>상품분류</option>
							<c:forEach items="${lprodList }" var="lprod">
								<option label="${lprod.lprodNm }" value="${lprod.lprodGu }" />
							</c:forEach>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="buyerAdd1" placeholder="소재지" class="form-control"/>
					</div>
					<div class="col-auto">
						<input type="text" name="buyerName" placeholder="제조사명" class="form-control"/>
					</div>
					<div class="col-auto">
						<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
						<a href="<c:url value='/buyer/form'/>" class="btn btn-success">신규제조사 등록</a>
					</div>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<form action="<c:url value='/buyer/listData'/>" id="searchForm" class="border">
	<h4>전송 UI</h4>
	<input type="text" name="buyerLgu" readonly="readonly" placeholder="buyerLgu"/>
	<input type="text" name="buyerAdd1" readonly="readonly" placeholder="buyerAdd1"/>
	<input type="text" name="buyerName" readonly="readonly" placeholder="buyerName"/>
	<input type="text" id="currpage" name="page" readonly="readonly" placeholder="page"/>
</form>

<script>

function makeTrTag(buyer){
	let cPath = document.body.dataset.contextPath;
	let buyerViewUrl = `\${cPath}/buyer/\${buyer.buyerId}`;
	let trCode = `
	<tr>
		<td>\${buyer.rnum}</td>
		<td><a href="\${buyerViewUrl}">\${buyer.buyerName}</a></td>
		<td>\${buyer.lprod.lprodNm}</td>
		<td>\${buyer.buyerAdd1} \${buyer.buyerAdd2}</td>
		<td>\${buyer.buyerComtel}</td>
		<td>\${buyer.buyerFax}</td>
		<td>\${buyer.buyerMail}</td>
	</tr>
	`;
	return trCode;
}


$(searchForm).on("submit", function(event){
	event.preventDefault();
	let url = this.action;
	let data = $(this).serialize();
	$.getJSON(`\${url}?\${data}`)
		.done(function(resp){
			let buyerList = resp.paging.dataList;
			let trTags = "";
			if(buyerList.length > 0){
				$.each(buyerList, function(idx, buyer){
					trTags += makeTrTag(buyer); 
				});
				$(pagingArea).empty();
				$(pagingArea).html(resp.paging.pagingHTML);
			}else{
				trTags += `
					<tr>
						<td colspan="7">제조사 없음.</td>
					</tr>
				`;
				$(pagingArea).empty();
			}
			$(listBody).html(trTags);
			
		});
}).submit();
function fn_paging(page){
	searchForm.page.value = page;
	searchForm.requestSubmit();
	searchForm.page.value = "";
}
$(searchUI).on("click", "#searchBtn", function(event){
	let inputs = $(this).parents("#searchUI").find(":input[name]");
	$.each(inputs, function(idx, ipt){
		let name = ipt.name;
		let value = $(ipt).val();
		$(searchForm).find(`:input[name=\${name}]`).val(value);
	});
	$(searchForm).submit();
});
</script>





