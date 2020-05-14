package com.cg.iter.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name= "question_table")
public class Question {
	@Id
	private BigInteger questionId;
	
	@OneToMany(targetEntity = Answer.class,cascade= CascadeType.ALL, mappedBy="question")
	private ArrayList<String> questionOptions;
	private String questionTitle;
	private Integer questionAnswer;
	private BigDecimal questionMarks;
	private Integer chosenAnswer;
	private BigDecimal marksScored;
	
	@OneToOne
	@JoinColumn(name="Test_NUMBER")
	private Test test;
	
	
	public Question() {}

	public Question(BigInteger questionId, ArrayList<String> questionOptions, String questionTitle,
			Integer questionAnswer, BigDecimal questionMarks, Integer chosenAnswer, BigDecimal marksScored) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	
	}
	

	public Question(BigInteger questionId, String questionTitle, Integer questionAnswer, BigDecimal questionMarks,
			Integer chosenAnswer, BigDecimal marksScored) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionOptions=" + questionOptions + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks=" + questionMarks
				+ ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + "]";
	}

	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public BigInteger getQuestionId() {
		return questionId;
	}

	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}

	public ArrayList<String> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(ArrayList<String> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Integer getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}

	public Integer getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(Integer chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public BigDecimal getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}
	
	

}
