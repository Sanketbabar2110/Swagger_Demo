package com.swagger.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.dao.EmployeeRepository;
import com.swagger.model.EmpCount;

@Service
public class EmpCountService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<EmpCount> getAllEmployeeByDepartmentId() {
		List<Object[]> result = empRepo.getEmpCountByDeptId();
		List<EmpCount> list = new ArrayList<EmpCount>();
		if (result != null && !result.isEmpty()) {
			for (Object[] object : result) {
				EmpCount emp = new EmpCount();
				emp.setDept(Integer.parseInt(object[0].toString()));
				emp.setEmployeeCount(new BigInteger(object[1].toString()).intValue());
				;
				list.add(emp);
			}
		}
		return list;
	}

}
