package org.pay.qrpay;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.junit.Test;

import com.cn.umessage.utils.HttpRequestUtil;
import com.cn.umessage.utils.QrPayUtils;

public class QrTest {
	@Test
	public void qrPay() {
		try {
			StringBuilder sb = new StringBuilder();

			HashMap<String, String> mapzf = new HashMap<>();
			mapzf.put("amount", "100");
			mapzf.put("orderNo", "1234567");
			String qrPay = QrPayUtils.qrPay(mapzf);
			System.out.println(qrPay);
			sb.append(qrPay);
			HashMap<String, String> mapwx = new HashMap<>();
			mapwx.put("amount", "100");
			mapwx.put("product_id", "1234567");
			mapwx.put("orderNo", "1234567");
			String strwx = QrPayUtils.qrwxPay(mapwx);
			sb.append(",");
			sb.append(strwx);
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void qrwxPay() {
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("amount", "100");
			map.put("product_id", "1234567");
			String qrPay = QrPayUtils.qrwxPay(map);
			System.out.println(qrPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pingNotify() throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("productid", "123456789");
		String wxpayStr = QrPayUtils.paycheck(map);
		System.out.println(wxpayStr);
	}
}
