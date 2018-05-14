package com.cn.umessage.service;

import com.cn.umessage.pojo.IdCard;

/**
 * 身份证服务
 * 
 * @author hyj
 * 
 */
public interface ICardService {
	/**
	 * 打开端口
	 * 
	 * @return
	 */
	public boolean openPort();

	/**
	 * 关闭端口
	 * 
	 * @return
	 */
	public boolean closePort();

	/**
	 * 检测是否放身份证
	 * 
	 * @return
	 */
	public boolean check();

	/**
	 * 读取身份证信息
	 * 
	 * @return
	 */
	public IdCard read();
}
