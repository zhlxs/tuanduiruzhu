package com.cn.umessage.dao.pms.ly.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.http.ParseException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
import com.cn.umessage.pojo.RoomType;
import com.cn.umessage.service.IDepositInfoService;
import com.cn.umessage.utils.HttpRequestUtil;
import com.cn.umessage.utils.InitConfig;
import com.cn.umessage.utils.pinyinUtil;

@Service("lyPmsDao")
public class LYDao implements IPmsDao {
	
	@Resource
	//押金服务
	private IDepositInfoService depositInfoService;
	@Resource
	private CheckOutRoomMapper checkOutRoomDao;
	@Resource
	private DepositInfoMapper depositInfoDao;
	private static final Logger log = LoggerFactory.getLogger(LYDao.class);
	// private static final String url = InitConfig.LY_URL;
	// private static final String appkey = InitConfig.LY_APPKEY;
	// private static final String sign = InitConfig.LY_SIGN;
	// private static final String sessionId = InitConfig.LY_SESSIONID;
	//

	//private static final String url = "http://122.224.119.138:7312/ipms/hep/WebConnector";
	private static final String url = "http://172.16.18.51:8089/westsoft/";
	private static final String appkey = "10003";
	private static final String sign = "E0D653539620D820516FDA5E7FA4C333A06A1366";
	private static final String sessionId = "52E3A94279D84121AC55B04395AEF403";

	private static String pmsCode = "GCBZ";
	private static String pmsKey = InitConfig.PMS_KEY;
	@Override
	public List<RoomType> getRoomTypes(String queryString) {
		// TODO Auto-generated method stub
		List<RoomType> result = new ArrayList<RoomType>();

		Map<String, String> map = new HashMap<String, String>();
		map.put("v", "3.0");
		map.put("n", "n");
		map.put("f", "705");
		map.put("q", ",,GCBZ");
		map.put("s", "s");
		map.put("c", "c");
		map.put("appKey", "10003");
		map.put("sign", "2483381F88810224A63C78A8FE513C997AC3F4C6");
		map.put("sessionId", "9A5DE246D7EC4C1F9EF64781A2F83289");
		// try {
		// // String json =
		// HttpRequestUtil.send("http://183.129.215.114:7310/ipms/hep/WebConnector",map,"utf-8");
		// // System.out.println(json);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		return result;
	}

	public static String send(String url, Map<String, String> map,
			String encoding) {
		String body = null;
		try {
			// 创建httpclient对象
			CloseableHttpClient client = HttpClients.createDefault();
			// 创建post方式请求对象
			HttpPost httpPost = new HttpPost(url);
			// 装填参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			if (map != null) {
				for (Entry<String, String> entry : map.entrySet()) {
					nvps.add(new BasicNameValuePair(entry.getKey(), entry
							.getValue()));
				}
			}
			// 设置参数到请求对象中
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

			// 设置header信息
			// 指定报文头【Content-type】、【User-Agent】
			httpPost.setHeader("Content-type",
					"application/x-www-form-urlencoded");

			// 执行请求操作，并拿到结果（同步阻塞）
			CloseableHttpResponse response = client.execute(httpPost);
			// 获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity, encoding);
			}
			EntityUtils.consume(entity);
			// 释放链接
			if (response != null) {
				response.close();
			}
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
			if (client != null) {
				client.close();
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return body;
	}

	// 获取房间类型接口
	/*public static Map<String, String> getHouseType() {
		Map<String, String> houseType = new HashMap<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("v", "3.0");
		map.put("n", "n");
		map.put("f", "705");
		map.put("q", ",," + pmsCode);
		map.put("s", "s");
		map.put("c", "c");
		map.put("appKey", appkey);
		map.put("sign", sign);
		map.put("sessionId", sessionId);
		String res = send(url, map, "utf-8");
		// System.out.println(res);
		if (res != null) {
			JSONObject obj = JSON.parseObject(res);
			JSONArray ary = obj.getJSONArray("M");
			Set<String> set = new HashSet<>();
			for (int i = 0; i < ary.size(); i++) {
				JSONObject tmp = ary.getJSONObject(i);
				String houseTypeCode = tmp.getString("c00");
				String houseTypeName = tmp.getString("c01");

				houseType.put("code", houseTypeCode);
				houseType.put("name", houseTypeName);
			}
		}
		return houseType;
	}*/

