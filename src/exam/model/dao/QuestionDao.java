package exam.model.dao;

import java.util.List;

import exam.model.entity.Question;

public interface QuestionDao {
	public List<Question> listQuestions(int numberOfQuestions);
	public List<Boolean> result (String userAnswers);
}
