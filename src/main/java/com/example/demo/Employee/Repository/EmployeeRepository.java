package com.example.demo.Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee.Model.Employee;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
	
	
	
	@Query("SELECT e FROM Employee e WHERE e.email = ?1")
	Optional<Employee> findEmployeeByEmail(String email);

}
