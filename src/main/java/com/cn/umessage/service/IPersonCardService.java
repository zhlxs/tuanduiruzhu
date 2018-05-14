package com.cn.umessage.service;

import com.cn.umessage.pojo.IdCard;

public interface IPersonCardService {
	/**
	 * 采集照片
	 */
	public void savePhoto(String cardNo, String str, String orderNo, String type);

	/**
	 * 比对照片
	 */
	public boolean Comparison(String cardNo, String orderNo, String type, IdCard idCard);
}
