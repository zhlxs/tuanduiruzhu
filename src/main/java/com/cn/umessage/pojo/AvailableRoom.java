package com.cn.umessage.pojo;

public class AvailableRoom {
	private String RoomType;//房类码
	private String RoomDescription;//房类名称
	private String RoomNumber;//房号
	private String FeatureCode;//房间特征码，多项用|分隔
	private String FeatureDescription;//房间特征，多项用|分隔
	private String Rate;//房价
	private String RoomState;//房态, R:干净房 D: 脏房
	private String RoomStateDescription;//房态名称
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public String getRoomDescription() {
		return RoomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		RoomDescription = roomDescription;
	}
	public String getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}
	public String getFeatureCode() {
		return FeatureCode;
	}
	public void setFeatureCode(String featureCode) {
		FeatureCode = featureCode;
	}
	public String getFeatureDescription() {
		return FeatureDescription;
	}
	public void setFeatureDescription(String featureDescription) {
		FeatureDescription = featureDescription;
	}
	public String getRate() {
		return Rate;
	}
	public void setRate(String rate) {
		Rate = rate;
	}
	public String getRoomState() {
		return RoomState;
	}
	public void setRoomState(String roomState) {
		RoomState = roomState;
	}
	public String getRoomStateDescription() {
		return RoomStateDescription;
	}
	public void setRoomStateDescription(String roomStateDescription) {
		RoomStateDescription = roomStateDescription;
	}
	
}