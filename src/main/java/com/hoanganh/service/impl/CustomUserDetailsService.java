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

import com.hoanganh.DTO.MyUser;
import com.hoanganh.entity.RoleEntity;
import com.hoanganh.entity.UserEntity;
import com.hoanganh.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity  userEntity = userRepository.findOneByuserName(username);
		if(userEntity==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		// Put thong tin vao security de duy tri thong tin khi user login vao he thong
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role:userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
						true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
