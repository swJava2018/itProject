<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/top.jsp" %>

<div class="pure-menu pure-menu-horizontal">
	<ul class="pure-menu-list">
    	<li class="pure-menu-item pure-menu-disabled"><a href="../login" class="pure-menu-link">로그인</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../enroll" class="pure-menu-link">회원가입</a></li>
    	<li class="pure-menu-item"><a href="../logout" class="pure-menu-link">로그아웃</a></li>
 	</ul>
</div><hr>

<h2 style="text-align:center">에러 발생</h2>

<div class="card">
	<c:if test="${error != null}">
		<p>${error}</p>
	</c:if>
</div>

<%@include file="include/bottom.jsp" %>