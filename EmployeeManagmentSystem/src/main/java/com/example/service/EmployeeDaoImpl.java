package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeEntity;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeServiceDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public int insert(Employee employee) {

		int count = 0;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);

		EmployeeEntity save = employeeRepository.save(employeeEntity);
		if (save != null) {
			count = 1;
		}
		return count;
	}

	
	public List<Employee> viewAllEmployee() {

		ArrayList<Employee> list=new ArrayList<Employee>();
		
		List<EmployeeEntity> findAll = employeeRepository.findAll();
		
		for(EmployeeEntity emp:findAll) {
		
			Employee employee=new Employee();
			BeanUtils.copyProperties(emp, employee);
			list.add(employee);
		}
		return list;
	}


	
	public Employee edit(int empId) {
		Optional<EmployeeEntity> findById = employeeRepository.findById(empId);
		EmployeeEntity employeeEntity=findById.get();
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		
		return employee;
	}

}
