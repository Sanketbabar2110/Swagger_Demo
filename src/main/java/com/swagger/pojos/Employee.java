package com.swagger.pojos;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	private int Id;
	private String Name;
	private int Age;
	private double Salary;
	private String Email;
	private Date JoiningDate;
	private Department department;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@NotBlank(message = "Name is mandatory")
	@Column(name = "EMP_NAME")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@NotNull(message = "Age is mandatory")
	@Max(55)
	@Min(18)
	@Column(name = "EMP_AGE")
	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	@NotNull(message = "Salary is mandatory")
	@Column(name = "EMP_SALARY")
	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	@NotBlank(message = "Eamil is mandatory")
	@Email
	@Column(name = "EMP_EMAIL")
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "EMP_JOINING_DATE")
	public Date getJoiningDate() {
		return JoiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		JoiningDate = joiningDate;
	}

	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPT_ID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", Salary=" + Salary + ", Email=" + Email
				+ ", JoiningDate=" + JoiningDate + ", department=" + department + "]";
	}

}
