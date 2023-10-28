<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<table class="table">
<c:url value="/buyer/${buyerId }" var="updateUrl" />
<form:form action="${updateUrl }" method="post" modelAttribute="buyer" enctype="multipart/form-data" >
	<input type="text" name="_method" value="put" />
<!--
	<input type="text" name="buyerId" value="" />
	경로변수 이름에 buyerId를 사용한다면 굳이 이렇게 넘길 필요 없다.
	알아서 넣어줌
-->
	<tr>
			<th>사업자등록증사본</th>
			<td>
				<input type="file" name="buyerImage" id="buyerImage" class="form-control" accept="image/*" />
			</td>
		</tr>
		<tr>
			<th><label for="buyerName"><spring:message code="buyer.buyerName" /> </label></th>
			<td><form:input type="text" path="buyerName"
					class="form-control"  />
				<form:errors path="buyerName" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerLgu">분류</label></th>
			<td>
				<form:select path="buyerLgu" items="${lprodList }" cssClass="form-select" itemLabel="lprodNm" itemValue="lprodGu" />
				<form:errors path="buyerLgu" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th><label for="buyerBank">은행</label></th>
			<td><form:input type="text" path="buyerBank"
					class="form-control" />
				<form:errors path="buyerBank" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerBankno">계좌</label></th>
			<td><form:input type="text" path="buyerBankno"
					class="form-control" />
				<form:errors path="buyerBankno" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerBankname">계좌주</label></th>
			<td><form:input type="text" path="buyerBankname"
					class="form-control" />
				<form:errors path="buyerBankname" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerZip">우편번호</label></th>
			<td><form:input type="text" path="buyerZip" class="form-control" />
				<form:errors path="buyerZip" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerAdd1">주소1</label></th>
			<td><form:input type="text" path="buyerAdd1"
					class="form-control" />
				<form:errors path="buyerAdd1" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerAdd2">주소2</label></th>
			<td><form:input type="text" path="buyerAdd2"
					class="form-control" />
				<form:errors path="buyerAdd2" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerComtel">전번</label></th>
			<td><form:input type="text" path="buyerComtel"
					class="form-control"  />
				<form:errors path="buyerComtel" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerFax">팩스</label></th>
			<td><form:input type="text" path="buyerFax" class="form-control"
					 />
				<form:errors path="buyerFax" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerMail">메일</label></th>
			<td><form:input type="text" path="buyerMail"
					class="form-control"  />
				<form:errors path="buyerMail" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerCharger">담당자</label></th>
			<td><form:input type="text" path="buyerCharger"
					class="form-control" />
				<form:errors path="buyerCharger" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<th><label for="buyerTelext">내선번호</label></th>
			<td><form:input type="text" path="buyerTelext"
					class="form-control" />
				<form:errors path="buyerTelext" element="span" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<div class="row g-2 d-flex justify-content-center mt-1">
					<div class="col-auto">
						<button type="submit" class="btn btn-primary">저장</button>
					</div>
					<div class="col-auto">
						<button type="reset" class="btn btn-warning">취소</button>
					</div>
					<div class="col-auto">	
						<a class="btn btn-secondary" href="<c:url value='/buyer'/>">목록으로</a>
					</div>		
				</div>
			</td>
		</tr>
</form:form>
</table>