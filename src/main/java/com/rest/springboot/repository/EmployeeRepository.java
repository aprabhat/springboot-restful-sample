package com.rest.springboot.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.springboot.entity.FileEntity;


@Repository
public interface EmployeeRepository extends CrudRepository<FileEntity, Long> {
}
