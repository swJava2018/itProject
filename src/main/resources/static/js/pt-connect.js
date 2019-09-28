var connect = (function() {
	'use strict';
	
	var reqRegUrl = '/contest_reg';
	var reqListUrl = '/contest_list';
	
	const requestContestList = function(contest) {
		
		$.ajax({
			type : "POST",
			url : reqListUrl,
			dataType : "json",
			success : function(result) {
				if(result.errCode == 100) {
					
				}
			},
			error : function(e) {
				console.log("[enroll] requestEnroll() error : " + e.responseText);
				alert("connection error : " + e.responseText);
			}		
		});
	};
	
	const requestContestReg = function(contest) {
		
		$.ajax({
			type : "POST",
			url : reqRegUrl,
			data : contest,
			dataType : "json",
			success : function(result) {
				if(result.resCode == 100) {
					alert("response message : " + result.resMsg);
				}
				else {
					alert("response message : " + result.resMsg);
				}				
			},
			error : function(e) {
				console.log("[enroll] requestEnroll() error : " + e.responseText);
				alert("connection error : " + e.responseText);
			}		
		});
	};
	
	// Member Functions
	return {
		requestContestList : requestContestList,
		requestContestReg : requestContestReg
	};
})();