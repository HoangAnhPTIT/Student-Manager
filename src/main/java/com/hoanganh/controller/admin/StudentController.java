package com.hoanganh.controller.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.DTO.TeacherDTO;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.entity.TeacherEntity;
import com.hoanganh.entity.UserEntity;
import com.hoanganh.repository.StudentRepository;
import com.hoanganh.repository.TeacherRepository;
import com.hoanganh.repository.UserRepository;

@Controller(value = "studentController")
public class StudentController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeacherRepository teacherRopository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@RequestMapping(value = "/student-admin", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam String type, @RequestParam Long id) {
		if (type.equals("edit")) {
			ModelAndView mav = new ModelAndView("/admin/student/edit");
			if (id != null) {
				UserEntity userEntity = userRepository.findOne(id);
				if (userEntity.getCode().equals("teacher")) {
					TeacherEntity teacherEntity = teacherRopository.findByuser(userEntity);
					TeacherDTO teacher = new TeacherDTO();
					teacher.setExperience(teacherEntity.getExperience());
					teacher.setSalary(teacherEntity.getSalary());
					teacher.setSubject(teacherEntity.getSubject());
					mav.addObject("teacher", teacher);
				}
				UserDTO user = modelMapper.map(userEntity, UserDTO.class);
				mav.addObject("model", user);
			}
			return mav;
		}
		return null;
	}

}
