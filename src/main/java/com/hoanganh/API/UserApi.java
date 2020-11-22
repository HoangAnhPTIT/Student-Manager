package com.hoanganh.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.service.IStudentService;
import com.hoanganh.service.ITeacherService;
import com.hoanganh.service.IUserService;

@RestController(value="studentAPI")
public class UserApi {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ITeacherService teacherService;
	@PostMapping(value="/api/student")
	public StudentDTO saveStudent(@RequestBody StudentDTO student) {
		studentService.save(student);
		return student;
	}
	
	@PutMapping(value="api/student")
	public UserDTO updateStudent(@RequestBody StudentDTO student) {
		StudentDTO studentDTO = userService.findStudentById(student.getId());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setGender(student.getGender());
		studentDTO.setCode(student.getCode());
		studentDTO.setFullName(student.getFullName());
		studentDTO.setAge(student.getAge());
		studentService.save(studentDTO);
		return studentDTO;
		
	}
	@PostMapping(value="/api/teacher")
	public TeacherDTO saveTeacher(@RequestBody TeacherDTO teacher) {
		teacherService.save(teacher);
		return teacher;
	}
	
	@PutMapping(value="/api/teacher")
	public TeacherDTO updateTeacher(@RequestBody TeacherDTO teacher) {
		TeacherDTO teacherDTO = userService.findTeacherById(teacher.getId());
		teacherDTO.setAddress(teacher.getAddress());
		teacherDTO.setAge(teacher.getAge());
		teacherDTO.setCode(teacher.getCode());
		teacherDTO.setExperience(teacher.getExperience());
		teacherDTO.setFullName(teacher.getFullName());
		teacherDTO.setGender(teacher.getGender());
		teacherDTO.setSubject(teacher.getSubject());
		teacherDTO.setSalary(teacherDTO.getSalary());
		
		teacherService.save(teacherDTO);
		return teacherDTO;
	}
}
