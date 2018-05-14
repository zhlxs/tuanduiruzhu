package com.cn.umessage.dao.pms.zhuzhe.bean;

import java.io.Serializable;

public class VoRoomType implements Serializable {
	private static final long serialVersionUID = 7593797847839848709L;
	private String hotelGroupId;// 集团id
	private String hotelId;// 酒店代码
	private String roomType;// 房型代码
	private String roomDescript;// 房型描述

	public String getHotelGroupId() {
		return hotelGroupId;
	}

	public void setHotelGroupId(String hotelGroupId) {
		this.hotelGroupId = hotelGroupId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomDescript() {
		return roomDescript;
	}

	public void setRoomDescript(String roomDescript) {
		this.roomDescript = roomDescript;
	}

}
