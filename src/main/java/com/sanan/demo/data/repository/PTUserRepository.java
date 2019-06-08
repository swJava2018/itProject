package com.sanan.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.sanan.demo.data.entity.PTUser;

public interface PTUserRepository extends CrudRepository<PTUser, String>{
	
}
