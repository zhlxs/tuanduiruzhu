package com.cn.umessage.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cn.umessage.dao.pms.IPmsDao;
import com.cn.umessage.dao.pms.ly.dao.LYDao;
import com.cn.umessage.pojo.PayBean;
import com.cn.umessage.pojo.PayResultBean;
import com.cn.umessage.service.IPayService;
import com.cn.umessage.utils.HttpRequestUtil;
import com.cn.umessage.utils.InitConfig;

@Service("payService")
public class PayServiceImpl implements IPayService {
	
	@Resource
	private IPmsDao lyPmsDao;
	private static final String url = InitConfig.PAY_URL;
	private DecimalFormat df   = new DecimalFormat("######0.00");//费用保留两位有效数字，只计算到分  
//	private static final String url = "http://39.104.68.154:8083/swiftpass";
	String pmsName = InitConfig.PMS_COMPANY;
	/**
	 * 获取二维码
	 */
	@Override
	public PayBean getPay(String hotelId, String orderNo, String body,
								String totalFree, String service) {
		PayBean pay = new PayBean();
		switch (pmsName) {
		case "xiruan":
			Map<String, String> map = new HashMap<String, String>();
			map.put("hotel_id", hotelId);
			map.put("out_trade_no", orderNo.split(",")[0]);
			map.put("body", body);
			map.put("total_fee", Double.parseDouble(totalFree)*100+"");
			map.put("service", service);
			try {
				String json = HttpRequestUtil.send(url + "/pay", map, "utf-8");
				System.out.println(json);
				JSONObject j = JSONObject.parseObject(json);
				String charset = j.getString("charset");
				String imgUrl = j.getString("code_img_url");
				String nonceStr = j.getString("nonce_str");
				String codeUrl = j.getString("code_url");
				String appId = j.getString("appid");
				String resultCode = j.getString("result_code");
				String mchId = j.getString("mch_id");
				String signType = j.getString("sign_type");
				String version = j.getString("version");
				String status = j.getString("status");
				pay.setAppId(appId);
				pay.setCodeUrl(codeUrl);
				pay.setcSet(charset);
				pay.setImgUrl(imgUrl);
				pay.setMchId(mchId);
				pay.setNonceStr(nonceStr);
				pay.setResultCode(resultCode);
				pay.setSignType(signType);
				pay.setStatus(status);
				pay.setVersion(version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "ly":
			String[] order_type = orderNo.split(",");//[0].split("_");
			String order = order_type[1];
			String type = order_type[0].split("_")[1];
			Map resMap = new LYDao().getQRcode("",order, "", "", totalFree,"zfb".equals(type)?"ALIPAY":"WEIXIN");
			pay.setStatus(String.valueOf(resMap.get("tradeCode")));//交易流水号
			pay.setImgUrl(String.valueOf(resMap.get("QRcode")));//二维码地址
			pay.setScanChannel("zfb".equals(type)?"ALIPAY":"WEIXIN");
			break;
		default:
			System.out.println("default");
			break;
	}
		return pay;
	}

	@Override
	public String queryPayStatus(String orderNo) {
		// TODO Auto-generated method stub
		String result = "";
		switch (pmsName) {
		case "xiruan":
			Map<String, String> map = new HashMap<String, String>();
			map.put("out_trade_no", orderNo.split(",")[0]);
			try {
				String json = HttpRequestUtil.send(url + "/queryPayStatus", map,
						"utf-8");
				System.out.println(json);
				if ("1".equals(json)) {
					result = "ok";
				}else{
					result = "fail";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "ly":
			List<Map> list = new LYDao().getOrderpayment(orderNo.split(",")[1],orderNo.split(",")[2]);
			if(list!=null && list.size()>0){
				 if("SUCCESS".equals(list.get(0).get("status"))){					 
					 result = "ok";
				 }else{
					 result = "fail";
				 }
			}else{
				result = "fail";
			}
			break;
		default:
			System.out.println("default");
			break;
		}
		return result;
	}

	@Override
	public String refund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String refundQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		new PayServiceImpl().getPay("", "17159_wx", "", "0.01","");
		/*String attach = "房费:100.55元 ,押金:100.66元 ,总计:200.11元";
		String deposit = attach.split(",")[1].split("\\:")[1].split("元")[0];
		System.out.println(deposit);*/
	}

	@Override
	public PayResultBean getPayResult(String orderNo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("out_trade_no", orderNo);
		try {
			String json = HttpRequestUtil.send(url + "/payQuery", map,
					"utf-8");
			System.out.println(json);
			System.out.println(json);
			JSONObject j = JSONObject.parseObject(json);
			
			String status = j.getString("status");
			if ("0".equals(status)) {
				String resultCode = j.getString("result_code");
				if("0".equals(resultCode)){
					String tradeState = j.getString("trade_state");
					if("SUCCESS".equals(tradeState)){
						String attach = j.getString("attach");
						String deposit = attach.split(",")[1].split("\\:")[1].split("元")[0];
						String totalFee = j.getString("total_fee");
						PayResultBean payResultBean = new PayResultBean();
						payResultBean.setStatus(status);
						payResultBean.setResultCode(resultCode);
						payResultBean.setTradeState(tradeState);
						payResultBean.setAttach(attach);
						payResultBean.setTotalFee(Double.parseDouble(df.format(Double.parseDouble(totalFee)/100)));
						payResultBean.setDeposit(Double.parseDouble(deposit));
						return payResultBean;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
