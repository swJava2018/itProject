<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/top.jsp" %>
<%
	String url = (String)request.getAttribute("google_url");
%>

<div class="pure-menu pure-menu-horizontal">
	<ul class="pure-menu-list">
    	<li class="pure-menu-item pure-menu-disabled"><a href="../login" class="pure-menu-link">로그인</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../enroll" class="pure-menu-link">회원가입</a></li>
    	<li class="pure-menu-item"><a href="../logout" class="pure-menu-link">로그아웃</a></li>
 	</ul>
</div><hr>

<h2 style="text-align:center">구글 로그인</h2>

<div class="card">
   	<p><strong><a href="<%=url%>">로그인</a></strong></p>
</div>



<!-- pop-up -->
<div id="keyword_modal" class="modal">

  <!-- pop-content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <div id="keyword_detail"></div>
  </div>  
</div>

<%@include file="include/bottom.jsp" %>