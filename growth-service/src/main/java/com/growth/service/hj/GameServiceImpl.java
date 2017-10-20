package com.growth.service.hj;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.growth.common.dal.DalClient;
import com.growth.common.file.FileClient;
import com.growth.common.utils.BeanCopyUtils;
import com.growth.service.intf.hj.GameService;
import com.growth.service.intf.hj.dto.GameInfo;
import com.growth.service.intf.hj.dto.GameInfoDto;
import com.growth.service.intf.hj.dto.GameJoin;
import com.growth.service.intf.hj.dto.UserInfo;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	DalClient dalClient;

	@Autowired
	FileClient fileClient;

	@Override
	public List<GameInfo> getList(String gameTitle, Boolean act, Long startIndex, Long num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", startIndex);
		map.put("maxCount", num);
		if (StringUtils.isNotEmpty(gameTitle)) {
			map.put("gameTitle", gameTitle);
		}
		if (act != null && act) {
			map.put("actStatus", 1);
		}
		map.put("orderBy", "CREATE_TIME");
		map.put("orderByDesc", "DESC");
		return dalClient.queryForList("GAME_INFO.SELECT_BY_FIELDS", map, GameInfo.class);
	}

	@Override
	public Long getListCount(String gameTitle, Boolean act) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(gameTitle)) {
			map.put("gameTitle", gameTitle);
		}
		if (act != null && act) {
			map.put("actStatus", 1);
		}
		Map<String, Object> rtMap = dalClient.queryForMap("GAME_INFO.SELECT_COUNT_BY_FIELDS", map);
		String num = String.valueOf(rtMap.get("NUM"));
		return Long.parseLong(num);
	}

	@Override
	public GameInfo getGame(Long id) {
		if (id == null) {
			return null;
		}
		GameInfo game = new GameInfo();
		game.setId(id);
		game = dalClient.find(GameInfo.class, game);
		if (game == null) {
			return null;
		} else {
			game.setId(id);
			return game;
		}
	}

	@Override
	public GameInfoDto getGame(Long gameId, Long userId) {
		GameInfo game = getGame(gameId);
		if (game == null) {
			return null;
		}
		GameInfoDto dto = new GameInfoDto();
		BeanCopyUtils.copyProperties(game, dto);
		if (userId != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gameId", gameId);
			map.put("userId", userId);
			List<GameJoin> list = dalClient.queryForList("GAME_JOIN.SELECT_BY_FIELDS", map, GameJoin.class);
			if (list == null || list.isEmpty()) {
				dto.setJoinStatus(0);
			} else {
				dto.setJoinStatus(1);
			}
		}
		return dto;

	}

	@Override
	public void joinGame(Long gameId, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gameId", gameId);
		map.put("userId", userId);
		List<GameJoin> list = dalClient.queryForList("GAME_JOIN.SELECT_BY_FIELDS", map, GameJoin.class);
		if (list == null || list.isEmpty()) {
			GameJoin join = new GameJoin();
			join.setGameId(gameId);
			join.setUserId(userId);
			join.setCreateTime(new Date());
			dalClient.persist(join);

			GameInfo game = getGame(gameId);
			game.setJoinCount(game.getJoinCount() + 1);
			dalClient.merge(game);

		}
	}

	@Override
	public List<UserInfo> getJoinUserList(Long gameId, String mobile, Long startIndex, Long num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gameId", gameId);
		map.put("startIndex", startIndex);
		map.put("maxCount", num);
		if (StringUtils.isNotEmpty(mobile)) {
			map.put("mobile", mobile);
		}
		return dalClient.queryForList("GAME_JOIN.SELECT_USER", map, UserInfo.class);
	}

	@Override
	public Long getJoinUserCount(Long gameId, String mobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gameId", gameId);
		if (StringUtils.isNotEmpty(mobile)) {
			map.put("mobile", mobile);
		}
		Map<String, Object> rtMap = dalClient.queryForMap("GAME_JOIN.SELECT_USER_COUNT", map);
		String num = String.valueOf(rtMap.get("NUM"));
		return Long.parseLong(num);
	}

	@Override
	public GameInfo saveGame(GameInfo game, MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			try {
				File tempFile = File.createTempFile("growth", ".jpg");
				file.transferTo(tempFile);
				String path = fileClient.saveFile(tempFile.getAbsolutePath(), FileClient.BIZTYPE_GAME);
				if (StringUtils.isNotEmpty(path)) {
					game.setCoverImgPath(path);
				}
				tempFile.delete();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		if (game.getId() == null) {
			game.setCreateTime(new Date());
			game.setJoinCount(0);
			Long id = dalClient.persist(game).longValue();
			game.setId(id);
			return game;
		} else {
			GameInfo old = getGame(game.getId());
			BeanCopyUtils.copyProperties(game, old);
			dalClient.merge(old);
			return old;
		}

	}

	@Override
	public void deleteGame(Long id) {
		GameInfo old = getGame(id);
		if (old != null) {
			dalClient.remove(old);
		}
	}

	@Override
	public void stopGame(Long id) {
		GameInfo old = getGame(id);
		if (old != null) {
			old.setActStatus(0);
			dalClient.merge(old);
		}

	}

	@Override
	public void startGame(Long id) {
		GameInfo old = getGame(id);
		if (old != null) {
			old.setActStatus(1);
			dalClient.merge(old);
		}

	}

}
