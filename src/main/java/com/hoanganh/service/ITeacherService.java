package com.hoanganh.service;

import java.util.List;

import com.hoanganh.DTO.TeacherDTO;

public interface ITeacherService {
	List<TeacherDTO> findByCodeLike(String code);
}
