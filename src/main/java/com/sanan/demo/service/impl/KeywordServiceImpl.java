package com.sanan.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableList;
import com.sanan.demo.data.entity.Keyword;
import com.sanan.demo.data.repository.KeywordRepository;
import com.sanan.demo.service.KeywordService;

@Service
public class KeywordServiceImpl implements KeywordService {
 
    @Autowired
    KeywordRepository keywordRepository;
     
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Keyword> selectKeywordList() {
        return ImmutableList.copyOf(keywordRepository.findAll());
    }
 
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Keyword> selectKeywordTop10List() {
    	return ImmutableList.copyOf(keywordRepository.findTop10ByOrderByCntDesc());
    }    
    
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Keyword selectKeyword(String id) {
        return keywordRepository.findOne(id);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void insertKeyword(Keyword keyword) {
    	keywordRepository.save(keyword);
    }
    
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void updateKeyword(Keyword keyword) {
    	if(keywordRepository.exists(keyword.getId())) {
    		Keyword one = keywordRepository.findOne(keyword.getId());
    		one.setCnt(one.getCnt() + 1);
    		keywordRepository.save(one);
    	} else {
    		keyword.setCnt(1);
    		keywordRepository.save(keyword);
    	}
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deleteKeyword(String id) {
    	keywordRepository.delete(id); 
    }
}
