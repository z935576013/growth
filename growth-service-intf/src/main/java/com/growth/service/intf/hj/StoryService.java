package com.growth.service.intf.hj;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.growth.service.intf.hj.dto.StoryInfo;

public interface StoryService {

	/**
	 * 列表
	 */
	List<StoryInfo> getList(Long userId, Integer storyType, String storyTitle, Boolean act, Long startIndex, Long num);

	/**
	 * 数量
	 */
	Long getListCount(Long userId, Integer storyType, String storyTitle, Boolean act);

	/**
	 * 故事
	 */
	StoryInfo getStory(Long id);

	/**
	 * 保存
	 */
	StoryInfo saveStory(StoryInfo story, MultipartFile file);

	/**
	 * 删除
	 */
	void deleteStory(Long id);

	/**
	 * 停止故事
	 */
	void stopStory(Long id);

	/**
	 * 开始故事
	 */
	void startStory(Long id);
}
