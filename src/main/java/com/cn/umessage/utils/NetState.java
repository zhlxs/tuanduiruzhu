package com.cn.umessage.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 判断网络连接状况.
 * 
 */
public class NetState extends Thread {
	public static boolean netState = false;

	public static void isConnect() {
		// Runtime runtime = Runtime.getRuntime();
		// Process process;
		// try {
		// process = runtime.exec("ping " + "www.baidu.com");
		// InputStream is = process.getInputStream();
		// InputStreamReader isr = new InputStreamReader(is);
		// BufferedReader br = new BufferedReader(isr);
		// String line = null;
		// StringBuffer sb = new StringBuffer();
		// while ((line = br.readLine()) != null) {
		// sb.append(line);
		// }
		// // System.out.println("返回值为:"+sb);
		// is.close();
		// isr.close();
		// br.close();
		//
		// if (null != sb && !sb.toString().equals("")) {
		// String logString = "";
		// if (sb.toString().indexOf("TTL") > 0) {
		// // 网络畅通
		// connect = true;
		// } else {
		// // 网络不畅通
		// connect = false;
		// }
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		URL url = null;
		Boolean bon = false;
		try {
			url = new URL("http://baicu.com/");
			InputStream in = url.openStream();// 打开到此 URL 的连接并返回一个用于从该连接读入的
												// InputStream
			System.out.println("网络连接正常");
			in.close();// 关闭此输入流并释放与该流关联的所有系统资源。
			netState = true;
		} catch (IOException e) {
			System.out.println("网络连接异常");
			netState = false;
		}
	}

	public static void main(String[] args) {
		NetState netState = new NetState();
		// System.out.println(netState.isConnect());

	}

	public void run() {
		while (true) {
			URL url = null;
			Boolean bon = false;
			try {
				url = new URL("http://baicu.com/");
				InputStream in = url.openStream();// 打开到此 URL 的连接并返回一个用于从该连接读入的
													// InputStream
				System.out.println("网络连接正常");
				in.close();// 关闭此输入流并释放与该流关联的所有系统资源。
				netState = true;
			} catch (IOException e) {
				System.out.println("网络连接异常");
				netState = false;
			}
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}