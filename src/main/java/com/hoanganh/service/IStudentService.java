package com.hoanganh.service;

import java.util.List;

import com.hoanganh.DTO.StudentDTO;

public interface IStudentService {
	List<StudentDTO> findAll();
	StudentDTO findOneByUsername(String username);
	void save(StudentDTO student);
}
