package com.growth.web.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.service.intf.hj.AdminService;
import com.growth.service.intf.hj.dto.AdminInfo;
import com.growth.web.admin.util.SessionUtil;

@Controller
@RequestMapping
public class IndexController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/index")
	public String index() {
		return "index.ftl";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome.ftl";
	}

	@RequestMapping("/loginPage")
	public String loginPage(String errorMessage, Model model) {
		model.addAttribute("errorMessage", errorMessage);
		return "login/loginPage.ftl";
	}

	@RequestMapping("/login")
	public String login(String loginId, String password, HttpServletRequest request, Model model) {
		AdminInfo admin = adminService.getAdmin(loginId, password);
		if (admin == null) {
			return loginPage("1", model);
		} else {
			SessionUtil.setUserInfo(request, admin);
			return index();
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		request.getSession().invalidate();
		return loginPage(null, model);
	}
}
