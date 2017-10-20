package com.growth.service.hj;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growth.common.dal.DalClient;
import com.growth.service.intf.hj.ActJoinService;
import com.growth.service.intf.hj.dto.ActJoin;

@Service
public class ActJoinServiceImpl implements ActJoinService {

	@Autowired
	DalClient dalClient;

	@Override
	public List<ActJoin> getList(String name, Long startIndex, Long num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", startIndex);
		map.put("maxCount", num);
		if (StringUtils.isNotEmpty(name)) {
			map.put("name", name);
		}
		map.put("orderBy", "CREATE_TIME");
		map.put("orderByDesc", "DESC");
		return dalClient.queryForList("ACT_JOIN.SELECT_BY_FIELDS", map, ActJoin.class);
	}

	@Override
	public Long getListCount(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(name)) {
			map.put("name", name);
		}
		Map<String, Object> rtMap = dalClient.queryForMap("ACT_JOIN.SELECT_COUNT_BY_FIELDS", map);
		String num = String.valueOf(rtMap.get("NUM"));
		return Long.parseLong(num);
	}

	@Override
	public ActJoin getActJoin(Long id) {
		if (id == null) {
			return null;
		}
		ActJoin actJoin = new ActJoin();
		actJoin.setId(id);
		actJoin = dalClient.find(ActJoin.class, actJoin);
		if (actJoin == null) {
			return null;
		} else {
			actJoin.setId(id);
			return actJoin;
		}
	}

	@Override
	public void saveActJoin(ActJoin join) {
		join.setCreateTime(new Date());
		dalClient.persist(join);
	}

	@Override
	public ActJoin getActJoinByUser(Long userId) {
		if (userId == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<ActJoin> list = dalClient.queryForList("ACT_JOIN.SELECT_BY_FIELDS", map, ActJoin.class);
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
