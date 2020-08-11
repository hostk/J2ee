package ems;

public class Student {
	private int id;
	private String name;
	private String rollNo;
	private String nrc;
	private String phone;
	public Student(int id, String name, String rollNo, String nrc, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.nrc = nrc;
		this.phone = phone;
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
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
