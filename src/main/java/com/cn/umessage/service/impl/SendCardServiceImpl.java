package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.sendcard.ISendCardDao;
import com.cn.umessage.service.ISendCardService;
import com.cn.umessage.utils.InitConfig;

@Service("sendCardService")
public class SendCardServiceImpl implements ISendCardService {
	@Resource
	private ISendCardDao crtSendCardDao;

	@Override
	public boolean isHasCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.isHasCard();
			break;
		}
		return result;
	}

	@Override
	public boolean openPort() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.openPort();
			break;
		}
		return result;
	}

	@Override
	public boolean closePort() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.closePort();
			break;
		}
		return result;
	}

	@Override
	public boolean outCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.outCard();
			break;
		}
		return result;
	}

	@Override
	public boolean inCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.inCard();
			break;
		}
		return result;
	}

	@Override
	public boolean recycling() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.recycling();
			break;
		}
		return result;
	}

	@Override
	public boolean isChannelAvail() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.isChannelAvail();
			break;
		}
		return result;
	}

	@Override
	public boolean moveCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.moveCard();
			break;
		}
		return result;
	}

	@Override
	public boolean isRecycleAvail() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.isRecycleAvail();
			break;
		}
		return result;
	}

	@Override
	public boolean notAllowInCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		String sendcardName = InitConfig.SENDCARD_COMPANY;
		switch (sendcardName) {
		case "crt":
			result = crtSendCardDao.notAllowInCard();
			break;
		}
		return result;
	}

}
