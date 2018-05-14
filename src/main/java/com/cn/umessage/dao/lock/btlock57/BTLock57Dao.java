package com.cn.umessage.dao.lock.btlock57;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.lock.ILockDao;
import com.cn.umessage.utils.InitConfig;

@Service("btLockDao")
public class BTLock57Dao implements ILockDao {

	private static BTLock xhbdLock = null;

	static {

		xhbdLock = BTLock.getInstance();

	}

	public static void main(String[] args) {

		byte port = Byte.parseByte("1");// 通讯com口号
		byte readerType = Byte.parseByte("5");// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
												// ；5：RW-49A
		byte sectorNo = Byte.parseByte("0");// MF1S50卡使用扇区号（范围0------15）
		String hotelPwd = "201512";// 酒店密码 (6位字符串，字符串内容为ASCII码字符)
		System.out.println(port);

		// 写卡测试
		// writeGuestCard();

		// 读卡测试
		// readGuestCard();

		// 写电梯控制信息测试
		// writeGuestLift();

		// 读电梯控制信息测试
		// readGuestLift();

		// 写取电开关信息
		// writeGuestPowerSwitch();

		// 读取电开关信息
		// readGuestPowerSwitch();

		// 写其它扇区数据测试
		// writeData();

		// 读其它扇区数据
		// readData();

	}

