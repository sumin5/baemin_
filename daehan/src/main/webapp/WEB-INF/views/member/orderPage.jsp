<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

member/orderPage �Դϴ�


    <button id="apibtn">īī�����̷� �����ϱ�</button>

</body>

<script type="text/javascript">

$(function () {
	$('#apibtn').click(function name() {
		$.ajax({
			url : '/member/kakaopay.cls',
			dataType : "json",
			success : function (data) {
				var box = data.next_redirect_pc_url;
				window.open(box);
			},
			error : function (error) {
				alert(error);
			}
		})
	})
})
</script>
</html>