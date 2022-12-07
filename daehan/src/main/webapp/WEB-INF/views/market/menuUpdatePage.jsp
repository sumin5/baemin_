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


<h2 class="text-center">${menuDto.menuName} - 메뉴 정보 수정 </h2>
<hr/><br/>


<div>
<form action="/market/menuUpdate" method="post">
	<div class="form-group">
		<label for="marketId">음식점아이디</label>
		<input class="form-control" type="text" id="marketId" name="marketId" value="${menuDto.marketId}" readonly>
	</div>
	
	<div>
		<label for="menuName">메뉴 이름</label>
		<input class="form-control" type="text" id="menuName" name="menuName" value="${menuDto.menuName}"/>
		<input type="hidden" id="menuId" name="menuId" value="${menuDto.menuId}" />

	</div>
	
	<div class="form-group">
		<label for="menuPrice">가격</label>
		<input class="form-control" type="text" id="menuPrice" name="menuPrice" value="${menuDto.menuPrice}"/>
	</div>
	
	<div class="form-group">
		<label for="introduce">소개</label>
		<textarea class="form-control" id="introduce" name="introduce" >${menuDto.introduce}</textarea>
	</div>
	
	<button class="btn btn-success">수정</button>
	<button type="reset" class="btn btn-danger">취소</button>
	
</form>
</div>


</body>
</html>