package com.hoanganh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hoanganh.DTO.StudentDTO;
import com.hoanganh.service.IStudentService;

@Controller(value="adminController")
public class HomeController {
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/quan-tri", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("/admin/home");
		return mav;
	}
	
	@RequestMapping(value="/quan-tri/list", method = RequestMethod.GET)
	public ModelAndView showStudent() {
		ModelAndView mav = new ModelAndView("/admin/student/list");
		StudentDTO student = new StudentDTO();
		student.setListResult(studentService.findAll());
		mav.addObject("model", student);
		return mav;
	}
}
