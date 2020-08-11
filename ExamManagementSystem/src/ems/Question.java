package ems;

public class Question {
	private int id;
	private String name;
	private int mark;
	private int examId;
	public Question(int id, String name, int mark, int examId) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.examId = examId;
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