	// 获取房间价格信息
	public static List<Map<String, String>> getHousePrice(String startDate,
			String endDate, String houseCode) {
		List<Map<String, String>> datas = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("v", "3.0");
		map.put("n", "n");
		map.put("f", "206");

		String q = ",," + pmsCode + ",";
		if (startDate != null) {
			q += startDate + ",";
		} else {
			q += ",";
		}
		if (endDate != null) {
			q += endDate + ",";
		} else {
			q += ",";
		}
		if (houseCode != null) {
			q += houseCode + ",";
		} else {
			q += ",";
		}

		map.put("q", q);
		map.put("s", "s");
		map.put("c", "c");
		map.put("appKey", appkey);
		map.put("sign", sign);
		map.put("sessionId", sessionId);

		String res = send(url, map, "utf-8");
		if (res != null) {
			JSONObject obj = JSON.parseObject(res);
			JSONArray ary = obj.getJSONArray("M");
			Set<String> set = new HashSet<>();
			for (int i = 0; i < ary.size(); i++) {
				JSONObject tmp = ary.getJSONObject(i);
				Map<String, String> data = new HashMap<>();
				String date = tmp.getString("c00");
				if (set.contains(date)) {

				} else {
					set.add(date);
					data.put("date", date);
					data.put("houseTypeCode", tmp.getString("c01"));
					data.put("normalStayPrice", tmp.getString("c02"));
					data.put("normalWeePrice", tmp.getString("c03"));
					data.put("rateStayPrice", tmp.getString("c04"));
					data.put("rateWeePrice", tmp.getString("c05"));
					data.put("pmsPriceCode", tmp.getString("c06"));
					data.put("priceType", tmp.getString("c07"));
					data.put("bargainPrice", tmp.getString("c08"));
					datas.add(data);
				}

			}
		}
		return datas;
	}

	// 获取房间数量
	public static List<Map<String, String>> getHouseCount(String startDate,
			String endDate, String houseCode) {
		List<Map<String, String>> datas = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("v", "3.0");
		map.put("n", "n");
		map.put("f", "201");

		String q = ",," + pmsCode + ",";
		if (startDate != null) {
			q += startDate + ",";
		} else {
			q += ",";
		}
		if (endDate != null) {
			q += endDate + ",";
		} else {
			q += ",";
		}
		if (houseCode != null) {
			q += houseCode + ",";
		} else {
			q += ",";
		}

		map.put("q", q);
		map.put("s", "s");
		map.put("c", "c");
		map.put("appKey", appkey);
		map.put("sign", sign);
		map.put("sessionId", sessionId);

		String res = send(url, map, "utf-8");
		if (res != null) {
			JSONObject obj = JSON.parseObject(res);
			JSONArray ary = obj.getJSONArray("M");
			Set<String> set = new HashSet<>();
			for (int i = 0; i < ary.size(); i++) {
				JSONObject tmp = ary.getJSONObject(i);
				Map<String, String> data = new HashMap<>();
				String date = tmp.getString("c01");
				if (set.contains(date)) {

				} else {
					set.add(date);
					data.put("date", date);

					data.put("allCount", tmp.getString("c02"));
					data.put("userUsedCount", tmp.getString("c03"));
					data.put("userArriveCount", tmp.getString("c04"));
					data.put("userLeaveCount", tmp.getString("c05"));
					data.put("repairCount", tmp.getString("c06"));
					data.put("disabledCount", tmp.getString("c07"));
					datas.add(data);
				}

			}
		}
		return datas;
	}

