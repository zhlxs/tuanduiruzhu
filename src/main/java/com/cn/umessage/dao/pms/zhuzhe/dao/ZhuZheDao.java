package com.cn.umessage.dao.pms.zhuzhe.dao;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.cn.umessage.dao.pms.IPmsDao;
import com.cn.umessage.dao.pms.zhuzhe.bean.VoHotelInfo;
import com.cn.umessage.dao.pms.zhuzhe.bean.VoRoomBook;
import com.cn.umessage.dao.pms.zhuzhe.bean.VoRoomPrice;
import com.cn.umessage.dao.pms.zhuzhe.bean.VoRoomType;
import com.cn.umessage.pojo.AvailableRoom;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.pojo.OrderInfo;
import com.cn.umessage.pojo.PayInfo;
import com.cn.umessage.pojo.RoomType;
import com.cn.umessage.utils.InitConfig;
import com.cn.umessage.utils.MD5Util;
import com.cn.umessage.utils.XmlTool;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("zhuzhePmsDao")
public class ZhuZheDao implements IPmsDao {
	// private static String url = InitConfig.ZHUZHE_URL;// 调用住哲的通用 URL
	// static String cId = InitConfig.ZHUZHE_CID;// 由住哲分配给客户的调用 ID
	// static String key = InitConfig.ZHUZHE_KEY;// 密钥，由住哲公司分配的密钥
	// static String dataKey = InitConfig.ZHUZHE_DATAKEY;// 数据加密密钥，由住哲公司分配的密钥
	// static String hotelId = InitConfig.ZHUZHE_HOTELID;

	private static String url = "http://open.zhuzher.com/api/request.action";// 调用住哲的通用
																				// URL
	static String cId = "C0096801";// 由住哲分配给客户的调用 ID
	static String key = "123456";// 密钥，由住哲公司分配的密钥
	static String dataKey = "12345678";// 数据加密密钥，由住哲公司分配的密钥
	static String hotelId = "201026";

	public static void main(String[] args) {
		// System.out.println(JSON.toJSONString(queryHRoomType()));
		// System.out.println(JSON.toJSONString(queryHotelRoomPrice("2017-12-02",
		// "2017-12-03")));

		// VoRoomBook vo = new VoRoomBook();
		// vo.setAdult(1);
		// vo.setArr("2017-12-02 14:30:00");
		// vo.setDep("2017-12-03 14:00:00");
		// vo.setEnsureFlag(0);
		// vo.setHotelId(hotelId);
		// vo.setMobile("15816881688");
		// vo.setRmNum(1);
		// vo.setRmtype("4405");
		// vo.setRsvMan("张三");
		// vo.setSex("1");
		// vo.setTotalPrice(200.00);
		// book(vo);
		queryOrder("729299");
		// queryAllOrder("贺先生","");
		ZhuZheDao z = new ZhuZheDao();
		// System.out.println(z.getAvailableRoom("2017-12-26 11:00:00",
		// "2017-12-27 12:00:00", "2982").size());
		//
		StringBuffer sb = new StringBuffer();
		sb.append("<request>")
				.append("<head></head>")
				.append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<orderId>729299</orderId>")
				.append("<roomTypeNo>2982</roomTypeNo>")
				.append("<roomNo>"
						+ z.getAvailableRoom("2018-1-29 11:00:00",
								"2018-1-30 12:00:00", "2982").get(0)
						+ "</roomNo>").append("<guestInfos>")
				.append("<guestInfo>").append("<name>张四</name>")
				.append("<sex>男</sex>").append("<tel></tel>")
				.append("<id_card_no>142732198902121214</id_card_no>")
				.append("<birth></birth>").append("<address></address>")
				.append("<nation></nation>").append("</guestInfo>")
				.append("</guestInfos>").append("</body>").append("</request>");
		String queryString = sb.toString();
		// z.checkIn(queryString);

		// StringBuffer sb = new StringBuffer();
		// sb.append("<request>").append("<head></head>").append("<body>").append("<hotelId>"
		// + hotelId + "</hotelId>")
		// .append("<roomNo>101</roomNo>").append("<isAlone>1</isAlone>")
		// .append("</body>").append("</request>");
		// String queryString = sb.toString();
		// z.checkOut(queryString);
		//
		// z.getOrder("贺跃杰");
		// StringBuffer sb = new StringBuffer();
		// sb.append("<request>").append("<head></head>").append("<body>").append("<hotelId>"
		// + hotelId + "</hotelId>")
		// .append("<roomNo>10001</roomNo>")
		// .append("</body>").append("</request>");
		// String queryString = sb.toString();
		// // z.checkOut(queryString);
		// System.out.println(z.getCheckInInfo(queryString).size());
	}

