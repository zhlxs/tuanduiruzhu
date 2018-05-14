package com.cn.umessage.dao.pms.jte.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.pms.IPmsDao;
import com.cn.umessage.dao.pms.jte.bean.GetRoomType;
import com.cn.umessage.dao.pms.jte.client.IThirdpartyService;
import com.cn.umessage.dao.pms.jte.client.ThirdpartyService;
import com.cn.umessage.pojo.AvailableRoom;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.pojo.OrderInfo;
import com.cn.umessage.pojo.PayInfo;
import com.cn.umessage.pojo.RoomType;
import com.cn.umessage.utils.JaxbUtil;

@Service("jtePmsDao")
public class JTEDao implements IPmsDao {

	@Override
	public List<RoomType> getRoomTypes(String queryString) {
		List<RoomType> result = new ArrayList<RoomType>();

		IThirdpartyService service = new ThirdpartyService()
				.getBasicHttpBindingIThirdpartyService();
		// String message=
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Context><SUVERL><hotelname>宾馆代码</hotelname><key>第三方授权</ key></SUVERL></Context>";
		// String s = test.gethHotelcode("好再来酒店");
		String typemessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<Context>" + "<SUVERL>"
				+ "<hotel_code>HOTEL1479385471</hotel_code>"
				+ "<room_type_code></room_type_code>"
				+ "<room_type_title></room_type_title>"
				+ "<key>Wide_Third</key>" + "</SUVERL>" + "</Context>";
		// String s = test.getstandard("HOTEL1479385471");
		String xml = service.getRoomType(typemessage);

		GetRoomType getRoomType = JaxbUtil.converyToJavaBean(xml,
				GetRoomType.class);

		List<Object> list = getRoomType.getMsgOrBody();
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			if (o.getClass() == GetRoomType.Body.class) {
				List<GetRoomType.Body.SUVERL> list2 = ((GetRoomType.Body) o)
						.getSUVERL();
				for (int j = 0; j < list2.size(); j++) {
					RoomType roomType = new RoomType();

					GetRoomType.Body.SUVERL suverl = list2.get(j);
					roomType.setName(suverl.getRoomTypeTitle());
					roomType.setPersonNum(suverl.getCheckInNum());
					roomType.setPrice(suverl.getIndividualPrice());
					roomType.setRoomNum("66");// TODO
					result.add(roomType);
				}

			}

		}

		return result;
	}

	public static void main(String[] args) {
		IThirdpartyService service = new ThirdpartyService()
				.getBasicHttpBindingIThirdpartyService();
		// String message=
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Context><SUVERL><hotelname>宾馆代码</hotelname><key>第三方授权</ key></SUVERL></Context>";

		String typemessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<Context>" + "<SUVERL>"
				+ "<hotel_code>HOTEL1489374686</hotel_code>"
				+ "<room_type_code></room_type_code>"
				+ "<room_type_title></room_type_title>"
				+ "<key>Wide_Third</key>" + "</SUVERL>" + "</Context>";

		String roommessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<Context>" + "<SUVERL>"
				+ "<hotel_code>HOTEL1479385471</hotel_code>"
				+ "<room_no></room_no>" + "<building></building>"
				+ "<floor></floor>" + "<key>Wide_Third</key>" + "</SUVERL>"
				+ "</Context>";

		String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<request>" + "<bookrq>"
				+ "<hotelCode>0891-878998720170803102605</hotelCode>"
				+ "<memberCode></memberCode>" + "<inDate>2017-11-15</inDate>"
				+ "<outDate>2017-11-16</outDate>" + "<keepTime></keepTime>"
				+ "<roomTypeCode>FX170313000000070001</roomTypeCode>"
				+ "<orderNum>1</orderNum>" + "<name>张杰</name>"
				+ "<mobile>13233638399</mobile>"
				+ "<orderSource>微信</orderSource>"
				+ "<roomCreditLimit>300</roomCreditLimit>"
				+ "<orderPrice>300</orderPrice>" + "<orderType>1</orderType>"
				+ "<reduceMoney></reduceMoney>" + "<remark></remark>"
				+ "<key>Jte_wx</key>" + "</bookrq>" + "</request>";

		String ordermessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<Context>" + "<SUVERL>"
				+ "<hotel_code>HOTEL1489374686</hotel_code>"
				+ "<order_no></order_no>" + "<order_type></order_type>"
				+ "<order_source></order_source>"
				+ "<in_time>2017-11-15</in_time>" + "<cred_no>123</cred_no>"
				+ "<Mobile>13233638399</Mobile>" + "<key>Wide_Third</key>"
				+ "</SUVERL>" + "</Context>";

		String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<Body>"
				+ "<SUVERL>" + "<card_no></card_no>" + "<acc_no></acc_no>"
				+ "<hotel_code>HOTEL1479385471</hotel_code>" + "<mode></mode>"
				+ "<tel></tel>" + "</SUVERL>" + "</Body>";

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<request>"
				+ "<queryOrderInfo>" + "<hotelCode></hotelCode>"
				+ "<orderNumber></orderNumber>"
				+ "<memberCode>13282802451</memberCode>"
				+ "<beginDate></beginDate>" + "<endDate></endDate>"
				+ "<startCount>1</startCount>" + "<number>5</number>"
				+ "<key>Wide_Third</key>" + "</queryOrderInfo>" + "</request>";

		// 宝来客控对接酒店 HOTEL1489374686 0891-878998720170803102605
		// 好再来酒店 HOTEL1479385471 0731-888888220170710032514

		// //酒店代码
		// String code = service.gethHotelcode("好再来酒店");
		//
		// //房型查询
		// String type = service.getRoomType(typemessage);
		// System.out.println(type);
		//
		//
		// //房间状态查询
		// String room = service.getStateByRoom(roommessage);
		// System.out.println(room);
		//
		// //创建订单
		// String result = service.createBookrq(message);
		// System.out.println(result);
		//
		//
		// 查询预定订单
		String order = service.getReserve(ordermessage);
		System.out.println(order);
		//
		//
		//
		// //查询酒店会员
		// String member = service.getMember(xml2);
		// System.out.println(member);

		// 查询会员所有订单
		// String OrderInfo = service.getOrderInfo(xml);
		// System.out.println(OrderInfo);
	}

	@Override
	public List<OrderInfo> getOrder(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInInfo> getCheckInInfo(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkIn(String queryString, String roomno) {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public List<String> getAvailableRoom(String startDate, String endDate,
			String houseCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yuliupmscode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkOut(String queryString) {
		// TODO Auto-generated method stub
		return false;
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

}
