package com.cn.umessage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.cn.umessage.dao.AdvertisingMapper;
import com.cn.umessage.pojo.Advertising;
import com.cn.umessage.service.IAdvertisingService;

@Service("advertisingService")
public class AdvertisingServiceImpl implements IAdvertisingService{
  
	@Resource
	private AdvertisingMapper advertisingDao;
	@Override
	public List<Advertising> selectAll() {
		// TODO Auto-generated method stub
		return advertisingDao.selectAll();
	}

}
