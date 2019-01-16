package com.sanan.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.sanan.demo.data.entity.User;

public interface UserRepository extends CrudRepository<User, String>{
	
}
