package org.pay.qrpay;

import org.junit.Test;

import com.cn.umessage.utils.SmsUtil;

public class SmsTest {
	@Test
	public void PrintSMS() {
		String sendSms = SmsUtil.sendSms("17631105409", "ce测试");
		System.out.println(sendSms);
	}
}
