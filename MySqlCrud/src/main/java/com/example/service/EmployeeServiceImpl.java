package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Employee_Entity;
import com.example.Model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	int count = 0;

	public int insert(Employee_Entity emp) {

//		Employee_Entity employee = new Employee_Entity();
//		employee.setId(emp.getId());
//		employee.setName(emp.getName());
//		employee.setSalary(emp.getSalary());
		Employee_Entity save = repository.save(emp);
		if (save != null) {
			count = 1;
		}

		return count;

	}

	@Override
	public Optional<Employee_Entity> getEmployeeById(int id) {

//		List<Employee_Entity> addProducts = new ArrayList<>();
//		List<Employee_Entity> find = repository.findAll();
//		for (Employee_Entity getById : find) {
//			Employee emp = new Employee();
//			emp.setId(getById.getId());
//			emp.setName(getById.getName());
//			emp.setSalary(getById.getSalary());
//			addProducts.add(getById);
//		}

		Optional<Employee_Entity> findById = repository.findById(id);
		return findById;
	}

	@Override
	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return null;
	}

	@Override
	public Employee editEmployee(int id) {
		Optional<Employee_Entity> findById = repository.findById(id);
		Employee_Entity emp = findById.get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(emp, employee);

		return employee;
	}

	@Override
	public int updateEmployee(Employee emp) {
		Employee_Entity employee = new Employee_Entity();
		BeanUtils.copyProperties(emp, employee);
		Employee_Entity emp1 = repository.saveAndFlush(employee);
		if (emp1 != null) {
			count = 1;
		}
		return count;
	}

}
