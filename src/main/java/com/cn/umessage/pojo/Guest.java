package com.cn.umessage.pojo;

public class Guest {
	private String pType;//固定值0，代表境内旅客
	private String psbId;//酒店旅馆代码
	private String idNo;//证件号
	private String name;//姓名
	private String sex;//性别，1：男；2：女
	private String nationCode;//民族
	private String birth;//出生日期
	private String idType;//证件类型，需提供代码
	private String province;//省市县，需提供编码表或使用身份证前6位
	private String address;//详细地址
	private String checkInDate;//入住日期，yyyy-MM-dd HH:mm:ss
	private String roomNo;//房间号
	private String photo;//照片，Base64编码
	private String ScenePhoto;//人脸现场照片，Base64编码
	private String Semblance;//人脸与证件相似度，0.00 – 1.00
	private String faceResult;//人脸比对结果
	private String Operator;//复核人
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getPsbId() {
		return psbId;
	}
	public void setPsbId(String psbId) {
		this.psbId = psbId;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
	public String getNationCode() {
		return nationCode;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getScenePhoto() {
		return ScenePhoto;
	}
	public void setScenePhoto(String scenePhoto) {
		ScenePhoto = scenePhoto;
	}
	public String getSemblance() {
		return Semblance;
	}
	public void setSemblance(String semblance) {
		Semblance = semblance;
	}
	public String getFaceResult() {
		return faceResult;
	}
	public void setFaceResult(String faceResult) {
		this.faceResult = faceResult;
	}
	public String getOperator() {
		return Operator;
	}
	public void setOperator(String operator) {
		Operator = operator;
	}
	
	
}
