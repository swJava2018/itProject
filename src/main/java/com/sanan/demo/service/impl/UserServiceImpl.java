package com.sanan.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableList;
import com.sanan.demo.data.entity.User;
import com.sanan.demo.data.repository.UserRepository;
import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    UserRepository userRepository;
     
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<User> selectUserList() {
        return ImmutableList.copyOf(userRepository.findAll());
    }
 
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public User selectUser(String id) {
        return userRepository.findOne(id);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void insertUser(User user) throws SananException {    	
    	if(userRepository.exists(user.getId())) {
    		throw new SananException(SananErrorCode.USER_ALREADY_EXISTED);
    	} else {
    		userRepository.save(user);
    	}
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        userRepository.save(user);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deleteUser(String id) {
        userRepository.delete(id); 
    }
}
