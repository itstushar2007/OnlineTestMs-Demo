package com.cg.iter.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.dto.Test;

public interface TestRepository extends CrudRepository<Test, BigInteger>{
	
	

}
