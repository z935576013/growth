package com.growth.service.intf.sample;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.growth.service.intf.sample.dto.Sample;

public interface SampleService {

	/**
	 * 列表
	 */
	List<Sample> getList(Long startIndex, Long num);

	/**
	 * 存文件
	 * @param file
	 * @return
	 */
	String saveFile(MultipartFile file);
	
	/**
	 * 保存
	 */
	void save(Sample sample);

}
