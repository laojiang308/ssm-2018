package com.jacky.foxi.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

public class ApiController {
	public static String success(Object data) {
		Map map = new HashMap();
		map.put("code", 0);
		map.put("msg", "成功");
		map.put("data", data);
		return new JSONObject(map).toString();
	}

	public static String error(String msg) {
		Map map = new HashMap();
		map.put("code", 1);
		map.put("msg", msg);
		return new JSONObject(map).toString();
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		String str = uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23)
				+ uuid.substring(24);
		return str;
	}

	public static String uploadOSS(String fileName, String filePath) {
		String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
		String accessKeyId = "LTAICbE5r6aX1XEE";
		String accessKeySecret = "n35xmvLiVNeod3G3K2oA8BtbiFoQ4v";
		try {
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			ossClient.putObject("foxi39echocom", fileName, new File(filePath));
			ossClient.shutdown();
			return "https://foxi39echocom.oss-cn-shenzhen.aliyuncs.com" + "/" + fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
