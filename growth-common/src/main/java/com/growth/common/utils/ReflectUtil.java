package com.growth.common.utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtil {
	private ReflectUtil(){};
	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtil.class);
	
	/**
	 * 获取t中域field的值
	 * @param field
	 * @param t
	 * @return
	 */
	public static <T> Object getValue(Field field, T t){
		boolean isAccessible = field.isAccessible();
		if(!isAccessible){
			field.setAccessible(true);
			try {
				return field.get(t);
			} catch (IllegalArgumentException e) {
				LOGGER.error("getValue is fail"+e);
			} catch (IllegalAccessException e) {
				LOGGER.error("getValue is fail"+e);
			} finally {
				field.setAccessible(isAccessible);
			}
		}
		
		try {
			return field.get(t);
		} catch (IllegalArgumentException e) {
			LOGGER.error("getValue is fail"+e);
		} catch (IllegalAccessException e) {
			LOGGER.error("getValue is fail"+e);
		}
		
		return null;
	}
	
	public static <T> void setValue(Field field, T t,Object value){
		boolean isAccessible = field.isAccessible();
		if(!isAccessible){
			field.setAccessible(true);
			try {
				field.set(t, value);
				return;
			} catch (IllegalArgumentException e) {
				LOGGER.error("setValue is fail"+e);
			} catch (IllegalAccessException e) {
				LOGGER.error("setValue is fail"+e);
			} finally {
				field.setAccessible(isAccessible);
			}
		}
		
		try {
			field.set(t, value);
		} catch (IllegalArgumentException e) {
			LOGGER.error("setValue is fail"+e);
		} catch (IllegalAccessException e) {
			LOGGER.error("setValue is fail"+e);
		}
		
	}
}
