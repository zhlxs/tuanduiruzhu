package com.cn.umessage.utils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class InitConfig extends HttpServlet implements Servlet {
	// httpservlet 实现了serializable 接口。所以这里的id的作用就是用来标识这个对象写入文件后的标识。
	private static final long serialVersionUID = 3994980056352080271L;

	public static final String PHOTO_PATH = ConfigContext.getInstance()
			.getString("photo.path"); // 客户照片留痕目录

	public static final String PMS_COMPANY = ConfigContext.getInstance()
			.getString("pms.company"); // pms厂商名称
	public static final String PMS_KEY = ConfigContext.getInstance()
			.getString("pms.pmskey"); // pmsKEY
	public static final String PSB_COMPANY = ConfigContext.getInstance()
			.getString("psb.company"); // psb厂商（省市区名称）
	public static final String PSB_HOTELID = ConfigContext.getInstance()
			.getString("psb.hotelId"); // psb分配的酒店Id
	public static final String LY_URL = ConfigContext.getInstance().getString(
			"ly.url"); // 绿云服务URl

	public static final String LY_APPKEY = ConfigContext.getInstance()
			.getString("ly.appkey"); // 绿云appkey

	public static final String LY_SIGN = ConfigContext.getInstance().getString(
			"ly.sign"); // 绿云sign

	public static final String LY_SESSIONID = ConfigContext.getInstance()
			.getString("ly.sessionId"); // 绿云sessionId

	public static final String LY_PMSCODE = ConfigContext.getInstance()
			.getString("ly.pmsCode"); // 酒店pmsCode

	public static final String ZHUZHE_URL = ConfigContext.getInstance()
			.getString("zhuzhe.url"); // 住哲服务URl

	public static final String ZHUZHE_CID = ConfigContext.getInstance()
			.getString("zhuzhe.cId"); // 住哲客户端ID

	public static final String ZHUZHE_KEY = ConfigContext.getInstance()
			.getString("zhuzhe.key"); // 住哲密钥

	public static final String ZHUZHE_DATAKEY = ConfigContext.getInstance()
			.getString("zhuzhe.dataKey"); // 住哲数据密钥

	public static final String ZHUZHE_HOTELID = ConfigContext.getInstance()
			.getString("zhuzhe.hotelId"); // 住哲hotelId

	public static final String XIRUAN_URL = ConfigContext.getInstance()
			.getString("xiruan.url"); // 西软url

	public static final String LOCK_COMPANY = ConfigContext.getInstance()
			.getString("lock.company"); // 门锁厂商名称

	public static final String BT_HOTELPWD = ConfigContext.getInstance()
			.getString("bt.hotelpwd"); // 必达酒店密码

	public static final String BT_PORT = ConfigContext.getInstance().getString(
			"bt.port"); // 必达门锁串口

	public static final String BT_READERTYPE = ConfigContext.getInstance()
			.getString("bt.readertype"); // 必达读卡器类型

	public static final String BT_SECTORNO = ConfigContext.getInstance()
			.getString("bt.sectorno"); // 必达门锁扇区号

	public static final String KEYU_PORT = ConfigContext.getInstance()
			.getString("keyu.port"); // 科裕门锁端口
	public static final String KEYU_NBLOCK = ConfigContext.getInstance()
			.getString("keyu.nBlock"); // nBlock
	public static final String KEYU_ENCRYPT = ConfigContext.getInstance()
			.getString("keyu.Encrypt"); // Encrypt
	public static final String KEYU_CARDPASS = ConfigContext.getInstance()
			.getString("keyu.cardpass"); // cardpass
	public static final String KEYU_SYSTEMCODE = ConfigContext.getInstance()
			.getString("keyu.systemCode"); // systemCode
	public static final String KEYU_HOTELCODE = ConfigContext.getInstance()
			.getString("keyu.hotelCode"); // hotelCode

	public static final String CARD_COMPANY = ConfigContext.getInstance()
			.getString("card.company"); // 身份证读卡器厂商
	public static final String HD_PORT = ConfigContext.getInstance().getString(
			"hd.port"); // 华大端口
	public static final String XZX_PORT = ConfigContext.getInstance()
			.getString("xzx.port"); // 新中新端口

	public static final String SENDCARD_COMPANY = ConfigContext.getInstance()
			.getString("sendcard.company"); // 收发卡器厂商
	public static final String CRT_PORT = ConfigContext.getInstance()
			.getString("crt.port"); // 创自端口
	public static final String CRT_BAUDRATE = ConfigContext.getInstance()
			.getString("crt.baudrate"); // 创自波特率

	public static final String PHONE_URL = ConfigContext.getInstance()
			.getString("sms.url");// 短信地址路径
	public static final String OPERATION_MOBILE = ConfigContext.getInstance()
			.getString("sms.operation.mobile");// 短信地址路径
	public static final String RECEPTION_MOBILE = ConfigContext.getInstance()
			.getString("sms.hotel.reception.mobile");// 短信地址路径
	// public static final String PHONE_URL =
	// ConfigContext.getInstance().getString("sms.url");//短信地址路径

	public static final String PAY_URL = ConfigContext.getInstance().getString(
			"pay.url");// 支付服务地址
	
	public static final String PAY_HOTELID = ConfigContext.getInstance().getString(
			"pay.hotelId");// 支付时用到的酒店ID
	public static final String XML_PATH = ConfigContext.getInstance()
			.getString("xml.path"); // xml生成地址
	public static final String LV_CODE = ConfigContext.getInstance()
			.getString("lv.code"); // 旅馆代码
	public static final String LV_HOTEL = ConfigContext.getInstance()
			.getString("lv.hotel"); // 旅馆代码
	public InitConfig() throws Exception {
	}

	private Scheduler getScheduler() throws Exception {
		SchedulerFactory schedFact = new StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();
		return sched;
	}

	Scheduler sched = getScheduler();

	public void init() throws ServletException {
		System.out.println("============网络监控开始===============");
		NetState netState = new NetState();
		netState.start();
		// try {
		// JobDetail deleteTemp_job = new JobDetail("deleteOpTemp_job",
		// "deleteTemp_jobGroup", DeleteOpTemp.class );
		// CronTrigger deleteTemp_trig = new CronTrigger("deleteOpTemp_trig",
		// "deleteTemp_trigGroup");
		// //deleteTemp_trig.setCronExpression("0 0 23 * * ?");
		// deleteTemp_trig.setCronExpression(CRON_DELETEOPTEMP); //设置调度规则
		// sched.scheduleJob(deleteTemp_job, deleteTemp_trig);;
		//
		// JobDetail sql_job = new JobDetail("deleteLog_job", "sql_jobGroup",
		// DeleteLog.class );
		// CronTrigger sql_trig = new CronTrigger("deleteLog_trig",
		// "sql_trigGroup");
		// sql_trig.setCronExpression(CRON_DELETELOG);
		// sched.scheduleJob(sql_job, sql_trig);
		// sched.start(); //定时调度任务
		// System.out.println("启动定时任务");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	public void destroy() {
		try {
			System.out.println("start destroy >>>>>>>>>>>>>>>>>>>>>");
			sched.shutdown();
			System.out.println("停掉定时任务");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}