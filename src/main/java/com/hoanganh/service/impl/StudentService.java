package com.hoanganh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.repository.StudentRepository;
import com.hoanganh.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<StudentDTO> findAll() {
		List<StudentDTO> students = new ArrayList<>();
		List<StudentEntity> studentEntities = studentRepository.findAll();
		for (StudentEntity item : studentEntities) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setUser(modelMapper.map(item.getUser(), UserDTO.class));
			students.add(studentDTO);
		}
		return students;
	}

	
}
