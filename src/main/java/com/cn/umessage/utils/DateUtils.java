package com.cn.umessage.utils;

import java.text.SimpleDateFormat;

public class DateUtils {
	public static String format(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(sdf.parse(str));
		return result;
	}
}
