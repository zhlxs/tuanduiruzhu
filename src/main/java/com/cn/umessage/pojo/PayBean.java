package com.cn.umessage.pojo;

public class PayBean {
	public String cSet;
	public String imgUrl;
	public String nonceStr;
	public String codeUrl;
	public String appId;
	public String resultCode;
	public String mchId;
	public String signType;
	public String version;
	public String status;
	public String scanChannel;//扫描类型   微信、支付宝
	
	
	public String getScanChannel() {
		return scanChannel;
	}

	public void setScanChannel(String scanChannel) {
		this.scanChannel = scanChannel;
	}

	public String getcSet() {
		return cSet;
	}

	public void setcSet(String cSet) {
		this.cSet = cSet;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
