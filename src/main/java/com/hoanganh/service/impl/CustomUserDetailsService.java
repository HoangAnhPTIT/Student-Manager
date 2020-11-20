package com.hoanganh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hoanganh.DTO.MyStudent;
import com.hoanganh.entity.RoleEntity;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentEntity studentEntity = studentRepository.findOneByuserName(username);
		if (studentEntity == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for(RoleEntity role:studentEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyStudent myStudent = new MyStudent(studentEntity.getUserName(), studentEntity.getPassword(), 
				true, true, true, true, authorities);
		myStudent.setFullName(studentEntity.getFullName());		
		return myStudent;
	}

}
