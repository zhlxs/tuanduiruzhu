package com.cn.umessage.dao.lock;

/**
 * 门锁接口 已接入品牌：必达、科裕
 * 
 * @author hyj
 * 
 */
public interface ILockDao {
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
