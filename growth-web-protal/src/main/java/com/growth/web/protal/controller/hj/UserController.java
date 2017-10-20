package com.growth.web.protal.controller.hj;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.Md5Util;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.StoryService;
import com.growth.service.intf.hj.UserService;
import com.growth.service.intf.hj.dto.Hobby;
import com.growth.service.intf.hj.dto.School;
import com.growth.service.intf.hj.dto.StoryInfo;
import com.growth.service.intf.hj.dto.UserInfo;
import com.growth.web.protal.util.SessionUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	StoryService storyService;

	@RequestMapping("/userView")
	public String userView(Model model) {
		Long userId = SessionUtil.getUserId();
		UserInfo user = userService.getUser(userId);
		model.addAttribute("user", user);
		return "/user/userView.ftl";
	}

	@RequestMapping("/userEditPage")
	public String userEditPage(Model model) {
		Long userId = SessionUtil.getUserId();
		UserInfo user = userService.getUser(userId);
		List<Hobby> hobbyList = userService.getHobbyList();
		List<School> schoolList = userService.getSchoolList();
		model.addAttribute("user", user);
		model.addAttribute("hobbyList", hobbyList);
		model.addAttribute("schoolList", schoolList);
		return "/user/userEditPage.ftl";
	}

	@RequestMapping("/updateUser")
	public String updateUser(UserInfo user, MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		Long userId = SessionUtil.getUserId();
		user.setId(userId);
		if (user.getHobby() == null) {
			user.setHobby("");
		}
		UserInfo userInfo = userService.saveUser(user, file);
		SessionUtil.setUserInfo(request, userInfo);
		response.sendRedirect("../user/userView.htm");
		return null;
	}

	@RequestMapping("/changePwd")
	public String changePwd(String error, Model model) throws IOException {
		model.addAttribute("error", error);
		return "/user/changePwd.ftl";
	}

	@RequestMapping("/updatePwd")
	public String updatePwd(String oldPwd, String newPwd, HttpServletResponse response, Model model)
			throws IOException {
		Long userId = SessionUtil.getUserId();
		UserInfo user = userService.getUser(userId);
		String md5 = Md5Util.MD5(oldPwd);
		if (Objects.equals(md5, user.getPassword())) {
			userService.setPassword(userId, newPwd);
			response.sendRedirect("../user/userView.htm");
			return null;
		} else {
			return changePwd("旧密码不正确", model);
		}
	}

	@RequestMapping("/userStoryList")
	public String userStoryList(MobilePageParam page, Model model) {
		Long userId = SessionUtil.getUserId();
		List<StoryInfo> list = storyService.getList(userId, 0, null, true, page.getStartIndex(), page.getNum());
		Long count = storyService.getListCount(userId, 0, null, true);
		model.addAttribute("list", list);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "/user/userStoryList.ftl";
	}

	@RequestMapping("/userStoryView")
	public String userStoryView(Long id, Model model) {
		StoryInfo story = storyService.getStory(id);
		model.addAttribute("story", story);
		return "/user/userStoryView.ftl";
	}

	@RequestMapping("/userStoryEdit")
	public String userStoryEdit(Long id, Model model) {
		Long userId = SessionUtil.getUserId();
		StoryInfo story = storyService.getStory(id);
		if (story == null) {
			story = new StoryInfo();
			story.setUserId(userId);
			story.setStoryType(0);
		}
		model.addAttribute("story", story);
		return "/user/userStoryEdit.ftl";
	}

	@RequestMapping("/saveUserStory")
	public String userStoryEdit(StoryInfo story, HttpServletResponse response, MultipartFile file, Model model)
			throws IOException {
		if (story.getUserId() == null) {
			UserInfo user = SessionUtil.getUserInfo();
			story.setUserId(user.getId());
			story.setUserName(user.getMobile());
		}
		StoryInfo storyInfo = storyService.saveStory(story, file);
		response.sendRedirect("../user/userStoryView.htm?id=" + storyInfo.getId());
		return null;
	}

	@RequestMapping("/deleteUserStory")
	public String deleteUserStory(Long id, HttpServletResponse response, Model model) throws IOException {
		storyService.deleteStory(id);
		response.sendRedirect("../user/userStoryList.htm");
		return null;
	}

}
