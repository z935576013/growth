package com.growth.web.admin.controller.hj;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.StoryService;
import com.growth.service.intf.hj.dto.StoryInfo;

@Controller
@RequestMapping("/story")
public class StoryController {

	@Autowired
	StoryService storyService;

	@RequestMapping("/storylist")
	public String userlist(Integer storyType, String storyTitle, MobilePageParam page, Model model) {
		List<StoryInfo> list = storyService.getList(null, storyType, storyTitle, null, page.getStartIndex(),
				page.getNum());
		Long count = storyService.getListCount(null, storyType, storyTitle, null);
		model.addAttribute("list", list);
		model.addAttribute("storyType", storyType);
		model.addAttribute("storyTitle", storyTitle);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "story/storylist.ftl";
	}

	@RequestMapping("/storyView")
	public String storyView(Long id, Integer storyType, Boolean success, Model model) {
		StoryInfo story = storyService.getStory(id);
		if (story == null) {
			story = new StoryInfo();
		}
		if (storyType == null) {
			storyType = story.getStoryType();
		}
		model.addAttribute("storyType", storyType);
		model.addAttribute("story", story);
		model.addAttribute("success", success);
		return "story/storyView.ftl";
	}

	@RequestMapping("/storySave")
	public String storySave(StoryInfo story, MultipartFile file, Model model) {
		StoryInfo result = storyService.saveStory(story, file);
		return storyView(result.getId(), null, true, model);
	}

	@RequestMapping(value = "delete", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request, Long id) {
		storyService.deleteStory(id);
		return "ok";
	}

}
