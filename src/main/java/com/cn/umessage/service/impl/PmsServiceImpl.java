package com.cn.umessage.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cn.umessage.dao.pms.IPmsDao;
import com.cn.umessage.dao.pms.ly.dao.LYDao;
import com.cn.umessage.dao.pms.xiruan.dao.XiRuanDao;
import com.cn.umessage.pojo.AvailableRoom;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.pojo.OrderInfo;
import com.cn.umessage.pojo.PayInfo;
import com.cn.umessage.pojo.RoomType;
import com.cn.umessage.service.IPmsService;
import com.cn.umessage.utils.InitConfig;
import com.cn.umessage.utils.SmsUtil;
import com.cn.umessage.utils.pinyinUtil;

@Service("pmsService")
public class PmsServiceImpl implements IPmsService {
	private static final Logger log = LoggerFactory.getLogger(PmsServiceImpl.class);
	@Resource
	private IPmsDao jtePmsDao;
	@Resource
	private IPmsDao lyPmsDao;
	@Resource
	private IPmsDao zhuzhePmsDao;
	@Resource
	private IPmsDao xiruanPmsDao;

	@Override
	public List<RoomType> getRoomTypes(String queryString) {
		// TODO Auto-generated method stub
		List<RoomType> result = new ArrayList<RoomType>();
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			result = lyPmsDao.getRoomTypes(queryString);
			break;
		case "jte":
			result = jtePmsDao.getRoomTypes(queryString);
			break;
		case "zhuzhe":
			result = zhuzhePmsDao.getRoomTypes(queryString);
			break;
		default:
			System.out.println("default");
			break;

		}

