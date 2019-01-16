package com.sanan.demo.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.model.OpenAPIQuery;
import com.sanan.demo.model.OpenAPIResult;
import com.sanan.demo.model.OpenAPIResultResponse;
import com.sanan.demo.service.OpenAPIService;
import com.sanan.demo.service.impl.kakao.Document;
import com.sanan.demo.service.impl.kakao.KakaoOpenAPIResponse;
import com.sanan.demo.utils.HttpClient;
import com.sanan.demo.utils.HttpException;

@Service
public class OpenAPIServiceImpl implements OpenAPIService {
	
	@Override
	public OpenAPIResultResponse requestSearchAPI(String provider, OpenAPIQuery query) throws SananException {
		switch(provider) {
		case "kakao": 
			return requestKakaoSearchAPI(query);
		default: 
			return null;
		}
	}
	
	private OpenAPIResultResponse requestKakaoSearchAPI(OpenAPIQuery query) throws SananException {
		
		try {
			String kakaoUrl = "https://dapi.kakao.com/v2/local/search/keyword.json";		
			String authKey = "KakaoAK 4e89a0a5fbc408530dbcc1588985e41d";
			String params = query.toUrlEncoded();
			String linkMapBaseUrl = "http://map.daum.net/link/map/";
			
        	HttpClient client = new HttpClient();
        	String res = client.send(kakaoUrl, params, authKey);
        	
        	KakaoOpenAPIResponse kakaoApi = new KakaoOpenAPIResponse();
            kakaoApi.fromJSON(res);
            
            if(kakaoApi.getMeta().getTotal_count() != 0) {
            	
	            ArrayList<OpenAPIResult> openApiResultList = new ArrayList<OpenAPIResult>();
	            for(Document doc : kakaoApi.getDocuments()) {
	            	OpenAPIResult openApiResult = new OpenAPIResult();
	            	openApiResult.setPlaceName(doc.getPlace_name());
	            	openApiResult.setDetail(doc.getAddress_name());
	            	openApiResult.setDetail_road(doc.getRoad_address_name());
	            	openApiResult.setLink(doc.getPlace_url());
	            	openApiResult.setLinkMap(linkMapBaseUrl + doc.getId());
	            	openApiResult.setX(doc.getX());
	            	openApiResult.setY(doc.getY());
	            	openApiResult.setPhone(doc.getPhone());
	            	openApiResultList.add(openApiResult);
	            }
	            
	            OpenAPIResultResponse result = new OpenAPIResultResponse();
	            result.setList(openApiResultList);
	            result.setPageableCnt(kakaoApi.getMeta().getPageable_count());
	            result.setTotalCnt(kakaoApi.getMeta().getTotal_count());
	            result.setKeyword((String)query.getMap().get("query"));
	            return result;
            } 
            else {
            	throw new SananException(SananErrorCode.SEARCH_KEYWORD_NOT_FOUND);
            }
            
		} catch (HttpException e) {
			throw new SananException(SananErrorCode.INTERNAL_ERROR, e);
			
		} catch (UnsupportedEncodingException e) {
			throw new SananException(SananErrorCode.INTERNAL_ERROR, e);
		}
	}
}
