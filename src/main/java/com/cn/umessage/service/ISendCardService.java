package com.cn.umessage.service;

/**
 * 收发卡器服务
 * 
 * @author hyj
 * 
 */
public interface ISendCardService {
	/**
	 * 判断卡槽是否有卡
	 * 
	 * @return
	 */
	public boolean isHasCard();

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
	 * 出卡
	 * 
	 * @return
	 */
	public boolean outCard();

	/**
	 * 入卡
	 * 
	 * @return
	 */
	public boolean inCard();

	/**
	 * 回收卡
	 * 
	 * @return
	 */
	public boolean recycling();

	/**
	 * 判断通道是否有卡
	 * 
	 * @return
	 */
	public boolean isChannelAvail();

	/**
	 * 判断卡槽是否已满
	 * 
	 * @return
	 */
	public boolean isRecycleAvail();

	/**
	 * 将卡移到IC卡位读写卡
	 * 
	 * @return
	 */
	public boolean moveCard();

	/**
	 * 禁止出卡口进卡
	 * 
	 * @return
	 */
	boolean notAllowInCard();
}
