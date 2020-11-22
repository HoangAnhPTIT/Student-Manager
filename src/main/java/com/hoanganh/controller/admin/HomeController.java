package com.hoanganh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hoanganh.DTO.UserDTO;
import com.hoanganh.service.IUserService;

import aj.org.objectweb.asm.Type;

@Controller(value = "adminController")
public class HomeController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("/admin/home");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/list", method = RequestMethod.GET)
	public ModelAndView showStudent(@RequestParam String type) {
		ModelAndView mav = new ModelAndView("/admin/student/list");
		UserDTO user = new UserDTO();
		if (type.equals("student")) {
			user.setListStudent(userService.findStudentByCodeLike("student"));
		} else if (type.equals("teacher")){
			user.setListTeacher(userService.findTeacherByCodeLike("teacher"));
		}
		mav.addObject("model", user);
		return mav;
	}
}
