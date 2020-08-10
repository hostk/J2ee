package library;

public class RentReturn {
	private int studentId;
	private int bookId;
	private String rentDate;	
	private String retrunDate;
	private String bookRent;
	private String bookReturn;
	private String studentName;
	private String bookName;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public RentReturn(int studentId, String studentName,String bookName, String rentDate) {
		super();
		this.studentId = studentId;
		this.rentDate = rentDate;
		this.studentName = studentName;
		this.bookName = bookName;
	}
	public RentReturn(int studentId, int bookId, String rentDate, String retrunDate, String bookRent,
			String bookReturn) {
		super();
		this.studentId = studentId;
		this.bookId = bookId;
		this.rentDate = rentDate;
		this.retrunDate = retrunDate;
		this.bookRent = bookRent;
		this.bookReturn = bookReturn;
	}
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getRetrunDate() {
		return retrunDate;
	}
	public void setRetrunDate(String retrunDate) {
		this.retrunDate = retrunDate;
	}
	public String getBookRent() {
		return bookRent;
	}
	public void setBookRent(String bookRent) {
		this.bookRent = bookRent;
	}
	public String getBookReturn() {
		return bookReturn;
	}
	public void setBookReturn(String bookReturn) {
		this.bookReturn = bookReturn;
	}
	
}
