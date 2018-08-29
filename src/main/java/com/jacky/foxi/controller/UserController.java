package com.jacky.foxi.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jacky.foxi.common.HttpService;
import com.jacky.foxi.common.WxDataDecrypt;
import com.jacky.foxi.entity.User;
import com.jacky.foxi.service.UserService;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends ApiController {

	@Resource
	private UserService userService;

	@Value("${appid}")
	private String appid;

	@Value("${secret}")
	private String secret;

	/**
	 * 登录接口
	 * 
	 * @param code
	 * @param encrypted_data
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(@RequestParam(value = "code") String code,
			@RequestParam(value = "encrypted_data") String encrypted_data, @RequestParam(value = "iv") String iv)
			throws Exception {

		// 微信小程序登录的接口
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + this.appid + "&secret=" + this.secret
				+ "&js_code=" + code + "&grant_type=authorization_code";

		// 调用微信登录接口解析为JSON对象
		JSONObject json = new JSONObject(HttpService.get(url, ""));

		// 把接口返回的数据赋值
		String user_openid = json.getString("openid");
		String user_session_key = json.getString("session_key");

		// 查詢数据库用户的信息
		User user = userService.getInfoByOpenid(user_openid);

		// 定义返回的数据
		Map result = new HashMap();

		// 如果用户信息为空，则开始注册
		if (user == null) {
			// 微信解密用户加密信息
			JSONObject userInfo = WxDataDecrypt.getUserInfo(user_session_key, encrypted_data, iv);

			user = new User();
			user.setCreate_time(System.currentTimeMillis() / 1000);
			user.setLast_login_time(System.currentTimeMillis() / 1000);
			user.setUser_name(userInfo.getString("nickName"));
			user.setUser_gender(userInfo.getInt("gender"));
			user.setUser_openid(user_openid);
			user.setUser_session_key(user_session_key);
			user.setUser_avatar(userInfo.getString("avatarUrl"));
			userService.register(user);
		}

		// 整理返回的数据
		result.put("user", user);

		return success(result);
	}

	/**
	 * 获取用户信息接口
	 * 
	 * @param code
	 * @param encrypted_data
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String info(@RequestHeader(value = "user_openid") String user_openid) throws Exception {

		// 查詢数据库用户的信息
		User user = userService.getInfoByOpenid(user_openid);

		// 定义返回的数据
		Map result = new HashMap();

		// 整理返回的数据
		result.put("user", user);

		return success(result);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String test(@RequestParam(value = "a") String a) throws Exception {

		return success(a);

	}
}