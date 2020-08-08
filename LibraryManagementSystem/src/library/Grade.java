package library;

public class Grade{
	private int id;
	private String name;
	
	public Grade(int id) {
		super();
		this.id = id;
	}

	public Grade(int id, String name2) {
		super();
		this.id = id;
		this.name = name2;
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

	
}