		return result;
	}

	@Override
	public List<Object> getRooms(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getHotelInfo(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getInhabitableRooms(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrice(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object extension(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> getOrder(String queryString) {
		// TODO Auto-generated method stub
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		String pmsName = InitConfig.PMS_COMPANY;
		String name = queryString.split(",")[0];
		String cardNum = queryString.split(",")[1];
		String queryStr = "";
		switch (pmsName) {
		case "ly":
			/*System.out.println("ly");
			queryStr = ",," + InitConfig.LY_PMSCODE + ",6," + cardNum + "#"
					+ name + ",";*/
			list = lyPmsDao.getOrder(name);
			break;
		case "jte":
			list = jtePmsDao.getOrder(queryString);
			break;
		case "zhuzhe":
			queryStr = name;
			list = zhuzhePmsDao.getOrder(queryStr);
			break;
		case "xiruan":
			queryStr = name;
			list = xiruanPmsDao.getOrder(queryStr);
			break;
		default:
			System.out.println("default");
			break;

		}

		return list;
	}

	@Override
	public List<CheckInInfo> getCheckInInfo(String queryString) {
		// TODO Auto-generated method stub
		List<CheckInInfo> list = new ArrayList<CheckInInfo>();
		String pmsName = InitConfig.PMS_COMPANY;
		String queryStr = "";
		switch (pmsName) {
		case "ly":
			/*System.out.println("ly");
			queryStr = ",," + InitConfig.LY_PMSCODE + ",3," + queryString;*/
			queryStr = queryString.split(",")[1];//房间号
			list = lyPmsDao.getCheckInInfo(queryStr);
			break;
		case "jte":
			list = jtePmsDao.getCheckInInfo(queryString);
			break;
		case "zhuzhe":
			StringBuffer sb = new StringBuffer();
			sb.append("<request>")
					.append("<head></head>")
					.append("<body>")
					.append("<hotelId>" + InitConfig.ZHUZHE_HOTELID
							+ "</hotelId>")
					.append("<roomNo>" + queryString + "</roomNo>")
					.append("</body>").append("</request>");
			queryStr = sb.toString();
			list = zhuzhePmsDao.getCheckInInfo(queryStr);
			break;
		case "xiruan":
			queryStr = queryString.split(",")[0];//订单号
			list = xiruanPmsDao.getCheckInInfo(queryString);
			break;
		default:
			System.out.println("default");
			break;

		}

		return list;
	}

	@Override
	public String checkIn(IdCard idCard, OrderInfo order) {
		// TODO Auto-generated method stub
		String pmsName = InitConfig.PMS_COMPANY;
		StringBuffer queryString = new StringBuffer("");// 查询条件
		String roomno = "";// 房间号，有些PMS是传入房间号办理入住，有些PMS是办理入住然后返回房间号
		String res = "";// 办理入住后返回的房间号
		switch (pmsName) {
		case "ly":
			/*List<String> datas = new LYDao().getAvailableRoom(order.inTime,order.outTime, order.roomCode);
			//lyPmsDao.getAvailableRoom(order.inTime,order.outTime, order.roomCode);
			String result = new LYDao().allotRoom(order.orderNumPMS,order.roomCode, datas.get(0));*/
					//lyPmsDao.allotRoom(order.orderNumPMS,order.roomCode, datas.get(0));
			/*queryString = ",," + InitConfig.LY_PMSCODE + ","
					+ order.orderNumPMS + "," + order.getRoomCode() + ","
					+ datas.get(0) + ",,,,,,,,,,,,,,,,,,,,,,,,";*/
			//q=,,0511,,TWRB,8202,BAR1,,2018-04-09#0.03#0.03,,,,冯晶晶#01#120109198103163592##女性#天津市滨海新区海滨街#1981-03-16##,,,,,HEP,3,,2018-04-09 14:39:43,2018-04-10 12:00:00,,1,,,8202,8202,,
			roomno = order.getRoomNo();
			String identity = "";//身份信息
			try{
				identity = idCard.getName()+"#01#"+idCard.getCardNum()
					+"#"+idCard.getMinzu()+"#"+idCard.getSex()+"性"+"#"+idCard.getAddress()
					+"#"+format(idCard.getBirthday())+"#"+pinyinUtil.toHanyuPinyin(idCard.getName())+"#";
			} catch (Exception e1) {
				log.error("format转换birthday异常！");
				e1.printStackTrace();
			}
			queryString.append(order.getDengjidanId()+",")
			.append(order.getRoomCode()+",")
			.append(roomno+",")
			.append(order.getPrice()+",")
			.append(order.getRzrqcjfjysfj()+",")
			.append(identity+",")
			.append(order.getInTime()+",")
			.append(order.getOutTime());
			res = lyPmsDao.checkIn(queryString.toString(), roomno);
			break;
		case "jte":

			break;
		case "zhuzhe":
			List<String> datas2 = zhuzhePmsDao.getAvailableRoom(order.inTime,
					order.outTime, order.roomCode);
			String result2 = zhuzhePmsDao.allotRoom(order.orderNumPMS,
					order.roomCode, datas2.get(0), order.getYudingId());
			StringBuffer sb = new StringBuffer();
			sb.append("<request>")
					.append("<head></head>")
					.append("<body>")
					.append("<hotelId>" + InitConfig.ZHUZHE_HOTELID
							+ "</hotelId>")
					.append("<orderId>" + order.orderNumPMS + "</orderId>")
					.append("<roomTypeNo>" + order.getRoomCode()
							+ "</roomTypeNo>")
					.append("<roomNo>" + datas2.get(0) + "</roomNo>")
					.append("<guestInfos>")
					.append("<guestInfo>")
					.append("<name>" + idCard.getName() + "</name>")
					.append("<sex>" + idCard.getSex() + "</sex>")
					.append("<tel></tel>")
					.append("<id_card_no>" + idCard.getCardNum()
							+ "</id_card_no>").append("<birth></birth>")
					.append("<address></address>").append("<nation></nation>")
					.append("</guestInfo>").append("</guestInfos>")
					.append("</body>").append("</request>");
			//queryString = sb.toString();
			roomno = datas2.get(0);
			res = zhuzhePmsDao.checkIn(sb.toString(), roomno);
			break;
		case "xiruan":

			res = xiruanPmsDao.checkIn(order.getOrderNumPMS(), roomno);
			break;
		default:
			System.out.println("default");
			break;

		}
		return res;
	}

	@Override
	public List<String> getAvailableRoom(String startDate, String endDate,
			String houseCode) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			System.out.println("ly");
			list = lyPmsDao.getAvailableRoom(startDate, endDate, houseCode);
			break;
		case "jte":
			list = jtePmsDao.getAvailableRoom(startDate, endDate, houseCode);
			break;
		case "zhuzhe":
			list = zhuzhePmsDao.getAvailableRoom(startDate, endDate, houseCode);
			break;
		case "xiruan":
			list = xiruanPmsDao.getAvailableRoom(startDate, endDate, houseCode);
			break;
		default:
			System.out.println("default");
			break;

		}
		return list;
	}

	@Override
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yudingId) {
		// TODO Auto-generated method stub
		String result = "";
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			System.out.println("ly");
			result = lyPmsDao.allotRoom(orderNum, houseCode, roomNum, yudingId);
			break;
		case "jte":
			result = jtePmsDao.allotRoom(orderNum, houseCode, roomNum, yudingId);
			break;
		case "zhuzhe":
			result = zhuzhePmsDao.allotRoom(orderNum, houseCode, roomNum, yudingId);
			break;
		case "xiruan":
			result = xiruanPmsDao.allotRoom(orderNum, houseCode, roomNum, yudingId);
			break;
		default:
			System.out.println("default");
			break;

		}
		return result;
	}

	@Override
	public boolean checkOut(CheckInInfo checkInInfo) {
		// TODO Auto-generated method stub
		boolean result = false;
		String pmsName = InitConfig.PMS_COMPANY;
		String queryString = "";
		switch (pmsName) {
		case "ly":
			//先调用506查询加收房费
			Map roomFeeMap = lyPmsDao.queryRoomFee(checkInInfo.getOrderNumPMS());
			////
			//调用501添加账务
			//lyPmsDao.addaccounting(checkInInfo.getOrderNumPMS(), xfxmrzbm, pmsnumber, Banbie, zhifuleixing, Beizhu);
			result = lyPmsDao.checkOut(checkInInfo.getOrderNumPMS());
			break;
		case "jte":
			//result = jtePmsDao.checkOut(queryString);
			break;
		case "zhuzhe":
			StringBuffer sb = new StringBuffer();
			sb.append("<request>")
					.append("<head></head>")
					.append("<body>")
					.append("<hotelId>" + InitConfig.ZHUZHE_HOTELID
							+ "</hotelId>")
					.append("<roomNo>" + checkInInfo.roomNum + "</roomNo>")
					.append("<isAlone>1</isAlone>").append("</body>")
					.append("</request>");
			queryString = sb.toString();
			result = zhuzhePmsDao.checkOut(queryString);
			break;
		case "xiruan":
			result = xiruanPmsDao.checkOut(checkInInfo.getOrderNumPMS());
			break;
		default:
			System.out.println("default");
			break;

		}
		return result;
	}

	public PayInfo getPayInfo(String queryString) {
		PayInfo pay = new PayInfo();
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			System.out.println("ly");
			pay = lyPmsDao.getPayInfo(queryString.split(",")[1]);
			break;
		case "jte":
			pay = jtePmsDao.getPayInfo(queryString);
			break;
		case "zhuzhe":
			pay = zhuzhePmsDao.getPayInfo(queryString);
			break;
		case "xiruan":
			pay = xiruanPmsDao.getPayInfo(queryString.split(",")[0]);
			break;
		default:
			System.out.println("default");
			break;

		}

		return pay;
	}


	@Override
	public boolean payOrder(String queryString,double totalFree) {
		// TODO Auto-generated method stub
		boolean result = false;
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			System.out.println("ly");
			result = true;//lyPmsDao.payOrder(queryString,totalFree);
			break;
		case "jte":
			result = jtePmsDao.payOrder(queryString,totalFree);
			break;
		case "zhuzhe":
			result = zhuzhePmsDao.payOrder(queryString,totalFree);
			break;
		case "xiruan":
			result = xiruanPmsDao.payOrder(queryString,totalFree);
			break;
		default:
			System.out.println("default");
			break;

		}

		return result;
	}

	@Override
	public boolean addPerson(IdCard idCard, String queryString) {
		// TODO Auto-generated method stub
		boolean result = false;
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			System.out.println("ly");
			result = lyPmsDao.addPerson(idCard,queryString);
			break;
		case "jte":
			result = jtePmsDao.addPerson(idCard,queryString);
			break;
		case "zhuzhe":
			result = zhuzhePmsDao.addPerson(idCard,queryString);
			break;
		case "xiruan":
			result = xiruanPmsDao.addPerson(idCard,queryString);
			break;
		default:
			System.out.println("default");
			break;

		}

		return result;
	}

	@Override
	public String getRoomStatus(String resno) {
		// TODO Auto-generated method stub
		String result = "";
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			System.out.println("ly");
			result = lyPmsDao.getRoomStatus(resno.split(",")[1]);
			break;
		case "jte":
			result = jtePmsDao.getRoomStatus(resno);
			break;
		case "zhuzhe":
			result = zhuzhePmsDao.getRoomStatus(resno);
			break;
		case "xiruan":
			result = xiruanPmsDao.getRoomStatus(resno.split(",")[0]);
			break;
		default:
			System.out.println("default");
			break;

		}

		return result;
	}

	@Override
	public boolean updateOrderInfo(IdCard idCard, String queryString) {
		// TODO Auto-generated method stub
		boolean result = false;
		String pmsName = InitConfig.PMS_COMPANY;
		switch (pmsName) {
		case "ly":
			result = true;//lyPmsDao.updateOrderInfo(idCard,queryString);
			break;
		case "jte":
			result = jtePmsDao.updateOrderInfo(idCard,queryString);
			break;
		case "zhuzhe":
			result = zhuzhePmsDao.updateOrderInfo(idCard,queryString);
			break;
		case "xiruan":
			result = xiruanPmsDao.updateOrderInfo(idCard,queryString);
			break;
		default:
			System.out.println("default");
			break;

		}

		return result;
	}

	@Override
	public List<AvailableRoom> getAvailableRoomForGroup(String startDate,
			String endDate, String houseCode) {
		return xiruanPmsDao.getAvailableRoomForGroup(startDate, endDate, houseCode);
	}
	/**
	 * 添加账务
	 */
	public String addaccounting(String ruzhupms,String xfxmrzbm,String pmsnumber,String Banbie,String zhifuleixing,String Beizhu){
		return lyPmsDao.addaccounting(ruzhupms, xfxmrzbm, pmsnumber, Banbie, zhifuleixing, Beizhu);
	}
	public static void main(String[] args) {
		/*OrderInfo order = new OrderInfo();
		order.setInTime("2018-04-27 18:00:00");
		order.setOutTime("2018-04-30 12:00:00");
		//order.setOrderNumPMS("17066");
		order.setRoomCode("SDT");
		order.setRzrqcjfjysfj("2018-04-27 00:00:00#0.01#0.01|2018-04-28 00:00:00#0.01#0.01|2018-04-29 00:00:00#0.01#0.01");
		order.setPrice("ZZ");
		order.setOrderNum("1804270054");
		IdCard card = new IdCard();
		card.setAddress("山东省");
		card.setBirthday("1989-01-02");
		card.setCardNum("370103198901028911");
		card.setName("陈永文");
		card.setSex("男");
		card.setMinzu("汉");
		new PmsServiceImpl().checkIn(card, order);*/
		try {
			System.out.println(format("19950128"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String format(String str) throws Exception {
		return str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
	}
}
