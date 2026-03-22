package com.example.demo.Employee.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Employee.Dto.EmployeeDto;
import com.example.demo.Employee.Model.Employee;
import com.example.demo.Employee.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	private EmployeeDto mapToDTO(Employee emp) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(emp.getId());
		dto.setFirstName(emp.getFirstName());
		dto.setSecondName(emp.getSecondName());
		dto.setEmail(emp.getEmail());
		dto.setDepartment(emp.getDepartment());
		dto.setDesignation(emp.getDesignation());
		dto.setSalary(emp.getSalary());
		dto.setJoindate(emp.getJoindate());
		dto.setDob(emp.getDob());
		dto.setAge(emp.getAge());
		return dto;
	}

	public List<EmployeeDto> getEmployees() {
		return employeeRepository.findAll().stream().map(this::mapToDTO).toList();

	}

	public void addNewEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employeeDto.getEmail());

		if (employeeOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}

		Employee employee = mapToEntity(employeeDto);
		employeeRepository.save(employee);

	}

	private Employee mapToEntity(EmployeeDto dto) {
		Employee emp = new Employee();
		emp.setId(dto.getId());
		emp.setFirstName(dto.getFirstName());
		emp.setSecondName(dto.getSecondName());
		emp.setEmail(dto.getEmail());
		emp.setDepartment(dto.getDepartment());
		emp.setDesignation(dto.getDesignation());
		emp.setSalary(dto.getSalary());
		emp.setJoindate(dto.getJoindate());
		emp.setDob(dto.getDob());
		return emp;
	}

	public void deleteEmployee(Long employeeId) {

		boolean exists = employeeRepository.existsById(employeeId);

		if (!exists) {
			throw new IllegalStateException("Employee with id " + employeeId + " does not exist");
		}

		employeeRepository.deleteById(employeeId);

	}

	@Transactional
	public void updateEmployee(Long employeeId, EmployeeDto dto) {
		// TODO Auto-generated method stub

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new IllegalStateException("Employee with id " + employeeId + " does not exist"));

		if (dto.getFirstName() != null && !dto.getFirstName().equals(employee.getFirstName())) {
			employee.setFirstName(dto.getFirstName());

		}
		if (dto.getSecondName() != null && !dto.getSecondName().equals(employee.getSecondName())) {
			employee.setSecondName(dto.getSecondName());
		}

		if (dto.getEmail() != null && !dto.getEmail().equals(employee.getEmail())) {
			Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(dto.getEmail());
			if (employeeOptional.isPresent()) {
				throw new IllegalStateException("Email already taken");
			}
			employee.setEmail(dto.getEmail());
		}

	}

	public Page<EmployeeDto> getEmployeesPaged(int pageNo, int pageSize, String sortBy) {
		Sort sort = Sort.by(Sort.Direction.ASC, (sortBy != null && !sortBy.isEmpty()) ? sortBy : "id");
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		return employeeRepository.findAll(pageable).map(this::mapToDTO);

	}

}
