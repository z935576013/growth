package com.growth.service.hj;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.growth.common.dal.DalClient;
import com.growth.common.file.FileClient;
import com.growth.common.utils.BeanCopyUtils;
import com.growth.common.utils.Md5Util;
import com.growth.service.intf.hj.UserService;
import com.growth.service.intf.hj.dto.Hobby;
import com.growth.service.intf.hj.dto.School;
import com.growth.service.intf.hj.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	DalClient dalClient;

	@Autowired
	FileClient fileClient;

	@Override
	public List<UserInfo> getList(String mobile, Long startIndex, Long num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", startIndex);
		map.put("maxCount", num);
		if (StringUtils.isNotEmpty(mobile)) {
			map.put("mobile", mobile);
		}
		return dalClient.queryForList("USER_INFO.SELECT_BY_FIELDS", map, UserInfo.class);
	}

	@Override
	public Long getListCount(String mobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(mobile)) {
			map.put("mobile", mobile);
		}
		Map<String, Object> rtMap = dalClient.queryForMap("USER_INFO.SELECT_COUNT_BY_FIELDS", map);
		String num = String.valueOf(rtMap.get("NUM"));
		return Long.parseLong(num);
	}

	@Override
	public UserInfo getUserByMobile(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", mobile);
		List<UserInfo> list = dalClient.queryForList("USER_INFO.SELECT_BY_FIELDS", map, UserInfo.class);
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Override
	public UserInfo saveUser(String mobile, String password, String openid) {
		UserInfo userInfo = new UserInfo();
		userInfo.setMobile(mobile);
		String md5 = Md5Util.MD5(password);
		userInfo.setPassword(md5);
		userInfo.setOpenid(openid);
		return saveUser(userInfo, null);
	}

	@Override
	public UserInfo saveUser(UserInfo userInfo, MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			try {
				File tempFile = File.createTempFile("growth", ".jpg");
				file.transferTo(tempFile);
				String path = fileClient.saveFile(tempFile.getAbsolutePath(), FileClient.BIZTYPE_HEAD);
				if (StringUtils.isNotEmpty(path)) {
					userInfo.setHeadImgPath(path);
				}
				tempFile.delete();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		if (userInfo.getId() == null) {
			userInfo.setCreateTime(new Date());
			Long id = dalClient.persist(userInfo).longValue();
			userInfo.setId(id);
			return userInfo;
		} else {
			UserInfo old = getUser(userInfo.getId());
			BeanCopyUtils.copyProperties(userInfo, old);
			dalClient.merge(old);
			return old;
		}
	}

	@Override
	public UserInfo getUserByPassword(String mobile, String password) {
		if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", mobile);
		String md5 = Md5Util.MD5(password);
		map.put("password", md5);
		List<UserInfo> list = dalClient.queryForList("USER_INFO.SELECT_BY_FIELDS", map, UserInfo.class);
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void setPassword(Long userId, String password) {
		UserInfo user = getUser(userId);
		if (user != null) {
			String md5 = Md5Util.MD5(password);
			user.setPassword(md5);
			dalClient.merge(user);
		}

	}

	@Override
	public UserInfo getUser(Long id) {
		if (id == null) {
			return null;
		}
		UserInfo user = new UserInfo();
		user.setId(id);
		user = dalClient.find(UserInfo.class, user);
		if (user == null) {
			return null;
		} else {
			user.setId(id);
			return user;
		}
	}

	@Override
	public UserInfo getUserByOpenid(String openid) {
		if (StringUtils.isEmpty(openid)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		List<UserInfo> list = dalClient.queryForList("USER_INFO.SELECT_BY_FIELDS", map, UserInfo.class);
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void setOpenid(Long userId, String openid) {
		UserInfo user = getUser(userId);
		user.setOpenid(openid);
		dalClient.merge(user);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		map.put("userId", userId);
		dalClient.execute("USER_INFO.CLEAR_OPENID", map);
	}

	@Override
	public List<School> getSchoolList() {
		Map<String, Object> map = new HashMap<String, Object>();
		return dalClient.queryForList("SCHOOL.SELECT_BY_FIELDS", map, School.class);
	}

	@Override
	public List<Hobby> getHobbyList() {
		Map<String, Object> map = new HashMap<String, Object>();
		return dalClient.queryForList("HOBBY.SELECT_BY_FIELDS", map, Hobby.class);
	}

}
