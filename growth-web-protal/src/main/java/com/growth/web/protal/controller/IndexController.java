package com.growth.web.protal.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		String agent = request.getHeader("User-Agent");
		if (StringUtils.isNotEmpty("agent") && agent.indexOf("MicroMessenger") >= 0) {
			return "/common/closeWx.ftl";
		} else {
			return "index.ftl";
		}

	}

}
