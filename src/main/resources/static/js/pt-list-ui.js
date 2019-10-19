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
	
	// Member Functions
	return {
		readyUI : readyUI,
		refreshUI : refreshUI
	};
})();