package com.cn.umessage.service;

import com.cn.umessage.pojo.RoomOrderInfo;

public interface IRoomOrderInfoService {
	 RoomOrderInfo selectByPrimaryKey(Integer id);
	 
	 int insert(RoomOrderInfo record);
}
