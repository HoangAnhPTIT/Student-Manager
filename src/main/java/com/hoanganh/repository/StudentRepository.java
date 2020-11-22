package com.hoanganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.entity.UserEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	StudentEntity findByuser(UserEntity user);

}
