package com.jacky.foxi.dao;

import com.jacky.foxi.entity.User;

public interface UserDao {
	public abstract User getInfoByOpenid(String user_openid);

	public abstract long register(User user);
}