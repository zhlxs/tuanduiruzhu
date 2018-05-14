package com.cn.umessage.dao.pms.zhuzhe.bean;

import java.io.Serializable;

public class VoHotelInfo implements Serializable {
	private static final long serialVersionUID = 3958489014666844730L;
	private String id;// 酒店ID
	private String hotelGroupId;// 集团ID
	private String code;// 酒店代码
	private String sta;// 酒店状态
	private String descript;// 酒店描述
	private String descriptEn;// 酒店描述英文
	private String descriptShort;// 酒店简称
	private String country;// 国家
	private String city;// 城市
	private String address1;// 地址
	private String phone;// 电话
	private String fax;// 传真
	private String phoneRsv;// 预订电话
	private String website;// 网址
	private String email;// 邮箱
	private String provinceCode;// 省份代码
	private String cityCode;// 城市代码
	private String districtCode;// 区域代码
	private String brandCode;// 品牌代码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelGroupId() {
		return hotelGroupId;
	}

	public void setHotelGroupId(String hotelGroupId) {
		this.hotelGroupId = hotelGroupId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getDescriptEn() {
		return descriptEn;
	}

	public void setDescriptEn(String descriptEn) {
		this.descriptEn = descriptEn;
	}

	public String getDescriptShort() {
		return descriptShort;
	}

	public void setDescriptShort(String descriptShort) {
		this.descriptShort = descriptShort;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhoneRsv() {
		return phoneRsv;
	}

	public void setPhoneRsv(String phoneRsv) {
		this.phoneRsv = phoneRsv;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

}
