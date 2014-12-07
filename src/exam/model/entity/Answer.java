package exam.model.entity;

public class Answer {
	private int idAnswer;
	private String textAnswer;
	private boolean isRight;
	
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
