package com.cn.umessage.dao.sendcard.crt.dao;

import org.springframework.stereotype.Service;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

import com.cn.umessage.dao.sendcard.ISendCardDao;
import com.cn.umessage.utils.InitConfig;

@Service("crtSendCardDao")
public class crtSendCardDao implements ISendCardDao {

	String iPort = InitConfig.CRT_PORT;
	String baudrate = InitConfig.CRT_BAUDRATE;
	int value;
	boolean isHasCard = false;
	boolean isChannelAvail = false;
	boolean isRecycleAvail = false;

	@Override
	public boolean isHasCard() {
		// TODO Auto-generated method stub
		try {
			exeCommand(0x30, 0x33, "复位但不移动卡");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isHasCard;
	}

	@Override
	public boolean openPort() {
		// TODO Auto-generated method stub
		JNative openJN = null;
		String code = "";
		try {
			openJN = new JNative("CRT_571", "CommOpenWithBaut");
			openJN.setRetVal(org.xvolks.jnative.Type.INT);
			openJN.setParameter(0, org.xvolks.jnative.Type.STRING, "" + iPort);
			openJN.setParameter(1, Integer.parseInt(baudrate));
			openJN.invoke();
			code = openJN.getRetVal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!code.equals("0")) {
			System.out.println("openPort串口打开成功！");
			value = Integer.parseInt(code);
			return true;
		} else {
			System.out.println("openPort串口打开失败！");
			return false;
		}
	}

	public int open() {
		// TODO Auto-generated method stub
		JNative openJN = null;
		String code = "";
		try {
			openJN = new JNative("CRT_571", "CommOpenWithBaut");
			openJN.setRetVal(org.xvolks.jnative.Type.INT);
			openJN.setParameter(0, org.xvolks.jnative.Type.STRING, "" + iPort);
			openJN.setParameter(1, Integer.parseInt(baudrate));
			openJN.invoke();
			code = openJN.getRetVal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!code.equals("0")) {
			System.out.println("open串口打开成功！");
			value = Integer.parseInt(code);
			return value;
		} else {
			System.out.println("open串口打开失败！");
			return 0;
		}
	}

	@Override
	public boolean closePort() {
		// TODO Auto-generated method stub
		JNative closeJN;
		String code = "";
		try {
			closeJN = new JNative("CRT_571", "CommClose");
			closeJN.setRetVal(org.xvolks.jnative.Type.INT);
			closeJN.setParameter(0, value);
			closeJN.invoke();
			code = closeJN.getRetVal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (code.equals("0")) {
			System.out.println("串口关闭成功！");
			return true;
		} else {
			System.out.println("串口关闭失败！");
			return false;
		}
	}

	@Override
	public boolean outCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			result = exeCommand(0x32, 0x39, "将卡移动到出卡口(不持卡位)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean inCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			result = exeCommand(0x33, 0x30, "单次等待出卡口进卡");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean notAllowInCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			result = exeCommand(0x33, 0x31, "设置禁止出卡口进卡");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean recycling() {
		// TODO Auto-generated method stub

		boolean result = false;
		try {
			result = exeCommand(0x32, 0x33, "将卡回收到回收盒中");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean isChannelAvail() {
		// TODO Auto-generated method stub
		// try {
		// exeCommand(0x30,0x33,"复位但不移动卡");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return isChannelAvail;
	}

	@Override
	public boolean isRecycleAvail() {
		// TODO Auto-generated method stub
		// try {
		// exeCommand(0x30,0x33,"复位但不移动卡");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return isRecycleAvail;
	}

	@Override
	public boolean moveCard() {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			result = exeCommand(0x32, 0x31, "将卡移动到IC卡位");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 收发卡器执行命令
	public boolean exeCommand(int cmCode, int pmCode, String msg)
			throws Exception {
		JNative initJN = new JNative("CRT_571", "ExecuteCommand");
		System.out.println("value=================" + value);
		Pointer rxReplyType = new Pointer(
				MemoryBlockFactory.createMemoryBlock(4 * 30));
		Pointer st0 = new Pointer(MemoryBlockFactory.createMemoryBlock(4 * 30));
		Pointer st1 = new Pointer(MemoryBlockFactory.createMemoryBlock(4 * 30));
		Pointer st2 = new Pointer(MemoryBlockFactory.createMemoryBlock(4 * 30));
		Pointer reDataLen = new Pointer(
				MemoryBlockFactory.createMemoryBlock(4 * 10));

		// byte txData[] = new byte[1024];
		// byte reData[] = new byte[1024];

		Pointer txData = new Pointer(
				MemoryBlockFactory.createMemoryBlock(4 * 30));
		Pointer reData = new Pointer(
				MemoryBlockFactory.createMemoryBlock(4 * 30));

		initJN.setRetVal(org.xvolks.jnative.Type.INT);
		initJN.setParameter(0, open()); // HANDLE
		initJN.setParameter(1, (byte) 0x00); // TxAddr
		initJN.setParameter(2, (byte) cmCode); // TxCmCode
		initJN.setParameter(3, (byte) pmCode); // TxPmCode
		initJN.setParameter(4, 0); // TxDataLen
		initJN.setParameter(5, txData);
		initJN.setParameter(6, rxReplyType.getPointer()); // TxData
		initJN.setParameter(7, st0.getPointer()); // TxData
		initJN.setParameter(8, st1.getPointer()); // TxData
		initJN.setParameter(9, st2.getPointer()); // TxData
		initJN.setParameter(10, reDataLen.getPointer()); // TxData
		initJN.setParameter(11, reData); // TxData
		initJN.invoke();
		System.out.println("reType=" + rxReplyType.getAsString());
		System.out.println("st0=" + st0.getAsString());
		System.out.println("st1=" + st1.getAsString());
		System.out.println("st2=" + st2.getAsString());
		System.out
				.println("--------------------exe code---------------------------------"
						+ initJN.getRetVal());

		if (!st1.getAsString().equals("0")) {
			isHasCard = true;
		} else {
			isHasCard = false;
		}

		if (st0.getAsString().equals("0")) {
			isChannelAvail = true;
		} else if (st0.getAsString().equals("1")
				|| st0.getAsString().equals("2")) {
			isChannelAvail = false;
		}

		if (st2.getAsString().equals("0")) {
			isRecycleAvail = true;
		} else {
			isRecycleAvail = false;
		}

		closePort();
		if (initJN.getRetVal().equals("0")) {
			System.out.println(msg + "成功！");
			return true;
		} else {
			System.out.println(msg + "失败！");
			return false;
		}
	}

}
