package com.cn.umessage.dao.card.xzx.dao;

import org.springframework.stereotype.Service;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

import javax.imageio.ImageIO;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.Image;

import org.xvolks.jnative.Type;

import com.cn.umessage.dao.card.ICardDao;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.utils.InitConfig;

@Service("xzxCardDao")
public class XzxCardDao implements ICardDao {
	private static final long serialVersionUID = -8959055752439578441L;

	int iPort = 1001;
	int iIfOpen = 1;

	@Override
	public boolean openPort() {
		// TODO Auto-generated method stub
		System.loadLibrary("sdtapi");
		JNative openJN;
		String code = "";
		try {
			openJN = new JNative("sdtapi", "SDT_OpenPort");
			openJN.setRetVal(org.xvolks.jnative.Type.INT);
			int i = 0;
			openJN.setParameter(i++, org.xvolks.jnative.Type.INT, "" + iPort);
			openJN.invoke();
			code = openJN.getRetVal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (code.equals("144")) {
			System.out.print("端口已打开，请放置身份证！");
			return true;
		} else {
			System.out.println("端口打开失败,请检查硬件！");
			return false;
		}
	}

	@Override
	public boolean closePort() {
		// TODO Auto-generated method stub
		System.loadLibrary("sdtapi");
		try {
			JNative closeJN = new JNative("sdtapi", "SDT_ClosePort");
			closeJN.setRetVal(Type.INT);
			closeJN.setParameter(0, Type.INT, "" + iPort);
			closeJN.invoke();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		try {
			int i = 0, j = 0, k = 0;
			String pucIIN = "", pucSN = "";
			Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(1000));
			Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(256));
			Pointer c = new Pointer(
					MemoryBlockFactory.createMemoryBlock(1024 * 3));
			Pointer d = new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
			Pointer e = new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
			JNative findJN = new JNative("sdtapi", "SDT_StartFindIDCard");
			findJN.setRetVal(org.xvolks.jnative.Type.INT);
			findJN.setParameter(i++, org.xvolks.jnative.Type.INT, "" + iPort);
			findJN.setParameter(i++, pucIIN);
			findJN.setParameter(i++, org.xvolks.jnative.Type.INT, "" + iIfOpen);
			findJN.invoke();
			if (findJN.getRetVal().equals("159")) {
				System.out.println();
				System.out.println("已找到二代身份证");
			} else {
				System.out.print(".");
			}
			JNative selectJN = new JNative("sdtapi", "SDT_SelectIDCard");
			selectJN.setRetVal(org.xvolks.jnative.Type.INT);
			selectJN.setParameter(j++, org.xvolks.jnative.Type.INT, "" + iPort);
			selectJN.setParameter(j++, pucSN);
			selectJN.setParameter(j++, org.xvolks.jnative.Type.INT, ""
					+ iIfOpen);
			selectJN.invoke();
			if (selectJN.getRetVal().equals("144")) {
				System.out.println("已选择二代身份证");
				return true;
			} else {
				System.out.print(".");
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public IdCard read() {
		IdCard idCard = null;

		String name = "";
		String sex = "";
		String minzu = "";
		String birthday = "";
		String address = "";
		String cardNum = "";
		String company = "";
		String startTime = "";
		String endTime = "";
		try {
			int i = 0, j = 0, k = 0;
			String pucIIN = "", pucSN = "";
			Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(1000));
			Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(256));
			Pointer c = new Pointer(
					MemoryBlockFactory.createMemoryBlock(1024 * 3));
			Pointer d = new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
			Pointer e = new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
			JNative readJN = new JNative("sdtapi", "SDT_ReadBaseMsg");
			readJN.setRetVal(org.xvolks.jnative.Type.INT);
			readJN.setParameter(k++, org.xvolks.jnative.Type.INT, "" + iPort);
			readJN.setParameter(k++, a);
			readJN.setParameter(k++, b);
			readJN.setParameter(k++, c);
			readJN.setParameter(k++, d);
			readJN.setParameter(k++, org.xvolks.jnative.Type.INT, "" + iIfOpen);
			readJN.invoke();
			if (readJN.getRetVal().equals("144")) {
				System.out.println("读取二代身份证成功！");
			}
			int count = a.getSize();
			byte[] byteArray = new byte[count + 2];
			for (i = 0; i < count; i++)
				byteArray[i + 2] = a.getAsByte(i);
			byteArray[0] = (byte) 0xff;
			byteArray[1] = (byte) 0xfe;
			String msg = new String(byteArray, "utf-16");
			StringTokenizer st = new StringTokenizer(msg);
			int hh = 0;
			String[] Info = new String[5];
			while (st.hasMoreElements()) {
				Info[hh++] = (String) st.nextElement();
				// System.out.println(Info[hh - 1]);
			}
			name = Info[0];

			if (Info[1].charAt(0) == '1') {
				sex = "男";
			} else if (Info[1].charAt(0) == '2')
				sex = "女";
			char[] nationChar = new char[2];
			Info[1].getChars(1, 3, nationChar, 0);
			String nationStr = "";
			nationStr = String.valueOf(nationChar);
			if (nationStr.equals("01"))
				minzu = "汉";
			else if (nationStr.equals("02"))
				minzu = "蒙古族";
			else if (nationStr.equals("03"))
				minzu = "回族";
			else if (nationStr.equals("04"))
				minzu = "藏族";
			else if (nationStr.equals("05"))
				minzu = "维吾尔族";
			else if (nationStr.equals("06"))
				minzu = "苗族";
			else if (nationStr.equals("07"))
				minzu = "彝族";
			else if (nationStr.equals("08"))
				minzu = "壮族";
			else if (nationStr.equals("09"))
				minzu = "布依族";
			else if (nationStr.equals("10"))
				minzu = "朝鲜族";
			else if (nationStr.equals("11"))
				minzu = "满族";
			else if (nationStr.equals("12"))
				minzu = "侗族";
			else if (nationStr.equals("13"))
				minzu = "瑶族";
			else if (nationStr.equals("14"))
				minzu = "白族";
			else if (nationStr.equals("15"))
				minzu = "土家族";
			else if (nationStr.equals("16"))
				minzu = "哈尼族";
			else if (nationStr.equals("17"))
				minzu = "哈萨克族";
			else if (nationStr.equals("18"))
				minzu = "傣族";
			else if (nationStr.equals("19"))
				minzu = "黎族";
			else if (nationStr.equals("20"))
				minzu = "傈僳族";
			else if (nationStr.equals("21"))
				minzu = "佤族";
			else if (nationStr.equals("22"))
				minzu = "畲族";
			else if (nationStr.equals("23"))
				minzu = "高山族";
			else if (nationStr.equals("24"))
				minzu = "拉祜族";
			else if (nationStr.equals("25"))
				minzu = "水族";
			else if (nationStr.equals("26"))
				minzu = "东乡族";
			else if (nationStr.equals("27"))
				minzu = "纳西族";
			else if (nationStr.equals("28"))
				minzu = "景颇族";
			else if (nationStr.equals("29"))
				minzu = "柯尔克孜族";
			else if (nationStr.equals("30"))
				minzu = "土族";
			else if (nationStr.equals("31"))
				minzu = "达翰尔族";
			else if (nationStr.equals("32"))
				minzu = "仫佬族";
			else if (nationStr.equals("33"))
				minzu = "羌族";
			else if (nationStr.equals("34"))
				minzu = "布朗族";
			else if (nationStr.equals("35"))
				minzu = "撒拉族";
			else if (nationStr.equals("36"))
				minzu = "毛南族";
			else if (nationStr.equals("37"))
				minzu = "仡佬族";
			else if (nationStr.equals("38"))
				minzu = "锡伯族";
			else if (nationStr.equals("39"))
				minzu = "阿昌族";
			else if (nationStr.equals("40"))
				minzu = "普米族";
			else if (nationStr.equals("41"))
				minzu = "哈萨克族";
			else if (nationStr.equals("42"))
				minzu = "怒族";
			else if (nationStr.equals("43"))
				minzu = "乌孜别克族";
			else if (nationStr.equals("44"))
				minzu = "俄罗斯族";
			else if (nationStr.equals("45"))
				minzu = "鄂温克族";
			else if (nationStr.equals("46"))
				minzu = "德昂族";
			else if (nationStr.equals("47"))
				minzu = "保安族";
			else if (nationStr.equals("48"))
				minzu = "裕固族";
			else if (nationStr.equals("49"))
				minzu = "京族";
			else if (nationStr.equals("50"))
				minzu = "塔塔尔族";
			else if (nationStr.equals("51"))
				minzu = "独龙族";
			else if (nationStr.equals("52"))
				minzu = "鄂伦春族";
			else if (nationStr.equals("53"))
				minzu = "赫哲族";
			else if (nationStr.equals("54"))
				minzu = "门巴族";
			else if (nationStr.equals("55"))
				minzu = "珞巴族";
			else if (nationStr.equals("56"))
				minzu = "基诺族";
			else if (nationStr.equals("57"))
				minzu = "其它";
			else if (nationStr.equals("98"))
				minzu = "外国人入籍";
			String BirthyearStr = "";
			char[] BirthyearChar = new char[4];
			Info[1].getChars(3, 7, BirthyearChar, 0);
			BirthyearStr = String.valueOf(BirthyearChar);
			String BirthmonthStr = "";
			char[] BirthmonthChar = new char[2];
			Info[1].getChars(7, 9, BirthmonthChar, 0);
			BirthmonthStr = String.valueOf(BirthmonthChar);
			String BirthdateStr = "";
			char[] BirthdateChar = new char[2];
			Info[1].getChars(9, 11, BirthdateChar, 0);
			BirthdateStr = String.valueOf(BirthdateChar);
			birthday = BirthyearStr + "年" + BirthmonthStr + "月" + BirthdateStr
					+ "日";
			char[] addressChar = new char[Info[1].length() - 11];
			String addressStr = "";
			Info[1].getChars(11, Info[1].length(), addressChar, 0);
			addressStr = String.valueOf(addressChar);
			address = addressStr;
			char[] INNChar = new char[18];
			Info[2].getChars(0, 18, INNChar, 0);
			String INNStr = "";
			INNStr = String.valueOf(INNChar);
			cardNum = INNStr;
			char[] issueChar = new char[Info[2].length() - 18];
			Info[2].getChars(18, Info[2].length(), issueChar, 0);
			String issueStr = "";
			issueStr = String.valueOf(issueChar);
			company = issueStr;
			char[] startyearChar = new char[4];
			Info[3].getChars(0, 4, startyearChar, 0);
			String startyearStr = "";
			startyearStr = String.valueOf(startyearChar);
			char[] startmonthChar = new char[2];
			Info[3].getChars(4, 6, startmonthChar, 0);
			String startmonthStr = "";
			startmonthStr = String.valueOf(startmonthChar);
			char[] startdateChar = new char[2];
			Info[3].getChars(6, 8, startdateChar, 0);
			String startdateStr = "";
			startdateStr = String.valueOf(startdateChar);
			startTime = startyearStr + "年" + startmonthStr + "月" + startdateStr
					+ "日";
			char[] endyearChar = new char[4];
			Info[3].getChars(8, 12, endyearChar, 0);
			String endyearStr = "";
			endyearStr = String.valueOf(endyearChar);
			char[] endmonthChar = new char[2];
			Info[3].getChars(12, 14, endmonthChar, 0);
			String endmonthStr = "";
			endmonthStr = String.valueOf(endmonthChar);
			char[] enddateChar = new char[2];
			Info[3].getChars(14, 16, enddateChar, 0);
			String enddateStr = "";
			enddateStr = String.valueOf(enddateChar);
			endTime = endyearStr + "年" + endmonthStr + "月" + enddateStr + "日";
			int count1 = d.getSize();

			String photoPath = InitConfig.PHOTO_PATH;
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String str = sdf.format(date);
			String path = photoPath + "/" + str + "/tmp/";
			if (!new File(path).exists()) {
				new File(path).mkdirs();
			}

			byte[] byteArray1 = new byte[count1];
			for (i = 0; i < count1; i++)
				byteArray1[i] = c.getAsByte(i);
			try {
				File myFile = new File(path + "card.wlt");
				FileOutputStream out = new FileOutputStream(myFile);
				out.write(byteArray1, 0, count1 - 1);
			} catch (IOException t) {
			}
			// closeJN.invoke();
			// System.out.println(closeJN.getRetVal());

			int l = 0;
			System.loadLibrary("WltRS");
			JNative BmpJN = new JNative("WltRS", "GetBmp");
			BmpJN.setRetVal(org.xvolks.jnative.Type.INT);
			BmpJN.setParameter(l++, path + "card.wlt");
			BmpJN.setParameter(l++, 1);
			BmpJN.invoke();
			if (readJN.getRetVal().equals("144"))
				System.out.println("相片解码成功！");
			else
				System.out.println("相片解码不成功！");
			File file = new File(path + "card.bmp");
			File file2 = new File(path + cardNum + ".bmp");
			if (file.exists() && !file2.exists()) {
				file.renameTo(file2);
			}
			a.dispose();
			b.dispose();
			c.dispose();
			d.dispose();
			e.dispose();
			idCard = new IdCard();
			idCard.setName(name);
			idCard.setAddress(address);
			idCard.setBirthday(birthday);
			idCard.setCardNum(cardNum);
			idCard.setCompany(company);
			idCard.setEndTime(endTime);
			idCard.setMinzu(minzu);
			idCard.setSex(sex);
			idCard.setStartTime(startTime);
			System.out.println("========================" + name);
			return idCard;
		} catch (Exception e) {
			System.out.println("系统异常！");
			return idCard;
		}

	}

	public static void main(String agrs[]) throws Exception {
		System.loadLibrary("sdtapi");
		XzxCardDao test = new XzxCardDao();
		IdCard idCard = test.read();
		System.out.println("==========" + idCard);
		// if(test.init()){
		// test.read();
		// String result =
		// "{姓名："+test.name+", 性别："+test.sex+", 民族："+test.minzu+", 出生年月："+test.birthday+", 地址："+test.address+", 身份证号："+test.cardNum+", 签发机构："+test.company+", 期限起始："+test.startTime+", 期限终止："+test.endTime+"}";
		// System.out.println(result);
		// }
	}

}
