package hibernate_jsp_example.usermanagement.model;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="country")
	private String country;
	
	public User() {
		
	}

	public User(int id, String name, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public User(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}