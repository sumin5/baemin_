<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul> 

<span style="color:blue; font-weight:bold;">${userName}님(${authorityCode})</span>이 로그인 하셨습니다. &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/market/marketDetailPage" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">음식점정보</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/market/menuListPage" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">메뉴 관리</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/market/orderDetailPage" onMouseover="this.style.background='pink'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">주문 접수</a> &nbsp;&nbsp; | &nbsp;&nbsp;

<a id="hypertext" href="/member/logout" onMouseover="this.style.background='#96FFFF'; this.style.textDecoration='underline';" 
onmouseout="this.style.background='white'; this.style.textDecoration='none';">로그아웃</a>&nbsp;&nbsp; ]

</ul>