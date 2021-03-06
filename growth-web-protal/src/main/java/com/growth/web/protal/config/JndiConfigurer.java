package com.growth.web.protal.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiLocatorDelegate;

public class JndiConfigurer {

	@Bean
	public DataSource ds01() throws NamingException {
		return JndiLocatorDelegate.createDefaultResourceRefLocator().lookup("growthDs01", DataSource.class);
	}

}
