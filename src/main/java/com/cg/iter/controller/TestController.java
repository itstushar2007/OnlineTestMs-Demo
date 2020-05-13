package com.cg.iter.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.service.TestService;


@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testservice;
	

		
		// Calculate total marks
		@GetMapping("/getMarks")
		public BigDecimal calculateTotalMarks(@RequestParam BigInteger testId)
		{
			return testservice.calculateTotalMarks(testId);
		}
		
		

}
