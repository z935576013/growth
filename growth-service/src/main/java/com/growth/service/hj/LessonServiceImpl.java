package com.growth.service.hj;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growth.common.dal.DalClient;
import com.growth.common.utils.BeanCopyUtils;
import com.growth.service.intf.hj.LessonService;
import com.growth.service.intf.hj.dto.LessonInfo;

@Service
public class LessonServiceImpl implements LessonService {

	@Autowired
	DalClient dalClient;

	@Override
	public List<LessonInfo> getList(Integer lessonType, String lessonTitle, Boolean act, Long startIndex, Long num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lessonType", lessonType);
		map.put("startIndex", startIndex);
		map.put("maxCount", num);
		if (StringUtils.isNotEmpty(lessonTitle)) {
			map.put("lessonTitle", lessonTitle);
		}
		if (act != null && act) {
			map.put("actStatus", 1);
		}
		map.put("orderBy", "CREATE_TIME");
		map.put("orderByDesc", "DESC");
		return dalClient.queryForList("LESSON_INFO.SELECT_BY_FIELDS", map, LessonInfo.class);
	}

	@Override
	public Long getListCount(Integer lessonType, String lessonTitle, Boolean act) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lessonType", lessonType);
		if (StringUtils.isNotEmpty(lessonTitle)) {
			map.put("lessonTitle", lessonTitle);
		}
		if (act != null && act) {
			map.put("actStatus", 1);
		}
		Map<String, Object> rtMap = dalClient.queryForMap("LESSON_INFO.SELECT_COUNT_BY_FIELDS", map);
		String num = String.valueOf(rtMap.get("NUM"));
		return Long.parseLong(num);
	}

	@Override
	public LessonInfo getLesson(Long id) {
		if (id == null) {
			return null;
		}
		LessonInfo lesson = new LessonInfo();
		lesson.setId(id);
		lesson = dalClient.find(LessonInfo.class, lesson);
		if (lesson == null) {
			return null;
		} else {
			lesson.setId(id);
			return lesson;
		}
	}

	@Override
	public LessonInfo saveLesson(LessonInfo lesson) {
		if (lesson.getId() == null) {
			lesson.setCreateTime(new Date());
			Long id = dalClient.persist(lesson).longValue();
			lesson.setId(id);
			return lesson;
		} else {
			LessonInfo old = getLesson(lesson.getId());
			BeanCopyUtils.copyProperties(lesson, old);
			dalClient.merge(old);
			return old;
		}
	}

	@Override
	public void stopLesson(Long id) {
		LessonInfo old = getLesson(id);
		if (old != null) {
			old.setActStatus(0);
			dalClient.merge(old);
		}

	}

	@Override
	public void startLesson(Long id) {
		LessonInfo old = getLesson(id);
		if (old != null) {
			old.setActStatus(1);
			dalClient.merge(old);
		}
	}

	@Override
	public void deleteLesson(Long id) {
		LessonInfo old = getLesson(id);
		if (old != null) {
			dalClient.remove(old);
		}

	}

}
