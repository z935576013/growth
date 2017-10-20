package com.growth.service.intf.hj;

import com.growth.service.intf.hj.dto.AdminInfo;

public interface AdminService {

	/**
	 * 管理员
	 */
	AdminInfo getAdmin(String loginId, String password);
}
