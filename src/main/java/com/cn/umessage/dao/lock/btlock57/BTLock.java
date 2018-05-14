package com.cn.umessage.dao.lock.btlock57;

public class BTLock {

	private BTLock() {
	}

	private static BTLock instance = null;

	public static BTLock getInstance() {

		if (instance == null) {
			instance = new BTLock();
		}
		return instance;
	}

	public int OpenCardPort() {
		byte port = 0;
		byte readerType = 5;
		byte alarmCount = 1;
		int y = BTCard.instance.Reader_Alarm(port, readerType, alarmCount);
		System.out.println("打开必达锁！" + y);
		return 1;
	}

	public int Alarm(byte readerType, byte port) {
		byte alarmCount = 1;
		int y = BTCard.instance.Reader_Alarm(port, readerType, alarmCount);
		// System.out.println("打开必达锁！"+y);
		return 1;
	}

	/* 读取卡机序号 */
	public int ReadSnr(int port, int readerType, byte[] Snr) {
		int y = BTCard.instance.Read_Snr(port, readerType, Snr);
		// System.out.println("打开必达锁！"+y);
		return 1;
	}

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
	public int WriteGuestCard(byte port, byte readerType, byte sectorNo,
			String hotelPwd, int cardNo, int guestSn, int guestIdx,
			byte[] doorId, byte[] suitDoor, byte[] pubDoor, byte[] beginTime,
			byte[] endTime) {

		int y = BTCard.instance.Write_Guest_Card(port, readerType, sectorNo,
				hotelPwd, cardNo, guestSn, guestIdx, doorId, suitDoor, pubDoor,
				beginTime, endTime);

		if (y == 0) {
			Alarm(readerType, port);
		}

		return y;
	}

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
			byte[] endTime) {

		int y = BTCard.instance.Read_Guest_Card(port, readerType, sectorNo,
				hotelPwd, cardNo, guestSn, guestIdx, doorId, suitDoor, pubDoor,
				beginTime, endTime);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

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
			byte maxLiftAddr, byte[] beginTime, byte[] endTime, byte[] liftData) {

		int y = BTCard.instance.Write_Guest_Lift(port, readerType, sectorNo,
				hotelPwd, cardNo, beginAddr, endAddr, maxLiftAddr, beginTime,
				endTime, liftData);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

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
	 * @param cardNo
	 *            宾客卡号（范围 1------4294967296）
	 * @param beginAddr
	 *            电梯所用的卡上起始地址
	 * @param endAddr
	 *            电梯所用的卡上结束地址
	 * @param beginTime
	 *            有效起始时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param endTime
	 *            有效终止时间，长度为10，时间格式“年年月月日日时时分分”
	 * @param liftData
	 *            电梯控制信息，即宾客卡可使用的电梯控制串码（只对一台电梯），为十六进制字符串为：“C300”
	 * @return
	 */
	public int Read_Guest_Lift(byte port, byte readerType, byte sectorNo,
			String hotelPwd, byte[] cardNo, byte beginAddr, byte endAddr,
			byte[] beginTime, byte[] endTime, byte[] liftData) {

		int y = BTCard.instance.Read_Guest_Lift(port, readerType, sectorNo,
				hotelPwd, beginAddr, endAddr, cardNo, beginTime, endTime,
				liftData);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

	/**
	 * 写取电开关信息
	 * 
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
			byte[] DoorID, byte[] GuestName, byte[] beginTime, byte[] endTime) {

		int y = BTCard.instance.Write_Guest_PowerSwitch(port, readerType,
				sectorNo, PowerSwitchPwd, cardNo, GuestSex, DoorID, GuestName,
				beginTime, endTime);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

	/**
	 * 读取电开关信息
	 * 
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
			byte[] endTime) {

		int y = BTCard.instance.Read_Guest_PowerSwitch(port, readerType,
				sectorNo, PowerSwitchPwd, cardNo, GuestSex, DoorID, GuestName,
				beginTime, endTime);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

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
			String SectorPwd, byte[] Data) {

		int y = BTCard.instance.Write_Data(port, readerType, sectorNo,
				SectorPwd, Data);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

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
			String SectorPwd, byte[] Data) {

		int y = BTCard.instance.Read_Data(port, readerType, sectorNo,
				SectorPwd, Data);

		if (y == 0) {

			Alarm(readerType, port);

		}

		return y;

	}

	public void CloseCardPort() {

	}

	public int SerialNo_FromNow() {
		return BTCard.instance.SerialNo_FromNow();
	}

	public static void main(String[] args) {
		// int m = XhbdLock.getInstance().OpenCardPort();
		// System.out.println("OpenCardPort: " + m);
		// String s = "410190326";
		// System.out.println(new Date().getTime());
		// int i = 557693759;
		// byte b = 55;
		// int r = 8015;
		// s = "00"+8015;
		// byte[] bs = s.getBytes();
		// System.out.println(bs.length);
		// System.out.println(bs[0]);
		// System.out.println(bs[1]);
		// System.out.println(bs[2]);
		// System.out.println(bs[3]);
		// System.out.println(bs[4]);
		// System.out.println(bs[5]);
		// System.out.println(new String(bs));
		// byte[] ALockNo = new byte[2];
		// byte AStartSuite = 0;
		// byte AEndSuite = 0;
		// byte[] ACardID = new byte[2];
		// byte ASubCardID = 0;
		// byte[] ATime = new byte[10];
		// int x = XhbdCard.instance.Read_Guest_Card(2, 44, 1, 5, 0, "15948577",
		// ALockNo, AStartSuite, AEndSuite, ACardID, ASubCardID, ATime);
		// System.out.println(x);
	}
}
/**
 * short port = 0; short readerType = 5; short sectorNo = 0; String HotelPwd =
 * "170518"; byte[] CardNo = new byte[4]; byte[] GuestSN = new byte[4]; byte[]
 * GuestIdx = new byte[4]; byte[] DoorID = new byte[6]; byte[] SuitDoor = new
 * byte[4]; byte[] PubDoor = new byte[8]; byte[] BeginTime = new byte[12];
 * byte[] EndTime = new byte[12]; int x =
 * XhbdCard.instance.Read_Guest_Card(port, readerType, sectorNo, HotelPwd,
 * ClientID, CardNo, GuestSN, GuestIdx, DoorID, SuitDoor, PubDoor, BeginTime,
 * EndTime);
 * System.out.println("读写x:"+x+"DoorID:"+DoorID[0]+' '+DoorID[1]+' '+DoorID
 * [2]+' '+DoorID[3]+' '+DoorID[4]+' '+DoorID[5]+' ');
 * System.out.println("开始时间："
 * +BeginTime[0]+' '+BeginTime[1]+' '+BeginTime[2]+' '+
 * BeginTime[3]+' '+BeginTime[4]+' '+BeginTime[5]+' '+BeginTime[6]+' '
 * +BeginTime
 * [7]+' '+BeginTime[8]+' '+BeginTime[9]+' '+BeginTime[10]+' '+BeginTime
 * [11]+' ');
 * System.out.println("结苏时间："+EndTime[0]+' '+EndTime[1]+' '+EndTime[2]
 * +' '+EndTime[3]+' '+EndTime[4]+' '+EndTime[5]+' '+EndTime[6]+' '
 * +EndTime[7]+' '
 * +EndTime[8]+' '+EndTime[9]+' '+EndTime[10]+' '+EndTime[11]+' '); int y =
 * getInt(CardNo,0); System.out.println("=========="+y); System.out.println();
 * return x;
 **/
/*
 * byte[] doorId = "008015".getBytes(); byte[] suitDoor = "0000".getBytes();
 * byte[] pubDoor = "00000000".getBytes(); String start =
 * DateUtils.formatDate(new Date(),"yyMMddHHmm"); String end =
 * DateUtils.formatDate(DateUtils.toDate(time),"yyMMddHHmm"); byte[] beginTime =
 * start.getBytes(); byte[] endTime = end.getBytes(); byte[] dataSource =
 * "192.168.1.210".getBytes(); byte[] userId = "sa".getBytes(); byte[] password
 * = "4321".getBytes(); int brand = 1;
 */