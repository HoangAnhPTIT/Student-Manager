package com.hoanganh.service;

import java.util.List;

import com.hoanganh.DTO.TeacherDTO;

public interface ITeacherService {
	TeacherDTO findById(Long id);
	void save(TeacherDTO teacher);
}
