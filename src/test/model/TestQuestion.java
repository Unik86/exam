package test.model;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.model.bo.QuestionBo;
import exam.model.dao.QuestionDao;
import exam.model.entity.Question;

public class TestQuestion {
		
	@Test
	public void quet(){
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("file:WebContent/WEB-INF/spring/Spring-Module.xml");
		QuestionBo questionBo = (QuestionBo)appContext.getBean("questionBo");
		QuestionDao questionDao = (QuestionDao)appContext.getBean("questionDao");
		
		List<Question> list = questionBo.listQuestions(5);

		for(Question q : list)
			System.out.println(q);
		
//		List<Boolean> list = questionDao.result("1,2,3,4,5,6,7");
//		for(Boolean q : list)
//			System.out.println(q);
		
//		System.out.println(questionBo.result("1,2,3"));
	}
}
