package com.cn.umessage.utils;

import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SmsUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SmsUtil.class);

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param context
	 *            短信模板 模板内容{0}{1} 会自动按顺序替换thparam的值
	 * @param thparam
	 *            替换的内容 有序
	 * @return 1失败 0成功
	 */
	/*
	 * public static String sendSms(String mobile,String context, List<String>
	 * thparam){ System.out.println(context);
	 * System.out.println(JsonUtil.objectToJsonStr(thparam)); String res="1";
	 * if(!StringUtil.empty(context)){ if(thparam != null) { for (int i = 0; i <
	 * thparam.size(); i++) { if (StringUtil.empty(thparam.get(i))) { context =
	 * context.replace("{" + i + "}", ""); } else { context =
	 * context.replace("{" + i + "}", thparam.get(i)); } } } Map<String,String>
	 * param=new HashMap<String, String>(); try { param.put("mobile", mobile);
	 * param.put("context", URLEncoder.encode(context, "utf-8"));
	 * param.put("smsType", "1630"); param.put("smsChannel", "");
	 * param.put("sendTime", ""); param.put("sendMan", ""); } catch
	 * (UnsupportedEncodingException e) { } Properties p =
	 * PropertiesUtil.getPropertiesWeb("config.properties");
	 * res=HttpUtil.sendPost(p.getProperty("sms.url"), param, "UTF-8"); } return
	 * res; }
	 */

	/**
	 * 根据模板生成短信内容
	 * 
	 * @param thparam
	 *            替换的内容 有序
	 * @return 短信内容
	 */
	/*
	 * public static String buildSmsContext(String context, List<String>
	 * thparam){ if(thparam!=null&&!StringUtil.empty(context)){ for (int i = 0;
	 * i < thparam.size(); i++) { if(StringUtil.empty(thparam.get(i))){
	 * context=context.replace("{"+i+"}",""); }else { context =
	 * context.replace("{" + i + "}", thparam.get(i)); } } } return context; }
	 */

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param context
	 *            内容
	 * @return 0成功 1失败
	 */
	public static String sendSms(String mobile, String context) {
		System.out.println(context);
		String res = "0";
		// if(!StringUtil.empty(context)){
		if (context != null) {
			Map<String, String> param = new HashMap<String, String>();
			try {
				// param.put("mobile", mobile);
				// param.put("smsContent", URLEncoder.encode(context, "utf-8"));
				// param.put("smsType", "1630");
				param.put("smsChannel", "");
				param.put("sendTime", "");
				param.put("sendMan", "");

				String sign = getVerificationChannelSign(mobile);
				param.put("smsType", "4");
				param.put("mobile", mobile);
				param.put("smsContent", URLEncoder.encode(context, "utf-8"));
				param.put("channelName", "tmc");
				param.put("status", "1");// 0就是没有上行,1是有上行(returnContent不能为空)
				param.put("returnContent", URLEncoder.encode("td,gh", "utf-8"));
				param.put("sign", sign);

			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
			// Properties p =
			// PropertiesUtil.getPropertiesWeb("config.properties");
			try {
				res = HttpRequestUtil
						.send("http://39.104.68.154:8081/", param, "UTF-8");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (res.equals("0")) {
				res = "1";
			} else {
				res = "0";
			}
		}
		return res;
	}

	/** 生成sign **/
	private static String getVerificationChannelSign(String mobile) {
		// String channelSign = MD5Util.MD5("travelh5" + "travelh5_2017" +
		// mobile);
		String channelSign = MD5Util.MD5Encode("tmc" + "tmc_2017" + mobile, "");
		return channelSign;
	}

	public static void main(String[] args) {
		String content = "【海逸大酒店】尊敬的先生，您的房间号是1010，入住日期为2018/12/12 6:00至2018/12/12 14:00，感谢您使用无限讯奇酒店自助机办理入住!";
		System.out.println(sendSms("15001096412", "【海逸大酒店】验证码：8888"));
	}

}
