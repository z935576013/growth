package com.growth.web.protal.controller.hj;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growth.service.intf.hj.GameService;
import com.growth.service.intf.hj.dto.GameInfo;
import com.growth.web.protal.util.SessionUtil;

@Controller
@RequestMapping("game")
public class GameController {

	@Autowired
	GameService gameService;

	@RequestMapping("/gameView")
	public String gameView(Long id, Model model) {
		Long userId = SessionUtil.getUserId();
		GameInfo game = gameService.getGame(id, userId);
		model.addAttribute("game", game);
		return "/game/gameView.ftl";
	}

	@RequestMapping("/joinGame")
	public String joinGame(Long id, HttpServletResponse response, Model model) throws IOException {
		Long userId = SessionUtil.getUserId();
		gameService.joinGame(id, userId);
		response.sendRedirect("../game/gameView.htm?id=" + id);
		return null;
	}

}
