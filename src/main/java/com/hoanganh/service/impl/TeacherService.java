package com.hoanganh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.entity.UserEntity;
import com.hoanganh.repository.UserRepository;
import com.hoanganh.service.ITeacherService;

public class TeacherService implements ITeacherService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<TeacherDTO> findByCodeLike(String code) {
		List<UserEntity> userEntity =  userRepository.findBycodeLike(code);
		return null;
	}

}
