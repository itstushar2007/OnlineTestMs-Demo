package com.cg.iter.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.dto.Test;
import com.cg.iter.dto.User;
import com.cg.iter.repository.TestRepository;
import com.cg.iter.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	TestRepository testrepository;
	
	//Add User
	    @Override
		public User addUser(User user)
		   {
			   return  userrepository.save(user);		   
		   }
		 
		 
	//Update User	
		    @Override
			public User updateUser(@Valid @RequestBody User user)
				{
					Optional<User> findById=userrepository.findById(user.getUserid());
					
					if(findById.isPresent())
					{
						
						 return  userrepository.save(user); 	
					}
					else
						{return null;}
//					else {
//						throw new RecordNotFoundException("Record not present");
//						}
//					}
//					catch(RecordNotFoundException e) {
//					return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
//					
//				}
					}
			
				
	//Delete User	 
		 @Override
		 public String deleteUser(Long userid) //throws RecordNotFoundException
		    {
			 Optional<User> findById = userrepository.findById(userid);
				if (findById.isPresent()) {
					userrepository.deleteById(userid);
					return "deleted";
				} else {
					return "!!   Id Is Invalid   !!";
				}
		    }
		 
		 
	//Get All User
		 @Override
		 public List<User> getAllUser(Long  userid){
		    	
			    System.out.println("All Students are:");
		    	return (List<User>) userrepository.findAll();  	
		    }
		 

	//Get User By Id
		 @Override
		 public Optional<User> getUSerById( Long userid)  //throws RecordNotFoundException
		 {
		    	Optional<User> user=userrepository.findById(userid);
		    	return user;
		    	
//		   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +userid));
//		    	return ResponseEntity.ok().body(user);
		    
		 }
		 
		 
		//login	
		 @Override
		 public BigInteger checkLogin(String  username,String password)
		 {
	   
			 Optional<BigInteger> findById=userrepository.checkLogin(username, password);
					 if(findById.isPresent()) {
				 BigInteger id=findById.get();
				 return id;
			 }
			 else return null;
		 }
		 
		 
		 //getTestByUserId
		 @Override
			public Long getTestByUserId(Long userid)  //throws RecordNotFoundException
			{

				Long id1= userrepository.getTestByUserId(userid);
						return id1;
			}

		 
	    //AssignTest
		 @Override
		 public String assignTest(Long userid,BigInteger testid)
			{
				Optional<User>findById=userrepository.findById(userid);
				Optional<Test>test=testrepository.findById(testid);
				if(findById.isPresent()&& test.isPresent())
				{
					User user=findById.get();
					user.setTest_id(testid);
					userrepository.save(user);
					return "Test Assigned";
					
				}
				return "User or Test does not exist";
				
			}

}
