package com.growth.web.protal.controller.hj;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.service.intf.hj.ActJoinService;
import com.growth.service.intf.hj.dto.ActJoin;
import com.growth.web.protal.util.SessionUtil;

@Controller
@RequestMapping("act")
public class ActJoinController {

	@Autowired
	ActJoinService actJoinService;

	@RequestMapping("/actView")
	public String gameView(Long id, Model model) {
		Long userId = SessionUtil.getUserId();
		ActJoin actJoin = actJoinService.getActJoinByUser(userId);
		model.addAttribute("actJoin", actJoin);
		return "/act/actView.ftl";
	}

	@RequestMapping("/joinPage")
	public String joinPage() throws IOException {
		return "/act/joinPage.ftl";
	}

	@RequestMapping("/join")
	public String joinGame(ActJoin join, HttpServletRequest request, Model model) throws IOException {
		Long userId = SessionUtil.getUserId();
		join.setUserId(userId);
		actJoinService.saveActJoin(join);
		ActJoin actJoin = actJoinService.getActJoinByUser(userId);
		model.addAttribute("actJoin", actJoin);
		return "/act/actView.ftl";
	}

}
