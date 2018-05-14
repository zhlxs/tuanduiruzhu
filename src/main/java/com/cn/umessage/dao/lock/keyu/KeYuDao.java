package com.cn.umessage.dao.lock.keyu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.lock.ILockDao;
import com.cn.umessage.pojo.RoomInfo;
import com.cn.umessage.pojo.RoomOrderInfo;
import com.cn.umessage.service.IRoomInfoService;
import com.cn.umessage.service.IRoomOrderInfoService;
import com.cn.umessage.utils.InitConfig;

@Service("keyuLockDao")
public class KeYuDao implements ILockDao {

	private static KeYuLock xhbdLock = null;
	@Resource
	private IRoomInfoService roomInfoServie;
	@Resource
	//房间号订单号对应服务
	private IRoomOrderInfoService roomOrderInfoService;
	static {

		xhbdLock = KeYuLock.getInstance();

	}

	public static void main(String[] args) {

		// byte port = Byte.parseByte("1");//通讯com口号
		// byte readerType =
		// Byte.parseByte("5");//MF读卡器类型，1：RW-21；2：RW-33；3：RW-26B；4：RW-41
		// ；5：RW-49A
		// byte sectorNo = Byte.parseByte("0");//MF1S50卡使用扇区号（范围0------15）
		// String hotelPwd = "201512";//酒店密码 (6位字符串，字符串内容为ASCII码字符)
		// System.out.println(port);

		// 写卡测试
		String inDate = "18-01-29";
		String inTime = "12:00:00";
		String outDate = "18-01-30";
		String outTime = "12:00:00";
		// KeyCard(inDate,inTime,outDate,outTime);

		System.out.println(CompactCipherTime());
	}

	/**
	 * 写卡测试
	 */
	public boolean write(String cardNo, String begin, String end) {
		System.out
				.println("==========keyu============write===============");
		DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat formatter1 = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
		String inDate = "";
		String inTime = "";
		String outDate = "";
		String outTime = "";
		System.out
		.println("==========keyu============write===============1");
		try {
			Date date1 = format1.parse(begin);
			Date date2 = format1.parse(end);
			inDate = formatter1.format(date1);
			inTime = formatter2.format(date1);
			outDate = formatter1.format(date2);
			outTime = formatter2.format(date2);
			System.out.println(inDate);
			System.out.println(inTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
		.println("==========keyu============write===============2");
		RoomOrderInfo roomOrderInfo = roomOrderInfoService.selectByPrimaryKey(Integer.parseInt(cardNo));
		RoomInfo roomInfo = roomInfoServie.selectByRoomno(roomOrderInfo.getRoomnum());
		String address = "";
		if(roomInfo!=null){
		    address = roomInfo.getRoomaddress();
		}
		System.out.println("=============address============="+address);
		
		int Com = 3;
		int CardNo = Integer.parseInt(cardNo);
		int nBlock = 4;
		int Encrypt = 1;
		byte[] CardPass = InitConfig.KEYU_CARDPASS.getBytes();
		byte[] SystemCode = InitConfig.KEYU_SYSTEMCODE.getBytes();
		byte[] HotelCode = InitConfig.KEYU_HOTELCODE.getBytes();
		byte[] Pass = CompactCipherTime().getBytes();
		byte[] Address = address.getBytes();
		byte[] SDIn = inDate.getBytes();
		byte[] STIn = inTime.getBytes();
		byte[] SDOut = outDate.getBytes();
		byte[] STOut = outTime.getBytes();
		int LEVEL_Pass = 3;
		int PassMode = 1;
		int AddressMode = 0;
		int AddressQty = 1;
		int TimeMode = 0;
		int V8 = 255;
		int V16 = 255;
		int V24 = 255;
		int AlwaysOpen = 0;
		int OpenBolt = 0;
		int TerminateOld = 0;
		int ValidTimes = 255;
		System.out
		.println("==========keyu============write===============3");
		int res = xhbdLock.KeyCard(Com, CardNo, nBlock, Encrypt, CardPass,
				SystemCode, HotelCode, Pass, Address, SDIn, STIn, SDOut, STOut,
				LEVEL_Pass, PassMode, AddressMode, AddressQty, TimeMode, V8,
				V16, V24, AlwaysOpen, OpenBolt, TerminateOld, ValidTimes);

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
	public String read() {

		int Com = 3;
		int nBlock = 4;
		int Encrypt = 1;
		int[] DBCardno = new int[4];
		int[] DBCardtype = new int[4];
		int[] DBPassLevel = new int[4];
		byte[] CardPass = "82A094FFFFFF".getBytes();
		byte[] DBSystemcode = "72ED3347".getBytes();
		byte[] DBAddress = new byte[20];
		byte[] SDateTime = new byte[20];

		int res = xhbdLock.ReadMessage(Com, nBlock, Encrypt, DBCardno,
				DBCardtype, DBPassLevel, CardPass, DBSystemcode, DBAddress,
				SDateTime);

		// int res = xhbdLock.ReadMessage(Com, nBlock, Encrypt, DBCardno,
		// DBCardtype, DBPassLevel, CardPass1, DBSystemcode1, DBAddress1,
		// SDateTime1);

		System.out.println("读卡代码：" + res);
		// System.out.println("Com：" + Com);
		// System.out.println("nBlock：" + nBlock);
		// System.out.println("Encrypt：" + Encrypt);
		// System.out.println("DBCardno：" + DBCardno[0]);
		// System.out.println("DBCardtype：" + DBCardtype[0]);
		// System.out.println("DBPassLevel：" + DBPassLevel[0]);
		// System.out.println("CardPass：" + new String(CardPass));
		// System.out.println("DBSystemcode：" + new String(DBSystemcode));
		// System.out.println("DBAddress：" + new String(DBAddress));
		// System.out.println("SDateTime：" + new String(SDateTime));

		// System.out.println("CardPass1：" + CardPass1);
		// System.out.println("DBSystemcode1：" + DBSystemcode1);
		// System.out.println("DBAddress1：" + DBAddress1);
		// System.out.println("SDateTime1：" + SDateTime1);
		if (res == 0) {
			return DBCardno[0] + "";
		} else {
			return "error";
		}

	}

	public static String CompactCipherTime() {
		Calendar now = Calendar.getInstance();
		int Min = now.get(Calendar.MINUTE);
		int Hour = now.get(Calendar.HOUR_OF_DAY);
		int Day = now.get(Calendar.DAY_OF_MONTH);
		int Month = now.get(Calendar.MONTH) + 1;
		int Year = now.get(Calendar.YEAR);
		int dw = (int) ((Min / 4) + Hour * (Math.pow(2, 4)) + Day
				* (Math.pow(2, 9)) + Month * (Math.pow(2, 14)) + (((Year - 8) % 1000) % 63)
				* (Math.pow(2, 18)));
		String result = decimalToHex(dw).toUpperCase();
		return result;
	}

	public static String decimalToHex(int decimal) {
		String hex = "";
		while (decimal != 0) {
			int hexValue = decimal % 16;
			hex = toHexChar(hexValue) + hex;
			decimal = decimal / 16;
		}
		return hex;
	}

	// 将0~15的十进制数转换成0~F的十六进制数
	public static char toHexChar(int hexValue) {
		if (hexValue <= 9 && hexValue >= 0)
			return (char) (hexValue + '0');
		else
			return (char) (hexValue - 10 + 'A');
	}
}
