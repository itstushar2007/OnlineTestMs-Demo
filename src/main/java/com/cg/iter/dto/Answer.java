package com.cg.iter.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {
	
	@ManyToOne
	Question question;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String value;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Answer [question=" + question + ", id=" + id + ", value=" + value + "]";
	}
	
	public Answer() {
		
	}
	
	
	

}
