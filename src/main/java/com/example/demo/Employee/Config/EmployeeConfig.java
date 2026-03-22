package com.example.demo.Employee.Config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Employee.Model.Employee;
import com.example.demo.Employee.Repository.EmployeeRepository;

@Configuration
public class EmployeeConfig {

	@Bean
	CommandLineRunner commandlinerunner(EmployeeRepository repository) {

		return args -> {
			Employee mohit = new Employee(null, "Mohit", "Chopra", "mohitchopra573@gmail.com", "It", "Developer",
					15000d, LocalDate.of(2019, 10, 06), LocalDate.of(2000, 07, 06)
			// 25

			);
			Employee prashant = new Employee(null, "Prashant", "Dhiman", "prd101@gmail.com", "Associate", "Developer",
					12000d, LocalDate.of(2025, 02, 06), LocalDate.of(2001, 11, 21)
			// 28
			);

			repository.saveAll(List.of(mohit, prashant));
		};
	}

}
