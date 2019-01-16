package com.sanan.demo.service;

import com.sanan.demo.exception.SananException;
import com.sanan.demo.model.OpenAPIQuery;
import com.sanan.demo.model.OpenAPIResultResponse;

public interface OpenAPIService {
	/**
     * Keyword 검색
     * @return
     */
    public OpenAPIResultResponse requestSearchAPI(String provider, OpenAPIQuery request) throws SananException;
}
