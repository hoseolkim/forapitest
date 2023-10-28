<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody id="listBody">
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<span id="pagingArea"></span>
				<div id="searchUI"  class="row g-3 d-flex justify-content-center">
					<div class="col-auto">
						<select name="searchType" class="form-select">
							<option value>전체</option>
							<option label="제목" value="title" />
							<option label="작성자" value="writer" />
							<option label="내용" value="content" />
						</select>
					</div>
					<div class="col-auto">
						<input name="searchWord" class="form-control" placeholder="검색키워드"/>
					</div>
					<div class="col-auto">
						<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
						<a href="<c:url value='/board/new'/>" class="btn btn-success">신규 게시글 등록</a>
					</div>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<form action="<c:url value='/board/data'/>" id="searchForm">
	<input type="text" name="searchType" readonly/>
	<input type="text" name="searchWord" readonly/>
	<input type="text" id="currpage" name="page" readonly="readonly" placeholder="page"/>
</form>
<script>

	
	
	var makeTrtags = (board)=>{
		let cPath = $(document.body).data("contextPath");
		let boDate = board.boDate;
		let dateFormat = `\${boDate[0]}-\${boDate[1]}-\${boDate[2]}T\${boDate[3]}:\${boDate[4]}:\${boDate[5]}`;
		let trCode =`
		<tr>
			<td>\${board.boNo}</td>
			<td><a href="\${cPath}/board/\${board.boNo}">\${board.boTitle} [\${board.fileCnt}]</a></td>
			<td>\${board.boWriter}</td>
			<td>\${dateFormat}</td>
			<td>\${board.boHit}</td>
		</tr>
		`;
		return trCode;
	}
	
	$(searchForm).on("submit",function(event){
		event.preventDefault();
		let url = this.action;
		let data = $(this).serialize();
		$.getJSON(url,data)
			.done(function(resp){
				let paging = resp.paging;
				let dataList = paging.dataList;
				let code = "";
				if(dataList?.length){
					$.each(dataList,function(i,board){
						code += makeTrtags(board);
					})
				}else{
					code += "<tr><td colspan='5'>조회된 게시글이 없습니다.</td></tr>"
				}
				$(pagingArea).html(paging.pagingHTML);
				$(listBody).html(code);
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


