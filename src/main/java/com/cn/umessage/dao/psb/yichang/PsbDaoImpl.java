package com.cn.umessage.dao.psb.yichang;
import org.apache.axiom.om.OMElement;
import org.springframework.stereotype.Repository;

import com.cn.umessage.dao.psb.IpsbDao;
import com.cn.umessage.dao.psb.bean.GuestBean;
import com.cn.umessage.dao.psb.bean.GuestBeanCheckOut;
import com.cn.umessage.dao.psb.yichang.client.DocumentClient;
import com.cn.umessage.utils.InitConfig;
@Repository("yichangPsbDao")
public class PsbDaoImpl implements IpsbDao{
	/**
	 * 入住-客人信息上传psb
	 */
	String hotelId = InitConfig.PSB_HOTELID;
	@Override
	public String checkInUpload(GuestBean guest) {
		// 对应参数的节点
        String[] paramStrArray = new String[] {"name", "sex", "nation", "birthday", "expired", "pid", "djsj", "hotelno", "roomno", "phone", "address", "photo", "sphoto", "cflag"};
        // 参数值
        String[] valStrArray = new String[] {guest.getName(),"男".equals(guest.getSex())?"1":"2",guest.getNationCode(),guest.getBirth(),guest.getExpired(),guest.getIdNo(),guest.getCheckInDate(),hotelId,guest.getRoomNo(),"",guest.getAddress(),guest.getPhoto(),guest.getScenePhoto(),"Y"};
        OMElement result = DocumentClient.getInstance().invokeRampartService("gnlkAdd",paramStrArray,valStrArray);
		if(result!=null && "登记成功".equals(result.getFirstElement().getText())){
			return "ok";
		}
        return "fail";
	}
	/**
	 * 退房-客人信息上传psb
	 */
	@Override
	public String checkOutUpload(GuestBeanCheckOut checkOutBean) {
		// 对应参数的节点
        String[] paramStrArray = new String[] {"pid", "djsj", "tfsj", "hotelno"};
        // 参数值
        String[] valStrArray = new String[] {checkOutBean.getCardNum(),checkOutBean.getCheckInDate(),checkOutBean.getCheckOutDate(),hotelId};
        OMElement result = DocumentClient.getInstance().invokeRampartService("checkOut",paramStrArray,valStrArray);
		if(result!=null && "退房成功".equals(result.getFirstElement().getText())){
			return "ok";
		}
        return "fail";
	
	}
	/*public static void main(String[] args) throws MalformedURLException {
		 
		final QName HOTELSERVICE_QNAME = new QName("http://service.tch.com", "HotelService");
		JaxWsPortProxyFactoryBean factory = new JaxWsPortProxyFactoryBean();  
		factory.setJaxWsService(new HotelService());
		factory.setServiceName(HOTELSERVICE_QNAME.toString());
		factory.setServiceInterface(HotelServicePortType.class);
		factory.setPortName("HotelServicePortType");
        factory.setWsdlDocumentUrl(new URL("http://122.189.200.170:9201/tchWebService/services/HotelService?wsdl"));    
        factory.setUsername("tch");  
        factory.setPassword("whtc027WS");  
        HotelService hs = (HotelService) factory.getJaxWsService();
		//HotelService hs = new HotelService();
		HotelServicePortType hspt = hs.getHotelServiceHttpSoap11Endpoint();
		String result = hspt.gnlkAdd("张三","1","汉","1990-01-01","2010.01.02-2020.01.02","370102199001018801","2018-04-11 16:17:02","4205000169","603","13411112222","北京市东城区","xxxxx","xxxxxx","N");
		System.out.println(result);
	}*/
	public static void main(String[] args) {
		// 对应参数的节点
        String[] paramStrArray = new String[] {"name", "sex", "nation", "birthday", "expired", "pid", "djsj", "hotelno", "roomno", "phone", "address", "photo", "sphoto", "cflag"};
        // 参数值
        String[] valStrArray = new String[] {"马六","1","汉","1990-01-01","2010.01.02-2020.01.02","370102199001018801","2018-04-11 16:17:02","4205000169","603","13411112222","北京市东城区","xxxxx","xxxxxx","N"};
        OMElement result = DocumentClient.getInstance().invokeRampartService("gnlkAdd",paramStrArray,valStrArray);
        if(result!=null && "登记成功".equals(result.getFirstElement().getText())){
			System.out.println("ok");
		}else{
			System.out.println("fail");
		}
	}
	
}
