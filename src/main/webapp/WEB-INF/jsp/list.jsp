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
	<script src="js/pt-list-ui.js"></script>
	<script src="js/pt-previw.js"></script>
</head>

<body>
	<div class="nav">
        <div class="nav-right-item">
            <a href="list" class="nav-item">공모전<br> 목록</a>
            <a href="register" class="nav-item">공모전<br> 등록하기</a>
        </div>
    </div>
    
    <div class="fl">
        <box class="bo font" style="padding: 5px;">번호</box>
        <box class="bo font" style="padding: 5px;">날짜</box>
        <box class="bo font" style="padding: 5px;">공모전 제목</box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data1_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data1_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data1_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data2_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data2_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data2_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data3_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data3_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data3_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data4_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data4_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data4_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data5_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data5_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data5_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data6_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data6_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data6_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data7_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data7_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data7_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data8_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data8_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data8_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data9_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data9_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data9_title"></box>
    </div>

    <div class="fl">
        <box class="bo2 font" style="padding: 5px" id="data10_id"></box>
        <box class="bo2 font" style="padding: 5px" id="data10_date"></box>
        <box class="bo2 font" style="padding: 5px" id="data10_title"></box>
    </div>
</body> 
</html>