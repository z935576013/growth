package com.growth.web.protal.controller.hj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.LessonService;
import com.growth.service.intf.hj.dto.LessonInfo;

@Controller
@RequestMapping("lesson")
public class LessonController {

	@Autowired
	LessonService lessonService;

	@RequestMapping("/lessonList")
	public String lessonList(Integer lessonType, MobilePageParam page, Model model) {
		if (lessonType == null) {
			lessonType = 0;
		}
		List<LessonInfo> list = lessonService.getList(lessonType, null, true, page.getStartIndex(), page.getNum());
		Long count = lessonService.getListCount(lessonType, null, true);
		model.addAttribute("list", list);
		model.addAttribute("lessonType", lessonType);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "/lesson/lessonList.ftl";
	}

	@RequestMapping("/lessonView")
	public String lessonView(Long id, Model model) {
		LessonInfo lesson = lessonService.getLesson(id);
		List<LessonInfo> list = lessonService.getList(lesson.getLessonType(), null, true, 0L, 5L);
		model.addAttribute("list", list);
		model.addAttribute("lesson", lesson);
		return "lesson/lessonView.ftl";
	}

	@RequestMapping("/aboutus")
	public String aboutus() {
		return "/lesson/aboutus.ftl";
	}
}
