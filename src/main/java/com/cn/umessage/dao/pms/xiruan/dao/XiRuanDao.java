package com.cn.umessage.dao.pms.xiruan.dao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.umessage.dao.CheckOutRoomMapper;
import com.cn.umessage.dao.DepositInfoMapper;
import com.cn.umessage.dao.pms.IPmsDao;
import com.cn.umessage.pojo.AvailableRoom;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.pojo.CheckOutRoom;
import com.cn.umessage.pojo.DepositInfo;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.pojo.OrderInfo;
import com.cn.umessage.pojo.PayInfo;
import com.cn.umessage.pojo.PayResultBean;
import com.cn.umessage.pojo.RoomType;
import com.cn.umessage.service.IDepositInfoService;
import com.cn.umessage.service.IPayService;
import com.cn.umessage.utils.HttpRequestUtil;
import com.cn.umessage.utils.InitConfig;
import com.cn.umessage.utils.RegexUtil;

@Service("xiruanPmsDao")
public class XiRuanDao implements IPmsDao {
//	public static String url = "http://jackchenyw.free.ngrok.cc/westsoft/";
	public static String url = InitConfig.XIRUAN_URL;
	private static Logger logger = Logger.getLogger(XiRuanDao.class);
	@Resource
	private CheckOutRoomMapper checkOutRoomDao;
	@Resource
	private DepositInfoMapper depositInfoDao;
	@Resource
	//支付服务
	private IPayService payService;
	@Resource
	//押金服务
	private IDepositInfoService depositInfoService;
	
	private DecimalFormat df   = new DecimalFormat("######0.00");//费用保留两位有效数字，只计算到分  

