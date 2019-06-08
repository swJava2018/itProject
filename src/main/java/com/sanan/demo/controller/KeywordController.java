package com.sanan.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanan.demo.data.entity.Keyword;
import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.model.OpenAPIQuery;
import com.sanan.demo.model.OpenAPIResultResponse;
import com.sanan.demo.model.ResponseMessage;
import com.sanan.demo.service.KeywordService;
import com.sanan.demo.service.OpenAPIService;

@RestController
@RequestMapping(value = "/keyword")
public class KeywordController {
//	
//	@Autowired
//	KeywordService keywordService;
//	
//	@Autowired
//	OpenAPIService openApiService;
//	
//	
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseMessage getKeyword( @PathVariable("id") String id ) throws SananException{   
//    	ResponseMessage res = new ResponseMessage();
//    	
//    	OpenAPIQuery query = new OpenAPIQuery();
//    	HashMap<String, Object> map = new HashMap<String, Object>();
//    	map.put("query", id);
//    	map.put("size", 10);
//    	query.setMap(map);
//    	
//        OpenAPIResultResponse result = openApiService.requestSearchAPI("kakao", query);               	
//    	Keyword keyword = new Keyword();
//        keyword.setId(id);
//        keywordService.updateKeyword(keyword);
//        res.setOpenApiResult(result);    
//                
//        List<Keyword> list = keywordService.selectKeywordTop10List();
//        res.setLatest10(list);
//        res.setErrCode(SananErrorCode.SUCCESS);
//    	return res;
//    }
//    
//    @RequestMapping(value = "/{id}/{page}", method = RequestMethod.GET)
//    public ResponseMessage getKeyword( @PathVariable("id") String id, @PathVariable("page") int page) throws SananException{   
//    	ResponseMessage res = new ResponseMessage();
//    	
//    	OpenAPIQuery query = new OpenAPIQuery();
//    	HashMap<String, Object> map = new HashMap<String, Object>();
//    	map.put("query", id);
//    	map.put("page", page);
//    	map.put("size", 10);
//    	query.setMap(map);
//    	
//        OpenAPIResultResponse result = openApiService.requestSearchAPI("kakao", query);
//        res.setOpenApiResult(result);   
//        
//        List<Keyword> list = keywordService.selectKeywordTop10List();
//        res.setLatest10(list);
//        res.setErrCode(SananErrorCode.SUCCESS);
//    	return res;
//    }
//    
//    @ExceptionHandler({SananException.class}) 
//    public ResponseMessage exceptionHandler(SananException e) {    	
//    	ResponseMessage res = new ResponseMessage();
//        res.setErrCode(e.getErrorCode());
//        res.setErrMsg(e.getMessage());
//        return res;
//    }
//    
//    @ExceptionHandler({Exception.class}) 
//    public ResponseMessage exceptionHandler(Exception e) {    	
//    	ResponseMessage res = new ResponseMessage();
//        res.setErrCode(SananErrorCode.INTERNAL_ERROR);
//        res.setErrMsg(SananErrorCode.getErrorMessage(SananErrorCode.INTERNAL_ERROR));
//        return res;
//    }
}
