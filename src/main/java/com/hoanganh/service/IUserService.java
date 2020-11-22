package com.hoanganh.service;

import java.util.List;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.UserEntity;

public interface IUserService {
	List<UserDTO> findAll();
	List<TeacherDTO> findTeacherByCodeLike(String code);
	TeacherDTO findTeacherById(Long id);
	List<StudentDTO> findStudentByCodeLike(String code);
	StudentDTO findStudentById(Long id);
	void save(UserDTO user);
	UserDTO findById(Long id);
}
