package com.cn.umessage.utils;

import java.util.Map;

public class QrPayUtils {
	public static String qrPay(Map<String, String> map) throws Exception {
		String alipayStr = HttpRequestUtil.send(
				"http://39.104.68.154:8082/payment/qrPay/qr", map, "utf-8");
		return alipayStr;
	}

	public static String qrwxPay(Map<String, String> map) throws Exception {
		String wxpayStr = HttpRequestUtil.send(
				"http://39.104.68.154:8082/payment/qrPay/qrwx", map, "utf-8");
		return wxpayStr;
	}

	public static String paycheck(Map<String, String> map) throws Exception {
		String wxpayStr = HttpRequestUtil
				.send("http://39.104.68.154:8082/payment/success/check", map,
						"utf-8");
		return wxpayStr;
	}
}
