package com.sanan.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableList;
import com.sanan.demo.data.entity.PTUser;
import com.sanan.demo.data.entity.User;
import com.sanan.demo.data.repository.PTUserRepository;
import com.sanan.demo.data.repository.UserRepository;
import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.service.PTUserService;

@Service
public class PTUserServiceImpl implements PTUserService {
 
    @Autowired
    PTUserRepository userRepository;
     
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<PTUser> selectPTUserList() {
        return ImmutableList.copyOf(userRepository.findAll());
    }
 
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public PTUser selectPTUser(String id) {
        return userRepository.findOne(id);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void insertPTUser(PTUser user) throws SananException {    	
    	if(userRepository.exists(user.getId())) {
    		throw new SananException(SananErrorCode.USER_ALREADY_EXISTED);
    	} else {
    		userRepository.save(user);
    	}
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void updatePTUser(PTUser user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deletePTUser(String id) {
        userRepository.delete(id); 
    }
 

}
