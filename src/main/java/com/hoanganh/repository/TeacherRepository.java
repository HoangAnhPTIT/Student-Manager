package com.hoanganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoanganh.entity.TeacherEntity;
import com.hoanganh.entity.UserEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{
	TeacherEntity findByuser(UserEntity user);
	TeacherEntity findByid(Long id);
}
