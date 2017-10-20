package com.growth.dao.intf.sample;

import java.util.List;

import com.growth.service.intf.sample.dto.Sample;

public interface SampleDAO {

	/**
	 * 列表
	 */
	List<Sample> getList(Long startIndex, Integer num);

	/**
	 * 保存
	 */
	void save(Sample sample);

}
