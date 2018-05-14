package com.cn.umessage.dao.card.hd.dao;

import org.springframework.stereotype.Service;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.xvolks.jnative.Type;

import com.cn.umessage.dao.card.ICardDao;
import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.utils.InitConfig;

/**
 * 华大身份证读取工具
 * 
 * @author hyj
 * 
 */
@Service("hdCardDao")
public class HdCardDao implements ICardDao {
	private static final long serialVersionUID = -8959055752439578441L;

	int iPort = 1001;
	int iIfOpen = 1;

	public static Map<String, String> map = new HashMap<String, String>();

	static {
		map.put("0", "函数调用成功");
		map.put("-1", "设备连接错");
		map.put("-2", "设备未建立连接(没有执行打开设备函数)");
		map.put("-3", "(动态库)加载失败");
		map.put("-4", "(发给动态库的)参数错");
		map.put("-5", "寻卡失败");
		map.put("-6", "选卡失败");
		map.put("-7", "读卡失败");
		map.put("-8", "读取追加信息失败");
		map.put("-9", "读取追加信息失败");
		map.put("-10", "管理通信失败");
		map.put("-11", "检验通信失败");
		map.put("-12", "管理通信模块不支持获取指纹");
		map.put("-999", "其他异常错误");
	}

	@Override
	public boolean openPort() {
		// TODO Auto-generated method stub
		String code = "";
		try {
			JNative openJN = new JNative("HDstdapi", "HD_InitComm");
			openJN.setRetVal(org.xvolks.jnative.Type.INT);
			int i = 0;
			openJN.setParameter(i++, org.xvolks.jnative.Type.INT, "" + iPort);
			openJN.invoke();
			code = openJN.getRetVal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (code.equals("0")) {
			System.out.print("端口已打开，请放置身份证！");
			return true;
		} else {
			System.out.println(map.get(code));
			return false;
		}
	}

	@Override
	public boolean closePort() {
		// TODO Auto-generated method stub
		String code = "";
		try {
			JNative closeJN = new JNative("HDstdapi", "HD_CloseComm");
			closeJN.setRetVal(org.xvolks.jnative.Type.INT);
			closeJN.setParameter(0, org.xvolks.jnative.Type.INT, "" + iPort);
			closeJN.invoke();
			code = closeJN.getRetVal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (code.equals("0")) {
			System.out.print("端口已关闭！");
			return true;
		} else {
			System.out.println(map.get(code));
			return false;
		}
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		try {
			JNative findJN = new JNative("HDstdapi", "HD_Authenticate");
			findJN.setRetVal(org.xvolks.jnative.Type.INT);
			findJN.invoke();
			String code = findJN.getRetVal();
			if (code.equals("0")) {
				System.out.println();
				System.out.println("已找到二代身份证");
				return true;
			} else {
				System.out.println("============HD_Authenticate==========code["
						+ code + "]========" + map.get(code));
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public IdCard read() {
		IdCard idCard = null;
		String sex = "";
		String minzu = "";
		String cardNum = "tmp";
		try {
			String photoPath = InitConfig.PHOTO_PATH;
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String str = sdf.format(date);
			String path = photoPath + "/" + str + "/" + cardNum + "/";
			if (!new File(path).exists()) {
				new File(path).mkdirs();
			}

			int k = 0;
			String pBmpFile = path + "card.bmp";
			Pointer pBmpData = new Pointer(
					MemoryBlockFactory.createMemoryBlock(78000));
			// String pName = "";
			// String pSex = "";
			// String pNation = "";
			// String pBirth = "";
			// String pAddress = "";
			// String pCertNo = "";
			// String pDepartment = "";
			// String pEffectData = "";
			// String pExpire = "";
			Pointer pName = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pSex = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pNation = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pBirth = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pAddress = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pCertNo = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pDepartment = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pEffectData = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			Pointer pExpire = new Pointer(
					MemoryBlockFactory.createMemoryBlock(200));
			JNative readJN = new JNative("HDstdapi", "HD_Read_BaseInfo");
			readJN.setRetVal(org.xvolks.jnative.Type.INT);
			readJN.setParameter(k++, pBmpFile);
			readJN.setParameter(k++, pBmpData);
			readJN.setParameter(k++, pName);
			readJN.setParameter(k++, pSex);
			readJN.setParameter(k++, pNation);
			readJN.setParameter(k++, pBirth);
			readJN.setParameter(k++, pAddress);
			readJN.setParameter(k++, pCertNo);
			readJN.setParameter(k++, pDepartment);
			readJN.setParameter(k++, pEffectData);
			readJN.setParameter(k++, pExpire);
			readJN.invoke();

			String code = readJN.getRetVal();
			System.out.println("==========name=============="
					+ pName.getAsString());
			if (!"".equals(pName.getAsString())) {
				System.out.println("读取二代身份证成功！");
			} else {
				System.out.println("读取二代身份证失败！");
				return idCard;
			}
	
			String nationStr = pNation.getAsString();
			
			File file = new File(path + "card.bmp");
			File file2 = new File(path + pCertNo.getAsString() + ".bmp");
			if (file.exists() && !file2.exists()) {
				file.renameTo(file2);
			}
			
			idCard = new IdCard();
			idCard.setName(pName.getAsString());
			idCard.setAddress(pAddress.getAsString());
			idCard.setBirthday(pBirth.getAsString());
			idCard.setCardNum(pCertNo.getAsString());
			idCard.setCompany(pDepartment.getAsString());
			idCard.setEndTime(pExpire.getAsString());
			idCard.setMinzu(nationStr);
			idCard.setSex(pSex.getAsString());
			idCard.setStartTime(pEffectData.getAsString());
			idCard.setDepartment(pDepartment.getAsString());
			idCard.setNation(pNation.getAsString());
			System.out.println(idCard.toString());
			return idCard;
		} catch (Exception e) {
			System.out.println("系统异常！");
			return idCard;
		}

	}

	public static void main(String agrs[]) throws Exception {
		System.loadLibrary("sdtapi");
		HdCardDao test = new HdCardDao();

		// if(test.init()){
		// test.read();
		// String result =
		// "{姓名："+test.name+", 性别："+test.sex+", 民族："+test.minzu+", 出生年月："+test.birthday+", 地址："+test.address+", 身份证号："+test.cardNum+", 签发机构："+test.company+", 期限起始："+test.startTime+", 期限终止："+test.endTime+"}";
		// System.out.println(result);
		// }
	}

}
