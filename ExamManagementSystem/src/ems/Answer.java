package ems;

public class Answer {
	private int id;
	private String name;
	private boolean status;
	private int questionId;
	public Answer(int id, String name, boolean status, int questionId) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.questionId = questionId;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
