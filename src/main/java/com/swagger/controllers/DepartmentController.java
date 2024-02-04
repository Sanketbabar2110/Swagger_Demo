package com.swagger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.dao.DepartmentRepository;
import com.swagger.pojos.Department;
import com.swagger.services.DepartmentService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@Api(value = "All operations On department table")
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	@PostMapping("/add")
	private int saveCustomer(@RequestBody Department dept) {
		deptService.saveOrUpdate(dept);
		return dept.getDeptId();
	}

	@GetMapping("/show")
	private List<Department> getAllDepartments() {
		return deptService.getAllDepartments();
	}

	@GetMapping("/show/{deptId}")
	private Department getDepartment(@PathVariable("deptId") int deptId) {
		return deptService.getDepartmentById(deptId);

	}

	@PutMapping("/update")
	private Department update(@RequestBody Department dept) {
		deptService.saveOrUpdate(dept);
		return dept;
	}

	@DeleteMapping("/delete/{deptId}")
	public void deleteDepartment(@PathVariable("deptId") int deptId) {
		deptService.delete(deptId);
	}

}
