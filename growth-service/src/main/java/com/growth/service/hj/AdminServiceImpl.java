package com.growth.service.hj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growth.common.dal.DalClient;
import com.growth.service.intf.hj.AdminService;
import com.growth.service.intf.hj.dto.AdminInfo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	DalClient dalClient;

	@Override
	public AdminInfo getAdmin(String loginId, String password) {
		if (StringUtils.isEmpty(loginId) || StringUtils.isEmpty(password)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginId", loginId);
		map.put("password", password);
		List<AdminInfo> users = dalClient.queryForList("ADMIN_INFO.SELECT_BY_FIELDS", map, AdminInfo.class);
		if (users == null || users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
