package com.practice.microservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeVersionController {

	@GetMapping("v1/employee")
	public EmployeeV1 employeeV1() {
		return new EmployeeV1("Alok Mrityunjay");
	}
	@GetMapping("v2/employee")
	public EmployeeV2 employeeV2() {
		return new EmployeeV2(new Name("Alok", "Mrityunjay"));
	}
}
