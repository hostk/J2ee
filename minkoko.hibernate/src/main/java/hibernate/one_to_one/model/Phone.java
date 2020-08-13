package hibernate.one_to_one.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="phone_one_to_one")
public class Phone implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String no;

	@OneToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public Phone(Integer id, String no, Employee employee) {
		super();
		this.id = id;
		this.no = no;
		this.employee = employee;
	}

	public Phone() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
}
