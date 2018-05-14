package com.cn.umessage.pojo;

public class PayInfo {
	public boolean isPay;//支付状态
	public double roomRate;//房价
	public double deposit;//押金
	public double otherFree;
	public double totalFree;//总费用

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	public double getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(double roomRate) {
		this.roomRate = roomRate;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getOtherFree() {
		return otherFree;
	}

	public void setOtherFree(double otherFree) {
		this.otherFree = otherFree;
	}

	public double getTotalFree() {
		return totalFree;
	}

	public void setTotalFree(double totalFree) {
		this.totalFree = totalFree;
	}

}
