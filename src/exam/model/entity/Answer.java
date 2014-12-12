package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Answer")
public class Answer {
	
	@Id
    @Column(name="idAnswer")
	private int idAnswer;
	
	@Column(name="textAnswer")
	private String textAnswer;
	
	@Transient
	//@Column(name="isRight")
	private boolean isRight;
	
	@ManyToOne
    @JoinColumn(name="idQuestion_parent", insertable=false, updatable=false)
	private Question question;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getIdAnswer() {
		return idAnswer;
	}
	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}
	public String getTextAnswer() {
		return textAnswer;
	}
	public void setTextAnswer(String textAnswer) {
		this.textAnswer = textAnswer;
	}

	public boolean isRight() {
		return isRight;
	}
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
	@Override
	public String toString() {
		return idAnswer + " " + textAnswer + " " + isRight + "\n  ";
	}
	
}
