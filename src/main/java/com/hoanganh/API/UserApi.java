package com.hoanganh.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.DTO.UserDTO;
import com.hoanganh.service.IUserService;

@RestController(value="studentAPI")
public class UserApi {
	@Autowired
	private IUserService userService;
	
	
	@PostMapping(value="/api/student")
	public UserDTO saveStudent(@RequestBody UserDTO user) {
		userService.save(user);
		return user;
	}
	
	@PutMapping(value="api/student")
	public UserDTO updateStudent(@RequestBody UserDTO user) {
		UserDTO userDTO = userService.findById(user.getId());
		userDTO.setAddress(user.getAddress());
		userDTO.setGender(user.getGender());
		userDTO.setCode("student");
		userDTO.setFullName(user.getFullName());
		userDTO.setAge(user.getAge());
		userService.save(userDTO);
		return userDTO;
		
	}
	
}
