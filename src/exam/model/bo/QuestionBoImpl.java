package exam.model.bo;

import java.util.List;

import exam.model.dao.QuestionDao;
import exam.model.entity.Question;

public class QuestionBoImpl implements QuestionBo{
	
	QuestionDao questionDao;
	
	public void setQuestionDao(QuestionDao questintDao) {
		this.questionDao = questintDao;
	}
	
	@Override
	public List<Question> listQuestions(int numberOfQuestions) {		
		return this.questionDao.listQuestions(numberOfQuestions);
	}

	@Override
	public int result(String userAnswers) {
		List<Boolean> res = this.questionDao.result(userAnswers);
		int mark = 0;
		for(boolean b : res)
			if(b) mark++;
		return mark;
	}
	
}
