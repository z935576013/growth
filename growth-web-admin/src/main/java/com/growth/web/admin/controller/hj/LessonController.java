package com.growth.web.admin.controller.hj;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.LessonService;
import com.growth.service.intf.hj.dto.LessonInfo;

@Controller
@RequestMapping("/lesson")
public class LessonController {

	@Autowired
	LessonService lessonService;

	@RequestMapping("/lessonlist")
	public String userlist(Integer lessonType, String lessonTitle, MobilePageParam page, Model model) {
		List<LessonInfo> list = lessonService.getList(lessonType, lessonTitle, null, page.getStartIndex(),
				page.getNum());
		Long count = lessonService.getListCount(lessonType, lessonTitle, null);
		model.addAttribute("list", list);
		model.addAttribute("lessonType", lessonType);
		model.addAttribute("lessonTitle", lessonTitle);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "lesson/lessonlist.ftl";
	}

	@RequestMapping("/lessonView")
	public String lessonView(Long id, Integer lessonType, Boolean success, Model model) {
		LessonInfo lesson = lessonService.getLesson(id);
		if (lesson == null) {
			lesson = new LessonInfo();
		}
		if (lessonType == null) {
			lessonType = lesson.getLessonType();
		}
		model.addAttribute("lessonType", lessonType);
		model.addAttribute("lesson", lesson);
		model.addAttribute("success", success);
		return "lesson/lessonView.ftl";
	}

	@RequestMapping("/lessonSave")
	public String lessonSave(LessonInfo lesson, Model model) {
		LessonInfo result = lessonService.saveLesson(lesson);
		return lessonView(result.getId(), null, true, model);
	}

	@RequestMapping(value = "delete", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request, Long id) {
		lessonService.deleteLesson(id);
		return "ok";
	}

}
