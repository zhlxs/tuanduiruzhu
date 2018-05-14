package com.cn.umessage.service;

import com.cn.umessage.pojo.RoomIdentityInfo;

public interface IRoomIdentityInfoService {

	int insert(RoomIdentityInfo roomIdentityInfo);

	RoomIdentityInfo getRoomOrderInfoById(int kahao);
	
}
