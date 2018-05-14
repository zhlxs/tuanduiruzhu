package com.cn.umessage.dao.lock.btlock57;

public class LiftParameter {

	private int cardNo;
	private String beginTime;
	private String endTime;
	private String liftData;

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLiftData() {
		return liftData;
	}

	public void setLiftData(String liftData) {
		this.liftData = liftData;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Lift \n").append("  Card No : " + cardNo + '\n');

		return sb.toString();
	}
}
