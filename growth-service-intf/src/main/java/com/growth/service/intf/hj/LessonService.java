package com.growth.service.intf.hj;

import java.util.List;

import com.growth.service.intf.hj.dto.LessonInfo;

public interface LessonService {

	/**
	 * 列表
	 */
	List<LessonInfo> getList(Integer lessonType, String lessonTitle, Boolean act, Long startIndex, Long num);

	/**
	 * 数量
	 */
	Long getListCount(Integer lessonType, String lessonTitle, Boolean act);

	/**
	 * 课堂
	 */
	LessonInfo getLesson(Long id);

	/**
	 * 保存课堂
	 */
	LessonInfo saveLesson(LessonInfo lesson);

	/**
	 * 删除课堂
	 */
	void deleteLesson(Long id);

	/**
	 * 停止课堂
	 */
	void stopLesson(Long id);

	/**
	 * 开始课堂
	 */
	void startLesson(Long id);
}
