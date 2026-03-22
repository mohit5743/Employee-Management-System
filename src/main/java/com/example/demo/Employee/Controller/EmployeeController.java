package com.example.demo.Employee.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee.Dto.EmployeeDto;
import com.example.demo.Employee.Service.EmployeeService;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping
	public List<EmployeeDto> getEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/pagination")
	public Page<EmployeeDto> getEmployeePage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy) {

		return service.getEmployeesPaged(page, size, sortBy);
	}

	@PostMapping
	public ResponseEntity<String> registerNewEmployee(@RequestBody EmployeeDto employeeDto) {
		service.addNewEmployee(employeeDto);
		return ResponseEntity.ok("Employee created Successfully");
	}

	@PutMapping(path = "{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto) {
		service.updateEmployee(employeeId, employeeDto);
		return ResponseEntity.ok("Employee details updated successfully");
	}

	@DeleteMapping(path = "{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
		service.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted Successfully");
	}

}
