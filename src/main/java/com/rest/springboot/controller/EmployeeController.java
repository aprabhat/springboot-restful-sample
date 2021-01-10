package com.rest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.model.EmployeeDetails;
import com.rest.springboot.model.FileDetail;
import com.rest.springboot.service.EmployeeService;

@RestController
@RequestMapping("/files")
public class EmployeeController {

	@Autowired
	private EmployeeService fileService;

	@GetMapping
	public List<EmployeeDetails> getAllFiles() {
		return fileService.getAllFiles();
	}

	@GetMapping("/{id}")
	public EmployeeDetails getFile(@PathVariable("id") Long id) {
		System.out.println(id);
		return fileService.getFile(id);
	}

	@PostMapping
	public EmployeeDetails saveFileDetails(@RequestBody EmployeeDetails employeeDetail) {
		return fileService.saveEmployeeDetails(employeeDetail);
	}

	@PutMapping("/{id}")
	public EmployeeDetails updateFileDetails(@PathVariable("id") Long id, @RequestBody EmployeeDetails employeeDetail) throws Exception {
		return fileService.updateEmployeeDetails(id, employeeDetail);
	}

	@DeleteMapping("/{id}")
	public void deleteFileDetail(@PathVariable("id") Long id) {
		fileService.deleteFileDetail(id);
	}

}
