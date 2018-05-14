package com.cn.umessage.dao.pms;

import java.util.List;
import java.util.Map;

import com.cn.umessage.pojo.AvailableRoom;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.pojo.OrderInfo;
import com.cn.umessage.pojo.PayInfo;
import com.cn.umessage.pojo.RoomType;

/**
 * pms接口 已接入品牌：金天鹅、绿云、西软、住哲
 * 
 * @author hyj
 * 
 */
public interface IPmsDao {
	public List<RoomType> getRoomTypes(String queryString);

	public List<OrderInfo> getOrder(String queryString);

	public List<CheckInInfo> getCheckInInfo(String queryString);

	// 入住
	public String checkIn(String queryString, String roomno);

	// 查询可住房间
	public List<String> getAvailableRoom(String startDate, String endDate,
			String houseCode);
	//查询可住房间（针对团队入住）
	public List<AvailableRoom> getAvailableRoomForGroup(String startDate, String endDate,String houseCode);
	// 预约单分房
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yuliupmscode);

	// 退房
	public boolean checkOut(String queryString);

	// 订单支付情况
	public PayInfo getPayInfo(String queryString);

	// 支付房费
	public boolean payOrder(String queryString,double totalFree);
	
	/**
	 * 增加同住人接口
	 * 
	 * @param param
	 * @return
	 */
	public boolean addPerson(IdCard idCard, String queryString);
	//查询订单状态
	public String getRoomStatus(String accnt);
	
	
	/**
	 * 更改主单证件信息
	 * 
	 * @param param
	 * @return
	 */
	public boolean updateOrderInfo(IdCard idCard, String queryString);
	//绿云获取订单支付信息
	public List<Map> getOrderpayment(String scanChannel, String hotelOutId);
	//绿云获取支付二维码
	public Map<String,String> getQRcode(String hotelOutId, String Orderpms,String lyResrvationNumber,String number,String totalFees,String scanChannel);
	//添加账务
	public String addaccounting(String ruzhupms, String xfxmrzbm,String pmsnumber,String Banbie,String zhifuleixing,String Beizhu);
	//查询加收房费506
	public Map queryRoomFee(String orderNoPMS);
}