	// 查询酒店信息
	public static List<VoHotelInfo> getHotelInfo() {
		String method = "zhuzher.data.getHotelInfo";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>").append("</body>")
				.append("</request>");
		String reqXml = sb.toString();
		List<VoHotelInfo> list = new ArrayList<>();
		JSONObject json = post(method, reqXml);
		if (json != null) {
			JSONArray ary1 = json.getJSONArray("body");
			if (ary1 != null && ary1.size() > 0) {
				for (int i = 0; i < ary1.size(); i++) {
					JSONObject job = ary1.getJSONObject(i);
					if (job != null) {
						JSONArray ary = job.getJSONArray("hotel");
						if (ary != null && ary.size() > 0) {
							for (int j = 0; j < ary.size(); j++) {
								JSONObject tmp = ary.getJSONObject(j);
								if (tmp != null) {
									VoHotelInfo vo = new VoHotelInfo();
									vo.setAddress1(tmp.getString("address"));
									vo.setCountry("中国");
									vo.setPhoneRsv(tmp.getString("tel"));
									vo.setCity(tmp.getString("city"));
									vo.setDescript(tmp.getString("name"));
									vo.setFax(tmp.getString("fax"));
									list.add(vo);
								}
							}
						}
					}
				}
			}

		}
		return list;
	}

