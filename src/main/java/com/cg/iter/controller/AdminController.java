package com.cg.iter.controller;


import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.dto.Question;
import com.cg.iter.dto.Test;
import com.cg.iter.service.QuestionService;
import com.cg.iter.service.TestService;
import com.cg.iter.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private TestService testservice;
	@Autowired
	private QuestionService questionservice;
	@Autowired
	private UserService userservice;

	
	//Add new Test
	@PostMapping("/addTest")
	public Test addTest(@RequestBody Test test)
	{
		return testservice.addTest(test);
	}
	
	//Update Test
	@PutMapping("/updateTest")
	public Test updateTest(@RequestBody Test test)
	{
		return testservice.updateTest(test);
		
	}
	
	//Delete test
	@DeleteMapping("/deleteTest")
	public String deleteTest(@RequestParam BigInteger testId)
	{

		return testservice.deleteTest(testId);
	}
	
			
		// Add question
		@PostMapping("/addQuestion")
		public Question addQuestion(@RequestParam BigInteger testId, @RequestBody Question question)
		{
			return questionservice.addQuestion(testId, question);

		}
		
		// Update question
		@PutMapping("/updateQuestion")
		public String updateQuestion(@RequestParam BigInteger testId,@RequestBody Question questionDetails)
		{
				 
			return questionservice.updateQuestion(testId,questionDetails);
		}
		
		// Delete question
		@DeleteMapping("/deleteQuestion")
		public String deleteQuestion(@RequestParam  BigInteger questionId)
		{

			return questionservice.deleteQuestion(questionId);
		}
		

		
		//aAssign test to user
		@PutMapping("/assignTest")
		public String assignTest(@RequestParam Long userId,
												@RequestParam BigInteger testId)
		{
			
					return userservice.assignTest(userId, testId);
		}
		
		
		
		// show question
		@GetMapping("/allQuestions")
		public List<Question> getQuestions() {

			return questionservice.findAllQuestions();

		}
		

		//show question by id
		@GetMapping("/findQuestionById")
		public Optional<Question> getQuestionsById(@RequestParam BigInteger testId)
		//		throws RecordNotFoundException 
		{

			return questionservice.findQuesById(testId);
		}

		public List<Test> getAllTest(BigInteger testId){
			return testservice.getAllTest(testId);
		}
		
		
//		// Get Test By Id
//				@GetMapping("/findTestById")
//				public Optional<Test> getTestById(@RequestParam BigInteger testId)
//				{
//					
//		          return testservice.getTestById(testId);
//				
//				}
//				
//				// Get All Test
//				@GetMapping("/AllTest")
//				public List<Test> getAllTest(BigInteger testId) {
//
//					return testservice.getAllTest(testId);
//
//				}

		
//		// Show questions
//		@GetMapping("/AllQuestions")
//		public List<Question> getQuestions() {
//
//			return questionservice.findAllQuestions();
//
//		}
//		
//		//Show question by id
//		@GetMapping("/findQuestionById")
//		public Optional<Question> getQuestionsById(@RequestParam BigInteger testId)
//		{
//				
//            return questionservice.findQuesById(testId);
//            
//		}
		
}
