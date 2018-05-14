package com.cn.umessage.dao.lock.keyu;

import java.util.Date;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public interface KeYuCard extends StdCallLibrary {

	KeYuCard instance = (KeYuCard) Native.loadLibrary("HUNERF", KeYuCard.class);

	/**
	 * 写卡
	 * 
	 * @param Com
	 *            发卡机与计算机所连接的串口号
	 * @param Nblock
	 *            RF读卡器类型，4
	 * @param Encrypt
	 *            1
	 * @param CardPass
	 *            房卡密码
	 * @param SystemCode
	 *            系统编码
	 * @param HotelCode
	 *            酒店编码
	 * @param SDIn
	 *            入住日期 格式“yy-mm-dd”，不能用“yyyy-mm-dd”
	 * @param STIn
	 *            入住时间 ，格式“hh:nn:ss”
	 * @param SDOut
	 *            终止日期，格式“yy-mm-dd”，不能用“yyyy-mm-dd”
	 * @param STOut
	 *            终止时间，格式“hh:nn:ss”
	 * @param LEVEL_Pass
	 *            3
	 * @param PassMode
	 *            1
	 * @param AddressMode
	 *            1
	 * @param AddressQty
	 *            1
	 * @param TimeMode
	 *            0
	 * @param V8
	 *            255
	 * @param V16
	 *            255
	 * @param V24
	 *            255
	 * @param AlwaysOpen
	 *            0
	 * @param OpenBolt
	 *            0
	 * @param TerminateOld
	 *            0
	 * @param ValidTimes
	 *            255
	 * @return
	 */
	public int KeyCard(int Com, int CardNo, int nBlock, int Encrypt,
			byte[] CardPass, byte[] SystemCode, byte[] HotelCode, byte[] Pass,
			byte[] Address, byte[] SDIn, byte[] STIn, byte[] SDOut,
			byte[] STOut, int LEVEL_Pass, int PassMode, int AddressMode,
			int AddressQty, int TimeMode, int V8, int V16, int V24,
			int AlwaysOpen, int OpenBolt, int TerminateOld, int ValidTimes);

	/**
	 * 读卡
	 * 
	 * @param Com
	 *            发卡机与计算机所连接的串口号
	 * @param nBlock
	 *            4
	 * @param Encrypt
	 * @param DBCardno
	 * @param DBCardtype
	 * @param DBPassLevel
	 * @param CardPass
	 * @param DBSystemcode
	 * @param DBAddress
	 * @param SDateTime
	 * @return
	 */

	public int ReadMessage(int Com, int nBlock, int Encrypt, int[] DBCardno,
			int[] DBCardtype, int[] DBPassLevel, byte[] CardPass,
			byte[] DBSystemcode, byte[] DBAddress, byte[] SDateTime);

	public int ReadMessage(int Com, int nBlock, int Encrypt, int[] DBCardno,
			int[] DBCardtype, int[] DBPassLevel, String CardPass,
			String DBSystemcode, String DBAddress, String SDateTime);
}
