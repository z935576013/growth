package com.growth.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan(basePackages = { "com.growth" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
@Import({ LogbackConfigurer.class, DaConfigurer.class,
		PropertiesConfigurer.class, ValidatorConfigurer.class })
@EnableAsync
public class AppConfig {
	private static String evnName = System.getProperty("evnName", "DEV");
	
	private static String appName = "";
	
	private static String nodeIP = "";

	public static String getEvnName() {
		return evnName;
	}

	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(1000);
		taskExecutor.setKeepAliveSeconds(30);
		taskExecutor.setMaxPoolSize(3000);
		taskExecutor.setQueueCapacity(5000);
		return taskExecutor;
	}

	public static String getAppName() {
		return appName;
	}

	public static void setAppName(String appName) {
		AppConfig.appName = appName;
	}

	public static String getNodeIP() {
		return nodeIP;
	}

	public static void setNodeIP(String nodeIP) {
		AppConfig.nodeIP = nodeIP;
	}
	
}