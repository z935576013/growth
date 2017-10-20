package com.growth.service.intf.hj;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.growth.service.intf.hj.dto.Hobby;
import com.growth.service.intf.hj.dto.School;
import com.growth.service.intf.hj.dto.UserInfo;

public interface UserService {

	/**
	 * 列表
	 */
	List<UserInfo> getList(String mobile, Long startIndex, Long num);

	/**
	 * 数量
	 */
	Long getListCount(String mobile);

	/**
	 * 用户
	 */
	UserInfo getUser(Long id);

	/**
	 * 电话取用户
	 */
	UserInfo getUserByMobile(String mobile);

	/**
	 * 保存用户
	 */
	UserInfo saveUser(UserInfo userInfo, MultipartFile file);

	/**
	 * 保存用户
	 */
	UserInfo saveUser(String mobile, String password, String openid);

	/**
	 * 密码取用户
	 */
	UserInfo getUserByPassword(String mobile, String password);

	/**
	 * 设置密码
	 */
	void setPassword(Long userId, String password);

	/**
	 * openid取用户
	 */
	UserInfo getUserByOpenid(String openid);

	/**
	 * 设置openid
	 */
	void setOpenid(Long userId, String openid);

	/**
	 * 学校列表
	 */
	List<School> getSchoolList();

	/**
	 * 兴趣列表
	 */
	List<Hobby> getHobbyList();
}
