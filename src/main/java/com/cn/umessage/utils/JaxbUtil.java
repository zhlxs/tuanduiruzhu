package com.cn.umessage.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cn.umessage.dao.pms.jte.bean.GetRoomType;

/**
 * Jaxb2工具类
 */
public class JaxbUtil {

	/**
	 * JavaBean转换成xml 默认编码UTF-8
	 * 
	 * @param obj
	 * @param writer
	 * @return
	 */
	public static String convertToXml(Object obj) {
		return convertToXml(obj, "UTF-8");
	}

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return
	 */
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * xml转换成JavaBean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	public static void main(String[] args) {
		String typemessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Context><Msg ID=\"OK\">成功</Msg><Body><SUVERL><hotel_code>HOTEL1479385471</hotel_code><room_type_code>FX170707000000110001</room_type_code><room_type_title>胭脂坊</room_type_title><market_price>111.00</market_price><individual_price>111.00</individual_price><agreement_price>1111.00</agreement_price><members_price>111.00</members_price><mediation_price>111.00</mediation_price><over_reserve_num></over_reserve_num><check_in_num>11</check_in_num><information></information><reservation></reservation><first_deposit>111.00</first_deposit><next_deposit></next_deposit><hours_price>111.00</hours_price><remark></remark></SUVERL></Body></Context>";

		GetRoomType c = converyToJavaBean(typemessage, GetRoomType.class);
		List<Object> list = c.getMsgOrBody();
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			if (o.getClass() == GetRoomType.Msg.class) {
				System.out.println(((GetRoomType.Msg) o).getValue());
			} else if (o.getClass() == GetRoomType.Body.class) {
				List<GetRoomType.Body.SUVERL> list2 = ((GetRoomType.Body) o)
						.getSUVERL();
				for (int j = 0; j < list2.size(); j++) {
					GetRoomType.Body.SUVERL suverl = list2.get(j);
					System.out.println(suverl.getRoomTypeTitle());
				}

			}

		}
		System.out.println(c.getMsgOrBody().size());
	}
}
