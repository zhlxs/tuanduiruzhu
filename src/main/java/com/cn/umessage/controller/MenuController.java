package com.cn.umessage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.umessage.pojo.Advertising;
import com.cn.umessage.pojo.RoomOrderInfo;
import com.cn.umessage.service.IAdvertisingService;
import com.cn.umessage.service.IRoomInfoService;
import com.cn.umessage.service.IRoomOrderInfoService;
import com.cn.umessage.service.ISendCardService;
import com.cn.umessage.utils.NetState;

/**
 * 菜单导航模块
 * @author hyj
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource
	private ISendCardService sendCardService;
	@Resource
	private IAdvertisingService advertisingService;
	@Resource
	//房间号订单号对应服务
	private IRoomOrderInfoService roomOrderInfoService;

	private static Logger logger = Logger.getLogger(MenuController.class);

	private static String namrname = "1111";
	/**
	 * 广告页--
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/wait")
	public ModelAndView wait(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/wait");

		List<Advertising> list = advertisingService.selectAll();
		mav.addObject("list",list);
		return mav;
	}
	
	
	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView netState(HttpServletRequest request) {
		//移除session中缓存的信息
		request.getSession().removeAttribute("firstIdCard");
		request.getSession().removeAttribute("secondIdCard");
		request.getSession().removeAttribute("queryIdCard");
		request.getSession().removeAttribute("checkInInfo");
		request.getSession().removeAttribute("order");
		request.getSession().removeAttribute("payInfo");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/index");
		// 网络状态
		boolean netState = NetState.netState;
		if (netState) {
			mav.addObject("netState", "ok");
		}
		// 是否有房卡
		boolean isHasCard = sendCardService.isHasCard();
		if (isHasCard) {
			mav.addObject("isHasCard", "ok");
		}
		// 房卡回收箱是否可用
		boolean isRecycleAvail = sendCardService.isRecycleAvail();
		if (isRecycleAvail) {
			mav.addObject("isRecycleAvail", "ok");
		}

		boolean isChannelAvail = sendCardService.isChannelAvail();
		if (!isChannelAvail) {
			sendCardService.outCard();
		}
		
		return mav;
	}

	/**
	 * 入住通知
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/notice")
	public ModelAndView notice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/police");
		return mav;
	}

	/**
	 * 取房卡菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getcard")
	public ModelAndView getcard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/IdCard");
		return mav;
	}

	/**
	 * 查询菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/query")
	public ModelAndView query(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/query");
		return mav;
	}

	/**
	 * 退房菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkout")
	public ModelAndView checkout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/Checkout");
		return mav;
	}

	/**
	 * 团队入住菜单
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/team")
	public ModelAndView team(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/team2");
		return mav;
	}

}
