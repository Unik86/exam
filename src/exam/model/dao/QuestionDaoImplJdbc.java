package exam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import exam.model.entity.Answer;
import exam.model.entity.Question;

public class QuestionDaoImplJdbc implements QuestionDao{
		
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Question> listQuestions(int numberOfQuestions) {
		List<Question> list = new ArrayList<Question>();
		String sql = "SELECT * FROM Question ORDER BY RAND() LIMIT ?";
		
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numberOfQuestions);
			
			ResultSet rsQuestion = ps.executeQuery();
			Question question;
			Answer answer;
			List<Answer> listAnswer;
			while(rsQuestion.next()) {
				question = new Question();
				question.setIdQuestion(rsQuestion.getInt("idQuestion"));
				question.setTextQuestion(rsQuestion.getString("textQuestion"));
				
				listAnswer = new ArrayList<Answer>();
				String sqlAnswer = "SELECT * FROM Answer WHERE idQuestion_parent=?";
				ps = conn.prepareStatement(sqlAnswer);
				ps.setInt(1, question.getIdQuestion());
				ResultSet rsAns = ps.executeQuery();
				while(rsAns.next()){
					answer = new Answer();
					answer.setIdAnswer(rsAns.getInt("idAnswer"));
					answer.setTextAnswer(rsAns.getString("textAnswer"));
					//answer.setRight(rsAns.getBoolean("isRight"));
					listAnswer.add(answer);
				}
				question.setAllAnswer(listAnswer);
				list.add(question);
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		return list;
	}

	@Override
	public int result(String userAnswers) {
		int mark = 0;
		String sql = "SELECT count(*) FROM Answer WHERE idAnswer IN (%s) AND isRight=true";
		
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(String.format(sql, userAnswers));
			ResultSet rsResult = ps.executeQuery();

			if(rsResult.next()) {
				mark = rsResult.getInt(1);
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		return mark;
	}
	
}
