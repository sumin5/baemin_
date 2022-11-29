
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>자바 스프링을 이용한 게시판 작성</title>

<script>

function loginCheck(){

	if(document.loginForm.user_id.value == '') 
		{
		alert('아이디를 입력하세요.');
		document.loginForm.user_id.focus();
		return false;
		}
	var Passwd = document.getElementById('user_password').value;
    if(Passwd == '')
    	{
    	alert('비밀번호를 입력하세요.');
    	document.loginForm.user_password.focus();
    	return false;
    	}
    document.loginForm.action = '/member/login';
    document.loginForm.submit();
}

function press() {
	
	if(event.keyCode == 13){ loginCheck(); }
	
}

</script>
<style>
body { font-family: "나눔고딕", "맑은고딕" }
h1 { font-family: "HY견고딕" }
a:link { color: black; }
a:visited { color: black; }
a:hover { color: blue; }
a:active { color: red; }
#hypertext { text-decoration-line: none; cursor: hand; }
#topBanner {
       margin-top:10px;
       margin-bottom:10px;
       max-width: 500px;
       height: auto;
       display: block; margin: 0 auto;
}
   
.loginForm {
  /* position:absolute; */
  width:900px;
  height:auto;
  padding: 20px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  /* top:50%; 
  left:50%;
  transform: translate(-50%,-50%);
  */
  border:5px solid gray;
  border-radius: 30px;
}   
   
.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.nameForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.titleForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.passwdForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.user_id, .username, .user_password {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.bottomText {
  text-align: center;
  font-size: 20px;
}

.login_btn  {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.navi_top_tbl {
	width: 800px;
	text-align: right;
}

.navi_bottom_tbl {
	width: 800px;
	text-align: center;
}


</style>

	
</head>

<body>

<div class="home_body_div" align=center>

	<form name="loginForm" method="post" class="loginForm" onsubmit="loginCheck()">
     
     <c:if test="${member == null}">
     	<h1>로그인</h1>
     	<div class="loginFormDivision">
         	<div class="idForm"><input type="text" name="user_id" id="user_id" class="user_id" placeholder="아이디를 입력하세요."></div>
         	<div class="passwdForm"><input type="password" id="user_password" name="user_password" class="user_password" onkeydown="press(this.form)" placeholder="비밀번호를 입력하세요."></div>
         	<input type="button" id="login_btn" class="login_btn" value="로그인" onclick="loginCheck()"> 
     	</div> 
     
     	<div class="bottomText">사용자가 아니면 ▶<a id="hypertext" href="/board/mbrInfoRegister" 
     	       onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
     	       onmouseout="this.style.background='white'; this.style.textDecoration='none';">여기</a>를 눌러 등록을 해주세요.<br><br></div>
     </c:if>
     
     <c:if test="${message == false}">
         <p style="color:red;">로그인 에러 !!! 아이디와 패스워드를 확인하세요.</p>
     </c:if>

	</form>


</div>

</body>
</html>
