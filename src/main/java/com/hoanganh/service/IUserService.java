package com.hoanganh.service;

import java.util.List;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
	List<TeacherDTO> findTeacherByCodeLike(String code);
	List<StudentDTO> findStudentByCodeLike(String code);
	
}
