$(document).ready(function(){
	ui.readyUI();
});

var ui = (function() {
	'use strict';
	
	// Input	
	var c_searchKeywordBtn	= "#searchKeyWordBtn";	// operation button	
	var i_searchKeyWordID 	= "#searchKeyWordID";	// operation input text
	
	
	// Output	
	var i_keywordTbl 		= "keywordTbl";			// keyword table
	var i_keywordModal 		= "keyword_modal";		// keyword table modal box
	var i_keywordModalText	= "keyword_detail"		// keyword table modal box text	
	var i_latest10 			= "latest10Tbl";		// keyword top 10
	var i_error 			= "keywordErr";			// keyword search error box
	
	// Output Table Pagination Number
	var pagination_isInit = false;
	var pagination_pageStart;
	var pagination_pagePart;
	var pagination_pageEnd;
	var pagination_pageReq;
	
	
	/**
	 * UI 로딩 초기화
	 */
	const readyUI = function() {
		
		// Search Button
		$(c_searchKeywordBtn).click(function(e){
			
			// initialize pagination
			pagination_isInit = false;
			
			// request keyword
			var keyword = $(i_searchKeyWordID).val();
    		connect.requestSearchKeyWord(keyword);    		
		});
		
		// PopUp Close Button
		$(".close").click(function(e){
			var keyword_modal = document.getElementById(i_keywordModal);
			keyword_modal.style.display = "none";	
		});
	};
	
	
	/**
	 * Keyword 검색 결과 갱신
	 */
	const refreshResultsBox = function(result) {
		var parentTag = document.getElementById(i_keywordTbl);
		
		/*
		private ArrayList<OpenAPIResult> list;
		private int pageableCnt;
		private int totalCnt;
		private String keyword;
		*/
		
		var openApiResults = result.list;
		var openApiResultsCnt = result.totalCnt/openApiResults.length;
		
		if(openApiResultsCnt != 0) {
			
			
			// table pagination (calculate)
			if(pagination_isInit != true) {
				pagination_pageReq = 1;
				
				pagination_pageStart = 0;
				pagination_pagePart = (openApiResultsCnt > 5) ? 5 : openApiResultsCnt;
				pagination_pageEnd = openApiResultsCnt;
				pagination_isInit = true;
			}
			
			
			// table
			var new_divTag = document.createElement("div");
			new_divTag.setAttribute('id', i_keywordTbl);	
			{				
				var tableTag = document.createElement("table");
				tableTag.setAttribute('class', 'pure-table pure-table-horizontal');
				{				
					// table head
					var theadTag = document.createElement("thead");
					var trTag = document.createElement("tr");
					var tdTag = document.createElement("th");
					tdTag.appendChild(document.createTextNode('#'));
					trTag.appendChild(tdTag);
					
					tdTag = document.createElement("th");
					tdTag.appendChild(document.createTextNode('장소'));
					trTag.appendChild(tdTag);
					
					tdTag = document.createElement("th");
					tdTag.appendChild(document.createTextNode('상세정보'));
					trTag.appendChild(tdTag);
					
					tdTag = document.createElement("th");
					tdTag.appendChild(document.createTextNode(''));
					trTag.appendChild(tdTag);
					
					theadTag.appendChild(trTag);
					tableTag.appendChild(theadTag);
					
					
					// table body
					var tbodyTag = document.createElement("tbody");
					var i;
					for(i=0; i<openApiResults.length; i++) {
						
						var doc = openApiResults[i];
						var trTag = document.createElement("tr");
						
						/*
						private String placeName;	
						private String link;
						private String linkMap;
						private String detail;
						private String detail_road;
						private String x;
						private String y;
						private String phone;
						*/
						
						var num = (pagination_pageReq-1) * 10 + i + 1;
						
						var tdTag = document.createElement("td");
						tdTag.appendChild(document.createTextNode(num));
						trTag.appendChild(tdTag);
											
						tdTag = document.createElement("td");
						tdTag.appendChild(document.createTextNode(doc.placeName));
						trTag.appendChild(tdTag);
						
						tdTag = document.createElement("td");
						tdTag.appendChild(document.createTextNode(doc.detail));
						trTag.appendChild(tdTag);
						
						// in detail button
						tdTag = document.createElement("td");
						var btnTag = generateInDetailTag(doc);
						tdTag.appendChild(btnTag);					
						trTag.appendChild(tdTag);
						
						
						
						tbodyTag.appendChild(trTag);
					}				
				}
			}//-- table			
			// append table to new one
			tableTag.appendChild(tbodyTag);
			new_divTag.appendChild(tableTag);
			
			
			
			// table pagination
			var divTag = document.createElement("div");
			divTag.setAttribute("class", "pure-menu pure-menu-horizontal");
			{	
				// table pagination arrow (left)
				{
					var aTag = document.createElement("button");
					aTag.setAttribute("class", "pure-button");
					aTag.appendChild(document.createTextNode("◀"));
					aTag.addEventListener('click', function() {
						
						if(pagination_pageStart > 0) {
							pagination_pageStart--;
							pagination_pagePart--;
						}
						
						var old_ulTag = document.getElementById("pagination_tag");
						var new_ulTag = generateResultsPaginationBox(pagination_pageStart, pagination_pagePart, result.keyword);
						old_ulTag.parentNode.replaceChild(new_ulTag, old_ulTag);
					});
					divTag.appendChild(aTag);
				}
				
				// table pagination number
				{
					var ulTag = generateResultsPaginationBox(pagination_pageStart, pagination_pagePart, result.keyword);
					divTag.appendChild(ulTag);
				}
				
				// table pagination arrow (right)
				{
					var aTag = document.createElement("button");
					aTag.setAttribute("class", "pure-button");
					aTag.appendChild(document.createTextNode("▶"));
					aTag.addEventListener('click', function() {

						if(pagination_pagePart < pagination_pageEnd) {
							pagination_pagePart++;
							pagination_pageStart++;
						}
						
						var old_ulTag = document.getElementById("pagination_tag");
						var new_ulTag = generateResultsPaginationBox(pagination_pageStart, pagination_pagePart, result.keyword);
						old_ulTag.parentNode.replaceChild(new_ulTag, old_ulTag);
					});
					divTag.appendChild(aTag);								
				}
			}//-- table pagination			
			// append table pagination to new one			
			new_divTag.appendChild(divTag);
			
			
			// replace old one with new one
			parentTag.parentNode.replaceChild(new_divTag, parentTag);
		}		
	};
		
	
	const generateInDetailTag = function(doc) {
		
		/*
		private String placeName;	
		private String link;
		private String linkMap;
		private String detail;
		private String detail_road;
		private String x;
		private String y;
		private String phone;
		*/
		
		var modal = document.getElementById(i_keywordModal);		
		var btnTag = document.createElement("button");
		btnTag.setAttribute("class", "pure-button");
		btnTag.onclick = function() {
			
			var contentTag = document.getElementById(i_keywordModalText);
			var new_contentTag = document.createElement("div");
			new_contentTag.setAttribute("id", i_keywordModalText);
			
			// place_name (title)
			var	h2Tag = document.createElement("h2");
			h2Tag.setAttribute("align", "center");
			h2Tag.appendChild(document.createTextNode(doc.placeName));			
			new_contentTag.appendChild(h2Tag);
			
			var ulTag = document.createElement("ul");
						
			// address_name
			var liTag = document.createElement("li");
			liTag.appendChild(document.createTextNode("지번주소 : " + doc.detail));
			ulTag.appendChild(liTag);
			
			// road_address_name
			if(doc.detail_road.length != 0){
				var liTag = document.createElement("li");
				liTag.appendChild(document.createTextNode("도로주소 : " + doc.detail_road));
				ulTag.appendChild(liTag);
			}
			
			// phone
			if(doc.phone.length != 0){
				liTag = document.createElement("li");
				liTag.appendChild(document.createTextNode("전화번호 : " + doc.phone));
				ulTag.appendChild(liTag);
			}
			
			// link map
			liTag = document.createElement("li");		
			var aTag = document.createElement("a");
			aTag.setAttribute("href", doc.linkMap);
			aTag.appendChild(document.createTextNode("지도 보기"));
			liTag.appendChild(aTag);				
			ulTag.appendChild(liTag);
			
			new_contentTag.appendChild(ulTag);
			contentTag.parentNode.replaceChild(new_contentTag, contentTag);
			
			modal.style.display = "block";
		}
		btnTag.appendChild(document.createTextNode("자세히"));
		return btnTag;
	}
	
	
	const generateResultsPaginationBox = function(start, end, keyword) {
		var ulTag = document.createElement("ul");
		ulTag.setAttribute("id", "pagination_tag");
		ulTag.setAttribute("class", "pure-menu-list");
		
		var i;
		for(i=start; i<end; i++) {
			var liTag = document.createElement("li");
			liTag.setAttribute("class", "pure-menu-item");
			
			var pagenum = i+1;
			var aTag = document.createElement("a");
			aTag.appendChild(document.createTextNode(pagenum));
			aTag.addEventListener('click', moveToOtherPage(keyword, pagenum));
			aTag.setAttribute("id", "pagination_" + pagenum);
			aTag.setAttribute("class", "pure-menu-link");
			
			liTag.appendChild(aTag);
			ulTag.appendChild(liTag);
		}
		return ulTag;
	};	
	
	
	/**
	 * Keyword 검색 결과 갱신 (페이징 영역)
	 */
	const refreshLatestTop10Box = function(result) {		
		var parentTag = document.getElementById(i_latest10);
		
		if(result != null) {
			
			var new_divTag = document.createElement("div");
			new_divTag.setAttribute("id", i_latest10);	
			new_divTag.setAttribute("class", "pure-menu custom-restricted-width");				
			
			// print the most frequently keywords
			{
				// title
				var spanTag = document.createElement("span");	
				spanTag.setAttribute("class", "pure-menu-heading");
				spanTag.appendChild(document.createTextNode("인기 검색어"));	
				new_divTag.appendChild(spanTag);
					
				
				// content
				var ulTag = document.createElement("ul");	
				ulTag.setAttribute("class", "pure-menu-list");
				var i;
				for(i=0; i<result.length; i++) {				
					var keyword = result[i];
					var content = keyword.id + " " + keyword.cnt + " ";
					
					var liTag = document.createElement("li");
					liTag.setAttribute("class", "pure-menu-item");
					var aTag = document.createElement("a");
					aTag.setAttribute("class", "pure-menu-link");
					aTag.setAttribute("href", "#");
					aTag.appendChild(document.createTextNode(content));		
					liTag.appendChild(aTag);				
					ulTag.appendChild(liTag);				
				}
				new_divTag.appendChild(ulTag);
			}
			
			// replace old one with new one
			parentTag.parentNode.replaceChild(new_divTag, parentTag);
		}
	};
	
	
	const moveToOtherPage = function(keyword, pagenum) {
		return function curried_func(e) {
			
			// set request page
			pagination_pageReq = pagenum;
			
			// request page
			connect.requestSearchKeyWord(keyword, pagenum);
	    }
	};
	
	
	/**
	 * Keyword 검색 에러 갱신
	 */
	const refreshErrorBox = function(message) {
		var errTag = document.getElementById(i_error);
		
		var new_errTag = document.createElement("div");
		new_errTag.setAttribute("id", i_error);
		new_errTag.textContent = message;
		
		errTag.parentNode.replaceChild(new_errTag, errTag);
	}
	
	
	/**
	 * Keyword 검색 페이지 초기화
	 */
	const refreshInitScreen = function() {
		var tag = document.getElementById(i_keywordTbl);
		tag.textContent = "";
		
		tag = document.getElementById(i_latest10);
		tag.textContent = "";
		
		tag = document.getElementById(i_error);
		tag.textContent = "";
	}
	
	
	// Member Functions
	return {
		readyUI : readyUI,
		refreshResultsBox : refreshResultsBox,
		refreshLatestTop10Box : refreshLatestTop10Box,
		refreshErrorBox : refreshErrorBox,
		refreshInitScreen : refreshInitScreen
	};
})();