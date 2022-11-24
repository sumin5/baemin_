<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<title>SIGN UP</title>
<!-- 지도 API (다음) -->	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execPostCode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            	  // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.               
                
                
                // 우편번호 주소그룹 코도 앞에 2글자
                $("[name=address_code_group_id]").val(data.zonecode[0]+data.zonecode[1]);
                // 우편번호 주소 코드아이디 1글자
                $("[name=address_code_id]").val(data.zonecode[2]);
                
                $("[name=delivery_zipcode]").val(data.zonecode);
                $("[name=delivery_road]").val(fullRoadAddr);
                
                

            }
        }).open();
    }
    
 // 약관 동의 체크박스 ajax
    $(document).ready(function() {
    $("#agree").on('click', function() {
          if ( $(this).prop('checked') ) {
            document.getElementById("agree").setAttribute("value", 'check');
          } else {
        	document.getElementById("agree").setAttribute("value", 'noncheck');
          }
        });
    });   
</script>
</head>

<body>
<div class="container join-container p-5">
        <h3 class="text-center">회원 상세 수정 페이지</h3>
        <form action="/member/detailInsert" method="post">
            <div class="form-group pt-4">
                <label for="user_id">아이디</label>
                <div class="d-flex">
	                <input type="text" id="user_id" class="form-control" name="user_id" value="${user_id}" readonly="readonly" >
                </div>
			</div>
            	
            <div class="form-group pt-3">
                <label for="bank_name">은행명</label>
                <input type="text" id="bank_name" class="form-control" name="bank_name" placeholder="은행명" required>
            </div>
            <div class="form-group pt-3">
                <label for="bank_number">계좌번호</label>
                <input type="text" id="bank_number" class="form-control" name="bank_number" placeholder="계좌번호" required>
            </div>
            
			 <div class="form-group pt-3">
            	<label for="delivery_zipcode">주소</label><br />        
				<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="delivery_zipcode" id="delivery_zipcode" type="text" readonly="readonly" >
				<button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
			</div>
			
			<div class="form-group">
			    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="delivery_road" id="delivery_road" type="text" readonly="readonly" />
			</div>
			
			<div class="form-group">
			    <input class="form-control" placeholder="배달주소" name="delivery_detail" id="delivery_detail" type="text"  />
			</div>
			 <input type="hidden"  name="address_code_group_id" id="address_code_group_id" />
			 <input type="hidden"  name="address_code_id" id="address_code_id" />
            <div class="form-group"> 회원상태 : 
				<select name = "member_state_id">
					<option value="none">선택하세요</option>
					<option value="1">활성화</option>
					<option value="2">비활성화</option>
					<option value="3">탈퇴예정</option>
				</select>	
			</div>
            
            
            <div class="form-group" id="checkboxform" style="text-align: center;" >
				<input type="checkbox" id="agree" name="agree" value="noncheck"><a> 개인정보 처리방침 및 주의사항에 동의합니다.</a>
			</div>
		            
            <button type="submit" class="btn btn-success">입력</button>
         
            <a href="#" class="btn btn-danger">취소</a>
           <!-- <a href="AdminLoginView" class="btn btn-primary" >로그인</a> -->
        </form>
    </div>
</body>
</html>

