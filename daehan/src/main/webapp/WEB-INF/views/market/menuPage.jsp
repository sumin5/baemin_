<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<h2 class="text-center">${marketId} 메뉴 입력 페이지</h2>
<hr/><br/>

<div>
<form action="/market/menuInsertion" method="post">
	<div class="form-group">
		<label for="marketId">음식점아이디</label>
		<input class="form-control" type="text" id="marketId" name="marketId" value="${mar0m-group">
		<label for="menuName">메뉴 이름</label>
		<input class="form-control" type="text" id="menuName" name="menuName" />
	</div>
	
	<div class="form-group">
		<label for="menuPrice">가격</label>
		<input class="form-control" type="text" id="menuPrice" name="menuPrice" />
	</div>
	
	<div class="form-group">
		<label for="introduce">소개</label>
		<textarea class="form-control" type="text" id="introduce" name="introduce" ></textarea>
	</div>
	
	<button class="btn btn-primary">저장</button>
	<button type="reset" class="btn btn-danger">취소</button>
	
</form>
</div>


</body>
</html>