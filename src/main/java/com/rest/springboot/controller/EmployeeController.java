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
		System.out.println(id);
		EmployeeDetails employee = employeeService.getEmployee(id);
		if (employee != null) {
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
	public EmployeeDetails updateEmployeeDetails(@PathVariable("id") Long id,
			@RequestBody EmployeeDetails employeeDetail) throws Exception {
		return employeeService.updateEmployeeDetails(id, employeeDetail);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployeeDetail(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeDetails(id);
	}

}
