package com.sanan.demo.service;

import java.util.List;

import com.sanan.demo.data.entity.PTUser;
import com.sanan.demo.data.entity.User;
import com.sanan.demo.exception.SananException;

public interface PTUserService {
	/**
     * 사용자 목록 조회
     * @return
     */
    public List<PTUser> selectPTUserList();
     
    /**
     * 사용자 조회
     * @param id
     * @return
     */
    public PTUser selectPTUser(String id);
     
    /**
     * 사용자 등록
     * @param user
     */
    public void insertPTUser(PTUser user) throws SananException;
     
    /**
     * 사용자 정보 수정
     * @param user
     */
    public void updatePTUser(PTUser user);
     
    /**
     * 사용자 삭제
     * @param id
     */
    public void deletePTUser(String id);
}
