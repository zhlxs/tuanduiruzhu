package com.cn.umessage.pojo;

public class PayResultBean {
  private String status;
  private String resultCode;
  private String tradeState;
  private double totalFee;//总金额，单位元
  private String attach;
  private double deposit;//押金，单位元
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getResultCode() {
	return resultCode;
}
public void setResultCode(String resultCode) {
	this.resultCode = resultCode;
}
public String getTradeState() {
	return tradeState;
}
public void setTradeState(String tradeState) {
	this.tradeState = tradeState;
}

public String getAttach() {
	return attach;
}
public void setAttach(String attach) {
	this.attach = attach;
}
public double getTotalFee() {
	return totalFee;
}
public void setTotalFee(double totalFee) {
	this.totalFee = totalFee;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit(double deposit) {
	this.deposit = deposit;
}
  
  
}
