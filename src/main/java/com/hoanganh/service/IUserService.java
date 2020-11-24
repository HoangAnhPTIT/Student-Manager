package com.hoanganh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
	List<TeacherDTO> findTeacherByCodeLike(String code, Pageable pageable);
	TeacherDTO findTeacherById(Long id);
	List<StudentDTO> findStudentByCodeLike(String code, Pageable pageable);
	StudentDTO findStudentById(Long id);
	void save(UserDTO user);
	UserDTO findById(Long id);
	
	int countByCodeLike(String code);
}
