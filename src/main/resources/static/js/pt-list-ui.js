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
	
	
	// Member Functions
	return {
		
	};
})();