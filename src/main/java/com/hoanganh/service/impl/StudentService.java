package com.hoanganh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.repository.StudentRepository;
import com.hoanganh.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentReposity;

	private ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<StudentDTO> findAll() {
		List<StudentDTO> model = new ArrayList<>();
		List<StudentEntity> studentEntity = studentReposity.findAll();
		for (StudentEntity item : studentEntity) {
			StudentDTO studentDTO = modelMapper.map(item, StudentDTO.class);
			model.add(studentDTO);
		}

		return model;
	}

	@Override
	public void save(StudentDTO student) {
		StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
		studentReposity.save(studentEntity);
	}

	@Override
	public StudentDTO findOneByUsername(String username) {
		StudentEntity student = studentReposity.findOneByuserName(username);
		return modelMapper.map(student, StudentDTO.class);
	}

}
