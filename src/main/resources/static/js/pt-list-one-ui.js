$(document).ready(function(){
	one_ui.readyUI();
});

var one_ui = (function() {
	'use strict';
	
	// Input	
	var i_modify_btn = "#i_modify_btn";
	
	
	
	/**
	 * UI 로딩 초기화
	 */
	const readyUI = function() {
		
		// 데이터 가져와서 출력하기
		connect.requestContest($("#contestId").val());
		
	
	};
	
	const refreshUI = function(result) {
		
		var tak = "title";
		var tag = document.getElementById(tak);
		tag.innerHTML = result.result.name;
		$("#" + tak).val(result.result.name);
		
	};
	
	
	// Member Functions
	return {
		readyUI : readyUI,
		refreshUI : refreshUI
	};
})();