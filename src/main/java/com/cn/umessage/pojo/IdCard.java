package com.cn.umessage.pojo;

public class IdCard {
	private String name;
	private String sex;
	private String minzu;
	private String birthday;
	private String address;
	private String cardNum;
	private String company;
	private String startTime;
	private String endTime;
	private String nation;//名族
	private String department;//发证机关
	
	
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "IdCard [name=" + name + ", sex=" + sex + ", minzu=" + minzu
				+ ", birthday=" + birthday + ", address=" + address
				+ ", cardNum=" + cardNum + ", company=" + company
				+ ", startTime=" + startTime + ", endTime=" + endTime +","
				+ " nation=" + nation +", department=" + department + "]";
	}

}
