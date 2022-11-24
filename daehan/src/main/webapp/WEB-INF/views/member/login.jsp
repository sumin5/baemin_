<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>LOG IN</title>
</head>

<style>
/* #header{
	text-align:center;
	font-size:40px;
} */
	#header{
		text-align:center;
		font-size:40px;
	}

   *{
      	box-sizing:border-box;
      	font-family:'Noto Sans KR', sans-serif;
   }

#menu{
	text-align:center;
	padding: 15px;
	margin: 30px;
}
#home, #signup, #list{
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

#login-form{
	border-radius:5px;
	padding:20px;
	margin:0 auto;
	width:350px;
	border:0;
	background-color:#EEEFF1;
}
     
#login_area{
   
	display : grid;
	place-items:center; 
	justify-content : center; /* 그리드를 화면 가운데로 */
	grid-template-columns: 120px 200px ;
	grid-template-rows: 35px 35px ;
}
#buttons{
	text-align:center;
	margin: 5px;
}
#login_button, #logout_button{
	cursor:pointer;
	text-align:center;

    background: whitesmoke;
    border: none;
    padding: 5px 10px;
    margin: 5px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    background-color: #a3a1a1;
    color: #e3dede;
}
#welcome{
	text-align:center;
	font-size:45px;
	font-weight:bold;
}

</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

	
	/* 로그인 빈칸 여부 체크 */
	function login() {
		if($("#userid").val() ==''){alert("아이디를 입력하세요."); $("#userid").focus(); return false; }
		if($("#userpassword").val() ==''){alert("비밀번호를 입력하세요."); $("#userpassword").focus(); return false; }
		console.log("login 진입");
		idcheck();
		
	}
	/* 아이디와 비밀번호 일치 여부 체크 */
	function idcheck() {
		console.log("아이디체크 진입");
	      $.ajax({
	          url : "/member/login", //전송할 url
	          type : "post", //전송할 메서드 타입
	          dataType : "text", //"json", //전송할 데이터 타입 안정하면 기본 xml형식
	          data : {"userid" : $("#userid").val() ,
	        	  "userpassword" : $("#userpassword").val()
	        	  }, ////전송할 데이터
	          success : function(id){
	        	  console.log(id);
	             if(id ==  ""){
	                alert("일치하는 회원정보가 없습니다.");
	                $("#userid").val("").focus();
	             }else if(id != ""){
	                //location.href = '/board/list';
	                document.getElementById('login_first').style.visibility="hidden"; //hide
	                console.log("id값은? " + id);
	                $("#welcome").html(id);
	                $("#userid1").val(id);
	                $("#login_welcome").show();
	             }else if(id =="ID_NOT_FOUND"){
	                $("#notFound").show();
	            	 
	             }
	          }
	       });
	}	
	/* 로그아웃 */
	function logout(){
		$.ajax({
			url : "/member/logout",
			success : function() {
				location.href = "/";
			}
		})
	}
</script>


<body>

<%-- ${message}
${test}

${FlashMessage} --%>

<div id="header">
<h1>LOG-IN</h1>
</div>

<div id="menu">
	<a href="/" id="home">홈</a>
	<a href="/member/signup" id="signup">회원가입</a>
</div>

<!-- 로그인 폼 -->
<div id="login-form" class="login-form">
	<div id="login_first">
		<form id="login_area" method="post"> 
			<label>ID</label>
			<input type="text" id="userid" name="userid" class="userid" placeholder="아이디를 입력하세요.">
			 <!-- 비밀번호 안보이게 type을 text에서 password로 변경 -->
			 <label>PASSWORD</label>
			<input type="password" id="userpassword" name="userpassword" class="userpassword" placeholder="비밀번호를 입력하세요.">
		</form>
		<div class="links">
			<a href=#>비밀번호를 잃어버리셨나요?</a>
		</div>
	</div>

	<div id="login_welcome" class="login_welcome" style="display:none">
		<div id="welcome" value=""></div>님! 환영합니다!
		<form action="/member/detailPage" method="post">
			<input type="hidden" id="userid1" name="userid" value="">
			<input type="submit" value="회원상세등록">
		</form>
		
		</div>
	</div>
	
	<div id="buttons">
	<form method="post">
		<input type="button" value="LOGIN" id="login_button" onclick="login()">
		<input type="button" value="LOGOUT" id="logout_button" onclick="logout()">
	</form>
	</div>
	
	
</div>
	




</body>
</html>

