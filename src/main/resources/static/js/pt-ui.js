$(document).ready(function(){
	ui.readyUI();
});

var ui = (function() {
	'use strict';
	
	// Input	
	var i_reg_btn = "#i_reg_btn";
	var i_reset_btn = "#i_reset_btn";
	
	
	
	/**
	 * UI 로딩 초기화
	 */
	const readyUI = function() {
		
		// Register Button
		$(i_reg_btn).click(function(e){
			
			var contest = new Object();
			
			//공모전 이름/설명
			contest.name = $("#title").val();
			contest.intro = $("#intro").val();
			
			//공모전 분야/부문
			contest.field = $("#field").val();
			contest.department = $("#sector").val();
			
			//공모전 주최/주관지역
			contest.week = $("#week").val();
			contest.area = $("#area").val();
			
			//공모전 신청기간
			contest.subStart = $("#subStart").val();
			contest.subEnd = $("#subEnd").val();
			
			//공모전 예선기간
			contest.preStart = $("#preStart").val();
			contest.preEnd = $("#preEnd").val();
			
			//공모전 본선기간
			contest.onStart = $("#onStart").val();
			contest.onEnd = $("#onEnd").val();
			
			//공모전 URL
			contest.url = $("#url").val();
			
			//공모전 추가자료
			contest.addtion = $("#addtion").val();
			
			connect.requestContestReg(contest);
		});
		
		
		
	};
	
	
	// Member Functions
	return {
		readyUI : readyUI
	};
})();