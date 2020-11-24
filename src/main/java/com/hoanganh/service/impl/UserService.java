package com.hoanganh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
@Transactional
public class UserService implements IUserService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private UserRepository userRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> userEntity = userRepository.findAll();
		List<UserDTO> users = new ArrayList<>();
		for (UserEntity item : userEntity) {
			users.add(modelMapper.map(item, UserDTO.class));
		}
		return users;
	}

	@Override
	public List<TeacherDTO> findTeacherByCodeLike(String code, Pageable pageable) {
		List<UserEntity> userEntity = userRepository.findBycodeLike(code, pageable);
		List<TeacherDTO> teachers = new ArrayList<>();
		for (UserEntity item : userEntity) {
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
	public List<StudentDTO> findStudentByCodeLike(String code, Pageable pageable) {
		List<UserEntity> userEntity = userRepository.findBycodeLike(code, pageable);
		List<StudentDTO> students = new ArrayList<>();
		for (UserEntity item : userEntity) {

			students.add(modelMapper.map(item, StudentDTO.class));
		}
		return students;
	}

	@Override
	public void save(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		StudentEntity studentEntity = new StudentEntity();
		userEntity.addStudent(studentEntity);
		if (user.getId() == null) {
			entityManager.persist(userEntity);
		} else {
			entityManager.merge(userEntity);
		}

	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity userEntity = userRepository.findByid(id);
		return modelMapper.map(userEntity, UserDTO.class);
	}

	@Override
	public TeacherDTO findTeacherById(Long id) {
		UserEntity userEntity = userRepository.findByid(id);

		TeacherEntity teacherEntity = teacherRepository.findByuser(userEntity);
		TeacherDTO teacher = modelMapper.map(userEntity, TeacherDTO.class);
		teacher.setExperience(teacherEntity.getExperience());
		teacher.setSalary(teacherEntity.getSalary());
		teacher.setSubject(teacherEntity.getSubject());

		return teacher;
	}

	@Override
	public StudentDTO findStudentById(Long id) {
		UserEntity userEntity = userRepository.findByid(id);
		StudentEntity studentEntity = studentRepository.findByuser(userEntity); // Them sau
		StudentDTO student = modelMapper.map(userEntity, StudentDTO.class);

		return student;
	}

	@Override
	public int countByCodeLike(String code) {
		return userRepository.countBycodeLike(code);
	}
}
