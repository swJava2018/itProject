<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
	    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
	    <link rel="stylesheet" href="../res/css/sanan.css">
	    <link rel="stylesheet" href="../res/css/sanan-popup.css">
	
	    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <!--script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script-->
        <script src="../res/js/sanan-ui.js"></script>
        <script src="../res/js/sanana-preview.js"></script>
    </head>
<body>
   <div class="nav">
        <div class="nav-right-item">
            <button class="nav-item">공모전 목록</button>
            <button class="nav-item">공모전 등록하기</button>
        </div>
   </div>

    <div class="tibo">
        <label class="bo title" for="title">제목</label>
        <input class="title" type="text" name="title" placeholder="제목" style="width: 100%;">
    </div>
    <section class="fl">
    <div class="fl2"> 
    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="filed">분야</label>
        <input class="font" type="text" name="filed" placeholder="분야">
    </div>

    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="sector">부문</label>
        <input class="font" type="text" name="sector" placeholder="부문">
    </div>

    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="week">주회/주관</label>
        <input class="font" type="text" name="week" placeholder="주회/주간">
    </div>

    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="area">지역</label>
        <input class="font" type="text" name="area" placeholder="지역">
    </div>
    
    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="receiveday">접수기간</label>
        <input class="font" type="text" name="receiveday" placeholder="접수기간">
    </div>

    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="qualifierday">예약기간</label>
        <input class="font" type="text" name="qualifierday" placeholder="예약기간">
    </div>

    <div class="tibo"  style="width: 400px">
        <label class="bo font" for="finalday">본선기간</label>
        <input class="font" type="text" name="finalday" placeholder="본선기간">
    </div>
    </div>
    <div class="fl2">
        <div class="tibo"  style="width: 400px">
            <label class="bo font" for="img">이미지</label>
            <div class="filebox">
                    <div id="attach">
                        <label class="waves-effect waves-teal btn-flat" for="uploadInputBox">업로드</label>
                        <input id="uploadInputBox" style="display: none" type="file" name="filedata" multiple />
                    </div>
            </div>
        </div>

        <div class="tibo"  style="width: 400px">
            <label class="bo font" for="addtion">추가자료</label>
            <input class="font" type="text" name="addtion" placeholder="추가자료">
        </div>

        <div class="tibo"  style="width: 400px">
            <label class="bo font" for="url">URL</label>
            <input class="font" type="text" name="url" placeholder="URL">
        </div>

        <div class="tibo"  style="width: 400px; flex-direction: column;" >
            <label class="bo font" for="description" style="margin-bottom: 30px;">추가 설명</label>
            <textarea name="content" cols="40" rows="8" style="width:100%; margin:0px 30px 30px 00px; "></textarea>
        </div>
    </div>    
    </section>
    <!-- 
    <div id="preview" class="content"></div>
    <div class="fl">
        <div class="filebox">
            <div id="attach">
                <label class="waves-effect waves-teal btn-flat" for="uploadInputBox">업로드</label>
                <input id="uploadInputBox" style="display: none" type="file" name="filedata" multiple />
            </div>
        </div>
    </div>
    <div class="fl">
        <textarea name="content" cols="40" rows="8" style="width:100%; margin:30px 30px 30px 30px; "></textarea>
    </div> -->
    <div class="fl">
        <a href="C:/workspace_vs/src/index.html" target="_blank">
            <div class="filebox">
                <label for="filebox">열기</label> 
            </div>
        </a>
        <button style="width:75px; height: 25px; margin-left: 30px">취소</button>
    </div>
</body> 
</html>