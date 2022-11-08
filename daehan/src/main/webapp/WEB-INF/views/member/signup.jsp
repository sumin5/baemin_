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
<script type="text/javascript">
/* 회원가입 제한 설정 */
function signup_test(){
	console.log("signup_test 진입");
	
	if($("#userid").val() == ''){alert("아이디를 입력하세요."); $("#userid").focus(); return false;}
	if($("#userpassword").val() == ''){alert("비밀번호를 입력하세요."); $("#userpassword").focus(); return false;}
	
	/* 비밀번호 길이 설정 */
	var pwdlength = document.getElementById('userpassword').value;
	if(pwdlength.length < 4 || pwdlength.length > 20) {alert("4~20자리의 비밀번호를 입력하세요."); return false;}
	
	if($("#username").val() == ''){alert("이름을 입력하세요."); $("#username").focus(); return false;}
	if($("#telno").val() == ''){alert("전화번호를 입력하세요."); $("#telno").focus(); return false;}
	if($("#email").val() == ''){alert("이메일을 입력하세요."); $("#email").focus(); return false;}
	if(id_same == ""){alert("아이디 중복 체크 하세요."); $("#userid").focus(); return false;}
	if(id_same == "1"){alert("다른 아이디를 입력하세요."); $("#userid").focus(); return false;}

	/* 0701 */
	$("#signup-form").attr("action","/member/signup").submit();
}

/* 중복 아이디 체크 */
var id_same="";
function idsame() {
	if($("#userid").val() == '') {alert("아이디를 입력하세요."); $("#userid").focus(); return false;}
	$.ajax({
		url : "/member/idsame",
		type : "post",
		dataType : "text",
		data : {"userid" : $("#userid").val()},
		success : function(result){
			if(result == "1"){
				alert("이미 존재하는 아이디입니다");
				id_same = "1";
			}else if(result == "0"){
				alert("사용 가능한 아이디입니다.");
				id_same = "2";
			}
		}
	});
}

</script>


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
	<form id="signup-form" method="post">
		<label>ID</label>
			<input id="userid" class="userid" name="userid" placeholder="아이디를 입력하세요"/> 	
			<input type="button" class="idsame"  value="아이디 중복 체크" onclick="idsame()">
		<label>PASSWORD</label>
			<input type="password" id="userpassword" class="userpassword" name="userpassword" placeholder="비밀번호를 입력하세요"/> <br> 
		<label>NAME</label>
			<input type="text" id="username" class="username" name="username" placeholder="이름을 입력하세요"/> <br>
		<label>PHONE NUMBER</label>
			<input id="telno" class="telno" name="telno" placeholder="휴대전화 번호를 입력하세요"/> <br>
		<label>E-MAIL</label>
			<input id="email" class="email" name="email" placeholder="이메일을 입력하세요"/> <br> <br>	
		<label>Address</label>
			<input id="address" class="address" name="address" placeholder="주소를 입력하세요"/> <br> <br>		
		<label>권한</label>
			<select name="authority_code">
				<option value="none">선택하세요</option>
				<option value="1">관리자</option>
				<option value="2">판매자</option>
				<option value="3">구매자1</option>
			</select>		
	</form>
</div>
	
	<div class = "button" >
		<input class = "submitbutton" type="button" value="회원가입 하기" onclick="signup_test()">
	</div>



</body>
</html>

