package com.practice.microservices.versioning;

public class EmployeeV2 {

	private Name name;

	public EmployeeV2() {
		super();
	}

	public EmployeeV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
