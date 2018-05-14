package com.cn.umessage.dao.lock.btlock57;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public interface BTCard extends StdCallLibrary {

	BTCard instance = (BTCard) Native.loadLibrary("E:\\DLL\\btlock57L",
			BTCard.class);

	/* 卡机蜂鸣 */
	public int Reader_Alarm(byte port, byte readerType, byte alarmCount);

	/* 读取卡机序号 */
	public int Read_Snr(int port, int readerType, byte[] Snr);

	/**
	 * 写卡
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param hotelPwd
	 *            酒店密码 (6位字符串，字符串内容为ASCII码字符)
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param guestSn
	 *            宾客流水号（范围 1------4294967296）
	 * @param guestIdx
	 *            宾客序号（范围 1------255）
	 * @param doorId
	 *            房间号 (6位字符串)
	 * @param suitDoor
	 *            套房内门选号,为十六进制字符串为：“00C3”
	 * @param pubDoor
	 *            公共门选号,为十六进制字符串为：“00004081”
	 * @param beginTime
	 *            有效起始时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param endTime
	 *            有效终止时间，长度为10，时间格式“年年月月日日时时分分”
	 * @return
	 */
	public int Write_Guest_Card(byte port, byte readerType, byte sectorNo,
			String hotelPwd, int cardNo, int guestSn, int guestIdx,
			byte[] doorId, byte[] suitDoor, byte[] pubDoor, byte[] beginTime,
			byte[] endTime);

	/**
	 * 读卡
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param hotelPwd
	 *            酒店密码 (6位字符串，字符串内容为ASCII码字符)
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param guestSn
	 *            宾客流水号（范围 1------4294967296）
	 * @param guestIdx
	 *            宾客序号（范围 1------255）
	 * @param doorId
	 *            房间号 (6位字符串)
	 * @param suitDoor
	 *            套房内门选号,为十六进制字符串为：“00C3”
	 * @param pubDoor
	 *            公共门选号,为十六进制字符串为：“00004081”
	 * @param beginTime
	 *            有效起始时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param endTime
	 *            有效终止时间，长度为10，时间格式“年年月月日日时时分分”
	 * @return
	 */
	public int Read_Guest_Card(byte port, byte readerType, byte sectorNo,
			String hotelPwd, byte[] cardNo, byte[] guestSn, byte[] guestIdx,
			byte[] doorId, byte[] suitDoor, byte[] pubDoor, byte[] beginTime,
			byte[] endTime);

	/**
	 * 写电梯控制信息
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param hotelPwd
	 *            酒店密码 (6位字符串，字符串内容为ASCII码字符)
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param beginAddr
	 *            电梯所用的卡上起始地址
	 * @param endAddr
	 *            电梯所用的卡上结束地址
	 * @param maxLiftAddr
	 *            所有电梯使用最大的结束地址
	 * @param beginTime
	 *            有效起始时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param endTime
	 *            有效终止时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param liftData
	 *            电梯控制信息，即宾客卡可使用的电梯控制串码（只对一台电梯），为十六进制字符串为：“C300”
	 * @return
	 */
	public int Write_Guest_Lift(byte port, byte readerType, byte sectorNo,
			String hotelPwd, int cardNo, byte beginAddr, byte endAddr,
			byte maxLiftAddr, byte[] beginTime, byte[] endTime, byte[] liftData);

	/**
	 * 读电梯控制信息
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param hotelPwd
	 *            酒店密码 (6位字符串，字符串内容为ASCII码字符)
	 * @param beginAddr
	 *            电梯所用的卡上起始地址
	 * @param endAddr
	 *            电梯所用的卡上结束地址
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param beginTime
	 *            有效起始时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param endTime
	 *            有效终止时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param liftData
	 *            电梯控制信息，即宾客卡可使用的电梯控制串码（只对一台电梯），为十六进制字符串为：“C300”
	 * @return
	 */
	public int Read_Guest_Lift(byte port, byte readerType, byte sectorNo,
			String hotelPwd, byte beginAddr, byte endAddr, byte[] cardNo,
			byte[] beginTime, byte[] endTime, byte[] liftData);

	/**
	 * 写取电开关信息
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param PowerSwitchPwd
	 *            取电开关密码 (12位字符串，字符串内容为十六进制码字符)
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param GuestSex
	 *            宾客性别，0：男，1：女
	 * @param DoorID
	 *            房间号 (6位字符串)
	 * @param GuestName
	 *            宾客姓名（8位字符串）
	 * @param beginTime
	 *            有效起始时间，长度为12，时间格式“年年月月日日时时分分秒秒”
	 * @param endTime
	 *            有效终止时间，长度为12，时间格式“年年月月日日时时分分秒秒”
	 * @return
	 */
	public int Write_Guest_PowerSwitch(byte port, byte readerType,
			byte sectorNo, String PowerSwitchPwd, int cardNo, int GuestSex,
			byte[] DoorID, byte[] GuestName, byte[] beginTime, byte[] endTime);

	/**
	 * 读取电开关信息
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param PowerSwitchPwd
	 *            取电开关密码 (12位字符串，字符串内容为十六进制码字符)
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param GuestSex
	 *            宾客性别，0：男，1：女
	 * @param DoorID
	 *            房间号 (6位字符串)
	 * @param GuestName
	 *            宾客姓名（8位字符串）
	 * @param beginTime
	 *            有效起始时间，长度为12，时间格式“年年月月日日时时分分秒秒”
	 * @param endTime
	 *            有效终止时间，长度为12，时间格式“年年月月日日时时分分秒秒”
	 * @return
	 */
	public int Read_Guest_PowerSwitch(byte port, byte readerType,
			byte sectorNo, String PowerSwitchPwd, byte[] cardNo,
			byte[] GuestSex, byte[] DoorID, byte[] GuestName, byte[] beginTime,
			byte[] endTime);

	/**
	 * 写其它扇区数据
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param SectorPwd
	 *            扇区密码 (12位字符串，字符串内容为16进制数字符串)
	 * @param Data
	 *            写入数据，长度为32，数据为16进制数字符串
	 * @return
	 */
	public int Write_Data(byte port, byte readerType, byte sectorNo,
			String SectorPwd, byte[] Data);

	/**
	 * 读其它扇区数据
	 * 
	 * @param port
	 *            串口号
	 * @param readerType
	 *            MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41 ；5：RW-49A
	 * @param sectorNo
	 *            MF1S50卡使用扇区号（范围0------15）
	 * @param SectorPwd
	 *            扇区密码 (12位字符串，字符串内容为16进制数字符串)
	 * @param Data
	 *            写入数据，长度为32，数据为16进制数字符串
	 * @return
	 */
	public int Read_Data(byte port, byte readerType, byte sectorNo,
			String SectorPwd, byte[] Data);

	/**
	 * Write_Guest_PowerSwitch(Port, ReaderType, SectorNo: Byte; PowerSwitchPwd:
	 * PChar; CardNo, GuestSex: Integer; DoorID,GuestName, BeginTime, EndTime:
	 * PChar; PowerSwitchType: Byte): Integer;
	 */

	public int SerialNo_FromNow();
}
/**
 * byte -> int pchar -> byte[] integer - > int 参数说明：
 * Port：通讯口号1、2、3、4分别代表串口COM1、COM2、COM3、COM4（范围 1------4）。
 * 当使用的读卡器为USB设备时，通迅口号不生效。
 * 
 * ReaderType：MF读卡器类型，1：RW-21；2：RW-33；3：RW-26D；4：RW-41；5：RW-49。 5
 * 
 * DataBaseType：数据库类型，0：SQL数据库；1：ACCESS数据库。 1
 * 
 * DoorID：房间号 (6位字符串)。
 * 
 * SuitDoor：套房内门选号，即宾客卡能够开启的多个套房内门的代号串，长度为4，
 * 默认值为“0000”。宾客卡最多能够同时开启16个套房内门及1个套房大门
 * 。如果门锁系统中存在两个或以上前6位门锁代号相同的房间，则该系统设置了套房。如果门锁系统没有设置套房或者不需要开启套房内门
 * （宾客卡一定能开启套房外门），则可以填写默认值
 * “0000”。算法：从右至左按位判断是否能够开启对应序号的套房内门，如果能够开启则置1，否则置0。最后再合并成十六进制的字符串
 * 。举例：宾客卡可以开启01、02、07、08号套房内门，则置位二进制字符串为：“0000 0000 1100
 * 0011”，转化为十六进制字符串为：“00C3”。
 * PubDoor：公共门选号，即宾客卡能够开启的多种公共门的代号串，长度为8，默认值为“00000000”
 * 。宾客卡最多能同时开启32种公共门。如果系统没有设置公共门或者不需要开启公共门
 * ，则可以填写默认值“00000000”。从右至左按位判断是否能够开启对应序号的公共门
 * ，如果能够开启则置1，否则置0。最后再合并成十六进制的字符串。宾客卡可以开启01、08、15号公共门，则置位二进制字符串为：“0000 0000 0000
 * 0000 0100 0000 1000 0001”，转化为十六进制字符串为：“00004081”。
 * 
 * BeginTime：有效起始时间，长度为10，时间格式“年年月月日日时时分分”。
 * 
 * EndTime：有效终止时间，长度为10，时间格式“年年月月日日时时分分”。
 * 
 * DataSource：服务器名称。
 * 
 * UserID：登陆数据库服务器的用户名。
 * 
 * Password：登陆数据库服务器的密码。
 * 
 * Brand：版本类型，0：普通版V5.7软件；1：加密版V5.7软件。
 ***/
/**
 * 0：表示成功； 255：表示不成功； 1：打开串口错误； 2：无卡错误； 3：卡类型错误； 4：读卡错误； 5：酒店密码错误； 6：写卡错误；
 * 7：数据库连接失败； 8：房间代号不存在； 9：房卡与房号错误； 10：系统忙； 11：房态错误； 12：客房已满； 13：修改密码失败；
 * 14：该卡不是客人卡； 15：该卡不是无效卡，未制过卡； 16：客户标识非法； 17：注册过期； 18：找不到加密狗。
 * 
 * 
 * 
 */
