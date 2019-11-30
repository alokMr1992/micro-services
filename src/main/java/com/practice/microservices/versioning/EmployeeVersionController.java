package com.practice.microservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeVersionController {

	/*
	 * below are basic URI versioning
	 */
	@GetMapping("v1/employee")
	public EmployeeV1 employeeV1() {
		return new EmployeeV1("Alok Mrityunjay");
	}
	
	@GetMapping("v2/employee")
	public EmployeeV2 employeeV2() {
		return new EmployeeV2(new Name("Alok", "Mrityunjay"));
	}
	
	/*
	 * below are request parameter versioning
	 */
	@GetMapping(value = "employee/params", params = "version=1")
	public EmployeeV1 paramEmployeeV1() {
		return new EmployeeV1("Alok Mrityunjay");
	}
	
	@GetMapping(value = "employee/params", params = "version=2")
	public EmployeeV2 paramEmployeeV2() {
		return new EmployeeV2(new Name("Alok", "Mrityunjay"));
	}
	
	/*
	 * below are custom header versioning
	 */
	@GetMapping(value = "employee/header", headers = "x-api-version=1")
	public EmployeeV1 headerEmployeeV1() {
		return new EmployeeV1("Alok Mrityunjay");
	}
	
	@GetMapping(value = "employee/header", headers = "x-api-version=2")
	public EmployeeV2 headerEmployeeV2() {
		return new EmployeeV2(new Name("Alok", "Mrityunjay"));
	}
	
	/*
	 * below are media type versioning
	 * also know as content negotiation or accept header versioning
	 */
	@GetMapping(value = "employee/produces", produces = "application/my.company.app-v1+json")
	public EmployeeV1 producesEmployeeV1() {
		return new EmployeeV1("Alok Mrityunjay");
	}
	
	@GetMapping(value = "employee/produces", produces = "application/my.company.app-v2+json")
	public EmployeeV2 producesEmployeeV2() {
		return new EmployeeV2(new Name("Alok", "Mrityunjay"));
	}
}
