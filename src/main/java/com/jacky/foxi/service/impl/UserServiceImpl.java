package com.jacky.foxi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jacky.foxi.dao.UserDao;
import com.jacky.foxi.entity.User;
import com.jacky.foxi.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User getInfoByOpenid(String user_openid) {
		return userDao.getInfoByOpenid(user_openid);
	}

	@Override
	public long register(User user) {
		return userDao.register(user);
	}

}
