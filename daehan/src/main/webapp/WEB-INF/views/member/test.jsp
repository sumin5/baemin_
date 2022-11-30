<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>SIGN UP</title>
</head>

<style>
#header{
	text-align:center;
	font-size:40px;
}
#menu{
	text-align:center;
	padding: 15px;
	margin: 30px;
}
#home, #login, #list{
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
#signup{
	text-align:center;
}
#signup-form{
	border-radius:5px;
	padding:20px;
	margin:0 auto;
	width:500px;
	border:0;
	background-color:#EEEFF1;
   
	display : grid;
	place-items:center; 
	justify-content : center; /* 그리드를 화면 가운데로 */
	grid-template-columns: 150px 200px 120px;
	grid-template-rows: 35px 35px 35px 35px 35px;
}

.button{
	text-align:center;
}
.submitbutton{
	cursor:pointer;
	text-align:center;

    /* box-sizing: border-box; */
    background: whitesmoke;
    border: none;
    /* display: inline-block; */
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    /* transition: 0.25s; */
    margin: 30px;
    
  
    /* background-color: #6aafe6;
    color: #d4dfe6; */
    
    background-color: #a3a1a1;
    color: #e3dede;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



<body>

<%-- ${message}
${test}

${FlashMessage} --%>

<div id="header">
	<h1>SIGN UP</h1>
</div>


<div id="menu">
	<a href="/" id="home">홈</a>
	<a href="/member/login" id="login">로그인</a>
</div>


<!-- 회원정보 가입란 -->
<div id="signup-formm">
	<form id="signup-form" method="post" action="test">
		<label>ID</label>
			<input id="userId" class="userId" name="userId" placeholder="아이디를 입력하세요"/> 	
			
		  <div class="form-group" id="checkboxform" style="text-align: center;" >
				<label for="ad-method"> 마케팅 활용 및 광고성 정보 수신 동의</label>
				<input type="checkbox" id="ad-method" name="email" value="Y">이메일
				<input type="checkbox" id="ad-method" name="sms" value="Y">문자
				<input type="checkbox" id="ad-method" name="kakaotalk" value="Y">카카오톡
				<input type="checkbox" id="ad-method" name="phonecall" value="Y">전화 
			</div>	
			<button type="submit" class="btn btn-success">입력</button>
	</form>
</div>
	
	 



</body>
</html>

