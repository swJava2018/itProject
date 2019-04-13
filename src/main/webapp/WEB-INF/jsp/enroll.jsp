<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/top.jsp" %>

<div class="pure-menu pure-menu-horizontal">
	<ul class="pure-menu-list">
    	<li class="pure-menu-item"><a href="../login" class="pure-menu-link">로그인</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../enroll" class="pure-menu-link">회원가입</a></li>
    	<li class="pure-menu-item pure-menu-disabled"><a href="../logout" class="pure-menu-link">로그아웃</a></li>
 	</ul>
</div><hr>

<h1 style="text-align:center">회원가입</h1>

<div class="card">
    <form class="pure-form pure-form-aligned" style="margin: 5px 5px 5px 5px;" 
    	action="/enroll" method="post">
        <fieldset>
         	<div class="pure-control-group">
                <strong><label for="id">아이디 : </label></strong>
                <input name="id" type="text" placeholder="아이디" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="pwd">비밀번호 : </label></strong>
                <input name="pwd" type="password" placeholder="비밀번호" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="pwd_confirm">비밀번호 확인 : </label></strong>
                <input name="pwd_confirm" type="password" placeholder="비밀번호 확인" style="width: 200px;">
            </div>
            
        	<div class="pure-control-group">
                <strong><label for="name">이름 : </label></strong>
                <input name="name" type="text" placeholder="이름" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="nickname">닉네임 : </label></strong>
                <input name="nickname" type="text" placeholder="닉네임" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="shcool">학교 : </label></strong>
                <input name="school" type="text" placeholder="학교" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="major">학과 : </label></strong>
                <input name="major" type="text" placeholder="학과" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="grade">성적 : </label></strong>
                <input name="grade" type="text" placeholder="성적" style="width: 200px;">
            </div>
            
            <div class="pure-control-group">
                <strong><label for="email">이메일 : </label></strong>
                <input name="email" type="text" placeholder="Email Address" style="width: 200px;">     
            </div>
            
            <div class="pure-control-group">
                <strong><label for="gender">성별  </label></strong>
                <input name="gender" type="radio">남자
                <input name="gender" type="radio">여자
            </div>
     	</fieldset>
     	<button class="pure-button pure-button-primary" type="submit">
     		회원가입
     	</button>
     	<a class="pure-button pure-button-primary" href="../login">
     		취소
     	</a>
     	<c:if test="${error != null}">
				<p>${error}</p>
		</c:if>
    </form>
</div>
 
 
<%@include file="include/bottom.jsp" %>