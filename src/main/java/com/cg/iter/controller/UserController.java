package com.cg.iter.controller;

import java.math.BigDecimal;
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
import com.cg.iter.dto.User;
import com.cg.iter.service.QuestionService;
import com.cg.iter.service.TestService;
import com.cg.iter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	TestService testservice;
	@Autowired
	QuestionService questionservice;
	@Autowired
	UserService userservice;
	
	// add new user
		@PostMapping("/addUser")
		public User addStudent(@RequestBody User user) 
		{

			return userservice.addUser(user);

		}
		
		// update user
		@PutMapping("/updateUser")
		public User updateUser( @RequestBody User user )
				//throws RecordNotFoundException 
		{

			return userservice.updateUser(user);
		}
		
		// delete user
		@DeleteMapping("/deleteUser")
		public String deleteStudent(@RequestParam Long userid) //throws RecordNotFoundException 
		{

			return userservice.deleteUser(userid);
		}

		// get user By Id
		@GetMapping("/findUserById")
		public Optional<User> getUSerById(@RequestParam Long userid)
				//throws RecordNotFoundException
		{

			return  userservice.getUSerById(userid);
		}

		// Get All users
		@GetMapping("/AllUsers")
		public List<User> getAllUser(Long userid) {

			return userservice.getAllUser(userid);
		}

		
		//login
		@GetMapping("/login")
		public BigInteger validUserLogin(@RequestParam String username,@RequestParam String password)
		{
			return userservice.checkLogin(username, password);
		}

		
		 //getTestIdByUserId
		@GetMapping("/getTestByUserId")
		public Long  getTestIdByUserId(@RequestParam Long userid)
		//		throws RecordNotFoundException 
		{

			Long tid= userservice.getTestByUserId(userid);
			 return tid;
			
		}
		
		//getTest
		@GetMapping("/getTest")
			public Optional<Question> getQuestionById(@RequestParam BigInteger testid)
					//throws RecordNotFoundException
			{

				return questionservice.findQuesById(testid);
			}
		
		//get result
		public BigDecimal getResult(Test test) 
		{
//		try {
//				return testservice.calculateTotalMarks(test.getTestId());
//		
//		}catch(RecordNotFoundException e) {
//				e.printStackTrace();
//			}
			return testservice.calculateTotalMarks(test.getTestId());
			
		}

		
		


	
	
	
}

