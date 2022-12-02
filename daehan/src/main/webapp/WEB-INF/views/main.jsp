<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="navi_top">

	<c:if test="${authorityCode == '3'}">
		<h2 class="text-center">${userId} 유저 페이지</h2><hr/>
		<%@ include file="include/nav_top.jsp" %>
	</c:if>
	
	<c:if test="${authorityCode != '3'}">
		<h2 class="text-center">${userId} 음식점 사장님 페이지</h2><hr/>
		<%@ include file="include/market_nav_top.jsp" %>
	</c:if>
	
</div>



main 페이지

</body>
</html>