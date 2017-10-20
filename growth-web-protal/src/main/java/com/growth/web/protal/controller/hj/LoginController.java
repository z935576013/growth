package com.growth.web.protal.controller.hj;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.growth.service.intf.hj.SmsService;
import com.growth.service.intf.hj.UserService;
import com.growth.service.intf.hj.dto.UserInfo;
import com.growth.web.protal.util.SessionUtil;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	SmsService smsService;

	@RequestMapping("/loginPage")
	public String loginPage(String mobile, String error, Model model) {
		model.addAttribute("mobile", mobile);
		model.addAttribute("error", error);
		return "/login/loginPage.ftl";
	}

	@RequestMapping("/registPage")
	public String registPage(String error, Model model) {
		model.addAttribute("error", error);
		return "/login/registPage.ftl";
	}

	@RequestMapping("/findPwd")
	public String findPwd(String error, Model model) {
		model.addAttribute("error", error);
		return "/login/findPwd.ftl";
	}

	@RequestMapping(value = "sendValCode", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String sendValCode(HttpServletRequest request, Integer regist, String mobile) {
		if (StringUtils.isNotEmpty(mobile)) {
			smsService.sendSmsCode(mobile, regist);
		}
		return "ok";
	}

	@RequestMapping("/resetPwd")
	public String resetPwd(Model model, HttpServletResponse response, HttpServletRequest request, String mobile,
			String password, String valCode) throws IOException {
		boolean valid = smsService.validSmsCode(mobile, valCode);
		if (valid) {
			UserInfo user = userService.getUserByMobile(mobile);
			if (null == user) {
				model.addAttribute("mobile", mobile);
				model.addAttribute("error", "账号不存在");
				return "login/findPwd.ftl";
			} else {
				userService.setPassword(user.getId(), password);
				return loginPage(mobile, null, model);
			}
		} else {
			model.addAttribute("mobile", mobile);
			model.addAttribute("error", "验证码不正确");
			return "login/findPwd.ftl";
		}
	}

	@RequestMapping("/register")
	public String register(Model model, HttpServletRequest request, String mobile, String password, String valCode,
			HttpServletResponse response) throws IOException {
		boolean valid = smsService.validSmsCode(mobile, valCode);
		if (valid) {
			UserInfo user = userService.getUserByMobile(mobile);
			if (null != user) {
				model.addAttribute("mobile", mobile);
				model.addAttribute("error", "手机号码已存在");
				return "login/registPage.ftl";
			}
			String openid = SessionUtil.getOpenid(request);
			UserInfo userInfo = userService.saveUser(mobile, password, openid);
			SessionUtil.setUserInfo(request, userInfo);
			response.sendRedirect("../user/userEditPage.htm");
			return null;
		} else {
			model.addAttribute("mobile", mobile);
			model.addAttribute("error", "验证码不正确");
			return "login/registPage.ftl";
		}
	}

	@RequestMapping("/login")
	public String login(String mobile, String password, HttpServletRequest request, Model model,
			HttpServletResponse response) throws IOException {
		UserInfo userInfo = userService.getUserByPassword(mobile, password);
		if (userInfo != null) {
			String openid = SessionUtil.getOpenid(request);
			if (StringUtils.isNotEmpty(openid)) {
				userService.setOpenid(userInfo.getId(), openid);
				userInfo.setOpenid(openid);
			}
			SessionUtil.setUserInfo(request, userInfo);
			response.sendRedirect("../index.htm");
			return null;
		} else {
			return loginPage(mobile, "error", model);
		}
	}

	/**
	 * 登陆页面
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("../index.htm");
	}
}
