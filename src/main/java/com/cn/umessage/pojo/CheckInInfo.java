package com.cn.umessage.pojo;

import java.util.ArrayList;

public class CheckInInfo {
	public String orderNum;
	public String orderNumPMS;
	public String orderFrom;
	public String roomNum;
	public String roomType;
	public String inTime;
	public String outTime;
	public String price;
	public String roomCode;
	public String earnestFlag;
	public String days;
	public ArrayList<String> persons;

	public ArrayList<String> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<String> persons) {
		this.persons = persons;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getOrderNumPMS() {
		return orderNumPMS;
	}

	public void setOrderNumPMS(String orderNumPMS) {
		this.orderNumPMS = orderNumPMS;
	}

	public String getEarnestFlag() {
		return earnestFlag;
	}

	public void setEarnestFlag(String earnestFlag) {
		this.earnestFlag = earnestFlag;
	}

}
