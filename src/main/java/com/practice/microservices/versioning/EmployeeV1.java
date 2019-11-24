package com.practice.microservices.versioning;

public class EmployeeV1 {

	private String name;

	public EmployeeV1() {
		super();
	}

	public EmployeeV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
