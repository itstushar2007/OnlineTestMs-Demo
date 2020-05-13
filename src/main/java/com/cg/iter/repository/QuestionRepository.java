package com.cg.iter.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cg.iter.dto.Question;

public interface QuestionRepository extends CrudRepository<Question, BigInteger> {
	@Query(value="select * from question_table where test_id=:id",nativeQuery = true)
	public Question[] findQuesById(BigInteger id);
	

}
