package com.rest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.model.FileDetail;
import com.rest.springboot.service.FileService;

@RestController("/files")
public class FileController {

	@Autowired
	private FileService fileService;

	@GetMapping
	public List<FileDetail> getAllFiles() {
		return fileService.getAllFiles();
	}

	@GetMapping("/{id}")
	public FileDetail getFile(@PathVariable("id") Long id) {
		System.out.println(id);
		return fileService.getFile(id);
	}

	@PostMapping
	public FileDetail saveFileDetails(@RequestBody FileDetail fileDetail) {
		return fileService.saveFileDetails(fileDetail);
	}

	@PostMapping("/{id}")
	public FileDetail updateFileDetails(@PathVariable("id") Long id, @RequestBody FileDetail fileDetail) throws Exception {
		return fileService.updateFileDetails(id, fileDetail);
	}

	@DeleteMapping("/{id}")
	public void deleteFileDetail(@PathVariable("id") Long id) {
		fileService.deleteFileDetail(id);
	}

}
