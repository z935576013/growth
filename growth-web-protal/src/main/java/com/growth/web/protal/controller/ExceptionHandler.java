package com.growth.web.protal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.growth.common.constants.ErrorMessage;
import com.growth.web.protal.util.AccountKickException;
import com.growth.web.protal.util.NoAuthorityException;
import com.growth.web.protal.util.WrongStatusException;

@Component
public class ExceptionHandler extends SimpleMappingExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ResultBean result = null;
		if (ex instanceof IllegalArgumentException) {
			result = new ResultBean(ErrorMessage.ERROR_0013);
		} else if (ex instanceof AccountKickException) {
			result = new ResultBean(ErrorMessage.ERROR_0015);
		} else if (ex instanceof WrongStatusException) {
			result = new ResultBean(ErrorMessage.ERROR_9000);
		} else if (ex instanceof NoAuthorityException) {
			result = new ResultBean(ErrorMessage.ERROR_0042);
		} else {
			// TODO error message
			result = new ResultBean(ErrorMessage.ERROR_0000);
		}
		result.addAttribute("Exception", ex.getMessage());
		try {
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			response.getWriter().write(result.toString());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
