var connect = (function() {
	'use strict';
	
	var requestSearchKeyWordUrl = '/keyword';
	
	var result_url = '/index'
	
	const requestSearchKeyWord = function(keyword, page) {
		var reqUrl = requestSearchKeyWordUrl;
		if(page == null)
			reqUrl = reqUrl + "/" + keyword;
		else
			reqUrl = reqUrl + "/" + keyword + "/" + page
			
		var query = {
			keyword : keyword,
			page : page
		};
		
		$.ajax({
			type : "GET",
			url : reqUrl,
			data : query,
			dataType : "json",
			success : function(result) {
				if(result.errCode == 100) {
					ui.refreshInitScreen();
					
					ui.refreshResultsBox(result.openApiResult);
					ui.refreshLatestTop10Box(result.latest10);
				}
				else {
					ui.refreshInitScreen();
					
					ui.refreshErrorBox(result.errMsg);	
				}				
			},
			error : function(e) {
				console.log("[enroll] requestEnroll() error : " + e.responseText);
				alert("connection error : " + e.responseText);
			}		
		});
	};
		
	// Move Result Page
	const moveResultPage = function() {
		location.href = result_url;
	};
	
	// Member Functions
	return {
		requestSearchKeyWord : requestSearchKeyWord
	};
})();