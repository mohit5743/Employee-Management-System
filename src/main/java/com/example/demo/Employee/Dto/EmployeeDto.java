package com.example.demo.Employee.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "firstName", "secondName", "email", "department", "designation", "salary", "joindate", "dob",
		"age" })
public class EmployeeDto {

	private Long id;

	private String firstName;

	private String secondName;

	private String email;

	private String department;

	private String designation;

	private Double salary;

	private LocalDate joindate;

	private LocalDate dob;

	private Integer age;

}
