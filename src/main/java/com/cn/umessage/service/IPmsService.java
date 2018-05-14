package com.cn.umessage.service;

import java.util.List;

import com.cn.umessage.pojo.AvailableRoom;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.pojo.OrderInfo;
import com.cn.umessage.pojo.PayInfo;
import com.cn.umessage.pojo.RoomType;

public interface IPmsService {
	/**
	 * 查询酒店房型列表
	 * 
	 * @param queryString
	 * @return
	 */
	public List<RoomType> getRoomTypes(String queryString);

	/**
	 * 查询所有房间房态
	 * 
	 * @param queryString
	 * @return
	 */
	public List<Object> getRooms(String queryString);

	/**
	 * 查询酒店信息
	 * 
	 * @param queryString
	 * @return
	 */
	public Object getHotelInfo(String queryString);

	/**
	 * 查询酒店所有可住房间
	 * 
	 * @param queryString
	 * @return
	 */
	public List<Object> getInhabitableRooms(String queryString);

	/**
	 * 查询房价
	 * 
	 * @param queryString
	 * @return
	 */
	public Object getPrice(String queryString);

	/**
	 * 续住接口
	 * 
	 * @param queryString
	 * @return
	 */
	public Object extension(String queryString);

	public List<OrderInfo> getOrder(String queryString);

	public List<CheckInInfo> getCheckInInfo(String queryString);

	/**
	 * 入住接口
	 * 
	 * @param queryString
	 * @return
	 */
	public String checkIn(IdCard idCard, OrderInfo order);

	// 查询可住房间
	public List<String> getAvailableRoom(String startDate, String endDate,
			String houseCode);
	//查询可住房间（针对团队入住）
	public List<AvailableRoom> getAvailableRoomForGroup(String startDate, String endDate,String houseCode);
	// 预约单分房
	public String allotRoom(String orderNum, String houseCode, String roomNum,String yudingId);

	// 退房
	public boolean checkOut(CheckInInfo checkInInfo);

	public PayInfo getPayInfo(String queryString);

	public boolean payOrder(String queryString,double totalFree);
	
	/**
	 * 增加同住人接口
	 * 
	 * @param param
	 * @return
	 */
	public boolean addPerson(IdCard idCard, String queryString);

	//查询订单状态
		public String getRoomStatus(String resno);
		
		/**
		 * 更改主单证件信息
		 * 
		 * @param param
		 * @return
		 */
		public boolean updateOrderInfo(IdCard idCard, String queryString);
}
