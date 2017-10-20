package com.growth.web.admin.controller.hj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.common.utils.ControllerUtil;
import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.hj.ActJoinService;
import com.growth.service.intf.hj.dto.ActJoin;

@Controller
@RequestMapping("/act")
public class ActJoinController {

	@Autowired
	ActJoinService actJoinService;

	@RequestMapping("/actJoinlist")
	public String actJoinlist(String name, MobilePageParam page, Model model) {
		List<ActJoin> list = actJoinService.getList(name, page.getStartIndex(), page.getNum());
		Long count = actJoinService.getListCount(name);
		model.addAttribute("list", list);
		model.addAttribute("name", name);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "act/actJoinlist.ftl";
	}

	@RequestMapping("/actJoinView")
	public String actJoinView(Long id, Model model) {
		ActJoin actJoin = actJoinService.getActJoin(id);
		model.addAttribute("actJoin", actJoin);
		return "act/actJoinView.ftl";
	}

}
