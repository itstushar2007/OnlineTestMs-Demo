package com.cg.iter.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cg.iter.dto.Question;
import com.cg.iter.dto.Test;
import com.cg.iter.dto.User;
import com.cg.iter.repository.QuestionRepository;
import com.cg.iter.repository.TestRepository;
import com.cg.iter.repository.UserRepository;

@EntityScan(basePackages = {"com.cg.iter.dto"} )
@EnableJpaRepositories(basePackages = {"com.cg.iter.repository"})
@SpringBootApplication
public class OnlineTestManagementApplication {
	
	@Autowired
	UserRepository repo;
	@Autowired
	TestRepository trepo;
	@Autowired
	QuestionRepository qrepo;
	
	@PostConstruct
	public void init() {
		
		
		Question question = new Question(new BigInteger("5"), "demo question"
				,4, new BigDecimal(50.2), 4, new BigDecimal(50.2));
		
		Set<Question> set = new HashSet<>();
		set.add(question);
		
		Test test = new Test(new BigInteger("88")
				, "demoTest",LocalTime.now(),set,
				new BigDecimal(54.0),new BigDecimal(54.0) ,
				question, LocalDateTime.now(), LocalDateTime.now());
		
		
		User user = new User((long) 25, "xyz",test, true, "userpassword",new BigInteger("5"));
		test.setUserId(user);
		
		repo.save(user);
		trepo.save(test);
		qrepo.save(question);
		
	}

	public static void main(String[] args) {
		
		SpringApplication.run(OnlineTestManagementApplication.class, args);
		//SpringApplication.run(OnlineTestManagementApplication.class, args);
		//ConfigurableApplicationContext ctx = 
	
	}

}
