package com.cg.iter.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "user_table")
public class User {
	
	@Id
	private Long userid;
	private String username;
	
	@OneToOne
	@JoinColumn(name= "testId")
	private Test userTest;
	
	private Boolean isAdmin;
	private String userpassword;
	private BigInteger test_id;
	
	public BigInteger getTest_id() {
		return test_id;
	}

	public void setTest_id(BigInteger test_id) {
		this.test_id = test_id;
	}

	public User() {
		
	}

	public User(Long userid, String username, Test useTest, Boolean isAdmin, String userpassword, BigInteger test_id) {
		super();
		this.userid = userid;
		this.username = username;
		this.userTest = useTest;
		this.isAdmin = isAdmin;
		this.userpassword = userpassword;
		this.test_id = test_id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Test getUserTest() {
		return userTest;
	}

	public void setUserTest(Test userTest) {
		this.userTest = userTest;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useTest=" + userTest + ", isAdmin=" + isAdmin
				+ ", userpassword=" + userpassword + "]";
	}
	
	
	
	
	
	

}
