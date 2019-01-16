package com.sanan.demo.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sanan.demo.data.entity.Keyword;

public interface KeywordRepository extends CrudRepository<Keyword, String>{
	List<Keyword> findTop10ByOrderByCntDesc();
}