	/**
	 * 写卡测试
	 */
	public boolean write(String roomId, String begin, String end) {

		byte port = Byte.parseByte(InitConfig.BT_PORT);// 通讯com口号
		byte readerType = Byte.parseByte(InitConfig.BT_READERTYPE);// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
																	// ；5：RW-49A
		byte sectorNo = Byte.parseByte(InitConfig.BT_SECTORNO);// MF1S50卡使用扇区号（范围0------15）
		String hotelPwd = InitConfig.BT_HOTELPWD;// 酒店密码 (6位字符串，字符串内容为ASCII码字符)
		int cardNo = serialNo_FromNow();// 宾客卡号（范围 1------4294967296）
		int guestSn = serialNo_FromNow();// 宾客流水号（范围 1------4294967296）
		int guestIdx = 1;// 宾客序号（范围 1------255）
		byte[] doorId = roomId.getBytes();// 房间号 (6位字符串)
		byte[] suitDoor = "00C3".getBytes();// 套房内门选号,为十六进制字符串为：“00C3”
		byte[] pubDoor = "00004081".getBytes();// 公共门选号,为十六进制字符串为：“00004081”
		byte[] beginTime = begin.getBytes();// 有效起始时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] endTime = end.getBytes();// 有效终止时间，长度为10，时间格式“年年月月日日时时分分”

		int res = xhbdLock.WriteGuestCard(port, readerType, sectorNo, hotelPwd,
				cardNo, guestSn, guestIdx, doorId, suitDoor, pubDoor,
				beginTime, endTime);

		System.out.println("写卡代码：" + res);
		if (res == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 读卡测试
	 */
	public int readGuestCard() {

		byte port = Byte.parseByte(InitConfig.BT_PORT);// 通讯com口号
		byte readerType = Byte.parseByte(InitConfig.BT_READERTYPE);// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
																	// ；5：RW-49A
		byte sectorNo = Byte.parseByte(InitConfig.BT_SECTORNO);// MF1S50卡使用扇区号（范围0------15）
		String hotelPwd = InitConfig.BT_HOTELPWD;// 酒店密码 (6位字符串，字符串内容为ASCII码字符)
		byte[] cardNo = new byte[4];// 宾客卡号（范围 1------4294967296）
		byte[] guestSn = new byte[4];// 宾客流水号（范围 1------4294967296）
		byte[] guestIdx = new byte[4];// 宾客序号（范围 1------255）
		byte[] doorId = new byte[6];// 房间号 (6位字符串)
		byte[] suitDoor = new byte[4];// 套房内门选号,为十六进制字符串为：“00C3”
		byte[] pubDoor = new byte[9];// 公共门选号,为十六进制字符串为：“00004081”
		byte[] beginTime = new byte[10];// 有效起始时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] endTime = new byte[10];// 有效终止时间，长度为10，时间格式“年年月月日日时时分分”

		int res = xhbdLock.Read_Guest_Card(port, readerType, sectorNo,
				hotelPwd, cardNo, guestSn, guestIdx, doorId, suitDoor, pubDoor,
				beginTime, endTime);

		System.out.println("读卡代码：" + res);

		if (res == 0) {

			// System.out.println("宾客卡号:" + getInt(cardNo));
			// System.out.println("宾客流水号:" + getInt(guestSn));
			// System.out.println("宾客序号:" + getInt(guestIdx));
			System.out.println("房间号:" + new String(doorId));

			// System.out.println("套房内门选号:" + new String(suitDoor));
			// System.out.println("公共门选号:" + new String(pubDoor));
			// System.out.println("有效起始时间:" + new String(beginTime));
			// System.out.println("有效终止时间:" + new String(endTime));

		}
		return res;

	}

	/**
	 * 读房卡返回房间号
	 */
	public String read() {

		byte port = Byte.parseByte(InitConfig.BT_PORT);// 通讯com口号
		byte readerType = Byte.parseByte(InitConfig.BT_READERTYPE);// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
																	// ；5：RW-49A
		byte sectorNo = Byte.parseByte(InitConfig.BT_SECTORNO);// MF1S50卡使用扇区号（范围0------15）
		String hotelPwd = InitConfig.BT_HOTELPWD;// 酒店密码 (6位字符串，字符串内容为ASCII码字符)
		byte[] cardNo = new byte[4];// 宾客卡号（范围 1------4294967296）
		byte[] guestSn = new byte[4];// 宾客流水号（范围 1------4294967296）
		byte[] guestIdx = new byte[4];// 宾客序号（范围 1------255）
		byte[] doorId = new byte[6];// 房间号 (6位字符串)
		byte[] suitDoor = new byte[4];// 套房内门选号,为十六进制字符串为：“00C3”
		byte[] pubDoor = new byte[9];// 公共门选号,为十六进制字符串为：“00004081”
		byte[] beginTime = new byte[10];// 有效起始时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] endTime = new byte[10];// 有效终止时间，长度为10，时间格式“年年月月日日时时分分”

		int res = xhbdLock.Read_Guest_Card(port, readerType, sectorNo,
				hotelPwd, cardNo, guestSn, guestIdx, doorId, suitDoor, pubDoor,
				beginTime, endTime);

		System.out.println("读卡代码：" + res);

		String roomNum = "";
		if (res == 0) {

			// System.out.println("宾客卡号:" + getInt(cardNo));
			// System.out.println("宾客流水号:" + getInt(guestSn));
			// System.out.println("宾客序号:" + getInt(guestIdx));
			System.out.println("房间号:" + new String(doorId));
			roomNum = new String(doorId);
			// System.out.println("套房内门选号:" + new String(suitDoor));
			// System.out.println("公共门选号:" + new String(pubDoor));
			// System.out.println("有效起始时间:" + new String(beginTime));
			// System.out.println("有效终止时间:" + new String(endTime));

		}
		return roomNum;

	}

	/**
	 * 写电梯控制信息测试
	 */
	private static void writeGuestLift() {

		byte port = 1;// 串口号
		byte readerType = 5;// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
							// ；5：RW-49A
		byte sectorNo = 0;// MF1S50卡使用扇区号（范围0------15）
		String hotelPwd = "201512";// 酒店密码 (6位字符串，字符串内容为ASCII码字符)
		int cardNo = 5678;// 宾客卡号（范围 1------4294967296）
		byte beginAddr = 96;// 电梯所用的卡上起始地址
		byte endAddr = 97;// 电梯所用的卡上结束地址
		byte maxLiftAddr = 97;// 所有电梯使用最大的结束地址
		byte[] beginTime = "1212201515".getBytes();// 有效起始时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] endTime = "1212211616".getBytes();// 有效终止时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] liftData = "C300".getBytes();// 电梯控制信息，即宾客卡可使用的电梯控制串码（只对一台电梯），为十六进制字符串为：“C300”

		int res = xhbdLock.Write_Guest_Lift(port, readerType, sectorNo,
				hotelPwd, cardNo, beginAddr, endAddr, maxLiftAddr, beginTime,
				endTime, liftData);

		System.out.println("写电梯控制信息错误代码：" + res);

	}

	/**
	 * 读电梯控制信息测试
	 */
	private static void readGuestLift() {

		byte port = 1;// 串口号
		byte readerType = 5;// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
							// ；5：RW-49A
		byte sectorNo = 0;// MF1S50卡使用扇区号（范围0------15）
		String hotelPwd = "201512";// 酒店密码 (6位字符串，字符串内容为ASCII码字符)
		byte[] cardNo = new byte[4];// 宾客卡号（范围 1------4294967296）
		byte beginAddr = 96;// 电梯所用的卡上起始地址
		byte endAddr = 97;// 电梯所用的卡上结束地址
		byte[] beginTime = new byte[10];// 有效起始时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] endTime = new byte[10];// 有效终止时间，长度为10，时间格式“年年月月日日时时分分”
		byte[] liftData = new byte[4];// 电梯控制信息，即宾客卡可使用的电梯控制串码（只对一台电梯），为十六进制字符串为：“C300”

		int res = xhbdLock.Read_Guest_Lift(port, readerType, sectorNo,
				hotelPwd, cardNo, beginAddr, endAddr, beginTime, endTime,
				liftData);

		System.out.println("读电梯控制信息错误代码：" + res);

		if (res == 0) {

			System.out.println("宾客卡号:" + getInt(cardNo));
			System.out.println("有效起始时间:" + new String(beginTime));
			System.out.println("有效终止时间:" + new String(endTime));
			System.out.println("电梯控制信息:" + new String(liftData));

		}

	}

	/**
	 * 写取电开关信息
	 */
	private static void writeGuestPowerSwitch() {

		byte port = 1;// 串口号
		byte readerType = 5;// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
							// ；5：RW-49A
		byte sectorNo = 15;// MF1S50卡使用扇区号（范围0------15）
		String PowerSwitchPwd = "FFFFFFFFFFFF";// 取电开关密码 (12位字符串，字符串内容为十六进制码字符)
		int cardNo = 5678;// 宾客卡号（范围 1------4294967296）
		int GuestSex = 1;// 宾客性别，0：男，1：女
		byte[] DoorID = "654321".getBytes();// 房间号 (6位字符串)
		byte[] GuestName = "abcdefgh".getBytes();// 宾客姓名（8位字符串）
		byte[] beginTime = "121221154734".getBytes();// 有效起始时间，长度为12，时间格式“年年月月日日时时分分秒秒”
		byte[] endTime = "121223174732".getBytes();// 有效终止时间，长度为12，时间格式“年年月月日日时时分分秒秒”

		int res = xhbdLock.Write_Guest_PowerSwitch(port, readerType, sectorNo,
				PowerSwitchPwd, cardNo, GuestSex, DoorID, GuestName, beginTime,
				endTime);

		System.out.println("写取电开关信息错误代码：" + res);

	}

	/**
	 * 读取电开关信息
	 */
	private static void readGuestPowerSwitch() {

		byte port = 1;// 串口号
		byte readerType = 5;// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
							// ；5：RW-49A
		byte sectorNo = 15;// MF1S50卡使用扇区号（范围0------15）
		String PowerSwitchPwd = "FFFFFFFFFFFF";// 取电开关密码 (12位字符串，字符串内容为十六进制码字符)
		byte[] cardNo = new byte[4];// 宾客卡号（范围 1------4294967296）
		byte[] GuestSex = new byte[1];// 宾客性别，0：男，1：女
		byte[] DoorID = new byte[12];// 房间号 (6位字符串)
		byte[] GuestName = new byte[16];// 宾客姓名（8位字符串）
		byte[] beginTime = new byte[12];// 有效起始时间，长度为12，时间格式“年年月月日日时时分分秒秒”
		byte[] endTime = new byte[12];// 有效终止时间，长度为12，时间格式“年年月月日日时时分分秒秒”

		int res = xhbdLock.Read_Guest_PowerSwitch(port, readerType, sectorNo,
				PowerSwitchPwd, cardNo, GuestSex, DoorID, GuestName, beginTime,
				endTime);

		System.out.println("读取电开关信息错误代码：" + res);

	}

	/**
	 * 写其它扇区数据测试
	 */
	private static void writeData() {

		byte port = 1;// 串口号
		byte readerType = 5;// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
							// ；5：RW-49A
		byte sectorNo = 15;// MF1S50卡使用扇区号（范围0------15）
		String SectorPwd = "FFFFFFFFFFFF";// 扇区密码 (12位字符串，字符串内容为16进制数字符串)
		byte[] Data = "0123456789ABCDEF0123456789ABCDEF".getBytes();// 写入数据，长度为32，数据为16进制数字符串

		int res = xhbdLock.Write_Data(port, readerType, sectorNo, SectorPwd,
				Data);

		System.out.println("写其它扇区数据错误代码：" + res);

	}

	/**
	 * 读其它扇区数据
	 */
	private static void readData() {

		byte port = 1;// 串口号
		byte readerType = 5;// MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
							// ；5：RW-49A
		byte sectorNo = 15;// MF1S50卡使用扇区号（范围0------15）
		String SectorPwd = "FFFFFFFFFFFF";// 扇区密码 (12位字符串，字符串内容为16进制数字符串)
		byte[] Data = new byte[32];// 写入数据，长度为32，数据为16进制数字符串

		int res = xhbdLock.Read_Data(port, readerType, sectorNo, SectorPwd,
				Data);

		System.out.println("读其它扇区数据错误代码：" + res);

	}

	/**
	 * 16进制byte转成10进制int
	 * 
	 * @param cardNo
	 * @return
	 */
	public static int getInt(byte[] bs) {

		// 调整排序
		byte[] bs2 = new byte[bs.length];
		for (int i = 0; i < bs2.length; i++) {

			bs2[i] = bs[bs.length - 1 - i];

		}

		// 转成十进制int
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bs2.length; i++) {

			sb.append(Integer.toHexString(bs2[i]));

		}
		long lg = Long.parseLong(sb.toString(), 16);
		int lgInt = (int) lg;

		return lgInt;

	}

	/**
	 * 通过本地电脑的时间换算出4个字节的整型流水号
	 * 
	 * @return
	 */
	public static int serialNo_FromNow() {
		return xhbdLock.SerialNo_FromNow();
	}

}
