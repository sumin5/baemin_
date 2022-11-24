<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>

<style>
#header{
	text-align:center;
	font-size:50px;
}

#menu{
	text-align:center;
	padding: 15px;
	margin: 30px;
}
#login, #signup, #list, #write{
	cursor:pointer;
	text-align:center;
    background: whitesmoke;
    border: none;
    padding: 10px 30px;
    border-radius: 10px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    background-color: #a3a1a1;
    color: #e3dede;
}
</style>

<body>
<div id="header">
<h1>
	배민 연습용 
</h1>
</div>



<hr>
<br>
	
<div id="menu">
	<!-- <button><a href="/board/list">리스트로 이동!</a></button> --> <!-- 버튼 안 글씨에 밑줄 O -->
	<a href="/member/login" id="login">로그인</a> <!-- 버튼 안 글씨에 밑줄 X -->
	<a href="/member/signup" id="signup">회원가입</a> <!-- 버튼 안 글씨에 밑줄 X -->
</div>


<!-- <a href="/board/update">글쓰기 업데이트로 이동!</a> -->
<!-- <button><a href="/board/list">리스트로 이동!</a></button>
<a href="/board/write"><button>글쓰기로 이동!</button></a> -->
</body>
</html>
