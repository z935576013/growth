package com.growth.web.protal.controller.hj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.StoryService;
import com.growth.service.intf.hj.dto.StoryInfo;

@Controller
@RequestMapping("story")
public class StoryController {

	@Autowired
	StoryService storyService;

	@RequestMapping("/storyList")
	public String storyList(Integer storyType, MobilePageParam page, Model model) {
		if (storyType == null) {
			storyType = 0;
		}
		List<StoryInfo> list = storyService.getList(null, storyType, null, true, page.getStartIndex(), page.getNum());
		Long count = storyService.getListCount(null, storyType, null, true);
		model.addAttribute("list", list);
		model.addAttribute("storyType", storyType);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "/story/storyList.ftl";
	}

	@RequestMapping("/storyView")
	public String storyView(Long id, Model model) {
		StoryInfo story = storyService.getStory(id);
		List<StoryInfo> list = storyService.getList(null, story.getStoryType(), null, true, 0L, 5L);
		model.addAttribute("list", list);
		model.addAttribute("story", story);
		return "story/storyView.ftl";
	}

}
