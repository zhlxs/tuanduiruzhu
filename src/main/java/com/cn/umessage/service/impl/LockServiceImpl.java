package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.lock.ILockDao;
import com.cn.umessage.service.ILockService;
import com.cn.umessage.utils.InitConfig;

@Service("lockService")
public class LockServiceImpl implements ILockService {
	@Resource
	private ILockDao btLockDao;
	@Resource
	private ILockDao keyuLockDao;

	@Override
	public String read() {
		// TODO Auto-generated method stub
		String result = "";
		String lockName = InitConfig.LOCK_COMPANY;
		switch (lockName) {
		case "bt":
			result = btLockDao.read();
			break;
		case "keyu":
			result = keyuLockDao.read();
			break;
		}
		return result;
	}

	@Override
	public boolean write(String roomId, String begin, String end) {
		// TODO Auto-generated method stub
		boolean result = false;
		String lockName = InitConfig.LOCK_COMPANY;
		switch (lockName) {
		case "bt":
			result = btLockDao.write(roomId, begin, end);
			break;
		case "keyu":
			result = keyuLockDao.write(roomId, begin, end);
			break;
		}
		return result;
	}

}