	/**
	 * 查询可住房间
	 */
	public List<String> getAvailableRoom(String startDate, String endDate,String houseCode) {
		String jsonParam = "{ArrivalDate:"+"\""+startDate+"\""+","+"DepartureDate:"+"\""+endDate+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"RoomType:"+"\""+houseCode+"\""+"}";
		List<String> list = new ArrayList<String>();
		try {
			String res = pmsKingCloud("GetAvailableRoomFeatures", jsonParam);
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONArray itemList = (JSONArray) objectNew;
	        	if (itemList != null && itemList.size() > 0) {
	                for (int i = 0; i < itemList.size(); i++) {
	                	JSONObject tmp = itemList.getJSONObject(i);
	                		String roomNumber = tmp.getString("RoomNumber");//可用房间号
		    				list.add(roomNumber);
	                }
	            }
	        }
			
		} catch (Exception e) {
			log.error("调用pms查询可用房异常！");
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * <pre>getQRcode(获取二维码)   
	 * 创建人：MaQiang   
	 * 创建时间：2018年4月25日 下午5:11:12    
	 * 修改人：MaQiang  
	 * 修改时间：2018年4月25日 下午5:11:12    
	 * 修改备注： 
	 * @param hotelOutId hotelOutId(非必填，支付流水号);
	 * @param Orderpms 预定单 PMS 编码 
	 * @param lyResrvationNumber 绿云中央预定号(非必填);
	 * @param number (非必填，账次);
	 * @param totalFees (必填，总金额);
	 * @param scanChannel(必填，扫码渠道，支付宝 ALIPAY，微信 WEIXIN); 
	 * @return</pre>
	 */
	public Map<String,String> getQRcode(String hotelOutId, String Orderpms,String lyResrvationNumber,String number,String totalFees,String scanChannel) {
		String jsonParam = "{hotelOutId:"+"\""+hotelOutId+"\""+","+"Orderpms:"+"\""+Orderpms+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"lyResrvationNumber:"+"\""+lyResrvationNumber+"\""+","+"number:"+"\""+number+"\""+","+"totalFees:"+"\""+totalFees+"\""+","+"scanChannel:"+"\""+scanChannel+"\""+"}";
		Map<String,String> map=new HashMap<>();
		try {
			String res = pmsKingCloud("getQRcode", jsonParam);
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONObject itemObj = (JSONObject) objectNew;
	                		String retun = itemObj.getString("retun");//返回信息
	                		String QRcode = itemObj.getString("QRcodeUrl");//二维码
	                		String tradeCode = itemObj.getString("zhifuliushui");//支付流水号
	                		map.put("retun", retun);
	                		map.put("QRcode", QRcode);
	                		map.put("tradeCode",tradeCode);
	        }
			
		} catch (Exception e) {
			log.error("获取二维码异常");
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * <pre>addaccounting(添加账务)   
	 * 创建人：MaQiang   
	 * 创建时间：2018年4月25日 下午5:29:45    
	 * 修改人：MaQiang  
	 * 修改时间：2018年4月25日 下午5:29:45    
	 * 修改备注： 
	 * @param ruzhupms 入住单PMS 编码
	 * @param xfxmrzbm 消费项目:入账 PMS 编码#总金额#数量#账目类别(见 E04)#操作时间;
	 * @param pmsnumber PMS 工号;
	 * @param Banbie 班别 PMS 编码; (1-早班,2-中班,3-晚班,4-夜审)
	 * @param zhifuleixing 支付类型(见 E01)#支付方式(见 E02)#支付金额#自助设备支付记 录编码#交易流水号#工号 PMS 编码#操作时间#交易类型(见 E74)#卡号#有效期#
	 * @param Beizhu 账务备注;
	 * @return</pre>
	 */
	public String addaccounting(String ruzhupms, String xfxmrzbm,String pmsnumber,String Banbie,String zhifuleixing,String Beizhu) {
		String jsonParam = "{ruzhupms:"+"\""+ruzhupms+"\""+","+"xfxmrzbm:"+"\""+xfxmrzbm+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"pmsnumber:"+"\""+pmsnumber+"\""+","+"Banbie:"+"\""+Banbie+"\""+","+"zhifuleixing:"+"\""+zhifuleixing+"\""+","+"Beizhu:"+"\""+Beizhu+"\""+"}";
		String str="";
		try {
			String res = pmsKingCloud("addaccounting", jsonParam);
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONObject itemObj = (JSONObject) objectNew;
	                		 str = itemObj.getString("zhifujilu");//自助设备的支付记录编码#支付记录 PMS 编码”
	        }
			
		} catch (Exception e) {
			log.error("添加账务异常");
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * <pre>getOrderpayment(获取订单支付信息)   
	 * 创建人：MaQiang   
	 * 创建时间：2018年4月25日 下午8:20:00    
	 * 修改人：MaQiang  
	 * 修改时间：2018年4月25日 下午8:20:00    
	 * 修改备注： 
	 * @param scanChannel 必填，扫码渠道，支付宝 ALIPAY，微信 WEIXIN，云闪付 UNIONPAY
	 * @param hotelOutId 必填交易流水号
	 * @return</pre>
	 */
	public List<Map> getOrderpayment(String scanChannel, String hotelOutId) {
		String jsonParam = "{scanChannel:"+"\""+scanChannel+"\""+","+"hotelOutId:"+"\""+hotelOutId+"\""+","+"hotelId:"+"\""+pmsKey+"\"}";
		List<Map> list=new ArrayList<>();
		try {
			String res = pmsKingCloud("getOrderpayment", jsonParam);
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONArray itemList = (JSONArray) objectNew;
	        	if (itemList != null && itemList.size() > 0) {
	                for (int i = 0; i < itemList.size(); i++) {
	                	Map<String,Object> resMap= new HashMap<>();
	                	JSONObject tmp = itemList.getJSONObject(i);
	                	String retuncode = tmp.getString("retuncode");//返回码
	                	String retun = tmp.getString("retun");//返回信息
	                	String status = tmp.getString("status");//支付状态
	                	String errorInfo = tmp.getString("errorInfo");//支付信息
	                	String tradeNo = tmp.getString("tradeNo");//支付订单号
	                	String hotelOutIds = tmp.getString("hotelOutId");//交易流水号
	                	String orderpms = tmp.getString("orderpms");//预订单pms编码
	                	String totelFee = tmp.getString("totelFee");//交易总金额
	                	String scanChannels = tmp.getString("scanChannel");//交易渠道
	                	resMap.put("hotelOutId", hotelOutIds);
	                	resMap.put("scanChannel", scanChannels);
	                	resMap.put("retuncode", retuncode);
	                	resMap.put("retun", retun);
	                	resMap.put("status", status);
	                	resMap.put("errorInfo", errorInfo);
	                	resMap.put("tradeNo", tradeNo);
	                	resMap.put("orderpms", orderpms);
	                	resMap.put("totelFee", totelFee);
	                	list.add(resMap);
	                }
	            }
	        }
			
		} catch (Exception e) {
			log.error("查询pms支付信息异常");
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 预约单分房
	 */
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yuliupmscode) {
		String result = "";
		String jsonParam = "{hotelId:"+"\""+pmsKey+"\""+","+"OrderPms:"+"\""+orderNum+"\""+","+"yuliupmscode:"+"\""+yuliupmscode+"\""+","+"roomNum:"+"\""+roomNum+"\""+"}";
		try {
			String res = pmsKingCloud("AssignRoom", jsonParam);
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONObject tmp = (JSONObject) objectNew;
	        	if (tmp != null) {
	        		result = tmp.getString("dengjidnaId");
	        	}else{
	        		result = "error";
	        	}
	        }else{
	        	result = "error";
	        }
		} catch (Exception e) {
			log.error("调用pms查询可用房异常！");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 入住
	 */
	public String checkIn(String queryString, String roomno) {

		String[] paramStr = queryString.split(",");
		String orderNumPMS = paramStr[0];
		String roomcode = paramStr[1];
		//String roomNo = paramStr[2];
		String priceCode = paramStr[3];
		String rzrqcjfjysfj = paramStr[4];
		String identity = paramStr[5];
		String inTime="";
		String outTime = "";
		try {
			inTime = getTime(paramStr[6]);
			outTime = getTime(paramStr[7]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String q = ",,pmscode,orderNum,roomType,roomNum,roomPrice,allPrice,inTime#1#,总金额劵,入住日期#餐券种类编码#餐券数量#餐券单价,会员卡号#会员级别PMS编码,入住人姓名#证件类型(见E11)#证件号#民族(文本),手机号,支付类型,,发卡数,设备人工,班别PMS编码,联房入住单PMS编码,入住时间,离店时间,入住类型,散团, 下单方,下单时间,房号PMS编码,锁房标记值,日期#包价,备注";
		//	 q =  ,,0511,,TWRB,8202,BAR1,,2018-04-09#0.03#0.03,,,,冯晶晶#01#120109198103163592##女性#天津市滨海新区海滨街#1981-03-16##,
		//,,,,HEP,3,,2018-04-09 14:39:43,2018-04-10 12:00:00,,1,,,8202,8202,,
		
		String result = "";
		String jsonParam = "{hotelId:"+"\""+pmsKey+"\""+","
				+"hotelCodePMS:"+"\""+InitConfig.LY_PMSCODE+"\""+","
				+"orderpms:"+"\""+orderNumPMS+"\""+","
				+"roomtypecode:"+"\""+roomcode+"\""+","+"roomNum:"+"\""+roomno+"\""+","
				+"roomPrice:"+"\""+priceCode+"\""+","
				+"roomtotalPrice:"+"\""+"\""+","+"rzrqcjfjysfj:"+"\""+rzrqcjfjysfj+"\""+","
				+"sumupmealCoupon:"+"\""+"\""+","+"rzrqcjzlcjslcjdj:"+"\""+"\""+","
				+"huiyuan:"+"\""+"\""+","+"Shenfenxinxi:"+"\""+identity+"\""+","
				+"mobile:"+"\""+"\""+","+"Zhifuleixing:"+"\""+"\""+","
				+"yuliu:"+"\""+"\""+","+"fakashu:"+"\""+"\""+","
				+"Shebeirengong:"+"\""+"HEP"+"\""+","+"Banbie:"+"\""+"3"+"\""+","
				+"Lianfang:"+"\""+"\""+","+"Ruzhudate:"+"\""+inTime+"\""+","
				+"Lidiandate:"+"\""+outTime+"\""+","+"Ruzhutype:"+"\""+"\""+","
				+"Santuan:"+"\""+"1"+"\""+","+"xiadanfangshi:"+"\""+"\""+","
				+"Xiadandate:"+"\""+"\""+","+"Roomnum:"+"\""+roomno+"\""+","
				+"Suofang:"+"\""+roomno+"\""+","+"Rqbj:"+"\""+"\""+","
				+"beizhu:"+"\""+"\""+"}";
		try {
			String res = pmsKingCloud("GuestRemoteCheckIn", jsonParam);
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONObject tmp = (JSONObject) objectNew;
	        	if (tmp != null) {
		        	String ruzhuPMS = tmp.getString("ruzhuPMS");
					String zhifujilu = tmp.getString("zhifujilu");
					String shenfenxinxi = tmp.getString("shenfenxinxi");
					result = roomno+","+ruzhuPMS;
	        	}else{
	        		result = "error";
	        	}
	        }else{
	        	result = "error";
	        }
		} catch (Exception e) {
			log.error("调用pms入住接口异常！");
			e.printStackTrace();
		}
		return result;
	}

	// 结账退房
	/**
	 * <pre>checkOut(结账退房)   
	 * 创建人：MaQiang   
	 * 创建时间：2018年4月25日 下午3:24:39    
	 * 修改人：MaQiang  
	 * 修改时间：2018年4月25日 下午3:24:39    
	 * 修改备注： 
	 * @param Orderpms 入住单 PMS 编码;(多个用|隔开) (同 307.C00,同 502.Q04)
	 * @param checkOut 是否退房(1-是,2-否,3-挂账 o-s, 4-转 AR,5-挂账 i-s);
	 * @param Zhifuxinxi 支付信息 (如果是联房结账,本字段 就是支付所有房间的费 用, 如果是单房结账,本字段只支付单房间费用);(支付金额为负数时,表示退款)
	 * @param banbie 班别 PMS 编码;(1-早班,2-中班,3-晚班,4-夜审)
	 * @param shebierengong 设备人工编号;
	 * @param AR AR 账号
	 * @return</pre>
	 */
	public boolean checkOut(String Orderpms) {
		//, "5", "", "", "", ""
		/*String jsonParam = "{Orderpms:"+"\""+Orderpms+"\""+","+"hotelId:"+"\""+pmsKey+"\""+"checkOut:"+"\""+"1"+"\""+","+"Zhifuxinxi:"+"\""+""+"\""+"banbie:"+"\""+""+"\""+","+"shebierengong:"+"\""+""+"\""+","+"AR:"+"\""+""+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("GuestRemoteCheckOut",jsonParam);
		} catch (Exception e) {
			log.error("退房时调用pms接口异常！");
			e.printStackTrace();
		}
		System.out.println(res);
		boolean result = false;
		try {
			JSONObject json = JSONObject.parseObject(res);
	        String resultCode = json.getString("status");
	        if (resultCode != null && "1".equals(resultCode)) {
	        	Object objectNew = json.get("data");
	        	JSONObject tmp = (JSONObject) objectNew;
	        	if (tmp != null) {
					String resultFlag = tmp.getString("result");
					if("1".equals(resultFlag)){
						result = true;
					}
	        	}
	        }
		} catch (Exception e) {
			log.error("解析pms退房接口返回值异常！");
			e.printStackTrace();
		}
		return result;*/
		CheckOutRoom c = checkOutRoomDao.selectByAccnt(Orderpms);
		if(c==null){
			CheckOutRoom checkOutRoom = getCheckOutRoom(Orderpms);
			checkOutRoomDao.insert(checkOutRoom);
		}
		return true;
	}
	/**
	 * 获取入住单
	 */
	public CheckOutRoom getCheckOutRoom(String queryString) {
		String jsonParam = "{queryType:"+"\""+"3"+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"shenfencode:"+"\""+queryString+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("GetInHouseReservation",jsonParam);
		} catch (Exception e) {
			log.error("获取入住单时调用pms接口异常！");
			e.printStackTrace();
		}
		List<CheckOutRoom> list = new ArrayList<CheckOutRoom>();
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONArray itemList = (JSONArray) objectNew;
        	if (itemList != null && itemList.size() > 0) {
                for (int i = 0; i < itemList.size(); i++) {
                	JSONObject tmp = itemList.getJSONObject(i);
                	CheckOutRoom checkOutRoom = new CheckOutRoom();
	    				String orderNumPMS = tmp.getString("ruzhuPMS");//pms账号
	    				String orderNum = tmp.getString("yudingdanPMS");//订单号
	    				String roomNum = tmp.getString("roomNum");//房间号
	    				String roomType = getHouseType().get(tmp.getString("roomtype"))==null &&  getHouseType().size()<=0 ? tmp.getString("roomtype") :  getHouseType().get(tmp.getString("roomtype")); //tmp.getString("roomtypename");//房间类型名称
	    				String roomCode = tmp.getString("roomtype");//房间类型代码
	    				String inTime = tmp.getString("ruzhushijian");//入住时间
						String outTime = tmp.getString("lidianshijian");//离店时间
	    				String shenfenxinxi = tmp.getString("shenfenxinxi");//身份信息
	    				
						checkOutRoom.setResno(orderNum);// 订单号
						checkOutRoom.setAccnt(orderNumPMS);// PMS帐号
						checkOutRoom.setArrival(inTime);// 到店时间
						checkOutRoom.setDeparture(outTime);// 离店时间
						checkOutRoom.setRoomno(roomNum);//房间号
						checkOutRoom.setRoomtype(roomCode);
						checkOutRoom.setRoomtypename(roomType);
						checkOutRoom.setGuestshare(shenfenxinxi);
						checkOutRoom.setOuttime(getDateTime());
						checkOutRoom.setStatus(1);
    				list.add(checkOutRoom);
                }
                DepositInfo depositInfo = depositInfoDao.selectByPrimaryKey(list.get(0).getResno());
				if(depositInfo==null){
					list.get(0).setRefundstatus("0");
				}else{
					list.get(0).setRefundstatus("1");
				}
            }
        }
		return list.get(0);
	}
	public static void demo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("v", "3.0");
		map.put("n", "n");
		map.put("f", "202");
		map.put("q", ",,GCBZ,,");
		map.put("s", "s");
		map.put("c", "c");
		map.put("appKey", appkey);
		map.put("sign", sign);
		map.put("sessionId", sessionId);
		System.out.println(send(url, map, "utf-8"));
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(pinyinUtil.toHanyuPinyin("陈永文"));
		// System.out.println(getHouseType());
		// System.out.println(getHousePrice("2017-11-20", "2017-11-21", "DXK"));
		// System.out.println(getHouseCount("2017-11-20", "2017-11-21", "DXK"));
		LYDao l = new LYDao();
		l.addPerson(new IdCard(),"");
		//List<OrderInfo> o = l.getOrder("陈永文");
		//l.getCheckInInfo("0509");
		//l.getPayInfo("17159");
		 //l.getHouseType();
		// List<String> datas = l.getAvailableRoom("2017-12-21 15:10:27.0", "2017-12-21 18:00:00.0", "SPT");
		// if(datas.size()>0){
		// String result = l.allotRoom("11834","SPT", datas.get(0));
		// String queryString =
		// ",,GCBZ,11834,SPT,"+datas.get(0)+",,,,,,,,,,,,,,,,,,,,,,,,";
		// l.checkIn(queryString);
		// }
		// String q = ",,GCBZ,11835,1,,,,,";
		// l.checkOut(q);
		// System.out.println(o.get(0).getOrderNum());
		// List<CheckInInfo> o = l.getCheckInInfo(",,GCBZ,3,0826");
		// l.getHouseType();

	}
	/**
	 * 获取当日未入住订单
	 */
	@Override
	public List<OrderInfo> getOrder(String queryString) {
		String jsonParam = "{name:"+"\""+queryString+"\""+","+"hotelId:"+"\""+pmsKey+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("GetArrivingReservation",jsonParam);
		} catch (Exception e) {
			log.error("获取订单时调用pms接口异常！");
			e.printStackTrace();
		}
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		try {
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONArray itemList = (JSONArray) objectNew;
        	if (itemList != null && itemList.size() > 0) {
                for (int i = 0; i < itemList.size(); i++) {
                	JSONObject tmp = itemList.getJSONObject(i);
                	String inTime = tmp.getString("didashijian");//入住日期
                	if (inTime.contains(getDate())) {//判断是当天订单
                		OrderInfo orderInfo = new OrderInfo();
                		String outTime = tmp.getString("lidianrqi");//离店日期
	    				String orderNumPMS = tmp.getString("yudingdanPMS");//pms账号
	    				//String name = tmp.getString("yudingren");//预订人名称
	    				String orderNum = tmp.getString("dingdanhao");//订单号
	    				String orderFrom = "".equals(tmp.getString("qudaoshangmingcheng")) ? "渠道" : tmp.getString("qudaoshangmingcheng");
	    				String roomNum = tmp.getString("fangjianshuliang");//房间数量
	    				String roomType = getHouseType().get(tmp.getString("fangxingPMS"))==null &&  getHouseType().size()<=0 ? tmp.getString("fangxingPMS") :  getHouseType().get(tmp.getString("fangxingPMS")); //tmp.getString("roomtypename");//房间类型名称
	    				String roomCode = tmp.getString("fangxingPMS");//房间类型代码
	    				String days = ("共"+daysBetween(format(inTime),format(outTime))+"晚");
	    				String price = tmp.getString("fangjiama");//房价码
	    				String rzrqcjfjysfj = tmp.getString("rzrqcjfj");//入住日期#房价..
	    				String chunyuliuId = tmp.getString("chunyuliuId");//预留ID
	    				
						
	    				
	    				orderInfo.setYudingId(chunyuliuId);
	    				orderInfo.setOrderNum(orderNum);
	    				orderInfo.setOrderFrom(orderFrom);
	    				orderInfo.setRoomNum(roomNum);
	    				orderInfo.setRoomType(roomType);
	    				orderInfo.setRoomCode(roomCode);
	    				orderInfo.setInTime(inTime);
	    				orderInfo.setOutTime(outTime);
	    				orderInfo.setPrice(price);
	    				orderInfo.setDays(days);
	    				orderInfo.setOrderNumPMS(orderNumPMS);
	    				orderInfo.setRzrqcjfjysfj(rzrqcjfjysfj);
    				list.add(orderInfo);
                }
                }
            }
        }
		} catch (Exception e) {
			e.printStackTrace();
			log.error("解析pms返回值异常！");
		}
		return list;
	}
	/**
	 * 获取入住单
	 */
	@Override
	public List<CheckInInfo> getCheckInInfo(String queryString) {
		String jsonParam = "{queryType:"+"\""+"3"+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"shenfencode:"+"\""+queryString+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("GetInHouseReservation",jsonParam);
		} catch (Exception e) {
			log.error("获取入住单时调用pms接口异常！");
			e.printStackTrace();
		}
		List<CheckInInfo> list = new ArrayList<CheckInInfo>();
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONArray itemList = (JSONArray) objectNew;
        	if (itemList != null && itemList.size() > 0) {
                for (int i = 0; i < itemList.size(); i++) {
                	JSONObject tmp = itemList.getJSONObject(i);
                	CheckInInfo checkInInfo = new CheckInInfo();
	    				String orderNumPMS = tmp.getString("ruzhuPMS");//pms账号
	    				String orderNum = tmp.getString("yudingdanPMS");//订单号
	    				String roomNum = tmp.getString("roomNum");//房间号
	    				String roomType = getHouseType().get(tmp.getString("roomtype"))==null &&  getHouseType().size()<=0 ? tmp.getString("roomtype") :  getHouseType().get(tmp.getString("roomtype")); //tmp.getString("roomtypename");//房间类型名称
	    				String roomCode = tmp.getString("roomtype");//房间类型代码
	    				String inTime = tmp.getString("ruzhushijian");//入住时间
						String outTime = tmp.getString("lidianshijian");//离店时间
	    				String shenfenxinxi = tmp.getString("shenfenxinxi");//身份信息
						String[] strs = shenfenxinxi.split("\\|");
						ArrayList<String> persons = new ArrayList<String>();
						for (int j = 0; j < strs.length; j++) {
							persons.add(strs[j].split("#")[0]);
						}
						checkInInfo.setPersons(persons);
						checkInInfo.setOrderNum(orderNum);
						checkInInfo.setOrderNumPMS(orderNumPMS);
						checkInInfo.setRoomNum(roomNum);
						checkInInfo.setRoomType(roomType);
						checkInInfo.setRoomCode(roomCode);
						checkInInfo.setInTime(inTime);
						checkInInfo.setOutTime(outTime);
						checkInInfo.setOrderNumPMS(orderNumPMS);
    				list.add(checkInInfo);
                }
            }
        }
		return list;
	}
	/**
	 * 查询订单支付情况
	 */
	@Override
	public PayInfo getPayInfo(String queryString) {
		String resnoPMS = queryString;//订单号pms
		PayInfo payInfo = new PayInfo();
		String pmsKey = InitConfig.PMS_KEY;
		String jsonParam = "{resno:"+resnoPMS+","+"hotelId:"+pmsKey+"}";
		String res = "";
		try {
			res = pmsKingCloud("getPayInfo",jsonParam);
		}catch(Exception e){
			log.error("调用pms查询订单支付情况异常！");
			e.printStackTrace();
		}
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONObject itemObj = (JSONObject) objectNew;
        	if (itemObj != null) {
        		String copewith = itemObj.getString("copewith");//是否支付的值
        		Double totalFee = Double.parseDouble(itemObj.getString("amount"));//总金额
        		Double advance  = Double.parseDouble(itemObj.getString("advance"));//预付款
        		Double deposit = Double.parseDouble("0.01");//押金
        		//boolean isPay = "2".equals(copewith)?false:true;//支付状态2:未支付 1：已支付（费用>=totalfee）
        		payInfo.setOtherFree(0);
        		if(advance<totalFee){//未收房费和押金
        			payInfo.setPay(false);
        			payInfo.setDeposit(deposit);
        			payInfo.setRoomRate(totalFee-advance);
        			payInfo.setTotalFree(totalFee-advance+deposit);
        		}
        		if(advance==totalFee){//收过房费 未收押金
        			payInfo.setPay(false);
        			payInfo.setDeposit(deposit);
        			payInfo.setRoomRate(0);
        			payInfo.setTotalFree(deposit);
        		}
        		if(advance>totalFee){//收过房费和押金 代表已支付
        			payInfo.setPay(true);
        			payInfo.setDeposit(0);
        			payInfo.setRoomRate(0);
        			payInfo.setTotalFree(0);
        		}
        	}
        }else{
        	String errorMsg = json.getString("msg");
        	log.error("调用pms查询订单支付情况返回错误信息："+errorMsg);
        }
		return payInfo;
	}

	@Override
	public boolean payOrder(String queryString,double totalFree) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 添加同住人信息
	 */
	@Override
	public boolean addPerson(IdCard idCard, String queryString) {
		String accnt = queryString;
		String pmsKey = InitConfig.PMS_KEY;
		String jsonParam = "";
		try {
			jsonParam = "{shenfenxinxi:"+"\""+idCard.getName()+"#1#"+idCard.getCardNum()
			+"#"+idCard.getMinzu()+"#"+idCard.getSex()+"#"+idCard.getAddress()+"#"+(idCard.getBirthday().substring(0,4)+"-"+idCard.getBirthday().substring(4,6)+"-"+idCard.getBirthday().substring(6,8))+"#"
			+pinyinUtil.toHanyuPinyin(idCard.getName())+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"ruzhudanPMS:"+"\""+accnt+"\""+"}";
		} catch (Exception e1) {
			log.error("format转换异常！");
			e1.printStackTrace();
		}
		String res = "";
		try {
			res = pmsKingCloud("AddGuest",jsonParam);
		}catch(Exception e){
			log.error("调用pms添加同住人接口异常！");
			e.printStackTrace();
		}
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONObject itemObj = (JSONObject) objectNew;
        	if (itemObj != null) {
        		String result = itemObj.getString("result");//结果
        		if("0".equals(result)){
        			return true;
        		}
        	  }
        	}else{
        		String errorMsg = json.getString("msg");
        		log.error("调用pms添加同住人接口失败："+errorMsg);
        	}
		return false;
	}
	/**
	 * 查询订单状态  入住|退房
	 */
	@Override
	public String getRoomStatus(String accnt) {
		String jsonParam = "{queryType:"+"\""+"3"+"\""+","+"hotelId:"+"\""+pmsKey+"\""+","+"shenfencode:"+"\""+accnt+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("GetInHouseReservation",jsonParam);
		} catch (Exception e) {
			log.error("获取入住单时调用pms接口异常！");
			e.printStackTrace();
		}
		List<CheckInInfo> list = new ArrayList<CheckInInfo>();
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONArray itemList = (JSONArray) objectNew;
        	if (itemList != null && itemList.size() > 0) {
                for (int i = 0; i < itemList.size(); i++) {
                	JSONObject tmp = itemList.getJSONObject(i);
                	CheckInInfo checkInInfo = new CheckInInfo();
	    				String status = tmp.getString("lianfangxinxi");//pms账号
						checkInInfo.setPrice(status);//借用-----状态
    				list.add(checkInInfo);
                }
            }
        	if("O".equals(list.get(0).getPrice())){
        		return "out";//已退房
        	}
        	if("I".equals(list.get(0).getPrice())){
        		return "in";//已入住
        	}
        }
        return "fail";
	}
	/**
	 * 查询加收房费506
	 */
	@Override
	public Map queryRoomFee(String orderNoPMS) {
		String jsonParam = "{ruzhudanPMS:"+"\""+orderNoPMS+"\""+","+"hotelId:"+"\""+pmsKey+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("getChargerate",jsonParam);
		} catch (Exception e) {
			log.error("查询加收房费时调用pms接口异常！");
			e.printStackTrace();
		}
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        Map resMap = new HashMap();
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONObject item = (JSONObject) objectNew;
        	if (item != null) {
	    		String ruzhudanPMS = item.getString("ruzhudanPMS");//入住单pms编码
	    		String shifoujiashou = item.getString("shifoujiashou");//是否加收房费
	    		String jiashouqianshu = item.getString("jiashouqianshu");//应加收的房费
	    		String zhanghuyue= item.getString("zhanghuyue");//账户余额
	    		resMap.put("ruzhudanPMS",ruzhudanPMS);
	    		resMap.put("shifoujiashou",shifoujiashou);
	    		resMap.put("jiashouqianshu",jiashouqianshu);
	    		resMap.put("zhanghuyue",zhanghuyue);
            }
        }
        return resMap;
	}
	@Override
	public boolean updateOrderInfo(IdCard idCard, String queryString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AvailableRoom> getAvailableRoomForGroup(String startDate,
			String endDate, String houseCode) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 调用自封装的接口服务
	 */
	public static String pmsKingCloud(String method, String paramXml)
			throws ParseException, IOException {
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("xmlStr", paramXml);
		// 调用公共方法去访问pms
		String jsonResult = HttpRequestUtil.send(url + method, mapParam,"utf-8");
		return jsonResult;
	}
	public static String daysBetween(String smdate, String bdate)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return String.valueOf(between_days);
	}

	public static String format(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(sdf.parse(str));
		return result;
	}

	public static Integer formatInt(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String result = sdf2.format(sdf.parse(str));
		return Integer.parseInt(result);
	}
	
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(new Date());
		return result;
	}
	public static Integer getDateInt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String result = sdf.format(new Date());
		return Integer.parseInt(result);
	}
	
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String result = sdf.format(new Date());
		return result;
	}
	public static String getTime(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = sdf.format(sdf.parse(str));
		return result;
	}
	/**
	 * 获取房型名称
	 * @return
	 */
	public Map<String,String> getHouseType(){
		
		Map<String,String> resMap = new HashMap<String,String>();
		String pmsKey = InitConfig.PMS_KEY;
		String jsonParam = "{hotelId:"+"\""+pmsKey+"\""+"}";
		String res = "";
		try {
			res = pmsKingCloud("getHouseType",jsonParam);
		} catch (Exception e) {
			log.error("获取房型列表时调用pms接口异常！");
			e.printStackTrace();
		}
		try {
		JSONObject json = JSONObject.parseObject(res);
        String resultCode = json.getString("status");
        if (resultCode != null && "1".equals(resultCode)) {
        	Object objectNew = json.get("data");
        	JSONArray itemList = (JSONArray) objectNew;
        	if (itemList != null && itemList.size() > 0) {
                for (int i = 0; i < itemList.size(); i++) {
                	JSONObject tmp = itemList.getJSONObject(i);
                	String roomCode = tmp.getString("roomCode");//房型编码
                	String roomName = tmp.getString("roomName");//房型名称
                	resMap.put(roomCode, roomName);
                	
                }
            }
        }
		} catch (Exception e) {
			e.printStackTrace();
			log.error("解析pms返回值异常！");
		}
		return resMap;
	
		
	}

	
}
