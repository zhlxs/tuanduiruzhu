package com.cn.umessage.dao.psb.bean;

import java.io.Serializable;

public class GuestBeanCheckOut implements Serializable{
	
 	private static final long serialVersionUID = -400009127141813650L;
 	
	private String psbId;//酒店旅馆代码
	private String checkInDate;//入住时间
	private String checkOutDate;//离店时间
	private String roomNo;//房间号
	private String cardNum;//证件号(requierd=false)
	private String roomCardNum;//房卡号
	
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getRoomCardNum() {
		return roomCardNum;
	}
	public void setRoomCardNum(String roomCardNum) {
		this.roomCardNum = roomCardNum;
	}
	public String getPsbId() {
		return psbId;
	}
	public void setPsbId(String psbId) {
		this.psbId = psbId;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	
}
