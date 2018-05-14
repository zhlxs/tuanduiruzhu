package com.cn.umessage.dao.pms.zhuzhe.bean;

import java.io.Serializable;

public class VoRoomPrice implements Serializable {
	private static final long serialVersionUID = -8294363116340215446L;
	private String hotelId;// 酒店id
	private String ratecode;// 房价码
	private String rmtype;// 房型
	private String rate1;// 房价
	private String avgRate1;// 均价
	private String crate1;// 预留
	private String src;// 来源
	private String market;// 市场
	private String packages;// 包价
	private String advMin;// 最小提前
	private String advMax;// 最大提前
	private String stayMin;// 最小入住
	private String stayMax;// 最大入住
	private String avail;// 可用量

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRatecode() {
		return ratecode;
	}

	public void setRatecode(String ratecode) {
		this.ratecode = ratecode;
	}

	public String getRmtype() {
		return rmtype;
	}

	public void setRmtype(String rmtype) {
		this.rmtype = rmtype;
	}

	public String getRate1() {
		return rate1;
	}

	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}

	public String getAvgRate1() {
		return avgRate1;
	}

	public void setAvgRate1(String avgRate1) {
		this.avgRate1 = avgRate1;
	}

	public String getCrate1() {
		return crate1;
	}

	public void setCrate1(String crate1) {
		this.crate1 = crate1;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getAdvMin() {
		return advMin;
	}

	public void setAdvMin(String advMin) {
		this.advMin = advMin;
	}

	public String getAdvMax() {
		return advMax;
	}

	public void setAdvMax(String advMax) {
		this.advMax = advMax;
	}

	public String getStayMin() {
		return stayMin;
	}

	public void setStayMin(String stayMin) {
		this.stayMin = stayMin;
	}

	public String getStayMax() {
		return stayMax;
	}

	public void setStayMax(String stayMax) {
		this.stayMax = stayMax;
	}

	public String getAvail() {
		return avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

}
