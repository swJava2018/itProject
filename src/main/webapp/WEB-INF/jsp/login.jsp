<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/top.jsp" %>

<div class="pure-menu pure-menu-horizontal">
	<ul class="pure-menu-list">
    	<li class="pure-menu-item"><a href="../login" class="pure-menu-link">로그인</a></li>
    	<li class="pure-menu-item"><a href="../enroll" class="pure-menu-link">회원가입</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../logout" class="pure-menu-link">로그아웃</a></li>
 	</ul>
</div><hr>

<h1 style="text-align:center">로그인</h1>

<div class="card">
    <form class="pure-form pure-form-aligned" style="margin: 5px 5px 5px 5px;" 
    	action="/login" method="post">
        <fieldset>
            <div class="pure-control-group">
                <label for="id">ID : </label>
                <input name="id" type="text" placeholder="ID" style="width: 200px;">
            </div>
            <div class="pure-control-group">
                <label for="password">Password : </label>
                <input name="password" type="password" placeholder="Password" style="width: 200px;">
            </div>  
     	</fieldset>
     	<button class="pure-button pure-button-primary" type="submit">
     		로그인
     	</button>
     	<a class="pure-button pure-button-primary" href="../enroll">
     		회원가입
     	</a>
     	<c:if test="${error != null}">
			<p>${error}</p>
		</c:if>
    </form>
    
</div>

<%@include file="include/bottom.jsp" %>