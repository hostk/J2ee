package library;

public class Student extends Grade {
	private int id;
	private String name;
	private String rollNo;
	private String phoneNo;
	private int gradeId;
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Student(int id,String name,String rollno,String phoneno,int gradeId) {
		super(gradeId);
		this.gradeId=gradeId;
		this.name=name;
		this.id=id;
		this.rollNo=rollno;
		this.phoneNo=phoneno;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
