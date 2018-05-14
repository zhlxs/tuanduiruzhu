package com.cn.umessage.service;

/**
 * 门锁服务
 * 
 * @author hyj
 * 
 */
public interface ILockService {
	/**
	 * 读卡
	 * 
	 * @return 房间号
	 */
	public String read();

	/**
	 * 写卡
	 * 
	 * @param inDate
	 * @param inTime
	 * @param outDate
	 * @param outTime
	 * @return 是否成功
	 */
	public boolean write(String roomId, String begin, String end);
}
