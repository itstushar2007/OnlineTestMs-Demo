package com.cg.iter.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.cg.iter.dto.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query(value="select user_id from student where user_name and user_password=:password",nativeQuery = true)
	public Optional<BigInteger> checkLogin(String username,String password);
	
	@Query(value="select test_id from student where user_id=:userid",nativeQuery = true)
	public Long getTestByUserId(@Param("userid")Long userid);
	
	

}
