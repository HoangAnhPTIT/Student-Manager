package com.hoanganh.service;

import java.util.List;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.UserDTO;

public interface IStudentService {
	List<StudentDTO> findAll();
	void save(StudentDTO student);
}
