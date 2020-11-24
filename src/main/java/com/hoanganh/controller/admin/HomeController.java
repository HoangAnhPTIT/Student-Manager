package com.hoanganh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hoanganh.DTO.MyUser;
import com.hoanganh.DTO.UserDTO;
import com.hoanganh.service.IUserService;
import com.hoanganh.util.SecurityUtil;

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
	public ModelAndView showList(@RequestParam("type") String type, @RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("/admin/user/list");
		UserDTO user = new UserDTO();
		user.setLimit(limit);
		user.setPage(page);

		Pageable pageable = new PageRequest(page - 1 , limit);

		if (type.equals("student")) {
			user.setListStudent(userService.findStudentByCodeLike("student", pageable));
			user.setTotalItem(userService.countByCodeLike("student"));
			user.setTotalPage((int) Math.ceil((double) user.getTotalItem() / user.getLimit()));
		} else if (type.equals("teacher")) {
			user.setListTeacher(userService.findTeacherByCodeLike("teacher", pageable));
			user.setTotalItem(userService.countByCodeLike("teacher"));
			user.setTotalPage((int) Math.ceil((double) user.getTotalItem() / user.getLimit()));
		}
		mav.addObject("model", user);
		return mav;
	}
}
