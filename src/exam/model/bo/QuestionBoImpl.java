package exam.model.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exam.model.dao.QuestionDao;
import exam.model.entity.Question;

@Component
public class QuestionBoImpl implements QuestionBo{
	
	@Autowired
	QuestionDao questionDao;
	
	public void setQuestionDao(QuestionDao questintDao) {
		this.questionDao = questintDao;
	}
	
	@Override
	public List<Question> listQuestions(int numberOfQuestions) {		
		return questionDao.listQuestions(numberOfQuestions);
	}

	@Override
	public int result(String userAnswers) {
		return questionDao.result(userAnswers);
	}
}
