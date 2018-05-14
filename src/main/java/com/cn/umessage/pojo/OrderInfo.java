package com.cn.umessage.pojo;


public class OrderInfo {
	public String orderNum;//订单号
	public String orderNumPMS;//PMS账号
	public String orderFrom;//来源
	public String roomNum;//房间数量
	public String roomType;//房型名称
	public String inTime;//到店日期
	public String outTime;//离店日期
	public String price;//房价（绿云房价码）
	public String roomCode;//房型代码
	public String earnestFlag;
	public String days;//几晚
	public String rooms;//房间数量
	public String adults;//成人数
	//绿云pms增加
	private String roomNo;//房间号
	
	private String rzrqcjfjysfj;//入住日期#房价..
	private String Shebeirengong;//设备人工
	private String Banbie;//班别
	private String Ruzhudate;//入住时间
	private String Lidiandate;//离店时间
	private String Santuan;//散团
	private String Roomnum;//房号PMS编码
	private String Suofang;//锁房标记值
	private String yudingId;//预留ID
	private String dengjidanId;//登记单id
	
	public String getDengjidanId() {
		return dengjidanId;
	}

	public void setDengjidanId(String dengjidanId) {
		this.dengjidanId = dengjidanId;
	}

	public String getYudingId() {
		return yudingId;
	}

	public void setYudingId(String yudingId) {
		this.yudingId = yudingId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRzrqcjfjysfj() {
		return rzrqcjfjysfj;
	}

	public void setRzrqcjfjysfj(String rzrqcjfjysfj) {
		this.rzrqcjfjysfj = rzrqcjfjysfj;
	}

	public String getShebeirengong() {
		return Shebeirengong;
	}

	public void setShebeirengong(String shebeirengong) {
		Shebeirengong = shebeirengong;
	}

	public String getBanbie() {
		return Banbie;
	}

	public void setBanbie(String banbie) {
		Banbie = banbie;
	}

	public String getRuzhudate() {
		return Ruzhudate;
	}

	public void setRuzhudate(String ruzhudate) {
		Ruzhudate = ruzhudate;
	}

	public String getLidiandate() {
		return Lidiandate;
	}

	public void setLidiandate(String lidiandate) {
		Lidiandate = lidiandate;
	}

	public String getSantuan() {
		return Santuan;
	}

	public void setSantuan(String santuan) {
		Santuan = santuan;
	}

	public String getRoomnum() {
		return Roomnum;
	}

	public void setRoomnum(String roomnum) {
		Roomnum = roomnum;
	}

	public String getSuofang() {
		return Suofang;
	}

	public void setSuofang(String suofang) {
		Suofang = suofang;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getAdults() {
		return adults;
	}

	public void setAdults(String adults) {
		this.adults = adults;
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
