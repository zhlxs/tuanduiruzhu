package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.RoomIdentityInfoMapper;
import com.cn.umessage.pojo.RoomIdentityInfo;
import com.cn.umessage.pojo.RoomOrderInfo;
import com.cn.umessage.service.IRoomIdentityInfoService;

@Service("roomIdentityInfoService")
public class RoomIdentityInfoServiceImpl implements IRoomIdentityInfoService{
    @Resource
    public RoomIdentityInfoMapper roomIdentityInfoMapper;

	@Override
	public int insert(RoomIdentityInfo roomIdentityInfo) {
		return roomIdentityInfoMapper.insert(roomIdentityInfo);
		
	}

	@Override
	public RoomIdentityInfo getRoomOrderInfoById(int kahao) {
		// TODO Auto-generated method stub
		return roomIdentityInfoMapper.selectByPrimaryKey(kahao);
	}
	

}
