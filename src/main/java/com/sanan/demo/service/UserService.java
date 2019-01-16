package com.sanan.demo.service;

import java.util.List;

import com.sanan.demo.data.entity.User;
import com.sanan.demo.exception.SananException;

public interface UserService {
	/**
     * 사용자 목록 조회
     * @return
     */
    public List<User> selectUserList();
     
    /**
     * 사용자 조회
     * @param id
     * @return
     */
    public User selectUser(String id);
     
    /**
     * 사용자 등록
     * @param user
     */
    public void insertUser(User user) throws SananException;
     
    /**
     * 사용자 정보 수정
     * @param user
     */
    public void updateUser(User user);
     
    /**
     * 사용자 삭제
     * @param id
     */
    public void deleteUser(String id);
}
