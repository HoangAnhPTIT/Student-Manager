package com.hoanganh.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.TeacherEntity;
import com.hoanganh.entity.UserEntity;
import com.hoanganh.repository.TeacherRepository;
import com.hoanganh.repository.UserRepository;
import com.hoanganh.service.ITeacherService;

@Service
@Transactional
public class TeacherService implements ITeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TeacherDTO> findByCodeLike(String code) {
		List<UserEntity> userEntity = userRepository.findBycodeLike(code);
		return null;
	}

	@Override
	public void save(TeacherDTO teacher) {
		UserEntity userEntity = new UserEntity();
		TeacherEntity teacherEntity = new TeacherEntity();
		// UserEntity Mapper
		userEntity.setId(teacher.getId());
		userEntity.setAddress(teacher.getAddress());
		userEntity.setAge(teacher.getAge());
		userEntity.setCode(teacher.getCode());
		userEntity.setFullName(teacher.getFullName());
		userEntity.setGender(teacher.getGender());

		// TeacherEntity Mapper
		teacherEntity.setSalary(teacher.getSalary());
		teacherEntity.setExperience(teacher.getExperience());
		teacherEntity.setSubject(teacher.getSubject());

		userEntity.addTeacher(teacherEntity);
		if(teacher.getId()==null) {
			entityManager.persist(userEntity);
		} else {
			entityManager.merge(userEntity);
		}
		
	}

	@Override
	public TeacherDTO findById(Long id) {
		UserEntity userEntity = userRepository.findByid(id);
		return modelMapper.map(teacherRepository.findByid(id), TeacherDTO.class);
	}

}
