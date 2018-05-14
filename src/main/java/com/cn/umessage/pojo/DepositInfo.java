package com.cn.umessage.pojo;

public class DepositInfo {
    private String accnt;

    private String isselfmachine;

    private String amount;

    private String consumptionamount;

    private String refundamount;

    private String refundstatus;

    private String reserve1;//支付方式   zfb支付宝      wx微信

    private String reserve2;
    
    private String mpcfgid;
    
    public String getMpcfgid() {
		return mpcfgid;
	}

	public void setMpcfgid(String mpcfgid) {
		this.mpcfgid = mpcfgid;
	}

	public String getAccnt() {
        return accnt;
    }

    public void setAccnt(String accnt) {
        this.accnt = accnt == null ? null : accnt.trim();
    }

    public String getIsselfmachine() {
        return isselfmachine;
    }

    public void setIsselfmachine(String isselfmachine) {
        this.isselfmachine = isselfmachine == null ? null : isselfmachine.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getConsumptionamount() {
        return consumptionamount;
    }

    public void setConsumptionamount(String consumptionamount) {
        this.consumptionamount = consumptionamount == null ? null : consumptionamount.trim();
    }

    public String getRefundamount() {
        return refundamount;
    }

    public void setRefundamount(String refundamount) {
        this.refundamount = refundamount == null ? null : refundamount.trim();
    }

    public String getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(String refundstatus) {
        this.refundstatus = refundstatus == null ? null : refundstatus.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }
}