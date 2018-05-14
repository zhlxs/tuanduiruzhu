package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.RoomOrderInfoMapper;
import com.cn.umessage.pojo.RoomOrderInfo;
import com.cn.umessage.service.IRoomOrderInfoService;

@Service("roomOrderInfoService")
public class RoomOrderInfoServiceImpl implements IRoomOrderInfoService{
    @Resource
    public RoomOrderInfoMapper roomOrderInfoDao;
	@Override
	public RoomOrderInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return roomOrderInfoDao.selectByPrimaryKey(id);
	}
	@Override
	public int insert(RoomOrderInfo record) {
		// TODO Auto-generated method stub
		return roomOrderInfoDao.insert(record);
	}

}
