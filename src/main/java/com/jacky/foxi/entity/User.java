package com.jacky.foxi.entity;

public class User {
	private long user_id;
	private String user_openid;
	private String user_session_key;
	private String user_name;
	private String user_avatar;
	private Integer user_gender;
	private long create_time;
	private long last_login_time;

	public User() {
		super();
	}

	public User(long user_id, String user_openid, String user_session_key, String user_name, String user_avatar,
			Integer user_gender, long create_time, long last_login_time) {
		super();
		this.user_id = user_id;
		this.user_openid = user_openid;
		this.user_session_key = user_session_key;
		this.user_name = user_name;
		this.user_avatar = user_avatar;
		this.user_gender = user_gender;
		this.create_time = create_time;
		this.last_login_time = last_login_time;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_openid() {
		return user_openid;
	}

	public void setUser_openid(String user_openid) {
		this.user_openid = user_openid;
	}

	public String getUser_session_key() {
		return user_session_key;
	}

	public void setUser_session_key(String user_session_key) {
		this.user_session_key = user_session_key;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public Integer getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(Integer user_gender) {
		this.user_gender = user_gender;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(long l) {
		this.last_login_time = l;
	}

}