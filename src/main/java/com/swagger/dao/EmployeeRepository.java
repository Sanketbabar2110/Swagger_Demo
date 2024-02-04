package com.swagger.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swagger.pojos.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee order by name;", nativeQuery = true)
	public List<Employee> sortByNameAsc();

	@Query(value = "select * from employee order by name desc;", nativeQuery = true)
	public List<Employee> sortByNameDesc();

	@Query(value = "select department.dept_id as dept, count(employee.id) as employeeCount from employee inner join department on employee.dept_id=department.dept_id group by employee.dept_id;", nativeQuery = true)
	public List<Object[]> getEmpCountByDeptId();

	public Page<Employee> findAll(Pageable pageable);
}
