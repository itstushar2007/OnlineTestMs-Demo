package com.cg.iter.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.iter.dto.Test;

import com.cg.iter.repository.QuestionRepository;
import com.cg.iter.repository.TestRepository;
import com.cg.iter.repository.UserRepository;


@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testrepository;
	@Autowired
	QuestionRepository questionrepository;
	@Autowired
	UserRepository userrepository;
	
	@Override
	public Test addTest(Test test) {
		
		return testrepository.save(test);
		
	}
	

	@Override
	public Test updateTest(Test test) {
		
		Optional<Test> find= testrepository.findById(test.getTestId());
		if(find.isPresent())
		{
			return  testrepository.save(test);
		}
		else return null;
		
	}
	

	@Override
	public String deleteTest(BigInteger testId) {
		
		Optional<Test> find = testrepository.findById(testId);
		if(find.isPresent())
		{
			testrepository.deleteById(testId);
			return "Test Deleted ...." ;
		}
		else return "Invalid test Id";
	}
	
	@Override
	public List<Test> getAllTest(BigInteger testId) {
		
		return (List<Test>) testrepository.findAll();
		
	}
	
	@Override
	public Optional<Test> getTestById(BigInteger testId) {
		
		return testrepository.findById(testId);
		
	}

	
	@Override
	public BigDecimal calculateTotalMarks(BigInteger testId) {
		
		testrepository.findById(testId);
		QuestionServiceImpl service = new QuestionServiceImpl();
		Test test = new Test();
		
		 test.setTestTotalMarks(service.calculateQuestionMarks(testId));
		 
		 return test.getTestTotalMarks();
		 
	}

//
//	@Override
//	public String assignTest(Long userId, BigInteger testId)
//	{
//		Optional<User> find = userrepository.findById(userId);
//		Optional<Test> find1 = testrepository.findById(testId);
//		if(find.isPresent() && find1.isPresent())
//		{
//			User user = find.get();
//			user.setTest_id(testId);
//			userrepository.save(user);
//			return "Test Assigned Successfully..." ;
//			
//		}
//		else return "User or Test does not exist";
//	}


//	@Override
//	public BigDecimal getResult(Test test)
//	{
//		Optional<Test> find = testrepository.findById(test.getTestId());
//		if(find.isPresent()) {
//			
//			return test.getTestMarksScored();
//			
//		}else return null;
//	
//	}	

	

//
//	@Override
//	public String giveTest(BigInteger testId) {
//		
//		
//	}
	
	
			
			
		
		
//		BigDecimal tmarks = new BigDecimal("0.0");
//		List<Question> list = (List<Question>) questionrepository.findAll();
//		for(Question ques:list)
//		{
//			tmarks= tmarks.add(ques.getMarksScored());
//		}
//		
//		
//		return tmarks;
	


	


	








	
	

		
}
