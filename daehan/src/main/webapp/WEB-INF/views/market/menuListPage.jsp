<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--propper jquery -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!--latest javascript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2 class="text-center">${userId} 메뉴 리스트 </h2>
<hr/><br/>

<a href="/market/menuInsertPage">새 메뉴 등록하기</a>
<table border="1" class="text-center">
	<tr>
		<th>No.</th>
		<th>메뉴명</th>
		<th>가격</th>
		<th>소개</th>
		<th>누적 주문 건수</th>
		<th>메뉴 등록일</th>
		<th>메뉴 수정</th>
		<th>메뉴 삭제</th>
	</tr>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.menuId}</td>
			<td>${list.menuName}</td>
			<td>${list.menuPrice}</td>
			<td>${list.introduce}</td>
			<td>${list.sm}</td>
			<td>${list.sysRegDate}</td>		
			<th>
				<a id="menuUpdateBtn"  class="btn btn-success" type="button" 
				href="/market/menuUpdatePage?menuId=${list.menuId}&marketId=${userId}" >x</a>
			</th>
			<th>
				<a id="menuDeleteBtn"  class="btn btn-danger" type="button" 
				href="/market/menuDelete?menuId=${list.menuId}&marketId=${userId}&sysRegDate=${list.sysRegDate}" >x</a>
			</th>
		</tr>
	</c:forEach>
</table>

</body>
</html>