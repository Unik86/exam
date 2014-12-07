package exam.model.dao;

import java.util.List;

import exam.model.entity.Question;

public interface QuestionDao {
	public List<Question> listQuestions(int numberOfQuestions);
	public int result(String userAnswers);
}
