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
import com.hoanganh.service.IUserService;

@Controller(value = "teacherController")
public class TeacherController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IUserService userService;

	@Autowired
	private TeacherRepository teacherRopository;

	private ModelMapper modelMapper = new ModelMapper();

	@RequestMapping(value = "/teacher-admin", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam String type, @RequestParam(required = false) Long id) {
		if (type.equals("edit")) {
			ModelAndView mav = new ModelAndView("/admin/user/editTeacher");
			if (id != null) {
				TeacherDTO teacher = userService.findTeacherById(id);
				mav.addObject("model", teacher);
			}
			return mav;
		}
		return null;
	}

}
