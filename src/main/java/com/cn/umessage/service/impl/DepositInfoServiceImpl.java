package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.DepositInfoMapper;
import com.cn.umessage.pojo.DepositInfo;
import com.cn.umessage.service.IDepositInfoService;
@Service("depositInfoService")
public class DepositInfoServiceImpl implements IDepositInfoService{

	@Resource
	public DepositInfoMapper depositInfoDao;
	@Override
	public int insert(DepositInfo record) {
		// TODO Auto-generated method stub
		return depositInfoDao.insert(record);
	}
	@Override
	public DepositInfo selectByPrimaryKey(String accnt) {
		// TODO Auto-generated method stub
		return depositInfoDao.selectByPrimaryKey(accnt);
	}

}