	// 查询酒店房型信息
	public static List<VoRoomType> queryHRoomType() {
		List<VoRoomType> list = new ArrayList<>();
		String method = "zhuzher.data.getAllRoomTypeInfo";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>").append("</body>")
				.append("</request>");
		String reqXml = sb.toString();

		JSONObject json = post(method, reqXml);
		if (json != null) {

			JSONArray ary1 = json.getJSONArray("body");
			if (ary1 != null && ary1.size() > 0) {
				for (int i = 0; i < ary1.size(); i++) {
					JSONObject job = ary1.getJSONObject(i);
					if (job != null) {
						JSONArray ary = job.getJSONArray("roomType");
						if (ary != null && ary.size() > 0) {
							for (int j = 0; j < ary.size(); j++) {
								JSONObject json2 = ary.getJSONObject(j);
								JSONArray ary2 = json2
										.getJSONArray("roomTypeItem");
								if (ary2 != null && ary2.size() > 0) {
									for (int k = 0; k < ary2.size(); k++) {
										JSONObject tmp = ary2.getJSONObject(k);
										if (tmp != null) {
											String img = tmp.getString("img");
											String webImg = tmp
													.getString("webImg");
											String price = tmp
													.getString("price");
											String roomTypeName = tmp
													.getString("roomTypeName");
											String description = tmp
													.getString("description");
											String roomTypeId = tmp
													.getString("roomTypeId");
											VoRoomType vo = new VoRoomType();
											vo.setHotelId(hotelId);
											vo.setRoomType(roomTypeId);
											vo.setRoomDescript(roomTypeName);
											vo.setHotelGroupId(price);
											list.add(vo);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return list;
	}

	// 询酒店房型价格信息
	public static List<VoRoomPrice> queryHotelRoomPrice(String stDate,
			String enDate) {
		List<VoRoomPrice> list = new ArrayList<>();
		String method = "zhuzher.room.getRoomNos";// 方法名

		List<VoRoomType> rts = queryHRoomType();
		for (VoRoomType rt : rts) {
			VoRoomPrice rp = new VoRoomPrice();
			rp.setHotelId(hotelId);
			rp.setRmtype(rt.getRoomType());
			rp.setRate1(rt.getHotelGroupId());
			rp.setAvgRate1(rt.getHotelGroupId());
			//
			StringBuffer sb = new StringBuffer();
			sb.append("<request>")
					.append("<head></head>")
					.append("<body>")
					.append("<hotelId>" + hotelId + "</hotelId>")
					.append("<roomTypeId>" + rt.getRoomType() + "</roomTypeId>")
					.append("<startDate>" + stDate + "</startDate>")
					.append("<endDate>" + enDate + "</endDate>")
					.append("</body>").append("</request>");
			String reqXml = sb.toString();

			JSONObject json = post(method, reqXml);
			if (json != null) {
				String roomNos = json.getString("roomNos");
				if (roomNos != null && roomNos.length() > 0) {
					Integer len = roomNos.split(",").length;
					rp.setAvail(len.toString());
				}
			}
			//
			list.add(rp);
		}
		return list;
	}

	// 预定
	public static String book(VoRoomBook vo) {
		String method = "zhuzher.order.submitOrder2";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<roomTypeId>" + vo.getRmtype() + "</roomTypeId>")
				.append("<roomTypeName></roomTypeName>")
				.append("<startTime>" + vo.getArr() + "</startTime>")
				.append("<endTime>" + vo.getDep() + "</endTime>").

				append("<roomNum>" + vo.getRmNum() + "</roomNum>")
				.append("<ratePlanId></ratePlanId>")
				.append("<bookPerson>" + vo.getRsvMan() + "</bookPerson>")
				.append("<bookTel>" + vo.getMobile() + "</bookTel>")
				.append("<bookEmail></bookEmail>").

				append("<checkInPerson>" + vo.getRsvMan() + "</checkInPerson>")
				.append("<checkInTel>" + vo.getMobile() + "</checkInTel>")
				.append("<cardNo></cardNo>").append("<comefrom>5</comefrom>")
				.append("<keepTime>23:00</keepTime>").

				append("<totalPrice>" + vo.getTotalPrice() + "</totalPrice>")
				.append("<ensureFlag>" + vo.getEnsureFlag() + "</ensureFlag>")
				.append("<guarantorType>无担保</guarantorType>")
				.append("<remark></remark>").

				//
				append("</body>").append("</request>");

		String reqXml = sb.toString();

		JSONObject json = post(method, reqXml);

		if (json != null) {
			return json.getString("orderId");
		}
		return null;
	}

	// 查询订单 727803
	public static JSONObject queryOrder(String orderId) {
		JSONObject vo = new JSONObject();
		String method = "zhuzher.order.getOrderInfo2";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<orderId>" + orderId + "</orderId>")
				.append("<showBills>1</showBills>")
				//
				.append("</body>").append("</request>");

		String reqXml = sb.toString();
		JSONObject json = post(method, reqXml);
		if (json != null) {
			JSONArray body = json.getJSONArray("body");
			if (body != null && body.size() > 0) {
				for (int i = 0; i < body.size(); i++) {
					JSONObject job = body.getJSONObject(i);
					if (job != null) {
						JSONArray groupOrder = job.getJSONArray("groupOrder");
						if (groupOrder != null && groupOrder.size() > 0) {
							for (int j = 0; j < groupOrder.size(); j++) {
								JSONObject groupOrderJob = groupOrder
										.getJSONObject(j);
								System.out.println(groupOrderJob);
								return groupOrderJob;
							}
						}
					}
				}
			}
		}

		return vo;
	}

	// 查询订单 727803
	public static JSONObject queryAllOrder(String checkInPerson,
			String checkInCardNo) {
		JSONObject vo = new JSONObject();
		String method = "zhuzher.order.queryAllOrderInfo2";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<isAllHotel>0</isAllHotel>")
				.append("<bookNum></bookNum>")
				.append("<bookPerson></bookPerson>")
				.append("<bookTel></bookTel>")
				.append("<checkInMemberNo></checkInMemberNo>")
				.append("<checkInPerson>" + checkInPerson + "</checkInPerson>")
				.append("<checkInTel></checkInTel>")
				.append("<checkInCardNo>" + checkInCardNo + "</checkInCardNo>")
				.append("<roomNo></roomNo>")
				.append("<roomTypeName></roomTypeName>")
				.append("<orderState>1</orderState>")
				.append("<comefrom></comefrom>")
				.append("<liveType></liveType>")
				.append("<startTime_beginDate></startTime_beginDate>")
				.append("<startTime_endDate></startTime_endDate>")
				.append("<endTime_beginDate></endTime_beginDate>")
				.append("<endTime_endDate></endTime_endDate>")
				.append("<showBills>1</showBills>").append("</body>")
				.append("</request>");

		String reqXml = sb.toString();
		JSONObject json = post(method, reqXml);
		System.out.println(json);
		if (json != null) {
			JSONArray body = json.getJSONArray("body");
			if (body != null && body.size() > 0) {
				for (int i = 0; i < body.size(); i++) {
					JSONObject job = body.getJSONObject(i);
					if (job != null) {
						JSONArray groupOrder = job.getJSONArray("groupOrder");
						if (groupOrder != null && groupOrder.size() > 0) {
							for (int j = 0; j < groupOrder.size(); j++) {
								JSONObject groupOrderJob = groupOrder
										.getJSONObject(j);
								System.out.println(groupOrderJob);
								return groupOrderJob;
							}
						}
					}
				}
			}
		}

		return vo;
	}

	private static JSONObject post(String method, String reqXml) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse resp = null;
		try {
			Long time = System.currentTimeMillis();// 时间戳，防串改数据
			String authCode = MD5Util.MD5Encode(cId + method + time + key,
					"UTF-8");// md5
			String inputObj = reqXml;
			inputObj = desCrypto(inputObj, dataKey);
			inputObj = java.net.URLEncoder.encode(inputObj, "UTF-8");
			String queryString = "cId=" + cId + "&authCode=" + authCode
					+ "&method=" + method + "&time=" + time + "&data="
					+ inputObj;
			HttpPost post = new HttpPost(url + "?" + queryString);
			resp = client.execute(post);
			HttpEntity entity = resp.getEntity();
			String res = EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
			post.releaseConnection();
			return XmlTool.documentToJSONObject(res);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resp != null) {
					resp.close();
				}
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
			}

		}
		return null;
	}

	public static String desCrypto(String datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把 DESKeySpec 转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher 对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化 Cipher 对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return new String(Base64.encodeBase64(cipher.doFinal(datasource
					.getBytes("UTF-8"))));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String src, String password) throws Exception {
		// DES 算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个 DESKeySpec 对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将 DESKeySpec 对象转换成 SecretKey 对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher 对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化 Cipher 对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return new String(cipher.doFinal(Base64.decodeBase64(src
				.getBytes("UTF-8"))));
	}

	@Override
	public List<RoomType> getRoomTypes(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> getOrder(String queryString) {
		// TODO Auto-generated method stub
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		String method = "zhuzher.order.queryAllOrderInfo2";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<isAllHotel>0</isAllHotel>")
				.append("<bookNum></bookNum>")
				.append("<bookPerson></bookPerson>")
				.append("<bookTel></bookTel>")
				.append("<checkInMemberNo></checkInMemberNo>")
				.append("<checkInPerson>" + queryString + "</checkInPerson>")
				.append("<checkInTel></checkInTel>")
				.append("<checkInCardNo></checkInCardNo>")
				.append("<roomNo></roomNo>")
				.append("<roomTypeName></roomTypeName>")
				.append("<orderState>1</orderState>")
				.append("<comefrom></comefrom>")
				.append("<liveType></liveType>")
				.append("<startTime_beginDate></startTime_beginDate>")
				.append("<startTime_endDate></startTime_endDate>")
				.append("<endTime_beginDate></endTime_beginDate>")
				.append("<endTime_endDate></endTime_endDate>")
				.append("<showBills>1</showBills>").append("</body>")
				.append("</request>");

		String reqXml = sb.toString();
		JSONObject json = post(method, reqXml);
		System.out.println(json);
		if (json != null) {
			JSONArray body = json.getJSONArray("body");
			if (body != null && body.size() > 0) {
				for (int i = 0; i < body.size(); i++) {
					JSONObject job = body.getJSONObject(i);
					if (job != null) {
						JSONArray groupOrderList = job
								.getJSONArray("groupOrderList");
						if (groupOrderList != null && groupOrderList.size() > 0) {
							for (int p = 0; p < groupOrderList.size(); p++) {
								JSONArray groupOrder = groupOrderList
										.getJSONObject(p).getJSONArray(
												"groupOrder");
								if (groupOrder != null && groupOrder.size() > 0) {
									for (int j = 0; j < groupOrder.size(); j++) {
										JSONArray orderList = groupOrder
												.getJSONObject(j).getJSONArray(
														"orderList");

										if (orderList != null
												&& orderList.size() > 0) {
											for (int q = 0; q < orderList
													.size(); q++) {
												JSONArray order = orderList
														.getJSONObject(q)
														.getJSONArray("order");

												if (order != null
														&& order.size() > 0) {
													for (int k = 0; k < order
															.size(); k++) {
														OrderInfo orderInfo = new OrderInfo();
														String orderNumPMS = groupOrder
																.getJSONObject(
																		j)
																.getString(
																		"outOrderId");
														String orderNum = groupOrder
																.getJSONObject(
																		j)
																.getString(
																		"orderId");
														String earnestFlag = groupOrder
																.getJSONObject(
																		j)
																.getString(
																		"earnestFlag");
														String orderFrom = order
																.getJSONObject(
																		k)
																.getString(
																		"comefromName");
														String roomNum = order
																.getJSONObject(
																		k)
																.getString(
																		"roomNo");
														String roomType = order
																.getJSONObject(
																		k)
																.getString(
																		"roomTypeName");
														String roomCode = order
																.getJSONObject(
																		k)
																.getString(
																		"roomTypeId");
														String inTime = order
																.getJSONObject(
																		k)
																.getString(
																		"startTime");
														String outTime = order
																.getJSONObject(
																		k)
																.getString(
																		"endTime");
														String price = order
																.getJSONObject(
																		k)
																.getString(
																		"price");
														orderInfo
																.setOrderNum(orderNum);
														orderInfo
																.setOrderFrom(orderFrom);
														orderInfo
																.setRoomNum(roomNum);
														orderInfo
																.setRoomType(roomType);
														orderInfo
																.setRoomCode(roomCode);
														orderInfo
																.setInTime(inTime);
														orderInfo
																.setOutTime(outTime);
														orderInfo
																.setPrice(price);
														orderInfo
																.setOrderNumPMS(orderNum);
														orderInfo
																.setEarnestFlag(earnestFlag);
														list.add(orderInfo);
													}
												}

											}

										}

									}
								}

							}
						}
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<CheckInInfo> getCheckInInfo(String queryString) {
		// TODO Auto-generated method stub
		List<CheckInInfo> list = new ArrayList<CheckInInfo>();
		String method = "zhuzher.bill.getRoomBillInfo";// 方法名
		JSONObject json = post(method, queryString);
		System.out.println(json);
		if (json != null) {
			JSONArray body = json.getJSONArray("body");
			if (body != null && body.size() > 0) {
				for (int i = 0; i < body.size(); i++) {
					JSONObject job = body.getJSONObject(i);
					if (job != null) {
						JSONArray bill = job.getJSONArray("bill");
						if (bill != null && bill.size() > 0) {
							for (int j = 0; j < bill.size(); j++) {
								JSONArray billItem = bill.getJSONObject(j)
										.getJSONArray("billItem");
								if (billItem != null && billItem.size() > 0) {
									for (int p = 0; p < billItem.size(); p++) {
										CheckInInfo checkinInfo = new CheckInInfo();
										String roomNum = billItem
												.getJSONObject(p).getString(
														"room");
										String price = billItem
												.getJSONObject(p).getString(
														"price");
										checkinInfo.setRoomNum(roomNum);
										checkinInfo.setPrice(price);
										list.add(checkinInfo);
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("============list==============" + list.size());
		return list;
	}

	/**
	 * 入住
	 */
	@Override
	public String checkIn(String queryString, String roomno) {
		// TODO Auto-generated method stub

		String method = "zhuzher.order.checkinRoomByOrder2";// 方法名

		JSONObject json = post(method, queryString);
		System.out.println(json);

		return roomno;
	}

	/**
	 * 获得预定房型可排房列表
	 */
	@Override
	public List<String> getAvailableRoom(String startDate, String endDate,
			String houseCode) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		String method = "zhuzher.room.getRoomNos";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<roomTypeId>" + houseCode + "</roomTypeId>")
				.append("<startDate>" + startDate + "</startDate>")
				.append("<endDate>" + endDate + "</endDate>")
				.append("<flag>1</flag>").append("<roomStatus></roomStatus>")
				.append("</body>").append("</request>");

		String reqXml = sb.toString();
		JSONObject json = post(method, reqXml);
		System.out.println(json);
		if (json != null) {
			JSONArray body = json.getJSONArray("body");
			if (body != null && body.size() > 0) {
				for (int i = 0; i < body.size(); i++) {
					JSONObject job = body.getJSONObject(i);
					if (job != null) {
						String roomNos = job.getString("roomNos");
						if (roomNos != null && !"".equals(roomNos)) {
							String[] rooms = roomNos.split(",");
							for (String room : rooms) {
								result.add(room);
							}
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * 订单排房
	 */
	@Override
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yuliupmscode) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		String method = "zhuzher.order.assaginRoomForOrder";// 方法名
		StringBuffer sb = new StringBuffer();
		sb.append("<request>").append("<head></head>").append("<body>")
				.append("<hotelId>" + hotelId + "</hotelId>")
				.append("<orderId>" + orderNum + "</orderId>")
				.append("<roomTypeNo>" + houseCode + "</roomTypeNo>")
				.append("<roomNos>" + roomNum + "</roomNos>")
				.append("<checkInNo></checkInNo>").append("</body>")
				.append("</request>");

		String reqXml = sb.toString();
		JSONObject json = post(method, reqXml);
		System.out.println(json);
		if (json != null) {
			JSONArray body = json.getJSONArray("body");
			if (body != null && body.size() > 0) {
				for (int i = 0; i < body.size(); i++) {
					JSONObject job = body.getJSONObject(i);
					if (job != null) {
						String roomNos = job.getString("roomNos");
						if (roomNos != null && !"".equals(roomNos)) {
							String[] rooms = roomNos.split(",");
							for (String room : rooms) {
								result.add(room);
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * 退房
	 */
	@Override
	public boolean checkOut(String queryString) {
		// TODO Auto-generated method stub
		String method = "zhuzher.room.checkOutRoom";// 方法名
		JSONObject json = post(method, queryString);
		System.out.println(json);
		return true;
	}

	/**
	 * 根据房间号查询账单信息
	 */

	public String getRoomBillInfo(String queryString) {
		// TODO Auto-generated method stub
		String method = "zhuzher.bill.getRoomBillInfo";// 方法名
		JSONObject json = post(method, queryString);
		System.out.println(json);

		return "";
	}

	@Override
	public PayInfo getPayInfo(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean payOrder(String queryString,double totalFree) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPerson(IdCard idCard, String queryString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRoomStatus(String accnt) {
		// TODO Auto-generated method stub
		return null;
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

	/**
	 * List<NameValuePair> nvps = new ArrayList<NameValuePair>(); nvps.add(new
	 * BasicNameValuePair("cId", cId)); nvps.add(new
	 * BasicNameValuePair("authCode", authCode)); nvps.add(new
	 * BasicNameValuePair("method", method)); nvps.add(new
	 * BasicNameValuePair("time", time + "")); nvps.add(new
	 * BasicNameValuePair("data", inputObj)); post.setEntity(new
	 * UrlEncodedFormEntity(nvps, "UTF-8"));
	 */
}
