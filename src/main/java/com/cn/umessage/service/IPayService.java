package com.cn.umessage.service;

import com.cn.umessage.pojo.PayBean;
import com.cn.umessage.pojo.PayResultBean;

/**
 * 支付服务
 * 
 * @author hyj
 * 
 */
public interface IPayService {
	/**
	 * 
	 * @param hotelId
	 * @param orderNo
	 * @param body
	 * @param totalFree
	 * @param service
	 * @return
	 */
	public PayBean getPay(String hotelId, String orderNo, String body,
			String totalFree, String service);

	public String queryPayStatus(String orderNo);

	public String refund();

	public String refundQuery();
	
	public PayResultBean getPayResult(String orderNo);

}
