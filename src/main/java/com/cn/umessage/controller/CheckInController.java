package com.cn.umessage.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.umessage.dao.psb.bean.GuestBean;
import com.cn.umessage.pojo.*;
import com.cn.umessage.service.*;
import com.cn.umessage.utils.Base64Image;
import com.cn.umessage.utils.DateUtils;
import com.cn.umessage.utils.InitConfig;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 入住模块
 *
 * @author hyj
 */
@Controller
@RequestMapping("/checkin")
public class CheckInController {
    //团队入住用
    @Autowired
    private TestServicetdrz testServicetdrz;

    private static Logger logger = Logger.getLogger(CheckInController.class);
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
    //人证比对服务
    private IPersonCardService personCardService;
    @Resource
    //短信服务
    private ISmsService smsService;
    @Resource
    //支付服务
    private IPayService payService;
    @Resource
    //房间号订单号对应服务
    private IRoomOrderInfoService roomOrderInfoService;
    @Resource
    //押金服务
    private IDepositInfoService depositInfoService;
    @Resource
    //psb服务
    private IPsbService psbService;
    @Resource
    //房间身份证号服务
    private IRoomIdentityInfoService roomIdentityInfoService;
    @Resource
    //字典
    private ICodeTableService codeTableService;

    /**
     * 检测身份证
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkcard")
    @ResponseBody
    public String checkcard(HttpServletRequest request) throws Exception {
        logger.info("checkcard call success.");
        cardService.openPort();//打开身份证读卡器端口
        boolean result = cardService.check();
        if (result) {
            return "ok";
        } else {
            return "fail";
        }
    }

    /**
     * 读取身份证
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/readcard")
    @ResponseBody
    public String readcard(HttpServletRequest request) throws Exception {
        logger.info("readcard call success.");
        IdCard idCard = cardService.read();//读取第一入住人身份证信息
        cardService.closePort();//关闭身份证读卡器端口
        if (idCard != null) {//读取成功
            request.getSession().setAttribute("firstIdCard", idCard);// session中放入第一入住人信息
            return "ok";
        } else {//读取失败
            request.getSession().removeAttribute("firstIdCard");
            return "fail";
        }
    }

    /**
     * 第二入住人读取身份证
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/secreadcard")
    @ResponseBody
    public String secreadcard(HttpServletRequest request) throws Exception {
        logger.info("secreadcard call success.");
        IdCard secondIdCard = cardService.read();//读取第二入住人身份证信息
        cardService.closePort();//关闭身份证读卡器端口
        if (secondIdCard != null) {//读取成功
            Object o = request.getSession().getAttribute("firstIdCard");
            if (o != null) {
                IdCard firstIdCard = (IdCard) o;
                if (secondIdCard.getCardNum().equals(firstIdCard.getCardNum())) {//判断第一入住人和第二入住人是否相同
                    return "same";//第一入住人和第二入住人相同，提示错误信息
                } else {
                    request.getSession().setAttribute("secondIdCard",
                            secondIdCard);// session中放入第二入住人信息
                    return "ok";
                }
            }

        } else {//读取失败
            request.getSession().removeAttribute("secondIdCard");
            return "fail";
        }
        return "fail";
    }

    /**
     * 查询模块读取身份证
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryreadcard")
    @ResponseBody
    public String queryreadcard(HttpServletRequest request) throws Exception {
        logger.info("queryreadcard call success.");
        IdCard queryIdCard = cardService.read();//读取查询人身份证信息
        cardService.closePort();
        if (queryIdCard != null) {//读取成功
            request.getSession().setAttribute("queryIdCard", queryIdCard);// session中放入查询人信息
            CheckInInfo checkInInfo = request.getSession().getAttribute(
                    "checkInInfo") == null ? null : (CheckInInfo) request
                    .getSession().getAttribute("checkInInfo");
            if (checkInInfo.getPersons().contains(queryIdCard.getName())) {
                return "ok";
            } else {
                return "other";// 非入住人，吞卡
            }
        } else {//读取失败
            request.getSession().removeAttribute("queryIdCard");
            return "fail";
        }
    }

    /**
     * 吞卡：回收失败房卡或非入住人查询房卡信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/recycling")
    @ResponseBody
    public String recycling() throws Exception {
        boolean res = sendCardService.recycling();
        if (res) {
            return "ok";
        } else {
            return "fail";
        }
    }

    /**
     * 查询未入住订单
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getorder")
    @ResponseBody
    public List<OrderInfo> getorder(HttpServletRequest request)
            throws Exception {
        logger.info("getorder call success.");
        Object o = request.getSession().getAttribute("firstIdCard");//session中获取第一入住人信息
        if (o != null) {
            IdCard idCard = (IdCard) o;
            String queryString = idCard.getName() + "," + idCard.getCardNum();// 查询条件：姓名,身份证号
            List<OrderInfo> list = pmsService.getOrder(queryString);
            if (list.size() == 1) {//查询到唯一订单，可以正常取房卡
                request.getSession().setAttribute("order", list.get(0));
            }
            logger.info("==========orderlist===========" + list.size());
            return list;
        } else {
            return null;
        }

    }

    /**
     * 查询支付情况
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getpayinfo")
    @ResponseBody
    public PayInfo getpayinfo(HttpServletRequest request) throws Exception {
        logger.info("getpayinfo call success.");
        Object o = request.getSession().getAttribute("order");//获取订单
        if (o != null) {
            OrderInfo order = (OrderInfo) o;
            String queryString = order.getOrderNum() + "," + order.getOrderNumPMS();// 查询条件：订单号-预订单pms
            logger.info("==========ordernum=============="
                    + queryString);
            PayInfo pay = pmsService.getPayInfo(queryString);//获取订单支付情况
            /*pay.setDeposit(0.01);
            pay.setRoomRate(0.01);
			pay.setTotalFree(0.02);*/
            request.getSession().setAttribute("payInfo", pay);
            return pay;
        } else {
            return null;
        }

    }

    /**
     * 入住并制作房卡
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/roomcard")
    @ResponseBody
    public CheckInInfo roomcard(HttpServletRequest request) throws Exception {
        logger.info("roomcard call success...");
        CheckInInfo checkIn = null;
        // TODO制作房卡
        IdCard idCard = (IdCard) request.getSession().getAttribute(
                "firstIdCard");
        OrderInfo order = (OrderInfo) request.getSession()
                .getAttribute("order");
        pmsService.updateOrderInfo(idCard, order.getOrderNumPMS());//更改主单证件信息

        logger.info("========客户姓名===" + idCard.getName());
        logger.info("========ordernum===" + order.getOrderNum());
        String identity = idCard.getCardNum();
        IdCard secondIdCard = request.getSession().getAttribute("secondIdCard") == null ? null
                : (IdCard) request.getSession().getAttribute("secondIdCard");
        String pmsName = InitConfig.PMS_COMPANY;
        String res = "";
        String roomno = "";
        switch (pmsName) {
            case "ly":
                List<String> roomnos = pmsService.getAvailableRoom(order.getInTime(), order.getOutTime(), order.getRoomCode());//获取可用房间
                order.setRoomNo(roomnos.get(0));
                //将带有房间号的订单信息再次存入session
                request.getSession().setAttribute("order", order);
                logger.info("============可用房间个数=================" + roomnos.size());
                if (roomnos != null && roomnos.size() > 0) {
                    String s = pmsService.allotRoom(order.getOrderNumPMS(), order.getRoomCode(), roomnos.get(0), order.getYudingId());//订单分配房间
                    if (!"error".equals(s)) {
                        order.setDengjidanId(s);
                    } else {
                        logger.error("pms分房出现异常，请检查！");
                    }
                    res = pmsService.checkIn(idCard, order);//办理入住，得到房间号
                    roomno = res.split(",")[0];
                    request.getSession().setAttribute("ruzhuPMS", res.split(",")[1]);
                }
                if (secondIdCard != null) {//多人入住
                    identity = identity + "," + secondIdCard.getCardNum();
                    String ruzhuPMS = (String) request.getSession().getAttribute("ruzhuPMS");
                    if (!"error".equals(ruzhuPMS)) {
                        boolean b1 = pmsService.addPerson(secondIdCard, ruzhuPMS);//增加同住人
                    } else {
                        logger.error("入住返回入住单PMS编码错误!");
                    }
                }
                break;
            case "xiruan":
                if (secondIdCard != null) {//多人入住
                    identity = identity + "," + secondIdCard.getCardNum();
                    boolean b2 = pmsService.addPerson(secondIdCard, order.getOrderNumPMS());//增加同住人
                    logger.info("============增加同住人=================" + b2);
                    List<String> roomnos2 = pmsService.getAvailableRoom(order.getInTime(), order.getOutTime(), order.getRoomCode());//获取可用房间
                    order.setRoomNo(roomnos2.get(0));
                    //将带有房间号的订单信息再次存入session
                    request.getSession().setAttribute("order", order);
                    logger.info("============可用房间个数=================" + roomnos2.size());
                    if (roomnos2 != null && roomnos2.size() > 0) {
                        String s = pmsService.allotRoom(order.getOrderNumPMS(), order.getRoomCode(), roomnos2.get(0), order.getYudingId());//订单分配房间
                    }
                }
                res = pmsService.checkIn(idCard, order);//办理入住，得到房间号
                roomno = res.split(",")[0];
                break;
            default:
                break;
        }
        //上传psb
        //String[] strs = new String[] {"name", "sex", "nation", "birthday", "expired", "pid", "djsj", "hotelno", "roomno", "phone", "address", "photo", "sphoto", "cflag"};
        String cardPhotoStr = Base64Image.GetImageStr(InitConfig.PHOTO_PATH + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + order.getOrderNum() + "/" + "getcard"
                + "/" + idCard.getCardNum() + "/card.bmp").replaceAll("\r\n", "");
        String caijiPhotoStr = Base64Image.GetImageStr(InitConfig.PHOTO_PATH + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + order.getOrderNum() + "/" + "getcard"
                + "/" + idCard.getCardNum() + "/caiji.bmp").replaceAll("\r\n", "");
        //String[] val = new String[] {idCard.getName(),"男".equals(idCard.getSex())?"1":"2",idCard.getMinzu(),idCard.getBirthday(),idCard.getStartTime()+"-"+idCard.getEndTime(),idCard.getCardNum(),
        //		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),"4205000169",roomno,"",idCard.getAddress(),cardPhotoStr,caijiPhotoStr,"Y"};
        String checkInTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        GuestBean bean = new GuestBean();
        bean.setName(idCard.getName());
        bean.setSex(idCard.getSex());
        bean.setNationCode(idCard.getMinzu());
        bean.setBirth(idCard.getBirthday());
        bean.setExpired(idCard.getStartTime() + "-" + idCard.getEndTime());
        bean.setIdNo(idCard.getCardNum());
        bean.setCheckInDate(checkInTime);
        bean.setRoomNo(roomno);
        bean.setPhone("");
        bean.setAddress(idCard.getAddress());
        bean.setPhoto(cardPhotoStr);
        bean.setScenePhoto(caijiPhotoStr);
        bean.setOperator(idCard.getName());
        bean.setSemblance("0.99");
        bean.setProvince(idCard.getCardNum().substring(0, 6));
        logger.info("身份证图片信息读取值：" + cardPhotoStr);
        logger.info("性别：" + idCard.getSex());
        logger.info("民族：" + idCard.getMinzu());
        logger.info("身份证有效日期-起始日期：" + idCard.getStartTime());
        String firstRes = psbService.checkInUpload(bean);//客人信息上传psb
        logger.info("第一入住人上传信息返回值：" + firstRes);
        logger.info("=============roomno==============" + roomno);
        if (!"error".equals(roomno) && "ok".equals(firstRes)) {
            if (secondIdCard != null) {
                String secondeRes = "";
                String secCardPhotoStr = Base64Image.GetImageStr(InitConfig.PHOTO_PATH + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + order.getOrderNum() + "/" + "getcard"
                        + "/" + secondIdCard.getCardNum() + "/card.bmp").replaceAll("\r\n", "");
                String secCaijiPhotoStr = Base64Image.GetImageStr(InitConfig.PHOTO_PATH + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + order.getOrderNum() + "/" + "getcard"
                        + "/" + secondIdCard.getCardNum() + "/caiji.bmp").replaceAll("\r\n", "");
                //String[] secVal = new String[] {secondIdCard.getName(),"男".equals(secondIdCard.getSex())?"1":"2",secondIdCard.getMinzu(),secondIdCard.getBirthday(),secondIdCard.getStartTime()+"-"+secondIdCard.getEndTime(),secondIdCard.getCardNum(),
                //		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),"4205000169",roomno,"",secondIdCard.getAddress(),secCardPhotoStr,secCaijiPhotoStr,"Y"};
                GuestBean bean2 = new GuestBean();
                bean2.setName(secondIdCard.getName());
                bean2.setSex(secondIdCard.getSex());
                bean2.setNationCode(secondIdCard.getMinzu());
                bean2.setBirth(secondIdCard.getBirthday());
                bean2.setExpired(secondIdCard.getStartTime() + "-" + secondIdCard.getEndTime());
                bean2.setIdNo(secondIdCard.getCardNum());
                bean2.setCheckInDate(checkInTime);
                bean2.setRoomNo(roomno);
                bean2.setPhone("");
                bean2.setAddress(secondIdCard.getAddress());
                bean2.setPhoto(secCardPhotoStr);
                bean2.setScenePhoto(secCaijiPhotoStr);
                bean2.setOperator(secondIdCard.getName());
                bean2.setSemblance("0.99");
                bean2.setProvince(secondIdCard.getCardNum().substring(0, 6));
                secondeRes = psbService.checkInUpload(bean2);//第二入住客人信息上传psb
                logger.info("第二入住人上传信息返回值：" + secondeRes);
                if ("fail".equals(secondeRes)) {
                    return null;
                }
            }
            boolean res1 = sendCardService.moveCard();//收发卡器将房卡移动到写卡位
            RoomOrderInfo roomOrderInfo = new RoomOrderInfo();
            roomOrderInfo.setOrdernum(order.getOrderNum());
            roomOrderInfo.setRoomnum(roomno);
            int flag = roomOrderInfoService.insert(roomOrderInfo);//得到房间号-订单对应表ID，作为房卡卡号
            //添加信息到RoomIdentity表
            RoomIdentityInfo roomIdentityInfo = new RoomIdentityInfo();
            roomIdentityInfo.setId(roomOrderInfo.getId());
            roomIdentityInfo.setRoomnum(roomno);
            roomIdentityInfo.setIdentity(identity);
            roomIdentityInfo.setCheckInTime(checkInTime);
            int l = roomIdentityInfoService.insert(roomIdentityInfo);
            logger.info("=============cardNum==============" + roomOrderInfo.getId());
            if (res1 && l > 0) {
                logger.info("收发卡器将房卡移动到写卡位");
                //boolean res2 = lockService.write(roomOrderInfo.getId()+"", order.getInTime()+ " 6:00", order.getOutTime() + " 14:00");//写房卡
                //if (res2) {//写房卡成功
                logger.info("写房卡成功");
                boolean res3 = sendCardService.outCard();//收发卡器出房卡
                if (res3) {
                    logger.info("收发卡器出房卡");
                    checkIn = new CheckInInfo();
                    checkIn.setRoomNum(roomno);
                    checkIn.setOrderNum(order.getOrderNum());
                    checkIn.setInTime(order.getInTime());
                    checkIn.setOutTime(order.getOutTime());
                    logger.info("收发卡器出房卡成功-返回");
                    return checkIn;
                }
                /*} else {//写房卡失败
                    logger.info("=========写卡信息失败=================");
				}*/
            }
        }
        return checkIn;

    }

    /**
     * 查询未入住订单(团队入住)-->支付-->获取可用房-->读取身份证-->采集照片并比对-->按订单录入、上传身份信息
     *
     * @param phone
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getGroupOrders")
//	public List<OrderInfo> getGroupOrders(@RequestParam(value = "phone") String phone, Model model)throws Exception {
//		List<OrderInfo> list = new ArrayList<>();//无订单
//		list = pmsService.getOrder(phone);
////		model.addAttribute("orderList",list);
//		System.out.println(list);
//		return list;
//
//	}
    public List<Testtdrz> getGroupOrders(@RequestParam(value = "phone") String phone, HttpServletRequest request) throws Exception {
        List<Testtdrz> orderList = testServicetdrz.getOrder(phone);
        Map<String, String> roomMap = new HashMap<>();
        if (orderList != null && orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                String[] roomStr = orderList.get(i).getRoomnum().split(",");
                for (int y = 0; y < roomStr.length; y++) {
                    roomMap.put(orderList.get(i).getOrderid() + "--" + roomStr[y], "0");
                }

            }
        }
        request.getSession().setAttribute("roomMap", roomMap);
        return orderList;
    }

    @ResponseBody
    @RequestMapping(value = "testSession")
    public List<ResultTest> getRoom(String orderid, HttpServletRequest request) {
        if (orderid != null && !orderid.equals("")) {
            request.getSession().setAttribute("orderId", orderid);
        }
        Map<String, String> roomMap = (Map<String, String>) request.getSession().getAttribute("roomMap");
        List<ResultTest> arrayList = new ArrayList<>();
        Iterator<String> iter = roomMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String[] str = key.split("--");
            String orderId = (String) request.getSession().getAttribute("orderId");
            if (str[0].equals(orderId)) {
                String[] split = str[1].split("-");
                ResultTest rt = new ResultTest();
                rt.setRoomname(split[0]);
                rt.setRoomtype(split[1]);
                rt.setCount(roomMap.get(key));
                arrayList.add(rt);
            }
        }
        return arrayList;
    }

    @ResponseBody
    @RequestMapping(value = "testruzhu")
    public List<ResultTest> ruzhu(String roomnum, String ruzhurenshu, String orderid, HttpServletRequest request) {
        List<ResultTest> arrayList = new ArrayList<>();
        Map<String, String> roomMap = (Map<String, String>) request.getSession().getAttribute("roomMap");
        //带上选择好的入住人数,

        //入住传pms,传psb


        //如果入住成功,把对应房间号的入住人数加上
        if (true) {
            Iterator<String> iter = roomMap.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                String[] str = key.split("--");
                if (str[0].equals(orderid)) {
                    String[] split = str[1].split("-");
                    if (split[0].equals(roomnum)) {
                        roomMap.put(key, ruzhurenshu);
                    }
                    ResultTest rt = new ResultTest();
                    rt.setRoomname(split[0]);
                    rt.setRoomtype(split[1]);
                    rt.setCount(roomMap.get(key));
                    arrayList.add(rt);
                }
            }

        }
        request.getSession().setAttribute("roomMap", roomMap);
        return arrayList;
    }

//    public static void main(String[] args) throws Exception {
//        Map<String, String> hashMap = new HashedMap();
//        hashMap.put("1991--1001-哈哈", "0");
//        hashMap.put("1991--1002-哈哈", "0");
//        hashMap.put("1992--2001-思考开始", "0");
//        hashMap.put("1992--2002-大健康", "0");
//        System.out.println(hashMap);
//        Iterator<String> iter = hashMap.keySet().iterator();
//        while (iter.hasNext()) {
//            String key = iter.next();
//            String[] str = key.split("--");
//            if (str[0].equals("1991")) {
//                String[] split = str[1].split("-");
//                if (split[0].equals("1001")) {
//                    hashMap.put(key, "1");
//                }
//            }
//        }
//        System.out.println(hashMap);
//    }

    /**
     * 获取可用房(团队入住)
     *
     * @param
     * @param inTime
     * @param outTime
     * @param orderNo
     * @param model
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getAvailableRoom")
    public List<AvailableRoom> getAvailableRoom(

            @RequestParam(value = "roomCode") String roomCode,
            @RequestParam(value = "inTime") String inTime,
            @RequestParam(value = "outTime") String outTime,
            @RequestParam(value = "orderNo") String orderNo, Model model) throws Exception {
        List<AvailableRoom> availableRoomList = pmsService.getAvailableRoomForGroup(inTime, outTime, roomCode);//获取可用房间
//		model.addAttribute("availableRoomList",availableRoomList);
//		model.addAttribute("orderNo",orderNo);
        return availableRoomList;
    }

    /**
     * 检测身份证 (团队入住)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkcardRorGroup")
    @ResponseBody
    public String checkcardRorGroup(HttpServletRequest request) throws Exception {
        logger.info("checkcard call success.");
        cardService.openPort();//打开身份证读卡器端口
        boolean result = cardService.check();
        System.out.println(result);
        if (result) {
            return "ok";
        } else {
            return "fail";
        }
    }

    /**
     * 读取身份证（团队入住）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/readCardRorGroup")
    @ResponseBody
    public String readCardRorGroup(String roomname,HttpServletRequest request) throws Exception {
        IdCard idCard = cardService.read();//读取团队入住人身份证信息
        cardService.closePort();//关闭身份证读卡器端
        if (idCard != null) {//读取成功
            request.getSession().setAttribute("idCardForGroup", idCard);// session中放入团队入住人信息
            request.getSession().setAttribute("roomnumber",roomname);//要住的房间号存到session
            return "ok";
        } else {//读取失败
            request.getSession().removeAttribute("idCardForGroup");
            return "fail";
        }
    }

    /**
     * 第二入住人读取身份证(团队入住)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/secreadcardRorGroup")
    @ResponseBody
    public String secreadcardRorGroup(HttpServletRequest request) throws Exception {
        IdCard secondIdCard = cardService.read();//读取第二入住人身份证信息
        cardService.closePort();//关闭身份证读卡器端口
        if (secondIdCard != null) {//读取成功
            Object o = request.getSession().getAttribute("firstIdCard");
            if (o != null) {
                IdCard firstIdCard = (IdCard) o;
                if (secondIdCard.getCardNum().equals(firstIdCard.getCardNum())) {//判断第一入住人和第二入住人是否相同
                    return "same";//第一入住人和第二入住人相同，提示错误信息
                } else {
                    request.getSession().setAttribute("secondIdCard",
                            secondIdCard);// session中放入第二入住人信息
                    return "ok";
                }
            }

        } else {//读取失败
            request.getSession().removeAttribute("secondIdCard");
            return "fail";
        }
        return "fail";
    }

    /**
     * 采集照片并比对第一入住人（团队入住）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkphotoForGroup")
    @ResponseBody
    public String checkphotoForGroup(HttpServletRequest request) throws Exception {
        System.out.println("--------------------  第一入住人------------------------");
        String str = request.getParameter("str");
        String photoStr = str;
        IdCard idCard = request.getSession().getAttribute("idCardForGroup") == null ? null :
                (IdCard) request.getSession().getAttribute("idCardForGroup");
        if (idCard != null) {
            personCardService.savePhoto(idCard.getCardNum(), photoStr, "000001", "getcard");
            if (personCardService.Comparison(idCard.getCardNum(), "000001", "getcard", idCard)) {
                return "ok";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

    /**
     * 第二入住人采集照片并比对(团队入住)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/seccheckphotoForGroup")
    @ResponseBody
    public String seccheckphotoForGroup(HttpServletRequest request) throws Exception {
        String str = request.getParameter("str");

        String photoStr = str;//str.split("<imgBase>")[1].split("</imgBase>")[0];
        IdCard idCard = request.getSession().getAttribute("secondIdCard") == null ? null
                : (IdCard) request.getSession().getAttribute("secondIdCard");
        OrderInfo order = request.getSession().getAttribute("order") == null ? null
                : (OrderInfo) request.getSession().getAttribute("order");
        if (idCard != null && order != null) {
            personCardService.savePhoto(idCard.getCardNum(), photoStr, "000001", "getcard");
            if (personCardService.Comparison(idCard.getCardNum(), "000001", "getcard", idCard)) {

                return "ok";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

   /* *//**
     * 按订单录入、上传身份信息（团队入住）
     *
     * @param request
     * @return
     * @throws Exception
     *//*
    @RequestMapping("/checkInForGroup")
    @ResponseBody
    public CheckInInfo checkInForGroup(@RequestBody OrderInfo order, HttpServletRequest request) throws Exception {
        CheckInInfo checkIn = null;
        IdCard idCard = request.getSession().getAttribute("idCardForGroup") == null ? null :
                (IdCard) request.getSession().getAttribute("idCardForGroup");
        pmsService.updateOrderInfo(idCard, order.getOrderNumPMS());//更改主单证件信息

        logger.info("========客户姓名===" + idCard.getName());
        logger.info("========ordernum===" + order.getOrderNum());

        String roomno = pmsService.checkIn(idCard, order);//办理入住，得到房间号
        logger.info("=============roomno==============" + roomno);
        checkIn = new CheckInInfo();
        checkIn.setRoomNum((order.getRoomNum() != null && !"".equals(order.getRoomNum())) ? order.getRoomNum() : roomno);
        checkIn.setOrderNum(order.getOrderNum());
        checkIn.setInTime(order.getInTime());
        checkIn.setOutTime(order.getOutTime());
        return checkIn;
    }*/

    /**
     * 根据房卡查询入住单
     *
     * @param request
     * @return
     */
    @RequestMapping("/getcheckinInfo")
    @ResponseBody
    public CheckInInfo getcheckinInfo(HttpServletRequest request, Model model)
            throws Exception {
        logger.info("getcheckinInfo call success...");
        String cardNum = lockService.read();//读房卡的卡号
        logger.info("getcheckinInfo==========cardNum==============="
                + cardNum);
        if ("error".equals(cardNum)) {
            return null;
        } else {
            RoomOrderInfo roomOrderInfo = roomOrderInfoService.selectByPrimaryKey(Integer.parseInt(cardNum));//根据房卡卡号得到房间-订单对应表记录
            if (roomOrderInfo == null) {
                return null;
            }
            String roomNum = roomOrderInfo.getRoomnum();//房号
            String resno = roomOrderInfo.getOrdernum();//订单号
            List<CheckInInfo> list = pmsService.getCheckInInfo(resno + "," + roomNum);
            logger.info("==============roomNum==============" + roomNum);
            if (list == null) {//查不到入住单，可能已退房
                String status = pmsService.getRoomStatus(resno + "," + roomNum);
                if ("out".equals(status)) {//已退房
                    CheckInInfo checkInfo = new CheckInInfo();
                    return checkInfo;
                }
            }
            logger.info("getcheckinInfo=========list size============"
                    + list.size());
            if (list.size() == 1) {//查询到唯一入住单
                request.getSession().setAttribute("roomCardNum", cardNum);
                request.getSession().setAttribute("checkInInfo", list.get(0));
                return list.get(0);
            } else {
                return null;
            }

        }
    }

    /**
     * 取房卡采集照片并比对
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkphoto")
    @ResponseBody
    public String checkphoto(HttpServletRequest request) throws Exception {
        logger.info("checkphoto call success...");
        String str = request.getParameter("str");

        String photoStr = str;//str.split("<imgBase>")[1].split("</imgBase>")[0];
        IdCard idCard = request.getSession().getAttribute("firstIdCard") == null ? null
                : (IdCard) request.getSession().getAttribute("firstIdCard");
        OrderInfo order = request.getSession().getAttribute("order") == null ? null
                : (OrderInfo) request.getSession().getAttribute("order");
        if (idCard != null && order != null) {
            logger.info("============cardno================="
                    + idCard.getCardNum());
            logger.info("============orderno================="
                    + order.getOrderNum());
            personCardService.savePhoto(idCard.getCardNum(), photoStr,
                    order.getOrderNum(), "getcard");
            logger.info("============checkphoto=================");
            if (personCardService.Comparison(idCard.getCardNum(),
                    order.getOrderNum(), "getcard", idCard)) {
                return "ok";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

    /**
     * 取房卡第二入住人采集照片并比对
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/seccheckphoto")
    @ResponseBody
    public String seccheckphoto(HttpServletRequest request) throws Exception {
        logger.info("seccheckphoto call success...");
        String str = request.getParameter("str");

        String photoStr = str;//str.split("<imgBase>")[1].split("</imgBase>")[0];
        IdCard idCard = request.getSession().getAttribute("secondIdCard") == null ? null
                : (IdCard) request.getSession().getAttribute("secondIdCard");
        OrderInfo order = request.getSession().getAttribute("order") == null ? null
                : (OrderInfo) request.getSession().getAttribute("order");
        if (idCard != null && order != null) {
            logger.info("============cardno================="
                    + idCard.getCardNum());
            logger.info("============orderno================="
                    + order.getOrderNum());
            personCardService.savePhoto(idCard.getCardNum(), photoStr,
                    order.getOrderNum(), "getcard");
            logger.info("============checkphoto=================");
            if (personCardService.Comparison(idCard.getCardNum(),
                    order.getOrderNum(), "getcard", idCard)) {

                return "ok";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

    /**
     * 查询模块采集照片并比对
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/querycheckphoto")
    @ResponseBody
    public String querycheckphoto(HttpServletRequest request) throws Exception {
        logger.info("querycheckphoto call success...");
        String str = request.getParameter("str");

        String photoStr = str;//str.split("<imgBase>")[1].split("</imgBase>")[0];
        IdCard idCard = request.getSession().getAttribute("queryIdCard") == null ? null
                : (IdCard) request.getSession().getAttribute("queryIdCard");
        CheckInInfo checkInInfo = request.getSession().getAttribute(
                "checkInInfo") == null ? null : (CheckInInfo) request
                .getSession().getAttribute("checkInInfo");
        if (idCard != null && checkInInfo != null) {
            logger.info("============cardno================="
                    + idCard.getCardNum());
            logger.info("============orderno================="
                    + checkInInfo.getOrderNum());
            personCardService.savePhoto(idCard.getCardNum(), photoStr,
                    checkInInfo.getOrderNum(), "query");
            logger.info("============checkphoto=================");
            if (personCardService.Comparison(idCard.getCardNum(),
                    checkInInfo.getOrderNum(), "query", idCard)) {
                return "ok";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

    /**
     * 发送短信，入住信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/sendSMS")
    @ResponseBody
    public String sendSMS(HttpServletRequest request) throws Exception {
        logger.info("sendSMS call success...");
        String phone = request.getParameter("mobile");
        String roomNum = request.getParameter("roomNum");
        String orderNum = request.getParameter("orderNum");
        logger.info("sendSMS===========orderNum================" + orderNum);
        IdCard idCard = request.getSession().getAttribute("firstIdCard") == null ? null
                : (IdCard) request.getSession().getAttribute("firstIdCard");
        OrderInfo order = (OrderInfo) request.getSession().getAttribute("order");
        List<CheckInInfo> list = pmsService.getCheckInInfo(order.getOrderNum() + "," + order.getRoomNo());
        if (list.size() == 1) {
            CheckInInfo checkInInfo = list.get(0);
            String sex = "";
            if ("男".equals(idCard.getSex())) {
                sex = "先生";
            }
            if ("女".equals(idCard.getSex())) {
                sex = "女士";
            }
            String content = "【滨江壹号大酒店】尊敬的" + idCard.getName() + sex + "，您的房间号是"
                    + checkInInfo.getRoomNum() + "，入住日期为"
                    + DateUtils.format(checkInInfo.getInTime()) + " 6:00至"
                    + DateUtils.format(checkInInfo.getOutTime()) + " 14:00，感谢您使用无限讯奇酒店自助机办理入住!";
            String code = smsService.send(phone, content);
            if ("0".equals(code)) {
                return "ok";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

    /**
     * 获取不同支付方式的二维码、金额等
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getpay")
    @ResponseBody
    public PayBean getpay(HttpServletRequest request) {
        logger.info("getpay call success...");
        String type = request.getParameter("type");
        String service = "";
        if ("zfb".equals(type)) {//支付宝支付
            service = "pay.alipay.native";
        }
        if ("wx".equals(type)) {//微信支付
            service = "pay.weixin.native";
        }
        OrderInfo order = request.getSession().getAttribute("order") == null ? null
                : (OrderInfo) request.getSession().getAttribute("order");
        PayInfo payInfo = request.getSession().getAttribute("payInfo") == null ? null
                : (PayInfo) request.getSession().getAttribute("payInfo");
        PayBean pay = payService.getPay(InitConfig.PAY_HOTELID, order.getOrderNum() + "_" + type + "," + order.getOrderNumPMS(), "房费:" + payInfo.getRoomRate() + "元 ,押金:" + payInfo.getDeposit() + "元 ,总计:" + payInfo.getTotalFree() + "元",
                payInfo.getTotalFree() + "", service);
        request.getSession().setAttribute("payParam", pay);
        System.out
                .println("===================pay===============" + pay.imgUrl);
        return pay;
    }

    /**
     * 支付
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/pay")
    @ResponseBody
    public String pay(HttpServletRequest request) {
        logger.info("pay call success...");

        OrderInfo order = request.getSession().getAttribute("order") == null ? null
                : (OrderInfo) request.getSession().getAttribute("order");
        PayInfo payInfo = request.getSession().getAttribute("payInfo") == null ? null
                : (PayInfo) request.getSession().getAttribute("payInfo");
        PayBean payParam = (PayBean) (request.getSession().getAttribute("payParam") == null ? new PayInfo() : request.getSession().getAttribute("payParam"));
        String payStatus = "";
        payStatus = payService.queryPayStatus(order.getOrderNum() + "_wx" + "," + payParam.getScanChannel() + "," + payParam.getStatus());
        String type = "wx";
        if (!"ok".equals(payStatus)) {
            payStatus = payService.queryPayStatus(order.getOrderNum() + "_zfb" + "," + payParam.getScanChannel() + "," + payParam.getStatus());
            type = "zfb";
        }
        if ("ok".equals(payStatus)) {//两种支付方式成功一种就成功

            if (depositInfoService.selectByPrimaryKey(order.getOrderNum()) == null) {
                boolean b = pmsService.payOrder(order.getOrderNumPMS(), payInfo.getTotalFree());//pms中写入支付信息

                //押金表插入记录
                DepositInfo depositInfo = new DepositInfo();
                depositInfo.setAccnt(order.getOrderNum());
                depositInfo.setAmount(payInfo.deposit + "");
                depositInfo.setIsselfmachine("1");
                depositInfo.setRefundstatus("1");
                depositInfo.setReserve1(type);
                depositInfoService.insert(depositInfo);
                if (b) {
                    return "ok";
                }
            }
        }
        return "fail";
    }

//	public static void main(String[] args) {
//		String s = "<?xml version=\"1.0\"?>"
//				+ "<returnMsg><camType>0</camType><deviceMacAddr>005056C00008</deviceMacAddr><imgBase>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</imgBase><locationPoint></locationPoint><resultCode>0</resultCode><resultMsg>成功</resultMsg><version>1.0.3.9</version></returnMsg>"
//				+ "";
//		ReturnMsg r = (ReturnMsg) XmlUtil.xmlStrToBean(s, ReturnMsg.class);
//		String photoStr = r.getImgBase();
//		logger.info(photoStr);
//		String photoPath = "D:/1";
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		String datestr = sdf.format(date);
//		String path = photoPath + "/" + datestr + "/" + 1234 + "/";
//		if (!new File(path).exists()) {
//			new File(path).mkdirs();
//		}
//		Base64Image.GenerateImage(photoStr, path + "caiji.bmp");
//	}

}
