package com.cn.umessage.service.impl;

import org.springframework.stereotype.Service;

import com.cn.umessage.service.ISmsService;
import com.cn.umessage.utils.SmsUtil;

@Service("smsService")
public class SmsServiceImpl implements ISmsService {

	@Override
	public String send(String phone, String content) {
		// TODO Auto-generated method stub
		String code = SmsUtil.sendSms(phone, content);
		return code;
	}

}
