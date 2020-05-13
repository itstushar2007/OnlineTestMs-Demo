package com.cg.iter.service;
 
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.dto.Question;
import com.cg.iter.repository.QuestionRepository;
import com.cg.iter.repository.TestRepository;
@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private TestRepository testrepository;
	
	Question q = new Question();
	

	@Override
	public Question addQuestion(BigInteger testId, Question question) {
		
		question.setTest(testrepository.findById(testId).get());
	
		return questionRepository.save(question);
	}
	
	@Override
	public String deleteQuestion(BigInteger qid) {
		
		Optional<Question> find = questionRepository.findById(qid);
		if(find.isPresent())
		{
			questionRepository.deleteById(qid);
			return "Question Deleted";
		}
		else {
			return " Id is invalid";
		}
		
	}
	
	@Override
	public String updateQuestion(BigInteger testId, Question question) {
		
		System.out.println(
				"Question id is " + question.getQuestionId() + "   Question marks is  " + question.getMarksScored());
		System.out.println("Question  " + question);
		
		question.setTest(testrepository.findById(testId).get());

		questionRepository.save(question);
		
		return "Question Updated";
	}

	@Override
	public List<Question> findAllQuestions() {
		
		return (List<Question>) questionRepository.findAll();
	}
	

	@Override
	public Optional<Question> findQuesById(BigInteger id) {
		
		return questionRepository.findById(id);	}
	
	BigDecimal marks;

	@Override
	public BigDecimal calculateQuestionMarks(BigInteger id) {
		
		if(q.getQuestionAnswer() == q.getChosenAnswer())
		{
			marks = q.getQuestionMarks();
		}
		return marks;
		
	}



	}