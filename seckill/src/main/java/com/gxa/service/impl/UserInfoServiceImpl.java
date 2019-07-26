package com.gxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxa.dao.UserInfoDao;
import com.gxa.pojo.UserInfo;
import com.gxa.service.UserInfoService;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
@Service(value = "userInfoServiceImpl")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	// 用户登录
	public List<UserInfo> Login(String name, String password) {

		return userInfoDao.Login(name, password);
	}

	// 用户注册
	public int Regest(UserInfo userInfo) {

		return userInfoDao.Regest(userInfo);
	}

	// 查看注册用户的用户名是否存在
	@Override
	public List<UserInfo> RegestUsername(String name) {
		// TODO Auto-generated method stub
		return userInfoDao.RegestUsername(name);
	}

	// 修改最后登录时间
	@Override
	public int updateLoginTime(String name) {
		// TODO Auto-generated method stub
		return userInfoDao.updateLoginTime(name);
	}

}
