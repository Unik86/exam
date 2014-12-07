package exam.model.bo;

import java.util.List;

import exam.model.entity.Question;

public interface QuestionBo {
	public List<Question> listQuestions(int numberOfQuestions);
	public int result (String userAnswers);
}
