<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
	<link rel="stylesheet" href="css/sanan.css">
	<link rel="stylesheet" href="css/sanan-popup.css">
	
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<!-- jQuery Modal -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/css/animate.min.css" />
	<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/css/jquery.modal.css" />
	<script src="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/js/jquery.modal.js"></script>
	<script src="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/js/modal.js"></script>
	
	<script src="js/pt-connect.js"></script>
	<script src="js/pt-list-one-ui.js"></script>
	<!--  script src="js/pt-previw.js"></script -->
	<!--  script src="../res/js/sanan-window.js"></script-->
</head>

<body>
	<div class="tibo">
        <label class="bo title" for="title">번호</label>
        <input class="title" type="text" maxlength="20" id="contestId" placeholder="제목" style="width: 100%;" value="${id}">
    </div>
    <div class="tibo">
        <label class="bo title" for="title">제목</label>
        <input class="title" type="text" maxlength="20" id="title" placeholder="제목" style="width: 100%;">
    </div>
    <section class="fl">
    <div class="fl2"> 
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="field">분야</label>
	        <input class="font" type="text" id="field" placeholder="분야">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">    
	        <label class="bo font" for="sector">부문</label>
	        <input class="font" type="text" id="sector" placeholder="부문">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="week">주회/주관</label>
	        <input class="font" type="text" id="week" placeholder="주회/주간">
	    </div>
	     
	    <div class="tibo"  style="width: 400px">
			<label class="bo font" for="area">지역</label>
	        <input class="font" type="text" id="area" placeholder="지역">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="subStart">신청접수</label>
	        <input class="font" type="text" id="subStart" placeholder="신청접수">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="subEnd">신청종료</label>
	        <input class="font" type="text" id="subEnd" placeholder="신청종료">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="preStart">예선시작</label>
	        <input class="font" type="text" id="preStart" placeholder="공모전시작">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="preEnd">예선종료</label>
	        <input class="font" type="text" id="preEnd" placeholder="공모전종료">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="onStart">공모전시작</label>
	        <input class="font" type="text" id="onStart" placeholder="공모전시작">
	    </div>
	    
	    <div class="tibo"  style="width: 400px">
	        <label class="bo font" for="onEnd">공모전종료</label>
	        <input class="font" type="text" id="onEnd" placeholder="공모전종료">
	    </div>
    </div>
    
    <div class="fl2">
        <div class="tibo"  style="width: 400px">
            <label class="bo font" for="img">이미지</label>
            <a href="#" onclick="openWin2()">
            <div class="filebox">      
                <label for="filebox">이미치창</label>
            </div>
            </a>
        </div>

        <div class="tibo"  style="width: 400px">
            <label class="bo font" for="addtion">추가자료</label>
            <input class="font" type="text" id="addtion" placeholder="추가자료">
        </div>
        <div class="tibo"  style="width: 400px">
            <label class="bo font" for="url">URL</label>
            <input class="font" type="text" id="url" placeholder="URL">
        </div>
        <div class="tibo"  style="width: 400px; flex-direction: column;" >
            <label class="bo font" for="description" style="margin-bottom: 30px;">추가 설명</label>
            <textarea id="intro" cols="40" rows="8" style="width:100%; margin:0px 30px 30px 00px; "></textarea>
        </div>
    </div>    
    </section>
    <div class="fl">
        <button style="width:75px; height: 25px; margin-left: 30px" id="i_modify_btn">수정</button>
    </div>
</body> 
</html>