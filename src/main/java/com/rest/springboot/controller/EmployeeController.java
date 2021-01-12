package com.rest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.model.EmployeeDetails;
import com.rest.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDetails> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable("id") Long id) {
		if (employeeService.isExist(id)) {
			EmployeeDetails employee = employeeService.getEmployee(id);
			return new ResponseEntity<EmployeeDetails>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetail) {
		return employeeService.saveEmployeeDetails(employeeDetail);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDetails> updateEmployeeDetails(@PathVariable("id") Long id,
			@RequestBody EmployeeDetails employeeDetail) throws Exception {
		if (employeeService.isExist(id)) {
			return new ResponseEntity<>(employeeService.updateEmployeeDetails(id, employeeDetail), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeDetail(@PathVariable("id") Long id) {
		if (employeeService.isExist(id)) {
			employeeService.deleteEmployeeDetails(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
