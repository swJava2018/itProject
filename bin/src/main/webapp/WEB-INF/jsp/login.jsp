<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/top.jsp" %>

<div class="pure-menu pure-menu-horizontal">
	<ul class="pure-menu-list">
    	<li class="pure-menu-item"><a href="../login" class="pure-menu-link">로그인</a></li>
    	<li class="pure-menu-item"><a href="../enroll" class="pure-menu-link">회원가입</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../logout" class="pure-menu-link">로그아웃</a></li>
 	</ul>
</div><hr>


<h2 style="text-align:center">Login</h2>

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

<div id="div1">
	구역1
</div>

<div id="div2">
	구역2
</div>

<div id="div3">
	구역3
</div>

<div id="div4">
	구역4
</div>

<div id="div5">
	구역5
</div>

<div id="div6">
	구역6
</div>

<%@include file="include/bottom.jsp" %>