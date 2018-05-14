package com.cn.umessage.dao.card;

import com.cn.umessage.pojo.IdCard;

/**
 * 身份证读取接口 已接入品牌：新中新、华大
 * 
 * @author hyj
 * 
 */
public interface ICardDao {
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
