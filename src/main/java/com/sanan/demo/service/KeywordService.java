package com.sanan.demo.service;

import java.util.List;

import com.sanan.demo.data.entity.Keyword;

public interface KeywordService {
	/**
     * Keyword 목록 조회
     * @return
     */
    public List<Keyword> selectKeywordList();
     
    /**
     * Keyword 목록 Top10 조회
     * @return
     */
    public List<Keyword> selectKeywordTop10List();
    
    /**
     * Keyword 조회
     * @param keyword
     * @return
     */
    public Keyword selectKeyword(String id);
     
    /**
     * Keyword 등록
     * @param keyword
     */
    public void insertKeyword(Keyword keyword);
     
    /**
     * Keyword 정보 수정
     * @param keyword
     */
    public void updateKeyword(Keyword keyword);
     
    /**
     * Keyword 삭제
     * @param keyword
     */
    public void deleteKeyword(String id);
}
