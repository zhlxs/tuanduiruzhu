package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.card.ICardDao;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.service.ICardService;
import com.cn.umessage.utils.InitConfig;

@Service("cardService")
public class CardServiceImpl implements ICardService {

	@Resource
	private ICardDao hdCardDao;
	@Resource
	private ICardDao xzxCardDao;

	@Override
	public boolean openPort() {
		// TODO Auto-generated method stub
		boolean result = false;
		String cardName = InitConfig.CARD_COMPANY;
		switch (cardName) {
		case "hd":
			result = hdCardDao.openPort();
			break;
		case "xzx":
			result = xzxCardDao.openPort();
			break;
		}
		return result;
	}

	@Override
	public boolean closePort() {
		// TODO Auto-generated method stub
		boolean result = false;
		String cardName = InitConfig.CARD_COMPANY;
		switch (cardName) {
		case "hd":
			result = hdCardDao.closePort();
			break;
		case "xzx":
			result = xzxCardDao.closePort();
			break;
		}
		return result;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		boolean result = false;
		String cardName = InitConfig.CARD_COMPANY;
		switch (cardName) {
		case "hd":
			result = hdCardDao.check();
			break;
		case "xzx":
			result = xzxCardDao.check();
			break;
		}
		return result;
	}

	@Override
	public IdCard read() {
		// TODO Auto-generated method stub
		IdCard idCard = new IdCard();
		String cardName = InitConfig.CARD_COMPANY;
		switch (cardName) {
		case "hd":
			idCard = hdCardDao.read();
			break;
		case "xzx":
			idCard = xzxCardDao.read();
			break;
		}
		return idCard;
	}

}
