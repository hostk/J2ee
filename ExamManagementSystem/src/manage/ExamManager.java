package manage;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import ems.Answer;
import ems.Question;

public class ExamManager {
	String driver ="com.mysql.cj.jdbc.Driver";
	String connection ="jdbc:mysql://localhost/ExamManagementSystem";
	String user = "root";
	String pass = "minkoko";
	public List<Question> getQuestionListByExam(int examId){
		List<Question> questionList = new ArrayList<Question>();
		try {
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(connection,user,pass);
		System.out.println("Connection successful");
		String sql ="select * from question where exam_id='"+examId+"'";
		
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			Question quest = new Question(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			questionList.add(quest);
		}
		con.close();

	}catch(Exception e) {
		e.printStackTrace();
	}
		return questionList;
	}
	public List<Answer> getAnswerListByQuestion(int id){
		List<Answer> ansList = new ArrayList<Answer>();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connection,user,pass);
			System.out.println("Connection successful");

			String sql ="select * from answer where question_id='"+id+"'";
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Answer quest = new Answer(rs.getInt(1),rs.getString(2),rs.getBoolean(3),rs.getInt(4));
				ansList.add(quest);
			}
			con.close();
			
		}catch(Exception e) {
			
		}
		
		return ansList;
	}
	public List<Question> getQuestionWithAnswerByExam(int id){
		
		List<Question> questionList=getQuestionListByExam(id);
		
		questionList.forEach(q ->{
			List<Answer> ansList = getAnswerListByQuestion(q.getId());
			q.setAnswerList(ansList);
		});
		return questionList;
	}
}
