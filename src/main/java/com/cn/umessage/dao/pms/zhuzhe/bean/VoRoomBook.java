package com.cn.umessage.dao.pms.zhuzhe.bean;

import java.io.Serializable;

public class VoRoomBook implements Serializable {
	private static final long serialVersionUID = -1938004303113741102L;
	private String hotelGroupId;// 集团ID
	private String hotelId;// 酒店ID
	private String arr;// 到达时间 yyyy-MM-dd HH:mm:ss
	private String dep;// 离开时间
	private String rmtype;// 房型

	private String rateCode;// 房价码 RAC
	private Integer rmNum;// 房数
	private String rsvMan;// 预订人
	private String sex;// 性别 1男 2女
	private String mobile;

	private Integer adult;// 人数
	private Double totalPrice;// 总价
	private Integer ensureFlag;// 支付 0-未，1-已

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

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getRmtype() {
		return rmtype;
	}

	public void setRmtype(String rmtype) {
		this.rmtype = rmtype;
	}

	public String getRateCode() {
		return rateCode;
	}

	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}

	public Integer getRmNum() {
		return rmNum;
	}

	public void setRmNum(Integer rmNum) {
		this.rmNum = rmNum;
	}

	public String getRsvMan() {
		return rsvMan;
	}

	public void setRsvMan(String rsvMan) {
		this.rsvMan = rsvMan;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getAdult() {
		return adult;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getEnsureFlag() {
		return ensureFlag;
	}

	public void setEnsureFlag(Integer ensureFlag) {
		this.ensureFlag = ensureFlag;
	}

}
