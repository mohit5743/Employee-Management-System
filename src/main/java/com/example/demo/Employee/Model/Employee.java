package com.example.demo.Employee.Model;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "firstName", "secondName", "email", "department", "designation", "salary", "joindate", "dob",
		"age" })
public class Employee {

	@Id
	@SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
	private Long id;

	private String firstName;

	private String secondName;

	private String email;

	private String department;

	private String designation;

	private Double salary;

	private LocalDate joindate;

	private LocalDate dob;

	@Transient
	private Integer age;

	public Employee(Integer age) {
		super();
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getJoindate() {
		return joindate;
	}

	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Employee(Long id, String firstName, String secondName, String email, String department, String designation,
			Double salary, LocalDate joindate, LocalDate dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.joindate = joindate;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email
				+ ", department=" + department + ", designation=" + designation + ", salary=" + salary + ", joindate="
				+ joindate + ", dob=" + dob + ", age=" + age + "]";
	}

}
