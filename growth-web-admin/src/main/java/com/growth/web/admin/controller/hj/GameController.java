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
import com.growth.service.intf.hj.GameService;
import com.growth.service.intf.hj.dto.GameInfo;
import com.growth.service.intf.hj.dto.UserInfo;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	GameService gameService;

	@RequestMapping("/gamelist")
	public String gamelist(String gameTitle, MobilePageParam page, Model model) {
		List<GameInfo> list = gameService.getList(gameTitle, null, page.getStartIndex(), page.getNum());
		Long count = gameService.getListCount(gameTitle, null);
		model.addAttribute("list", list);
		model.addAttribute("gameTitle", gameTitle);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "game/gamelist.ftl";
	}

	@RequestMapping("/gameView")
	public String gameView(Long id, Boolean success, Model model) {
		GameInfo game = gameService.getGame(id);
		if (game == null) {
			game = new GameInfo();
		}
		model.addAttribute("game", game);
		model.addAttribute("success", success);
		return "game/gameView.ftl";
	}

	@RequestMapping("/gameSave")
	public String gameSave(GameInfo game, MultipartFile file, Model model) {
		GameInfo result = gameService.saveGame(game, file);
		return gameView(result.getId(), true, model);
	}

	@RequestMapping(value = "delete", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request, Long id) {
		gameService.deleteGame(id);
		return "ok";
	}

	@RequestMapping("/gameJoinList")
	public String gameJoinList(Long gameId, String mobile, MobilePageParam page, Model model) {
		List<UserInfo> list = gameService.getJoinUserList(gameId, mobile, page.getStartIndex(), page.getNum());
		Long count = gameService.getJoinUserCount(gameId, mobile);
		model.addAttribute("list", list);
		model.addAttribute("gameId", gameId);
		model.addAttribute("mobile", mobile);
		model.addAttribute("PageParam", ControllerUtil.getPageParam(count, page));
		return "game/gameJoinList.ftl";
	}

}
