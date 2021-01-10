package com.rest.springboot.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.entity.Employee;
import com.rest.springboot.model.EmployeeDetails;
import com.rest.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository fileRepository;
	private ModelMapper mapper = new ModelMapper();

	public List<EmployeeDetails> getAllFiles() {
		Iterable<Employee> fileEntities = fileRepository.findAll();
		Type type = new TypeToken<List<EmployeeDetails>>() {
		}.getType();
		List<EmployeeDetails> EmployeeDetailss = mapper.map(fileEntities, type);
		return EmployeeDetailss;
	}

	public EmployeeDetails getFile(Long id) {
		Optional<Employee> EmployeeEntity = fileRepository.findById(id);
		if (EmployeeEntity.isPresent()) {
			return mapper.map(EmployeeEntity.get(), EmployeeDetails.class);
		}
		return null;
	}

	public EmployeeDetails saveEmployeeDetailss(EmployeeDetails EmployeeDetails) {
		Employee employee = mapper.map(EmployeeDetails, Employee.class);
		System.out.println(employee.getId());
		Employee savedEmployee = fileRepository.save(employee);
		EmployeeDetails.setId(savedEmployee.getId());
		return EmployeeDetails;
	}

	public EmployeeDetails updateEmployeeDetailss(Long id, EmployeeDetails EmployeeDetails) throws Exception {
		boolean isExist = fileRepository.existsById(id);
		if (isExist) {
			EmployeeDetails.setId(id);
			Employee employee = mapper.map(EmployeeDetails, Employee.class);
			employee = fileRepository.save(employee);
			return mapper.map(employee, EmployeeDetails.class);
		}
		throw new Exception("File not exist with id " + id);
	}

	public void deleteEmployeeDetails(Long id) {
		fileRepository.deleteById(id);
	}
}
