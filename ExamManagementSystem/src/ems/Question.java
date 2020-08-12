package ems;

import java.util.List;

public class Question {
	private int id;
	private String name;
	private int mark;
	private int examId;
	private List<Answer> answerList;
	private List<Question> questionList;
	
	public Question(int id, String name, int mark, int examId, List<Question> questionList, List<Answer> answerList) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.examId = examId;
		this.questionList = questionList;
		this.answerList = answerList;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public Question(int id, String name, int mark, int examId, List<Answer> answerList) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.examId = examId;
		this.answerList = answerList;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public Question(int id, String name, int mark, int examId) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.examId = examId;
	}
	public Question(int questionId) {
		this.id=questionId;
	}
	public Question(int qid, String string2) {
		this.name=string2;
		this.id=qid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	
}