	// public static String url = InitConfig.XIRUAN_URL;
	public static void main(String[] args) {
		// Wxuser u = new Wxuser();
		// u.setUsername("");
		// u.setPhone("15001096412");
//		new XiRuanDao().getOrder("林志成");
		// new XiRuanDao().checkOut("F18B060067");
		// String jsonResultStr =
		// "{\"item\":{\"accnt\":\"F18B060067\"},\"result\":\"0\",\"resultdesc\":\"成功\"}";
		// try {
		// JSONObject json = JSONObject.parseObject(jsonResultStr);
		// System.out.println(json);
		// String resultCode = json.getString("result");
		// if(resultCode!=null && "0".equals(resultCode)){
		// System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

//		String name = "贺跃杰";
//		System.out.println(name.substring(0, 1));
//		System.out.println(name.substring(1));
//		List<CheckInInfo> list = new XiRuanDao().getCheckInInfo("6012");
//		System.out.println(list.size());
		
		try {
//			System.out.println(daysBetween("2018/03/10","2018/03/10"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				try {
					System.out.println(format("2018/03/10 10:00"));
					System.out.println(formatInt("2018/03/10 10:00"));
					System.out.println(getDateInt());
					System.out.println(formatInt("2018/03/10 10:00")-getDateInt());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	/*
	 * 调用自封装的接口服务-->西软接口
	 */
	public static String pmsWestSoft(String method, String paramXml)
			throws ParseException, IOException {
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("xmlStr", paramXml);
		// 调用公共方法去访问pms
		String jsonResult = HttpRequestUtil.send(url + method, mapParam,
				"utf-8");
		logger.info("jsonResult="+jsonResult);
		return jsonResult;
	}

	@Override
	public List<RoomType> getRoomTypes(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询订单信息
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<OrderInfo> getOrder(String queryString) {
		String method = "GetArrivingReservation";// 方法名
		StringBuffer sb = new StringBuffer();
		String fullname = "";
		String phone = "";
		if(RegexUtil.isMobileNO(queryString.trim())){//是否是手机号
			phone = queryString.trim();
		}else{
			fullname = queryString.trim();
		}
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<resno>").append("</resno>");
		sb.append("<accnt>").append("</accnt>");
		sb.append("<fullname>").append(fullname == null ? "" : fullname).append("</fullname>");
		sb.append("<ident>").append("</ident>");
		sb.append("<mobile>").append(phone == null ? "" : phone).append("</mobile>");
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			System.out.println(json);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				List<OrderInfo> orderList = new ArrayList<OrderInfo>();
				Object items = json.get("items");
				if (items instanceof JSONArray) {
					JSONArray itemList = json.getJSONArray("items");

					if (itemList != null && itemList.size() > 0) {
						for (int i = 0; i < itemList.size(); i++) {
							JSONObject orderListI = itemList.getJSONObject(i);
							String inTime = format(orderListI
									.getString("arrival"));
							if (inTime.equals(getDate())) {//判断是当天订单
								//判断此订单是否属于团队
								if(!"".equals(phone) && (orderListI.getString("groupno")==null || "".equals(orderListI.getString("groupno")))){
									continue;
								}
								OrderInfo orderInfo = new OrderInfo();
								orderInfo.setOrderNum(orderListI
										.getString("resno"));// 订单号
								orderInfo.setOrderNumPMS(orderListI
										.getString("accnt"));// PMS帐号
								orderInfo.setInTime(inTime);// 到店时间
								orderInfo.setOutTime(format(orderListI
										.getString("departure")));// 离店时间
								orderInfo.setDays("共"+daysBetween(
										format(orderListI.getString("arrival")),
										format(orderListI.getString("departure")))+"晚");
								orderInfo.setRoomType(orderListI
										.getString("roomtypename"));// 房间类型
								orderInfo.setRoomCode(orderListI.getString("roomtype"));
								orderInfo.setRooms(orderListI.getString("roomnum"));//房间数量
								orderInfo.setAdults(orderListI.getString("adults"));//成人数量
								orderList.add(orderInfo);
							}
						}
					}
				}
				if (items instanceof JSONObject) {
					OrderInfo orderInfo = new OrderInfo();
					JSONObject item = json.getJSONObject("items");
					String inTime = format(item.getString("arrival"));
					if (inTime.equals(getDate())) {//判断是当天订单
						//判断此订单是否属于团队
						if(!"".equals(phone) && (item.getString("groupno")==null || "".equals(item.getString("groupno")))){
							return null;
						}
						orderInfo.setOrderNum(item.getString("resno"));// 订单号
						orderInfo.setOrderNumPMS(item.getString("accnt"));// PMS帐号
						orderInfo.setInTime(inTime);// 到店时间
						orderInfo
								.setOutTime(format(item.getString("departure")));// 离店时间
						orderInfo.setDays("共"+daysBetween(
								format(item.getString("arrival")),
								format(item.getString("departure")))+"晚");
						orderInfo.setRoomType(item.getString("roomtypename"));// 房间类型
						orderInfo.setRoomCode(item.getString("roomtype"));
						orderInfo.setRooms(item.getString("roomnum"));//房间数量
						orderInfo.setAdults(item.getString("adults"));//成人数量
						orderList.add(orderInfo);
					}
				}
				return orderList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询订单支付情况
	 */
	public PayInfo getPayInfo(String queryString) {
		PayInfo pay = new PayInfo();
		String method = "GetArrivingReservation";// 方法名
		StringBuffer sb = new StringBuffer();
		String resno = queryString;
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<resno>").append(resno == null ? "" : resno)
				.append("</resno>");
		sb.append("<name>").append("</name>");
		sb.append("<fullname>").append("</fullname>");
		sb.append("<ident>").append("</ident>");
		sb.append("<mobile>").append("</mobile>");
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		String accnt = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			System.out.println(json);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				Object items = json.get("items");

				if (items instanceof JSONObject||items instanceof JSONArray) {
					JSONObject item = null;
					if(items instanceof JSONArray){
					     JSONArray itemList = json.getJSONArray("items");
					     item = itemList.getJSONObject(0);
					}else{
					     item = json.getJSONObject("items");
					}
					String creditcard = item.getString("creditcard");
					String credit = item.getString("credit");
					String balance = item.getString("balance");
					accnt = item.getString("accnt");
					String ratedetail = item.getString("ratedetail");
					
					
					
					if(Double.parseDouble(credit)==0){//两种支付方式成功一种就成功,但是pms中预付款为0，证明是支付超时了
						PayResultBean payResultBean = null;
						String type = "";
						payResultBean = payService.getPayResult(resno+"_wx");
						type = "wx";
						if(payResultBean==null){
							payResultBean = payService.getPayResult(resno+"_zfb");
							type = "zfb";
						}
						if (payResultBean!=null) {
							
							if(depositInfoService.selectByPrimaryKey(resno)==null){
								payOrder(accnt,payResultBean.getTotalFee());//pms中写入支付信息
								
								//押金表插入记录
								DepositInfo depositInfo = new DepositInfo();
								depositInfo.setAccnt(resno);
								depositInfo.setAmount(payResultBean.getDeposit()+"");
								depositInfo.setIsselfmachine("1");
								depositInfo.setRefundstatus("1");
								depositInfo.setReserve1(type);
								depositInfoService.insert(depositInfo);
								
								return getPayInfo(resno);
							}
					}
					
				}
					
					
					
					
					
					
					
					String[] rates = ratedetail.split("\\|");
					double roomRate = 0;
					double deposit = 0;
//					double test1 = 0;//测试使用的房费
//					double test2 = 0;//测试使用的押金
					for (int i = 0; i < rates.length; i++) {
						roomRate += Double.parseDouble(rates[i].split("#")[3]);
//						test1 += 0.05;//TODO
						if("房费".equals(rates[i].split("#")[2])){
							deposit = Double.parseDouble(rates[i].split("#")[3]);
//							test2 = 0.05;//TODO
						}
					}
					
					
//					两个都未付     credit=0&&balance=0
//					房费已付，押金未付   credit=房费总和&&balance=房费总和
//					房费和押金都付   credit=房费押金总和&&balance=房费押金总和
					
					if(Double.parseDouble(credit)==0&&Double.parseDouble(balance)==0){//微信公众号订饭，房费未付，先调用房费码1000入账，然后收押金+房费
						
						//5分钱测试代码
//						addAccnt(accnt,test1);//增加房费账务
//						pay.setPay(false);
//						pay.setRoomRate(test1);
//						pay.setDeposit(test2);
//						pay.setOtherFree(0);
//						pay.setTotalFree(test1+test2);
						
						//真实房费
//						addAccnt(accnt,roomRate);//增加房费账务     修改为退房时增加房费账务
						pay.setPay(false);
						pay.setRoomRate(Double.parseDouble(df.format(roomRate)));
						pay.setDeposit(Double.parseDouble(df.format(deposit)));
						pay.setOtherFree(0);
						pay.setTotalFree(Double.parseDouble(df.format(roomRate+deposit)));
						
						
						
					}
					
					if(Double.parseDouble(credit)-roomRate==0&&Double.parseDouble(balance)-roomRate==0){//房费已付，只收押金
						//5分钱测试代码
//						pay.setPay(false);
//						pay.setRoomRate(0);
//						pay.setDeposit(test2);
//						pay.setOtherFree(0);
//						pay.setTotalFree(test2);
						
						//真实房费
						pay.setPay(false);
						pay.setRoomRate(0);
						pay.setDeposit(Double.parseDouble(df.format(deposit)));
						pay.setOtherFree(0);
						pay.setTotalFree(Double.parseDouble(df.format(deposit)));
						
					}
					if(Double.parseDouble(balance)<0){//房费未付，收房费+押金
						//5分钱测试代码
//						pay.setPay(false);
//						pay.setRoomRate(test1);
//						pay.setDeposit(test2);
//						pay.setOtherFree(0);
//						pay.setTotalFree(test1+test2);
						
						//真实房费
						pay.setPay(false);
						pay.setRoomRate(Double.parseDouble(df.format(roomRate)));
						pay.setDeposit(Double.parseDouble(df.format(deposit)));
						pay.setOtherFree(0);
						pay.setTotalFree(Double.parseDouble(df.format(roomRate+deposit)));
						
					}
					if(Double.parseDouble(credit)-(roomRate+deposit)==0&&Double.parseDouble(balance)-(roomRate+deposit)==0){//房费已付，押金已付
						pay.setPay(true);
						pay.setRoomRate(0);
						pay.setDeposit(0);
						pay.setOtherFree(0);
						pay.setTotalFree(0);
					}
					
					
			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pay;
	}

	/**
	 * 订单支付成功后调用西软付款接口
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public boolean payOrder(String queryString,double totalFree) {
		System.out.println("西软支付-付款接口");
		String accnt = queryString;
		String method = "AccntPosting";// 方法名
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		String monthYear = sdf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<accnt>").append(accnt == null ? "" : accnt)
				.append("</accnt>");
		sb.append("<feecode>").append("P").append("</feecode>");
		sb.append("</item>");
		sb.append("<accredits>");
		sb.append("<cardno>").append("</cardno>");
		sb.append("<expiry>").append("11/11").append("</expiry>");
		sb.append("<pccode>").append("9010").append("</pccode>");
		sb.append("<amount>").append(totalFree).append("</amount>");
		sb.append("<foliono>").append("</foliono>");
		sb.append("<creditno>").append("</creditno>");
		sb.append("</accredits>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 微信公众号订饭后未付房费，自助机办理入住时增加房费账务
	 * 
	 * @param param
	 * @return
	 */
	public boolean addAccnt(String queryString,double totalFree) {
		System.out.println("西软支付-付款接口");
		String accnt = queryString;
		String method = "AccntPosting";// 方法名
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		String monthYear = sdf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<accnt>").append(accnt == null ? "" : accnt)
				.append("</accnt>");
		sb.append("<feecode>").append("P").append("</feecode>");
		sb.append("</item>");
		sb.append("<accredits>");
		sb.append("<cardno>").append("</cardno>");
		sb.append("<expiry>").append("11/11").append("</expiry>");
		sb.append("<pccode>").append("1000").append("</pccode>");
		sb.append("<amount>").append(totalFree).append("</amount>");
		sb.append("<foliono>").append("</foliono>");
		sb.append("<creditno>").append("</creditno>");
		sb.append("</accredits>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	/**
	 * 增加同住人接口
	 * 
	 * @param param
	 * @return
	 */
	public boolean addPerson(IdCard idCard, String queryString) {
		logger.info("=================增加同住人接口=================");
		String accnt = queryString;
		String method = "AddGuest";// 方法名
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		String monthYear = sdf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<accnt>").append(accnt == null ? "" : accnt)
				.append("</accnt>");
		sb.append("<fname>")
				.append(idCard == null ? "" : idCard.getName().substring(1))
				.append("</fname>");
		sb.append("<lname>")
				.append(idCard == null ? "" : idCard.getName().substring(0, 1))
				.append("</lname>");
		sb.append("<idcode>").append("01").append("</idcode>");
		sb.append("<idno>").append(idCard == null ? "" : idCard.getCardNum())
				.append("</idno>");
		sb.append("<sex>").append(idCard == null ? "" : idCard.getSex())
				.append("</sex>");
		sb.append("<birth>").append(idCard == null ? "" : idCard.getBirthday())
				.append("</birth>");
		sb.append("<address>")
				.append(idCard == null ? "" : idCard.getAddress())
				.append("</address>");
		sb.append("<idend>").append(idCard == null ? "" : idCard.getEndTime())
				.append("</idend>");
		sb.append("<race>").append("HA").append("</race>");
		sb.append("<city>")
				.append(idCard == null ? "" : idCard.getCardNum().substring(0,
						6)).append("</city>");
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 更改主单证件信息
	 * 
	 * @param param
	 * @return
	 */
	public boolean updateOrderInfo(IdCard idCard, String queryString) {
		logger.info("=================增加同住人接口=================");
		String accnt = queryString;
		String method = "UpdateGusetIDcode";// 方法名
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		String monthYear = sdf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<accnt>").append(accnt == null ? "" : accnt)
				.append("</accnt>");
		sb.append("<fname>")
				.append(idCard == null ? "" : idCard.getName().substring(1))
				.append("</fname>");
		sb.append("<lname>")
				.append(idCard == null ? "" : idCard.getName().substring(0, 1))
				.append("</lname>");
		sb.append("<idcode>").append("01").append("</idcode>");
		sb.append("<idno>").append(idCard == null ? "" : idCard.getCardNum())
				.append("</idno>");
		sb.append("<sex>").append(idCard == null ? "" : idCard.getSex())
				.append("</sex>");
		sb.append("<birth>").append(idCard == null ? "" : idCard.getBirthday())
				.append("</birth>");
		sb.append("<address>")
				.append(idCard == null ? "" : idCard.getAddress())
				.append("</address>");
		sb.append("<idend>").append(idCard == null ? "" : idCard.getEndTime())
				.append("</idend>");
		sb.append("<race>").append("HA").append("</race>");
		sb.append("<city>")
				.append(idCard == null ? "" : idCard.getCardNum().substring(0,
						6)).append("</city>");
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	

	@Override
	/**
	 * 获取入住单
	 */
	public List<CheckInInfo> getCheckInInfo(String queryString) {
		// TODO Auto-generated method stub
		String method = "GetInHouseReservation";// 方法名
		StringBuffer sb = new StringBuffer();
		String resno = queryString;
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<name>").append("</name>");
		sb.append("<resno>").append(resno == null ? "" : resno).append("</resno>");
		sb.append("<accnt>").append("</accnt>");
		sb.append("<roomno>").append("</roomno>");
		sb.append("<idcls>").append("</idcls>");
		sb.append("<ident>").append("</ident>");
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			System.out.println(json);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				List<CheckInInfo> checkInList = new ArrayList<CheckInInfo>();
				Object items = json.get("items");
				if (items instanceof JSONObject || items instanceof JSONArray) {
					CheckInInfo checkInInfo = new CheckInInfo();
					JSONObject orderListI = null;
					if(items instanceof JSONObject ){
					    orderListI = json.getJSONObject("items");
					}
					if(items instanceof JSONArray ){
					    orderListI = json.getJSONArray("items").getJSONObject(0);
					}
					checkInInfo.setOrderNum(orderListI.getString("resno"));// 订单号
					checkInInfo.setRoomNum(orderListI.getString("roomno"));
					checkInInfo.setOrderNumPMS(orderListI.getString("accnt"));// PMS帐号
					checkInInfo.setInTime(format(orderListI
							.getString("arrival")));// 到店时间
					checkInInfo.setOutTime(format(orderListI
							.getString("departure")));// 离店时间
					checkInInfo.setRoomType(orderListI
							.getString("roomtypename"));// 房间类型

					String str = orderListI.getString("guestshare");
					String[] strs = str.split("\\|");
					ArrayList<String> persons = new ArrayList<String>();
					for (int i = 0; i < strs.length; i++) {
						persons.add(strs[i].split("#")[1]);
					}
					checkInInfo.setPersons(persons);
					checkInList.add(checkInInfo);
				}
				return checkInList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * 入住
	 */
	public String checkIn(String queryString, String room) {
		// TODO Auto-generated method stub
		String method = "GuestRemoteCheckIn";// 方法名
		StringBuffer sb = new StringBuffer();
		String accnt = queryString;
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<accnt>").append(accnt == null ? "" : accnt)
				.append("</accnt>");// 账号
		sb.append("<feecode>P").append("</feecode>");// 预授权或者付款标记 A 预授权， P 付款
		sb.append("<masterremark>").append("</masterremark>");// 主单备注
		sb.append("<billremark>").append("</billremark>");// 结账提醒备注
		sb.append("</item>");
		sb.append("<accredits>");
		sb.append("<cardno>**").append("</cardno>");
		sb.append("<expiry>11/11").append("</expiry>");
		sb.append("<pccode>").append("</pccode>");
		sb.append("<amount>0").append("</amount>");
		sb.append("<foliono>").append("</foliono>");
		sb.append("<creditno>").append("</creditno>");
		sb.append("</accredits>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			System.out.println(json);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				JSONObject item = json.getJSONObject("item");
				String roomno = item.getString("roomno");
				return roomno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 获取可用房
	 */
	@Override
	public List<String> getAvailableRoom(String startDate, String endDate,
			String houseCode) {
		logger.info("==================houseCode================="+houseCode);
		// TODO Auto-generated method stub
		String method = "GetAvailableRoomFeatures";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<ArrivalDate>").append(startDate == null ? "" : startDate)
				.append("</ArrivalDate>");// 到店日期
		sb.append("<DepartureDate>").append(endDate == null ? "" : endDate)
				.append("</DepartureDate>");// 离店日期
		sb.append("<RoomType>").append(houseCode == null ? "" : houseCode)
				.append("</RoomType>");// 房类码,可以为空
		sb.append("<RoomNumber>").append("</RoomNumber>");// 房号,可以为空
		sb.append("<RoomStates>R").append("</RoomStates>");// 房态, R:干净房 RD: 干净房和脏房
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				List<String> list = new ArrayList<String>();
				Object items = json.get("items");
				if (items instanceof JSONArray) {
					JSONArray itemList = json.getJSONArray("items");

					if (itemList != null && itemList.size() > 0) {
						for (int i = 0; i < itemList.size(); i++) {
							JSONObject roomList = itemList.getJSONObject(i);
							String roomno = roomList.getString("RoomNumber");
							list.add(roomno);
						}
					}
				}
				if (items instanceof JSONObject) {
					OrderInfo orderInfo = new OrderInfo();
					JSONObject item = json.getJSONObject("items");
					String roomno = item.getString("RoomNumber");
					list.add(roomno);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取可用房(针对团队入住)
	 */
	@Override
	public List<AvailableRoom> getAvailableRoomForGroup(String startDate, String endDate,String houseCode) {
		logger.info("==================houseCode================="+houseCode);
		// TODO Auto-generated method stub
		String method = "GetAvailableRoomFeatures";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<ArrivalDate>").append(startDate == null ? "" : startDate)
				.append("</ArrivalDate>");// 到店日期
		sb.append("<DepartureDate>").append(endDate == null ? "" : endDate)
				.append("</DepartureDate>");// 离店日期
		sb.append("<RoomType>").append(houseCode == null ? "" : houseCode)
				.append("</RoomType>");// 房类码,可以为空
		sb.append("<RoomNumber>").append("</RoomNumber>");// 房号,可以为空
		sb.append("<RoomStates>R").append("</RoomStates>");// 房态, R:干净房 RD: 干净房和脏房
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				List<AvailableRoom> list = new ArrayList<AvailableRoom>();
				Object items = json.get("items");
				if (items instanceof JSONArray) {
					JSONArray itemList = json.getJSONArray("items");

					if (itemList != null && itemList.size() > 0) {
						for (int i = 0; i < itemList.size(); i++) {
							AvailableRoom room = new AvailableRoom();
							JSONObject roomList = itemList.getJSONObject(i);
							room.setRoomType(roomList.getString("RoomType"));
							room.setRoomDescription(roomList.getString("RoomDescription"));
							room.setRoomNumber(roomList.getString("RoomNumber"));
							room.setFeatureCode(roomList.getString("FeatureCode"));
							room.setFeatureDescription(roomList.getString("FeatureDescription"));
							room.setRate(roomList.getString("Rate"));
							room.setRoomState(roomList.getString("RoomState"));
							room.setRoomStateDescription(roomList.getString("RoomStateDescription"));
							list.add(room);
						}
					}
				}
				if (items instanceof JSONObject) {
					JSONObject item = json.getJSONObject("items");
					AvailableRoom room = new AvailableRoom();
					room.setRoomType(item.getString("RoomType"));
					room.setRoomDescription(item.getString("RoomDescription"));
					room.setRoomNumber(item.getString("RoomNumber"));
					room.setFeatureCode(item.getString("FeatureCode"));
					room.setFeatureDescription(item.getString("FeatureDescription"));
					room.setRate(item.getString("Rate"));
					room.setRoomState(item.getString("RoomState"));
					room.setRoomStateDescription(item.getString("RoomStateDescription"));
					list.add(room);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 分配房间
	 */
	@Override
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yuliupmscode) {
		// TODO Auto-generated method stub
		String method = "AssignRoom";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<roomno>").append(roomNum == null ? "" : roomNum)
				.append("</roomno>");// 房间号
		sb.append("<accnt>").append(orderNum == null ? "" : orderNum)
				.append("</accnt>");// 账号
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			System.out.println(json);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				return "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@Override
	/**
	 * 退房
	 */
	public boolean checkOut(String queryString) {
		String accnt = queryString;//账号
		
		//前台退房平账，暂时注释
//		String method = "GuestCheckOut_Nobill";// 方法名：退房不结账
//		StringBuffer sb = new StringBuffer();
//		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
//		sb.append("<interface>");
//		sb.append("<item>");
//		sb.append("<accnt>").append(accnt == null ? "" : accnt)
//				.append("</accnt>");// 账号
//		sb.append("<feecode>P").append("</feecode>");// 预授权或者付款标记 A 预授权， P 付款
//		sb.append("<masterremark>").append("</masterremark>");// 主单备注
//		sb.append("<billremark>").append("</billremark>");// 结账提醒备注
//		sb.append("</item>");
//		sb.append("<postings>");
//		sb.append("<cardno>**").append("</cardno>");
//		sb.append("<expiry>11/11").append("</expiry>");
//		sb.append("<pccode>").append("</pccode>");
//		sb.append("<amount>0").append("</amount>");
//		sb.append("<foliono>").append("</foliono>");
//		sb.append("</postings>");
//		sb.append("</interface>");
//		String reqXml = sb.toString();
//		// 调用接口并返回转换后的json字符串
//		String jsonResultStr = "";
		
//		try {
//			jsonResultStr = pmsWestSoft(method, reqXml);
//			JSONObject json = JSONObject.parseObject(jsonResultStr);
//			System.out.println(json);
//			String resultCode = json.getString("result");
//			if (resultCode != null && "0".equals(resultCode)) {
//				CheckOutRoom checkOutRoom = getCheckOutRoom(accnt);
//				checkOutRoomDao.insert(checkOutRoom);
//				
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
		
		
		
		/**  退房时增加房费账务信息，目前前台统一录入，暂时注释
		String method = "GetReservation_Details";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
			sb.append("<item>");
				sb.append("<resno>").append("</resno>");
				sb.append("<accnt>").append(accnt==null?"":accnt).append("</accnt>");
				sb.append("<fullname>").append("</fullname>");
				sb.append("<ident>").append("</ident>");
				sb.append("<mobile>").append("</mobile>");
				sb.append("<roomno>").append("</roomno>");
			sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		//调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method,reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if(resultCode!=null && "0".equals(resultCode)){
				Object objectNew = json.get("items");
				if(objectNew instanceof JSONObject||objectNew instanceof JSONArray){
				
					JSONObject orderListI = null;
					if(objectNew instanceof JSONObject){
						orderListI = (JSONObject)objectNew;
					}
					if(objectNew instanceof JSONArray){
						orderListI = ((JSONArray)objectNew).getJSONObject(0);
					}
					
					String inTime = orderListI.getString("arrival");
					String outTime =orderListI.getString("departure");
					String days = daysBetween(format(inTime),format(outTime));
					
					String ratedetail = orderListI.getString("ratedetail");
					String[] rates = ratedetail.split("\\|");
					double roomRate = 0;
					for (int i = 0; i < rates.length; i++) {
						if("房费".equals(rates[i].split("#")[2])){
							roomRate = Double.parseDouble(rates[i].split("#")[3]);
						}
					}
					
					//住宿几天增加几天房费账务,前台统一录入房费账务，暂时注释
					for(int i=0;i<Integer.parseInt(days);i++){
						addAccnt(accnt, roomRate);
					}
					
					 Calendar now = Calendar.getInstance();  
				     int now_hour = now.get(Calendar.HOUR_OF_DAY);  
				     int now_sec = now.get(Calendar.MINUTE);  
					
				     
					if(formatInt(outTime)-getDateInt()==0){//pms中离店日期退房，判断退房时间是否超时，超时加收房费
						//离店时间超过14点未到18点加收半天房费
						if((now_hour>14&&now_hour<18)||(now_hour==14&&now_sec>0)||(now_hour==18&&now_sec==0)){
							addAccnt(accnt, Double.parseDouble(df.format(roomRate/2)));
						}
					
						//离店时间超过18点加收一天房费
						if((now_hour==18&&now_sec>0)||now_hour>18){
							addAccnt(accnt, Double.parseDouble(df.format(roomRate)));
						}
					}
					
					if(formatInt(outTime)-getDateInt()>0){//提前退房，不额外增加房费
						
					}
					
					if(getDateInt()-formatInt(outTime)>0){//超天数退房加收房费
						String dayNum = daysBetween(format(outTime),getDate());
						//住宿超几天增加几天房费账务
						for(int i=0;i<Integer.parseInt(dayNum);i++){
							addAccnt(accnt, roomRate);
						}
						
						//离店时间超过14点未到18点额外加收半天房费
						if((now_hour>14&&now_hour<18)||(now_hour==14&&now_sec>0)||(now_hour==18&&now_sec==0)){
							addAccnt(accnt, Double.parseDouble(df.format(roomRate/2)));
						}
					
						//离店时间超过18点额外加收一天房费
						if((now_hour==18&&now_sec>0)||now_hour>18){
							addAccnt(accnt, Double.parseDouble(df.format(roomRate)));
						}
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		*/
		
		
		
		CheckOutRoom c = checkOutRoomDao.selectByAccnt(accnt);
		if(c==null){
			CheckOutRoom checkOutRoom = getCheckOutRoom(accnt);
			checkOutRoomDao.insert(checkOutRoom);
		}
		return true;
	}
	
	
	/**
	 * 查询订单信息
	 * 
	 * @param param
	 * @return
	 */
	public CheckOutRoom getCheckOutRoom(String accnt) {
		String method = "GetReservation_Details";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
		sb.append("<item>");
		sb.append("<resno>").append("</resno>");
		sb.append("<accnt>").append(accnt == null ? "" : accnt)
		.append("</accnt>");
		sb.append("<fullname>").append("</fullname>");
		sb.append("<ident>").append("</ident>");
		sb.append("<mobile>").append("</mobile>");
		sb.append("<roomno>").append("</roomno>");
		sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		// 调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method, reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			System.out.println(json);
			String resultCode = json.getString("result");
			if (resultCode != null && "0".equals(resultCode)) {
				CheckOutRoom checkOutRoom = new CheckOutRoom();
				Object items = json.get("items");
				if (items instanceof JSONObject||items instanceof JSONArray) {
					JSONObject item = null;
					
					if(items instanceof JSONObject ){
						item = json.getJSONObject("items");
					}
					if(items instanceof JSONArray ){
						item = json.getJSONArray("items").getJSONObject(0);
					}
					
					String inTime = format(item.getString("arrival"));
					if (inTime.equals(getDate())) {
						checkOutRoom.setResno(item.getString("resno"));// 订单号
						checkOutRoom.setAccnt(item.getString("accnt"));// PMS帐号
						checkOutRoom.setArrival(item.getString("arrival"));// 到店时间
						checkOutRoom.setDeparture(item.getString("departure"));// 离店时间
						checkOutRoom.setRoomno(item.getString("roomno"));// 房间类型
						checkOutRoom.setRoomtype(item.getString("roomtype"));
						checkOutRoom.setRoomtypename(item.getString("roomtypename"));
						checkOutRoom.setFname(item.getString("fname"));
						checkOutRoom.setLname(item.getString("lname"));
						checkOutRoom.setGuestshare(item.getString("guestshare"));
						checkOutRoom.setIdcode(item.getString("idcode"));
						checkOutRoom.setIdno(item.getString("idno"));
						checkOutRoom.setMobile(item.getString("mobile"));
						checkOutRoom.setCardno(item.getString("cardno"));
						checkOutRoom.setCardtype(item.getString("cardtype"));
						checkOutRoom.setOuttime(getDateTime());
						checkOutRoom.setStatus(1);
						
						DepositInfo depositInfo = depositInfoDao.selectByPrimaryKey(item.getString("resno"));
						if(depositInfo==null){
							checkOutRoom.setRefundstatus("0");
						}else{
							checkOutRoom.setRefundstatus("1");
						}
					}
				}
				return checkOutRoom;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 查询订单状态  入住|退房
	 * @param param
	 * @return
	 */
	public String getRoomStatus(String resno){
		String method = "GetReservation_Details";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<interface>");
			sb.append("<item>");
				sb.append("<resno>").append(resno==null?"":resno).append("</resno>");
				sb.append("<accnt>").append("</accnt>");
				sb.append("<fullname>").append("</fullname>");
				sb.append("<ident>").append("</ident>");
				sb.append("<mobile>").append("</mobile>");
				sb.append("<roomno>").append("</roomno>");
			sb.append("</item>");
		sb.append("</interface>");
		String reqXml = sb.toString();
		//调用接口并返回转换后的json字符串
		String jsonResultStr = "";
		try {
			jsonResultStr = pmsWestSoft(method,reqXml);
			JSONObject json = JSONObject.parseObject(jsonResultStr);
			String resultCode = json.getString("result");
			if(resultCode!=null && "0".equals(resultCode)){
				Object objectNew = json.get("items");
				if(objectNew instanceof JSONObject){
				
					JSONObject orderListI = (JSONObject)objectNew;
					if("O".equals(orderListI.getString("sta"))){
						return "out";//已退房
					}
					if("I".equals(orderListI.getString("sta"))){
						return "in";//已退房
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	

	public static String daysBetween(String smdate, String bdate)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return String.valueOf(between_days);
	}

	public static String format(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String result = sdf.format(sdf.parse(str));
		return result;
	}

	public static Integer formatInt(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String result = sdf2.format(sdf.parse(str));
		return Integer.parseInt(result);
	}
	
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String result = sdf.format(new Date());
		return result;
	}
	public static Integer getDateInt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String result = sdf.format(new Date());
		return Integer.parseInt(result);
	}
	
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String result = sdf.format(new Date());
		return result;
	}

	@Override
	public List<Map> getOrderpayment(String scanChannel, String hotelOutId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getQRcode(String hotelOutId, String Orderpms, String lyResrvationNumber, String number,
			String totalFees, String scanChannel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addaccounting(String ruzhupms, String xfxmrzbm,
			String pmsnumber, String Banbie, String zhifuleixing, String Beizhu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map queryRoomFee(String orderNoPMS) {
		// TODO Auto-generated method stub
		return null;
	}
}
