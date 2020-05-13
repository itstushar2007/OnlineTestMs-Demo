package com.cg.iter.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.dto.User;

public interface UserService {
	
	public User addUser(User user);
	public User updateUser(@Valid @RequestBody User user);
	public String deleteUser(Long userid);
	public List<User> getAllUser(Long  userid);
    public Optional<User> getUSerById( Long userid);
	public BigInteger checkLogin(String  username,String password);
	public Long getTestByUserId(Long userid);
	public String assignTest(Long userid,BigInteger testid);

}
