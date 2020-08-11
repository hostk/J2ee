package ems;

public class StudentExamAnswer {
	private int id;
	private int studentExamId;
	private int questionId;
	private int answerId;
	public StudentExamAnswer(int id, int studentExamId, int questionId, int answerId) {
		super();
		this.id = id;
		this.studentExamId = studentExamId;
		this.questionId = questionId;
		this.answerId = answerId;
	}
	
	public StudentExamAnswer(int studentExamId, int questionId, int answerId) {
		super();
		this.studentExamId = studentExamId;
		this.questionId = questionId;
		this.answerId = answerId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentExamId() {
		return studentExamId;
	}
	public void setStudentExamId(int studentExamId) {
		this.studentExamId = studentExamId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
}
