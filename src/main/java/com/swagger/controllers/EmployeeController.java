package com.swagger.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.dao.EmployeeRepository;
import com.swagger.model.EmpCount;
import com.swagger.pojos.Employee;
import com.swagger.services.EmpCountService;
import com.swagger.services.EmployeeService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@Api(value = "All operations On employee table")
@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private EmpCountService empCountService;

	@Autowired
	private EmployeeRepository empRepo;

	@PostMapping("/add")
	private Employee saveCustomer(@RequestBody Employee emp) {
		return empService.saveOrUpdate(emp);
	}

	@GetMapping("/show")
	private List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/show/{id}")
	private Employee getCustomer(@PathVariable("id") int id) {
		return empService.getEmployeeById(id);
	}

	@PutMapping("/update")
	private Employee update(@RequestBody Employee emp) {
		empService.saveOrUpdate(emp);
		return emp;
	}

	@DeleteMapping("/delete/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		empService.delete(id);
	}

	@GetMapping("/employee")
	private List<Employee> sort(@RequestParam String order) {
		return empService.getEmpByDescOrder();
	}

	@GetMapping("/employees")
	private List<Employee> sortAsc(@RequestParam String order) {
		return empService.getEmpByAscOrder();
	}

	@GetMapping("/emp")
	private ResponseEntity<List<EmpCount>> getAllEmployeeByDepartmentId() {
		List<EmpCount> list = empCountService.getAllEmployeeByDepartmentId();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping("/paging/{page}/{size}")
	private ResponseEntity<Map<String, Object>> getAllEmployeesByPage(@PathVariable("page") int page,
			@PathVariable("size") int size) {

		try {
			List<Employee> employee = new ArrayList<Employee>();
			Pageable pages = PageRequest.of(page, size);

			Page<Employee> pageTuts;
			pageTuts = empRepo.findAll(pages);
			employee = pageTuts.getContent();

			Map<String, Object> response = new TreeMap<>();
			response.put("employee", employee);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorMap = new HashMap<>();
			errorMap.put("error", "No Emplyee's in Database");
			return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
