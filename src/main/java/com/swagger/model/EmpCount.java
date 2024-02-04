package com.swagger.model;

public class EmpCount {

	private int dept;
	private int employeeCount;

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	@Override
	public String toString() {
		return "EmpCount [dept=" + dept + ", employeeCount=" + employeeCount + "]";
	}

}
