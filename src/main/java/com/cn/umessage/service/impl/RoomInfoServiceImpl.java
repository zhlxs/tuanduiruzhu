package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.RoomInfoMapper;
import com.cn.umessage.pojo.RoomInfo;
import com.cn.umessage.service.IRoomInfoService;
@Service("roomInfoService")
public class RoomInfoServiceImpl implements IRoomInfoService{
@Resource
private RoomInfoMapper roomInfoDao;
	@Override
	public RoomInfo selectByRoomno(String roomno) {
		// TODO Auto-generated method stub
		return roomInfoDao.selectByRoomno(roomno);
	}

}
