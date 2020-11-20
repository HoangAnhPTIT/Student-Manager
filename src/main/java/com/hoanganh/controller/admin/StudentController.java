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
import com.hoanganh.entity.StudentEntity;
import com.hoanganh.repository.StudentRepository;

@Controller(value = "studentController")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	private ModelMapper modelMapper = new ModelMapper();

	@RequestMapping(value = "/student-admin", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam String type, @RequestParam Long id) {
		if (type.equals("edit")) {
			ModelAndView mav = new ModelAndView("/admin/student/edit");
			if (id != null) {
				StudentEntity studentEntity = studentRepository.findOne(id);
				StudentDTO student = modelMapper.map(studentEntity, StudentDTO.class);
				mav.addObject("model", student);
			} else {
			}
			return mav;
		}
		return null;
	}

}
