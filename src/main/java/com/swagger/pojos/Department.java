package com.swagger.pojos;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

	private int DeptId;
	private String DeptName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPT_ID")
	public int getDeptId() {
		return DeptId;
	}

	public void setDeptId(int deptId) {
		DeptId = deptId;
	}

	@Column(name = "DEPT_NAME")
	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

}
