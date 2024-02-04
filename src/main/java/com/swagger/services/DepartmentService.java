package com.swagger.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.dao.DepartmentRepository;
import com.swagger.pojos.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;

	public void saveOrUpdate(Department dept) {
		deptRepo.save(dept);
	}

	public List<Department> getAllDepartments() {
		List<Department> dept = new ArrayList<Department>();
		deptRepo.findAll().forEach(dept::add);
		return dept;
	}

	public Department getDepartmentById(int deptId) {
		return deptRepo.findById(deptId).get();
	}

	public void update(Department dept, int deptId) {
		deptRepo.save(dept);
	}

	public void delete(int deptId) {
		deptRepo.deleteById(deptId);
	}

}
