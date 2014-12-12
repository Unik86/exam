package exam.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import exam.model.entity.Question;

@Resource
public class QuestionDaoImpl implements QuestionDao{
	
	@Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    @SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestions(int numberOfQuestions) {
        Session session = this.sessionFactory.openSession();
        String sql = "SELECT * FROM Question ORDER BY RAND() LIMIT %d";

        SQLQuery query = session.createSQLQuery(String.format(sql, numberOfQuestions));
        query.addEntity(Question.class);
                
        List<Question> questionList = query.list();
		return questionList;
	}

	@Override
	public int result(String userAnswers) {
        Session session = this.sessionFactory.openSession();
        String sql = "SELECT count(*) FROM Answer WHERE idAnswer IN (%s) AND isRight=true";

        Query query = session.createQuery(String.format(sql, userAnswers));
        int mark = ((Number) query.uniqueResult()).intValue();
		return mark;
	}	
}
