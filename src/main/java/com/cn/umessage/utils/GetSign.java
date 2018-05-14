package com.cn.umessage.utils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSign {
	public static String getSign(Map<String, String> signParams,
			String appSecret) {

		// 2.1 获取signParams中的key值
		StringBuilder sb = new StringBuilder();
		List<String> keyList = new ArrayList(signParams.size());
		for (Map.Entry entry : signParams.entrySet()) {
			keyList.add((String) entry.getKey());
		}
		// 2.2将key值进行排序
		Collections.sort(keyList);
		// 2.3 根据排序后的key值按照下列各式输出
		sb.append(appSecret);
		for (String key : keyList) {
			sb.append(key).append((String) signParams.get(key));
		}
		sb.append(appSecret);
		// 2.4 SHA1 加密后 将二进制输出为字符串
		try {
			byte[] sha1Digest = getSHA1Digest(sb.toString());
			return byte2hex(sha1Digest);
		} catch (IOException e) {
			throw new RuntimeException("签名失败", e);
		}
	}

	private static byte[] getSHA1Digest(String data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			bytes = md.digest(data.getBytes("UTF-8"));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.getMessage());
		}
		return bytes;
	}

	private static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}

	public static void main(String[] args) {
		GetSign sn = new GetSign();

		String appSecret = "8b3d727f1ba1cde61cef63143ebab5e5";
		Map<String, String> signParams = new HashMap<String, String>();
		// 1.1接口所有请求参数，以获取sessionId接口为例，演示sign生成方式
		signParams.put("v", "3.0");
		signParams.put("s", "s");
		signParams.put("n", "n");
		signParams.put("c", "c");
		signParams.put("f", "702");
		signParams.put("q", ",,GCBZ");
		signParams.put("sessionId", "2ED04CE0472B48FEBB57110600AC56D6");
		signParams.put("appKey", "10003");

		String sign = sn.getSign(signParams, appSecret);
		System.out.println(sign);
	}

}