package com.jacky.foxi.service;

import com.jacky.foxi.entity.User;

public interface UserService {
	public User getInfoByOpenid(String user_openid);

	public long register(User user);
	
}
