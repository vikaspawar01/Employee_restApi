package com.example.empApi.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Emp {
	private Integer id;
	

	@Size(max = 20, message = "max 20 characters are allowed")
	@Pattern(regexp = "[a-zA-Z]+",message = "Only Characters are Allow")
	private String first_name;

	@Size(max = 20, message = "max 20 characters are allowed")
	@Pattern(regexp = "[a-zA-Z]+",message = "Only Characters are Allow")
	private String last_name;
	
	@NotNull(message = "Email is required")
	@Email(message = "please enter valid email address")
	private String email;
	
	@NotBlank(message = "password must not be blank")
	@Size(min = 6,max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]+",message = "Only AlphaNumeric Characters Allow")
	private String password;
	
	@NotBlank(message = "salary must be filled")
	@Pattern(regexp = "[0-9]+",message = "only Numerics are Alow")
	@Size(min = 4,max = 6)
	private String salary;
	
	@NotBlank(message = "department must be filled")
	@Size(max = 20, message = "max 20 characters are allowed")
	@Pattern(regexp = "[a-zA-Z]+",message = "Only Characters are Allow")
	private String department;
	
	@Pattern(regexp = "[a-zA-Z]+",message = "Only Characters are Allow")
	private String city;
	
	public Emp(Integer id, String first_name, String last_name, String email, String password, String salary,
			String department, String city) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.department = department;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", salary=" + salary + ", department=" + department + ", city=" + city
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Emp() {
		
	}
}
