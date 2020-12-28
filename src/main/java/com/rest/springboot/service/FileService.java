package com.rest.springboot.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.entity.FileEntity;
import com.rest.springboot.model.FileDetail;
import com.rest.springboot.repository.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;
	private ModelMapper mapper = new ModelMapper();

	public List<FileDetail> getAllFiles() {
		Iterable<FileEntity> fileEntities = fileRepository.findAll();
		Type type = new TypeToken<List<FileDetail>>() {
		}.getType();
		List<FileDetail> fileDetails = mapper.map(fileEntities, type);
		return fileDetails;
	}

	public FileDetail getFile(Long id) {
		Optional<FileEntity> fileEntity = fileRepository.findById(id);
		if (fileEntity.isPresent()) {
			return mapper.map(fileEntity.get(), FileDetail.class);
		}
		return null;
	}

	public FileDetail saveFileDetails(FileDetail fileDetail) {
		FileEntity fileEntity = mapper.map(fileDetail, FileEntity.class);
		System.out.println(fileEntity.getId());
		FileEntity savedFileEntity = fileRepository.save(fileEntity);
		fileDetail.setId(savedFileEntity.getId());
		return fileDetail;
	}

	public FileDetail updateFileDetails(Long id, FileDetail fileDetail) throws Exception {
		boolean isExist = fileRepository.existsById(id);
		if (isExist) {
			fileDetail.setId(id);
			FileEntity fileEntity = mapper.map(fileDetail, FileEntity.class);
			fileEntity = fileRepository.save(fileEntity);
			return mapper.map(fileEntity, FileDetail.class);
		}
		throw new Exception("File not exist with id " + id);
	}

	public void deleteFileDetail(Long id) {
		fileRepository.deleteById(id);
	}
}
