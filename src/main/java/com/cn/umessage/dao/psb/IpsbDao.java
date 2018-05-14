package com.cn.umessage.dao.psb;

import com.cn.umessage.dao.psb.bean.GuestBean;
import com.cn.umessage.dao.psb.bean.GuestBeanCheckOut;

/**
 * psb接口
 * @author cyw
 *
 */
public interface IpsbDao {
	/**
	 * 入住上传客人信息
	 */
	public String checkInUpload(GuestBean guest);
	/**
	 * 退房上传信息
	 */
	public String checkOutUpload(GuestBeanCheckOut checkOutBean);
}
