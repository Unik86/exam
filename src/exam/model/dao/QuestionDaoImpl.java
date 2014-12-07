package exam.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import exam.model.entity.Question;

public class QuestionDaoImpl implements QuestionDao{
	
	@Override
	public List<Question> listQuestions(int numberOfQuestions) {
		return null;
	}

	@Override
	public List<Boolean> result(String userAnswers) {
		return null;
	}

	
}
