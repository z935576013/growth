package com.growth.service.intf.hj;

import java.util.List;

import com.growth.service.intf.hj.dto.ActJoin;

public interface ActJoinService {

	/**
	 * 列表
	 */
	List<ActJoin> getList(String name, Long startIndex, Long num);

	/**
	 * 数量
	 */
	Long getListCount(String name);

	/**
	 * 报名
	 */
	ActJoin getActJoin(Long id);
	
	/**
	 * 报名
	 */
	ActJoin getActJoinByUser(Long userId);

	/**
	 * 保存
	 */
	void saveActJoin(ActJoin join);

}
