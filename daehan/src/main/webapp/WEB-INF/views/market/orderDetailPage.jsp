<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
orderDetailPage.jsp입니다

<c:forEach items="${arrdto }" var="arrdto">
	1. ${arrdto.test1 }<br/>
	2. ${arrdto.test2 }<br/>
	3. ${arrdto.test3 }<br/>
	========================<br>
</c:forEach>

</body>
</html>