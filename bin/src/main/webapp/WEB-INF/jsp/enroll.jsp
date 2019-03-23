<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/top.jsp" %>

<div class="pure-menu pure-menu-horizontal">
	<ul class="pure-menu-list">
    	<li class="pure-menu-item"><a href="../login" class="pure-menu-link">로그인</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../enroll" class="pure-menu-link">회원가입</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../logout" class="pure-menu-link">로그아웃</a></li>
 	</ul>
</div><hr>

<h2 style="text-align:center">회원가입</h2>

<div class="card">
    <form class="pure-form pure-form-aligned" style="margin: 5px 5px 5px 5px;" 
    	action="/enroll" method="post">
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
     		회원가입
     	</button>
     	<c:if test="${error != null}">
				<p>${error}</p>
		</c:if>
    </form>
</div>
 
 
<%@include file="include/bottom.jsp" %>