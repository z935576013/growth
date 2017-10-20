package com.growth.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.growth.common.config.AppConfig;



@ContextConfiguration(classes = { AppConfig.class,FakeJndiConfigurer.class})
@TransactionConfiguration(defaultRollback = false)
public abstract class BaseTest extends AbstractTransactionalTestNGSpringContextTests {

}