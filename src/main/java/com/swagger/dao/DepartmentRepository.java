package com.swagger.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swagger.pojos.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
