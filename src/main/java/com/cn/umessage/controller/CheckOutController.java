package com.cn.umessage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.umessage.dao.psb.bean.GuestBeanCheckOut;
import com.cn.umessage.pojo.CheckInInfo;
import com.cn.umessage.service.ICardService;
import com.cn.umessage.service.ILockService;
import com.cn.umessage.service.IPmsService;
import com.cn.umessage.service.IPsbService;
import com.cn.umessage.service.IRoomOrderInfoService;
import com.cn.umessage.service.ISendCardService;
import com.cn.umessage.service.ISmsService;

/**
 * 退房模块
 * 
 * @author hyj
 * 
 */
@Controller
@RequestMapping("/checkout")
public class CheckOutController {

	private static Logger logger = Logger.getLogger(CheckOutController.class);

	@Resource
	//pms服务
	private IPmsService pmsService;
	@Resource
	//门锁服务
	private ILockService lockService;
	@Resource
	//身份证读取服务
	private ICardService cardService;
	@Resource
	//收发卡器服务
	private ISendCardService sendCardService;
	@Resource
	//短信服务
	private ISmsService smsService;
	@Resource
	//房间号订单号对应服务
	private IRoomOrderInfoService roomOrderInfoService;
	@Resource
	//psb退房服务
	private IPsbService psbService;
	/**
	 * 检测房卡
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkroomcard")
	@ResponseBody
	public String checkroomcard(HttpServletRequest request) throws Exception {
		/*logger.info("checkroomcard call success.");
		boolean res = sendCardService.inCard();//允许前端进卡
		boolean isChannelAvail = sendCardService.isChannelAvail();//检测通道里是否有卡
		logger.info("==========收发卡器通道里是否有卡=======" + isChannelAvail);
		if (!isChannelAvail) {//有卡
			String cardNum = lockService.read();//读房卡
			logger.info("checkroomcard========cardNum==============" + cardNum);
			if ("error".equals(cardNum)) {//读取失败
				return "fail";
			} else {
				return "ok";

			}
		}
		return "fail";*/
		logger.info("checkroomcard call success.");
	    boolean res = this.sendCardService.inCard();
	    boolean isChannelAvail = this.sendCardService.isChannelAvail();
	    logger.info("==========收发卡器通道里是否有卡=======" + isChannelAvail);
	    if (!(isChannelAvail))
	    {
	      return "ok";
	    }

	    return "fail";
	}

	/**
	 * 允许收发卡机出卡口进卡
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/incard")
	@ResponseBody
	public String incard(HttpServletRequest request) throws Exception {
		logger.info("incard call success.");
		boolean res = sendCardService.inCard();
		if (res) {
			return "ok";

		} else {
			return "fail";
		}

	}

	/**
	 * 禁止收发卡机出卡口进卡
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/notAllowInCard")
	@ResponseBody
	public String notAllowInCard(HttpServletRequest request) throws Exception {
		logger.info("notAllowInCard call success.");
		boolean res = sendCardService.notAllowInCard();
		if (res) {
			return "ok";

		} else {
			return "fail";
		}

	}

	/**
	 * 推出房卡
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/outCard")
	@ResponseBody
	public String outCard() throws Exception {
		boolean res = sendCardService.outCard();
		if (res) {
			return "ok";
		} else {
			return "fail";
		}
	}

	/**
	 * 退房
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkouting")
	@ResponseBody
	public String checkouting(HttpServletRequest request) throws Exception {
		logger.info("checkouting call success.");
		CheckInInfo checkInInfo = (CheckInInfo) request.getSession().getAttribute("checkInInfo");
		String roomCardNum = lockService.read();//读房卡的卡号
		boolean result = pmsService.checkOut(checkInInfo);//pms退房，目前自助机只回收房卡，mysql表插入退房记录
		logger.info("=====pms checkout========" + result);
		if (result) {
			String psbRes = "";
			GuestBeanCheckOut checkOutBean = new GuestBeanCheckOut();
			checkOutBean.setRoomCardNum(roomCardNum);
			checkOutBean.setRoomNo(checkInInfo.getRoomNum());
			checkOutBean.setCheckOutDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			psbRes = psbService.checkOutUpload(checkOutBean);
			// TODO退房
			boolean res = sendCardService.recycling();//
			logger.info("=====recycling========" + res);
			if (res && "ok".equals(psbRes)) {
				return "ok";
			} else {
				sendCardService.outCard();
				return "fail";
			}
		} else {
			sendCardService.outCard();
			return "fail";
		}
		/*logger.info("checkouting call success.");
	    CheckInInfo checkInInfo = (CheckInInfo)request.getSession().getAttribute("checkInInfo");
	    boolean res = this.sendCardService.recycling();
	    logger.info("=====recycling========" + res);
	    if (res)
	      return "ok";
	    this.sendCardService.outCard();
	    return "fail";*/
	  }
}
