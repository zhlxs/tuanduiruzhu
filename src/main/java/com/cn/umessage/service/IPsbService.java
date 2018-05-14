package com.cn.umessage.service;

import com.cn.umessage.dao.psb.bean.GuestBean;
import com.cn.umessage.dao.psb.bean.GuestBeanCheckOut;

public interface IPsbService {
	/**
	 * 入住上传客人信息
	 */
	public String checkInUpload(GuestBean guest);
	/**
	 * 退房上传信息
	 */
	public String checkOutUpload(GuestBeanCheckOut checkOutBean);
}
