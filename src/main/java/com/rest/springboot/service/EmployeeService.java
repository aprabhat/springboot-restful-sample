package com.rest.springboot.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rest.springboot.entity.Employee;
import com.rest.springboot.model.EmployeeDetails;
import com.rest.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	private ModelMapper mapper = new ModelMapper();

	public List<EmployeeDetails> getAllEmployees() {
		Iterable<Employee> employees = employeeRepository.findAll();
		Type type = new TypeToken<List<EmployeeDetails>>() {
		}.getType();
		List<EmployeeDetails> EmployeeDetailss = mapper.map(employees, type);
		return EmployeeDetailss;
	}

	public EmployeeDetails getEmployee(Long id) {
		Optional<Employee> EmployeeEntity = employeeRepository.findById(id);
		if (EmployeeEntity.isPresent()) {
			return mapper.map(EmployeeEntity.get(), EmployeeDetails.class);
		}
		return null;
	}

	public EmployeeDetails saveEmployeeDetails(EmployeeDetails EmployeeDetails) {
		Employee employee = mapper.map(EmployeeDetails, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDetails.setId(savedEmployee.getId());
		return EmployeeDetails;
	}

	public EmployeeDetails updateEmployeeDetails(Long id, EmployeeDetails EmployeeDetails) throws Exception {
			EmployeeDetails.setId(id);
			Employee employee = mapper.map(EmployeeDetails, Employee.class);
			employee = employeeRepository.save(employee);
			return mapper.map(employee, EmployeeDetails.class);
	}

	public void deleteEmployeeDetails(Long id) {
		if (isExist(id)) {
			employeeRepository.deleteById(id);
		}
	}

	public boolean isExist(Long id) {
		return employeeRepository.existsById(id);
	}
}
