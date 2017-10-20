package com.growth.web.admin.controller.hj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.UserService;
import com.growth.service.intf.hj.dto.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/userlist")
	public String userlist(String mobile, MobilePageParam page, Model model) {
		List<UserInfo> list = userService.getList(mobile, page.getStartIndex(), page.getNum());
		Long count = userService.getListCount(mobile);
		model.addAttribute("mobile", mobile);
		model.addAttribute("list", list);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "user/userlist.ftl";
	}

	@RequestMapping("/userView")
	public String userView(Long id, Model model) {
		UserInfo user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user/userView.ftl";
	}
}
