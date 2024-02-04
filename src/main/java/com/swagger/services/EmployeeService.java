package com.swagger.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.dao.EmployeeRepository;
import com.swagger.pojos.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public Employee saveOrUpdate(Employee emp) {
		return empRepo.save(emp);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> emp = new ArrayList<Employee>();
		empRepo.findAll().forEach(emp::add);
		return emp;
	}

	public Employee getEmployeeById(int id) {
		return empRepo.findById(id).get();
	}

	public void update(Employee emp, int id) {
		empRepo.save(emp);
	}

	public void delete(int id) {
		empRepo.deleteById(id);
	}

	public List<Employee> getEmpByDescOrder() {
		List<Employee> employees = getAllEmployees();
		return employees.stream().sorted(Comparator.comparing(Employee::getName).reversed())
				.collect(Collectors.toList());
	}

	public List<Employee> getEmpByAscOrder() {
		List<Employee> employees = getAllEmployees();
		return employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
	}
}
