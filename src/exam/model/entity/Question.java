package exam.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {

	@Id
    @Column(name="idQuestion")
	private int idQuestion;
	
	@Column(name="textQuestion")
	private String textQuestion;
	
	@OneToMany(mappedBy="question")
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
