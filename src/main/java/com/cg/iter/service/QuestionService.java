package com.cg.iter.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.cg.iter.dto.Question;

public interface QuestionService {
	
	//public void saveQuestion(Question q);
	public Question addQuestion(BigInteger testId,Question question);
	public String deleteQuestion(BigInteger qid);
	public String updateQuestion(BigInteger testId,Question question);
	public List<Question> findAllQuestions();
	public Optional<Question> findQuesById(BigInteger id);
	public BigDecimal calculateQuestionMarks(BigInteger id);


}
