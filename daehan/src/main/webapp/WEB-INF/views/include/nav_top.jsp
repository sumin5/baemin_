<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul> 

<span style="color:blue; font-weight:bold;">${userName}님(${authority_code})</span>이 로그인 하셨습니다. 

[<c:if test="${authority_code == '01'}">
&nbsp;&nbsp; <a id="hypertext" href="/member/test" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">사용자정보</a>&nbsp;&nbsp; | &nbsp;&nbsp;
</c:if>
<c:if test="${authority_code != '01'}">
&nbsp;&nbsp; <a id="hypertext" href="/member/detailPage?userId=${userId}" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">사용자정보</a>&nbsp;&nbsp; | &nbsp;&nbsp;
</c:if>
<a id="hypertext" href="/board/listPage?num=1" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">음식점리스트</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/board/eduView" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">주문이력</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/board/sourceView" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">리뷰이력</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/board/sourceView" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">쿠폰이력</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/member/logout" onMouseover="this.style.background='#96FFFF'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">로그아웃</a>&nbsp;&nbsp; ]
 
 
</ul>