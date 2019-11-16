$(document).ready(function(){
	ui.readyUI();
});

var ui = (function() {
	'use strict';
	
	var myList;
	
	/**
	 * UI 로딩 초기화
	 */
	const readyUI = function() {
		
		// 데이터 가져와서 출력하기
		connect.requestContestList();
		
		// 데이터 가져온거 선택해서 출력하기 (onClick)
		var size = 1;
		for(var i=1; i<=size; i++) {
			
			var i_n = '#data' + i + '_id';
			
			$(i_n).click(function(){
//				$(i_n).hide();
				var index = $(i_n).val();
				chooseUI(index);
			});
		}
	};
	
	const refreshUI = function(result) {
		
		myList = result;
		
		var size = 10;
		if(size > result.result.length) {
			size = result.result.length;
		}
		
		
		for(var i=1; i<=size; i++)
		{
			var tak = "data" + i + "_id"
			var tag = document.getElementById(tak);
			var obj = result.result[i-1];
			tag.innerHTML = obj.id;
			$("#" + tak).val(obj.id);
		}
		
		for(i=1; i<=size; i++)
		{
			var tak2 = "data" + i + "_date"
			var tag2 = document.getElementById(tak2);
			var obj2 = result.result[i-1];
			tag2.innerHTML = Date(obj2.onStart);
		}
		
		for(i=1; i<=size; i++)
			{
				var tak3 = "data" + i + "_title"
				var tag3 = document.getElementById(tak3);
				var obj3 = result.result[i-1];
				tag3.innerHTML = obj3.name;
			}
	};
	
	
	/**
	 * 대회 정보 자세히 보기
	 * 
	 * 모달 팝업 참고 사이트 : https://stove99.github.io/javascript/2019/04/16/jquery-modal-plugin/
	 */
	const chooseUI = function(index) {
		
        $.popup({
            url: '/list_one/' + index,
            close: function(result) {
                console.log(result);
            }
        });
	    
		
		//var url = "http://localhost:8080/popup/" + i;
		//var URL = myList.result[index-1];
		//window.open(URL,"새창", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	};
	
	// Member Functions
	return {
		readyUI : readyUI,
		refreshUI : refreshUI
	};
})();