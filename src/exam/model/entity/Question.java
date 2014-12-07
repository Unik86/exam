package exam.model.entity;

import java.util.List;

public class Question {

	private int idQuestion;
	
	private String textQuestion;
	
	private List<Answer> allAnswer;
	
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getTextQuestion() {
		return textQuestion;
	}
	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
	}
	public List<Answer> getAllAnswer() {
		return allAnswer;
	}
	public void setAllAnswer(List<Answer> allAnswer) {
		this.allAnswer = allAnswer;
	}
	@Override
	public String toString() {
		return idQuestion + " " + textQuestion + "\n   " + allAnswer;
	}
	
}
