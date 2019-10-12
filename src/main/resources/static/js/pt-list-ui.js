$(document).ready(function(){
	ui.readyUI();
});

var ui = (function() {
	'use strict';
	
	/**
	 * UI 로딩 초기화
	 */
	const readyUI = function() {
		connect.requestContestList();
	};
	
	const refreshUI = function(result) {
		var tag = document.getElementById("data1_title");
		var obj = result.result[0];
		tag.innerHTML = obj.name;
	};
	
	// Member Functions
	return {
		readyUI : readyUI,
		refreshUI : refreshUI
	};
})();