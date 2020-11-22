//package com.hoanganh.API;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hoanganh.DTO.StudentDTO;
//import com.hoanganh.service.IStudentService;
//
//@RestController(value="studentAPI")
//public class StudentApi {
//	@Autowired
//	private IStudentService studentService;
//	
//	
//	@PostMapping(value="/api/student")
//	public StudentDTO saveStudent(@RequestBody StudentDTO student) {
//		studentService.save(student);
//		return student;
//	}
//	
//	@PutMapping(value="api/student")
//	public StudentDTO updateStudent(@RequestBody StudentDTO student) {
//		StudentDTO studentDTO = studentService.findById(student.getId());
//		studentDTO.setFullName(student.getFullName());
//		studentDTO.setAddress(student.getAddress());
//		studentDTO.setAge(student.getAge());
//		studentDTO.setGender(student.getGender());
//		studentService.save(studentDTO);
//		return studentDTO;
//	}
//	
//}
