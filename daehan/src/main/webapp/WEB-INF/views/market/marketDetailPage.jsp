<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                
                $("[name=marketZipcode]").val(data.zonecode);
                $("[name=marketRoad]").val(fullRoadAddr);
                
                

            }
        }).open();
    } 

</script>
</head>

<body>

<h2 class="text-center">음식점 상세 페이지</h2>
<hr/><br/><br/>

<div>
<form action="/market/marketDetailInsert" method="post">
	<div class="form-group">
		<label for="marketId">음식점아이디</label>
		<input class="form-control" type="text" id="marketId" name="marketId" value="${user_id}" readonly />	<!-- 추후에 user_id를 market_id로 수정하기 -->		
	</div>
	
	<div class="form-group">
		<label for="marketName">음식점이름</label>
		<input class="form-control" type="text" id="marketName" name="marketName" value="${user_name}" readonly /> 
	</div>
	
	<div class="from-group">
		<label for="categoryCodeId">음식점 카테고리</label><br/>
		<select name="categoryCodeId">
			<option value="1">족발, 보쌈</option>
			<option value="2">찜, 탕, 찌개</option>
			<option value="3">돈까스, 회, 일식</option>
			<option value="4">피자</option>
			<option value="5">고기, 구이</option>
			<option value="6">양식</option>
			<option value="7">치킨</option>
			<option value="8">중식</option>
			<option value="9">아시안</option>
			<option value="10">백반, 죽, 국수</option>
		</select>
	</div>
	
	<div class="form-group pt-3">
       	<label for="marketZipcode">주소</label><br/>        
		<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="marketZipcode" id="marketZipcode" type="text" readonly="readonly" >
		<button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
	</div>
	
	<div class="form-group">
	    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="marketRoad" id="marketRoad" type="text" readonly="readonly" />
	</div>
	
	<div class="form-group">
	    <input class="form-control" placeholder="상세주소" name="addressDetail" id="addressDetail" type="text"  />
	</div>
	
	<input type="hidden"  name="address_code_group_id" id="address_code_group_id"/>
	<input type="hidden"  name="address_code_id" id="address_code_id" />
	
	
	<div class="form-group">
		<label for="phone">전화번호</label>
		<input class="form-control" type="text" id="phone" name="phone" />		
	</div>
	
	<div class="form-group">
		<label for="time">영업시간</label><br/>
		<input type="time" id="time" name="openingTime" /> ~ <input type="time" id="time" name="closingTime" />
	</div>
	
	<div class="form-group">
		<label for="minPrice">최소 배달 금액</label>
		<input class="form-control" type="text" id="minPrice" name="minPrice" placeholder="금액을 입력하세요" />
	</div>
	
	<button class="btn btn-primary">저장</button>
	<button type="reset" class="btn btn-danger">취소</button>
</form>
</div>

</body>
</html>
