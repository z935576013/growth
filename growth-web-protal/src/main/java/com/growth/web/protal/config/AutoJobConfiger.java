package com.growth.web.protal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.growth.service.intf.sample.SampleService;

/**
 * 
 * 自动任务
 *
 * @author zhuliang
 */
@Component
public class AutoJobConfiger {

	@Autowired
	SampleService sampleService;

	@Scheduled(cron = "0 0 0/4 * * ?")
	public void countReturn() {
		System.out.println("AutoJob");
	}

}
