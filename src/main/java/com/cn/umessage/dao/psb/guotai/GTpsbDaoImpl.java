package com.cn.umessage.dao.psb.guotai;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.cn.umessage.dao.psb.IpsbDao;
import com.cn.umessage.dao.psb.bean.GuestBean;
import com.cn.umessage.dao.psb.bean.GuestBeanCheckOut;
import com.cn.umessage.dao.psb.guotai.httpClient.GThttpClient;
@Repository("guotaiPsbDao")
public class GTpsbDaoImpl implements IpsbDao {
	private static Logger logger = Logger.getLogger(GTpsbDaoImpl.class);
	/**
	 * 入住
	 */
	@Override
	public String checkInUpload(GuestBean guest) {
		String url = "http://58.210.180.134:8891/HotelSer/CheckIn";
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(guest);
		Map map = new HashMap();
		map.put("json",jsonObject.toString());
		String result = "";
		try {
			result = GThttpClient.send(url,map,"UTF-8");
		} catch (ParseException e) {
			logger.error("调用psb接口Parse异常");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("调用psb接口IO异常");
			e.printStackTrace();
		}
		if("1".equals(result)){
			return "ok";
		}
		return "fail";
	}
	/**
	 * 退房
	 */
	@Override
	public String checkOutUpload(GuestBeanCheckOut checkOutBean) {
		StringBuffer sb = new StringBuffer("");
		sb.append("psbId="+checkOutBean.getPsbId());
		sb.append("&roomNo="+checkOutBean.getRoomNo());
		sb.append("&cardNum="+checkOutBean.getCardNum());
		sb.append("&checkOutDate="+checkOutBean.getCheckOutDate());
		//String paramStr = "psbId=1234567890"+"&roomNo=606"+"&cardNum=410381200007119678"+"&checkOutDate="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String url = "http://58.210.180.134:8891/HotelSer/CheckOut";
		String result = "";
		try {
			result = GThttpClient.sendStr(url,sb.toString(),"UTF-8");
		} catch (ParseException | IOException e) {
			logger.error("调用国泰psb退房接口异常！");
			e.printStackTrace();
			return "fail";
		}
		if(result.equals("1")){
			return "ok";
		}
		return "fail";
	}

}
