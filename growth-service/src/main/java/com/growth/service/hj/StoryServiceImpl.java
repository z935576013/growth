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
import com.growth.service.intf.hj.StoryService;
import com.growth.service.intf.hj.UserService;
import com.growth.service.intf.hj.dto.StoryInfo;
import com.growth.service.intf.hj.dto.UserInfo;

@Service
public class StoryServiceImpl implements StoryService {

	@Autowired
	DalClient dalClient;

	@Autowired
	FileClient fileClient;
	
	@Autowired
	UserService userService;

	@Override
	public List<StoryInfo> getList(Long userId, Integer storyType, String storyTitle, Boolean act, Long startIndex,
			Long num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storyType", storyType);
		map.put("userId", userId);
		map.put("startIndex", startIndex);
		map.put("maxCount", num);
		if (StringUtils.isNotEmpty(storyTitle)) {
			map.put("storyTitle", storyTitle);
		}
		if (act != null && act) {
			map.put("actStatus", 1);
		}
		map.put("orderBy", "CREATE_TIME");
		map.put("orderByDesc", "DESC");
		
		List<StoryInfo> list = dalClient.queryForList("STORY_INFO.SELECT_BY_FIELDS", map, StoryInfo.class);
		UserInfo userInfo = null;
		for(StoryInfo si : list) {
			userInfo = userService.getUserByMobile(si.getUserName());
			if(userInfo != null && StringUtils.isNotBlank(userInfo.getName())) {
				si.setUserName(userInfo.getName());
			}
		}
		return list;
	}

	@Override
	public Long getListCount(Long userId, Integer storyType, String storyTitle, Boolean act) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("storyType", storyType);
		if (StringUtils.isNotEmpty(storyTitle)) {
			map.put("storyTitle", storyTitle);
		}
		if (act != null && act) {
			map.put("actStatus", 1);
		}
		Map<String, Object> rtMap = dalClient.queryForMap("STORY_INFO.SELECT_COUNT_BY_FIELDS", map);
		String num = String.valueOf(rtMap.get("NUM"));
		return Long.parseLong(num);
	}

	@Override
	public StoryInfo getStory(Long id) {
		if (id == null) {
			return null;
		}
		StoryInfo story = new StoryInfo();
		story.setId(id);
		story = dalClient.find(StoryInfo.class, story);
		if (story == null) {
			return null;
		} else {
			UserInfo userInfo = userService.getUserByMobile(story.getUserName());
			if(userInfo != null && StringUtils.isNotBlank(userInfo.getName())) {
				story.setUserName(userInfo.getName());
			}
			story.setId(id);
			return story;
		}
	}

	@Override
	public StoryInfo saveStory(StoryInfo story, MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			try {
				File tempFile = File.createTempFile("growth", ".jpg");
				file.transferTo(tempFile);
				String path = fileClient.saveFile(tempFile.getAbsolutePath(), FileClient.BIZTYPE_STORY);
				if (StringUtils.isNotEmpty(path)) {
					story.setCoverImgPath(path);
				}
				tempFile.delete();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		if (story.getId() == null) {
			story.setCreateTime(new Date());
			story.setActStatus(1);
			Long id = dalClient.persist(story).longValue();
			story.setId(id);
			return story;
		} else {
			StoryInfo old = getStory(story.getId());
			BeanCopyUtils.copyProperties(story, old);
			dalClient.merge(old);
			return old;
		}
	}

	@Override
	public void deleteStory(Long id) {
		StoryInfo old = getStory(id);
		if (old != null) {
			dalClient.remove(old);
		}

	}

	@Override
	public void stopStory(Long id) {
		StoryInfo old = getStory(id);
		if (old != null) {
			old.setActStatus(0);
			dalClient.merge(old);
		}

	}

	@Override
	public void startStory(Long id) {
		StoryInfo old = getStory(id);
		if (old != null) {
			old.setActStatus(1);
			dalClient.merge(old);
		}

	}

}
