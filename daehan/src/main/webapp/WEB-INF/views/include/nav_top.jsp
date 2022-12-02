<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul> 

<span style="color:blue; font-weight:bold;">${userName}님(${authorityCode})</span>이 로그인 하셨습니다. 

[<c:if test="${authorityCode == '1'}">
&nbsp;&nbsp; <a id="hypertext" href="/member/test" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">사용자정보</a>&nbsp;&nbsp; | &nbsp;&nbsp;
</c:if>
<c:if test="${authorityCode != '1'}">
&nbsp;&nbsp; <a id="hypertext" href="/member/detailPage?userId=${userId}" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">사용자정보</a>&nbsp;&nbsp; | &nbsp;&nbsp;
</c:if>

<a id="hypertext" href="/member/orderPage" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">주문하기</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/board/eduView" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">주문이력</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/board/sourceView" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">리뷰이력</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/board/eduView" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">리뷰이력</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/member/logout" onMouseover="this.style.background='#96FFFF'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">로그아웃</a>&nbsp;&nbsp; ]
 
 
</ul>