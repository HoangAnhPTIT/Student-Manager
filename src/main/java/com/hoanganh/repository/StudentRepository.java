package com.hoanganh.repository;

import org.springframework.data.repository.CrudRepository;

import com.hoanganh.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long>{
	StudentEntity findOneByuserName(String username);
	
	
}
