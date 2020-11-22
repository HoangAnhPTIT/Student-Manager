package com.hoanganh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.entity.TeacherEntity;
import com.hoanganh.entity.UserEntity;
import com.hoanganh.repository.StudentRepository;
import com.hoanganh.repository.TeacherRepository;
import com.hoanganh.repository.UserRepository;
import com.hoanganh.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StudentRepository studentRepository;
	private ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> userEntity = userRepository.findAll();
		List<UserDTO> users = new ArrayList<>();
		for(UserEntity item:userEntity) {
			users.add(modelMapper.map(item, UserDTO.class));
		}
		return users;
	}
	@Override
	public List<TeacherDTO> findTeacherByCodeLike(String code) {
		List<UserEntity> userEntity = userRepository.findBycodeLike(code);
		List<TeacherDTO> teachers = new ArrayList<>();
		for(UserEntity item:userEntity) {
			TeacherEntity teacherEntity = teacherRepository.findByuser(item);
			TeacherDTO teacher = modelMapper.map(item, TeacherDTO.class);
			teacher.setExperience(teacherEntity.getExperience());
			teacher.setSalary(teacherEntity.getSalary());
			teacher.setSubject(teacherEntity.getSubject());
			teachers.add(teacher);
		}
		return teachers;
	}
	@Override
	public List<StudentDTO> findStudentByCodeLike(String code) {
		List<UserEntity> userEntity = userRepository.findBycodeLike(code);
		List<StudentDTO> students = new ArrayList<>();
		for(UserEntity item:userEntity) {
			
			students.add( modelMapper.map(item, StudentDTO.class));
		}
		return students;
	}
	@Override
	public void save(UserDTO user) {
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setUser(userEntity);
		studentRepository.save(studentEntity);
		userRepository.save(userEntity);
	}
	@Override
	public UserDTO findById(Long id) {
		UserEntity userEntity = userRepository.findByid(id);
		return modelMapper.map(userEntity, UserDTO.class);
	}
	
}
