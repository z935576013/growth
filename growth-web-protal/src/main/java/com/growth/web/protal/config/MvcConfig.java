package com.growth.web.protal.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.growth.common.config.AppConfig;
import com.growth.service.intf.hj.GameService;

import freemarker.template.TemplateException;

@Configuration
@ComponentScan(basePackages = "com.growth.web.protal.controller")
//@Import({ HessianConfigurer.class})
//@Import({ DubboConfigurer.class})
public class MvcConfig extends WebMvcConfigurationSupport {

	@Autowired
	GameService gameService;

	@Bean
	public ViewResolver viewResolver() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("conf/web/"
				+ AppConfig.getEvnName() + "-main-setting-web.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		Properties props = propertiesFactoryBean.getObject();

		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setViewNames(new String[] { "*.ftl" });
		resolver.setOrder(1);
		resolver.setViewClass(FreeMarkerView.class);
		resolver.setContentType("text/html;charset=utf-8");
		resolver.setAttributes(props);
		
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("gameService", gameService);
		resolver.setAttributesMap(attributes);
		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() throws IOException,
			TemplateException {
		FreeMarkerConfigurationFactoryBean freemarkerConfiguration = new FreeMarkerConfigurationFactoryBean();
		freemarkerConfiguration
				.setTemplateLoaderPath("../../WEB-INF/freemarker/");
		freemarkerConfiguration.setConfigLocation(new ClassPathResource(
				"conf/freemarker.properties"));
		freemarkerConfiguration.setDefaultEncoding("utf-8");

		FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
		freemarkerConfig.setConfiguration(freemarkerConfiguration
				.createConfiguration());
		return freemarkerConfig;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1024 * 1024 * 1024 * 10);
		return resolver;
	}


}