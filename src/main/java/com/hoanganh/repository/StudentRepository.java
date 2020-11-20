package com.hoanganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoanganh.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	StudentEntity findOneByuserName(String username);
	
	
}
