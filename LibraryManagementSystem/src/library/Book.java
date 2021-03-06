package library;

public class Book extends Category{
	private int id;
	private String bname;
	private String author;
	private String isbn;
	private double price;
	private int qty;
	private int cat;
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book(int id,String bname, String author, String isbn, double price, int qty,int categoryId) {
		super(categoryId);
		this.id=id;
		this.cat=categoryId;
		this.bname = bname;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.qty = qty;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
