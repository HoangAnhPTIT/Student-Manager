package com.hoanganh.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.service.IStudentService;

@RestController(value="studentAPI")
public class StudentApi {
	@Autowired
	private IStudentService studentService;
	
	
	@PostMapping(value="/api/student")
	public void updateStudent(@RequestBody StudentDTO student) {
		studentService.save(student);
	}
	
}
