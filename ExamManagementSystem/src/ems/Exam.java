package ems;

public class Exam {
	private int id;
	private String name;
	private int totalMark;
	public Exam(int id, String name, int totalMark) {
		super();
		this.id = id;
		this.name = name;
		this.totalMark = totalMark;
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
	public int getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}
	
}
