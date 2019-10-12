<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >

    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sanan.css">
    <link rel="stylesheet" href="css/sanan-popup.css">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="js/pt-previw.js"></script>
</head>
<body>
    <h1>이미지 업로드</h1>
    <div class="fl" style="justify-content: flex-start;">
        <div class="img"></div>
            <div id="preview"></div>
    </div>
     <div class="filebox">
        <div id="attach">
            <label class="waves-effect waves-teal btn-flat" for="uploadInputBox">업로드</label>
            <input id="uploadInputBox" style="display: none" type="file" name="filedata" multiple />
        </div>
    </div>
</body>
</html>