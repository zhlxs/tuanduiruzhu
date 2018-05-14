package com.cn.umessage.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.cn.umessage.dao.psb.IpsbDao;
import com.cn.umessage.dao.psb.bean.GuestBean;
import com.cn.umessage.dao.psb.bean.GuestBeanCheckOut;
import com.cn.umessage.dao.psb.guotai.bean.NationCode;
import com.cn.umessage.pojo.CodeTable;
import com.cn.umessage.pojo.RoomIdentityInfo;
import com.cn.umessage.service.ICodeTableService;
import com.cn.umessage.service.IPsbService;
import com.cn.umessage.service.IRoomIdentityInfoService;
import com.cn.umessage.service.IRoomOrderInfoService;
import com.cn.umessage.utils.CreateXMLUtis;
import com.cn.umessage.utils.InitConfig;

@Service("psbService")
public class PsbServiceImpl implements IPsbService{
	private static Logger logger = Logger.getLogger(PsbServiceImpl.class);
	@Resource
	private IpsbDao yichangPsbDao;
	@Resource
	private IpsbDao guotaiPsbDao;
	@Resource
    //字典
    private ICodeTableService codeTableService;
	@Resource
	//房间号订单号对应服务
	private IRoomOrderInfoService roomOrderInfoService;
	@Resource
	 //房间身份证号服务
    private IRoomIdentityInfoService roomIdentityInfoService;
	@Override
	public String checkInUpload(GuestBean guest) {
		String result = "";
		String psbName = InitConfig.PSB_COMPANY;
		
		switch (psbName) {
		case "yichang":
			// 对应参数的节点
	        //String[] yichangparamStrArray = new String[] {"name", "sex", "nation", "birthday", "expired", "pid", "djsj", "hotelno", "roomno", "phone", "address", "photo", "sphoto", "cflag"};
	        // 参数值
	        //String[] yichangvalStrArray = new String[] {guest.getName(),"男".equals(guest.getSex())?"1":"2",guest.getNationCode(),guest.getBirth(),guest.getExpired(),guest.getIdNo(),guest.getCheckInDate(),"4205000169",guest.getRoomNo(),"",guest.getAddress(),guest.getPhoto(),guest.getScenePhoto(),"Y"};
			result = yichangPsbDao.checkInUpload(guest);
			break;
		case "guotai":
			guest.setSex("男".equals(guest.getSex())?"1":"2");
			guest.setFaceResult("通过");
			guest.setIdType("11");
			guest.setpType("0");
			guest.setPsbId("1234567890");
			guest.setNationCode(NationCode.getNationCode(guest.getNationCode()));//民族代码
			//String[] guotaiparamStrArray = new String[] {"pType", "psbId", "idNo", "name", "sex", "nationCode", "birth", "idType", "province", "address", "checkInDate", "roomNo", "photo", "ScenePhoto","Semblance","faceResult","Operator"};
			//String[] guotaivalStrArray = new String[] {"0",guest.getPsbId(),guest.getIdNo(),guest.getName(),"男".equals(guest.getSex())?"1":"2",guest.getNationCode(),guest.getBirth(),"11",guest.getProvince(),guest.getAddress(),guest.getCheckInDate(),guest.getRoomNo(),guest.getPhoto(),guest.getScenePhoto(),guest.getSemblance(),guest.getFaceResult(),guest.getOperator()};
			result = guotaiPsbDao.checkInUpload(guest);
			break;
		case "jinchengxin":
			String jgy=guest.getAddress();
			if(guest.getAddress().contains("区")){
				String[] saddress2=guest.getAddress().split("区");
				String[] saddse3=(saddress2[0]+"区").split("市");
				CodeTable codeTable=codeTableService.getCodeByName(saddse3[1],"1");
				if(codeTable==null){
				}else {
					jgy=codeTable.getDmzm();
				}
			}else if (guest.getAddress().contains("县")) {
				String[] saddress2=guest.getAddress().split("县");
				String[] saddse3=(saddress2[0]+"县").split("市");
				CodeTable codeTable=codeTableService.getCodeByName(saddse3[1],"1");
				if(codeTable==null){
				}else {
					jgy=codeTable.getDmzm();
				}
			}
			boolean bool = CreateXMLUtis.createNBXML("NB", "I", "1", "11", 
					guest.getIdNo(), guest.getName(), codeTableService.getCodeByTypeANDByName("xb", guest.getSex()), 
					guest.getBirth(), guest.getRoomNo(), codeTableService.getCodeByTypeANDByName("mz", (guest.getNationCode()+"族")), jgy, 
					guest.getAddress(), "15","03", "", "330302", "330302", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
					guest.getScenePhoto(), "");
			result = bool==true?"ok":"fail";
			break;
		default:
			System.out.println("default");
			break;
		}
		return result;
	}

	@Override
	public String checkOutUpload(GuestBeanCheckOut checkOutBean) {
		String result = "";
		String psbName = InitConfig.PSB_COMPANY;
		Integer kahao=Integer.valueOf(checkOutBean.getRoomCardNum());
		RoomIdentityInfo roomIdentityInfo=roomIdentityInfoService.getRoomOrderInfoById(kahao);
		switch (psbName) {
		case "yichang":
			String yichangRes = "";
			if(roomIdentityInfo != null){
				String checkInTime = roomIdentityInfo.getCheckInTime();
				checkOutBean.setCheckInDate(checkInTime);//入住日期
				String [] listIdentity= roomIdentityInfo.getIdentity().split(",");
				for (int i = 0; i < listIdentity.length; i++) {
					checkOutBean.setCardNum(listIdentity[i]);//身份证号
					String psbRes = yichangPsbDao.checkOutUpload(checkOutBean);
					yichangRes+=psbRes;
				}
				if(yichangRes.contains("fail")){
					result = "fail";
				}else{
					result = "ok";
				}
			}else{
				logger.info("查询roomIdentityInfo为空值！位置---PsbServiceImpl.java--jinchengxin分支");
				result = "fail";
			}
			break;
		case "guotai":
			checkOutBean.setPsbId("1234567890");
			result = guotaiPsbDao.checkOutUpload(checkOutBean);
			break;
		case "jinchengxin":
			//------------退房生成xml---------
			String boolRes = "";
			if(roomIdentityInfo != null){
				String [] listIdentity= roomIdentityInfo.getIdentity().split(",");
				for (int i = 0; i < listIdentity.length; i++) {
					boolean bool = CreateXMLUtis.createNBLDXML(listIdentity[i], roomIdentityInfo.getRoomnum(),i);
					boolRes+=String.valueOf(bool);
				}
				if(boolRes.contains("false")){
					result = "fail";
				}else{
					result = "ok";
				}
			}else{
				logger.info("查询roomIdentityInfo为空值！位置---PsbServiceImpl.java--jinchengxin分支");
				result = "fail";
			}
			break;
		default:
			logger.info("未配置psb厂商信息！");
			break;
		}
		return result;
	}

}
