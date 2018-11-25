package com.selenium.datadriven.fileread;

public class Employee {

	private String employeeName;
	private int empAge;
	private String empBirthDay;

	public Employee(String name, int age, String birthDay) {
		this.employeeName = name;
		this.empAge = age;
		this.empBirthDay = birthDay;

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpBirthDay() {
		return empBirthDay;
	}

	public void setEmpBirthDay(String empBirthDay) {
		this.empBirthDay = empBirthDay;
	}
	

}
