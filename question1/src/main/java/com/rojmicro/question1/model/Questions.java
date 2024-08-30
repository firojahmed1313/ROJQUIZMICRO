package com.rojmicro.question1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Questions {
	
	@Id
	private Integer id;
	private String category;
	private String difficultylevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String question;
	private String ans;
	
	
	public Questions() {}
	
	
	public Questions(int id, String category, String difficultyLevel, String option1, String option2, String option3,
			String option4, String question, String ans) {
		super();
		this.id = id;
		this.category = category;
		this.difficultylevel = difficultyLevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.question = question;
		this.ans = ans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCatagory(String catagory) {
		this.category = catagory;
	}
	public String getDifficultyLevel() {
		return difficultylevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultylevel = difficultyLevel;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}


	@Override
	public String toString() {
		return "Questions [id=" + id + ", category=" + category + ", difficultyLevel=" + difficultylevel + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", question="
				+ question + ", ans=" + ans + "]";
	}
	
	
	
}
