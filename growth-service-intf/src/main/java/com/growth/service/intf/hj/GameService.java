package com.growth.service.intf.hj;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.growth.service.intf.hj.dto.GameInfo;
import com.growth.service.intf.hj.dto.GameInfoDto;
import com.growth.service.intf.hj.dto.UserInfo;

public interface GameService {

	/**
	 * 列表
	 */
	List<GameInfo> getList(String gameTitle, Boolean act, Long startIndex, Long num);

	/**
	 * 数量
	 */
	Long getListCount(String gameTitle, Boolean act);

	/**
	 * 比赛
	 */
	GameInfo getGame(Long id);

	/**
	 * 保存比赛
	 */
	GameInfo saveGame(GameInfo game, MultipartFile file);

	/**
	 * 比赛
	 */
	GameInfoDto getGame(Long gameId, Long userId);

	/**
	 * 参加比赛
	 */
	void joinGame(Long gameId, Long userId);

	/**
	 * 参加用户列表
	 */
	List<UserInfo> getJoinUserList(Long gameId, String mobile, Long startIndex, Long num);

	/**
	 * 参加用户数量
	 */
	Long getJoinUserCount(Long gameId, String mobile);

	/**
	 * 删除比赛
	 */
	void deleteGame(Long id);

	/**
	 * 停止比赛
	 */
	void stopGame(Long id);

	/**
	 * 开始比赛
	 */
	void startGame(Long id);
}
