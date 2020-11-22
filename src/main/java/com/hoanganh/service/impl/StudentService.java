package com.hoanganh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.entity.UserEntity;
import com.hoanganh.repository.StudentRepository;
import com.hoanganh.service.IStudentService;

@Service
@Transactional
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@PersistenceContext
	private EntityManager entityManager;

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

	@Override
	public void save(StudentDTO student) {
		UserEntity userEntity = new UserEntity();
		StudentEntity studentEntity = new StudentEntity();
		
		userEntity.setId(student.getId());
		userEntity.setAddress(student.getAddress());
		userEntity.setAge(student.getAge());
		userEntity.setCode(student.getCode());
		userEntity.setFullName(student.getFullName());
		userEntity.setGender(student.getGender());

		userEntity.addStudent(studentEntity);
		if (student.getId() == null) {
			
			entityManager.persist(userEntity);
		} else {
	
			entityManager.merge(userEntity);
		}

	}

}
