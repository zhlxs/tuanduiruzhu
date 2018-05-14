package com.cn.umessage.dao.pms.jte.bean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>
 * anonymous complex type�� Java �ࡣ
 * 
 * <p>
 * ����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Msg">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SUVERL" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="hotel_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="room_type_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="room_type_title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="market_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="individual_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="agreement_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="members_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="mediation_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="over_reserve_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="check_in_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="reservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="first_deposit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="next_deposit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="hours_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "msgOrBody" })
@XmlRootElement(name = "Context")
public class GetRoomType {

	@XmlElements({
			@XmlElement(name = "Msg", type = GetRoomType.Msg.class, nillable = true),
			@XmlElement(name = "Body", type = GetRoomType.Body.class) })
	protected List<Object> msgOrBody;

	/**
	 * Gets the value of the msgOrBody property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the msgOrBody property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMsgOrBody().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link GetRoomType.Msg } {@link GetRoomType.Body }
	 * 
	 * 
	 */
	public List<Object> getMsgOrBody() {
		if (msgOrBody == null) {
			msgOrBody = new ArrayList<Object>();
		}
		return this.msgOrBody;
	}

	/**
	 * <p>
	 * anonymous complex type�� Java �ࡣ
	 * 
	 * <p>
	 * ����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="SUVERL" maxOccurs="unbounded" minOccurs="0">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="hotel_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="room_type_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="room_type_title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="market_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="individual_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="agreement_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="members_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="mediation_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="over_reserve_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="check_in_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="reservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="first_deposit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="next_deposit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="hours_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "suverl" })
	public static class Body {

		@XmlElement(name = "SUVERL")
		protected List<GetRoomType.Body.SUVERL> suverl;

		/**
		 * Gets the value of the suverl property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the suverl property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getSUVERL().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link GetRoomType.Body.SUVERL }
		 * 
		 * 
		 */
		public List<GetRoomType.Body.SUVERL> getSUVERL() {
			if (suverl == null) {
				suverl = new ArrayList<GetRoomType.Body.SUVERL>();
			}
			return this.suverl;
		}

		/**
		 * <p>
		 * anonymous complex type�� Java �ࡣ
		 * 
		 * <p>
		 * ����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="hotel_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="room_type_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="room_type_title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="market_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="individual_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="agreement_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="members_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="mediation_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="over_reserve_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="check_in_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="reservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="first_deposit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="next_deposit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="hours_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "hotelCode", "roomTypeCode",
				"roomTypeTitle", "marketPrice", "individualPrice",
				"agreementPrice", "membersPrice", "mediationPrice",
				"overReserveNum", "checkInNum", "information", "reservation",
				"firstDeposit", "nextDeposit", "hoursPrice", "remark" })
		public static class SUVERL {

			@XmlElement(name = "hotel_code")
			protected String hotelCode;
			@XmlElement(name = "room_type_code")
			protected String roomTypeCode;
			@XmlElement(name = "room_type_title")
			protected String roomTypeTitle;
			@XmlElement(name = "market_price")
			protected String marketPrice;
			@XmlElement(name = "individual_price")
			protected String individualPrice;
			@XmlElement(name = "agreement_price")
			protected String agreementPrice;
			@XmlElement(name = "members_price")
			protected String membersPrice;
			@XmlElement(name = "mediation_price")
			protected String mediationPrice;
			@XmlElement(name = "over_reserve_num")
			protected String overReserveNum;
			@XmlElement(name = "check_in_num")
			protected String checkInNum;
			protected String information;
			protected String reservation;
			@XmlElement(name = "first_deposit")
			protected String firstDeposit;
			@XmlElement(name = "next_deposit")
			protected String nextDeposit;
			@XmlElement(name = "hours_price")
			protected String hoursPrice;
			protected String remark;

			/**
			 * ��ȡhotelCode���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getHotelCode() {
				return hotelCode;
			}

			/**
			 * ����hotelCode���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setHotelCode(String value) {
				this.hotelCode = value;
			}

			/**
			 * ��ȡroomTypeCode���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getRoomTypeCode() {
				return roomTypeCode;
			}

			/**
			 * ����roomTypeCode���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setRoomTypeCode(String value) {
				this.roomTypeCode = value;
			}

			/**
			 * ��ȡroomTypeTitle���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getRoomTypeTitle() {
				return roomTypeTitle;
			}

			/**
			 * ����roomTypeTitle���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setRoomTypeTitle(String value) {
				this.roomTypeTitle = value;
			}

			/**
			 * ��ȡmarketPrice���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getMarketPrice() {
				return marketPrice;
			}

			/**
			 * ����marketPrice���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setMarketPrice(String value) {
				this.marketPrice = value;
			}

			/**
			 * ��ȡindividualPrice���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getIndividualPrice() {
				return individualPrice;
			}

			/**
			 * ����individualPrice���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setIndividualPrice(String value) {
				this.individualPrice = value;
			}

			/**
			 * ��ȡagreementPrice���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getAgreementPrice() {
				return agreementPrice;
			}

			/**
			 * ����agreementPrice���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setAgreementPrice(String value) {
				this.agreementPrice = value;
			}

			/**
			 * ��ȡmembersPrice���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getMembersPrice() {
				return membersPrice;
			}

			/**
			 * ����membersPrice���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setMembersPrice(String value) {
				this.membersPrice = value;
			}

			/**
			 * ��ȡmediationPrice���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getMediationPrice() {
				return mediationPrice;
			}

			/**
			 * ����mediationPrice���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setMediationPrice(String value) {
				this.mediationPrice = value;
			}

			/**
			 * ��ȡoverReserveNum���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getOverReserveNum() {
				return overReserveNum;
			}

			/**
			 * ����overReserveNum���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setOverReserveNum(String value) {
				this.overReserveNum = value;
			}

			/**
			 * ��ȡcheckInNum���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getCheckInNum() {
				return checkInNum;
			}

			/**
			 * ����checkInNum���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setCheckInNum(String value) {
				this.checkInNum = value;
			}

			/**
			 * ��ȡinformation���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getInformation() {
				return information;
			}

			/**
			 * ����information���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setInformation(String value) {
				this.information = value;
			}

			/**
			 * ��ȡreservation���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getReservation() {
				return reservation;
			}

			/**
			 * ����reservation���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setReservation(String value) {
				this.reservation = value;
			}

			/**
			 * ��ȡfirstDeposit���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getFirstDeposit() {
				return firstDeposit;
			}

			/**
			 * ����firstDeposit���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setFirstDeposit(String value) {
				this.firstDeposit = value;
			}

			/**
			 * ��ȡnextDeposit���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNextDeposit() {
				return nextDeposit;
			}

			/**
			 * ����nextDeposit���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setNextDeposit(String value) {
				this.nextDeposit = value;
			}

			/**
			 * ��ȡhoursPrice���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getHoursPrice() {
				return hoursPrice;
			}

			/**
			 * ����hoursPrice���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setHoursPrice(String value) {
				this.hoursPrice = value;
			}

			/**
			 * ��ȡremark���Ե�ֵ��
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getRemark() {
				return remark;
			}

			/**
			 * ����remark���Ե�ֵ��
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setRemark(String value) {
				this.remark = value;
			}

		}

	}

	/**
	 * <p>
	 * anonymous complex type�� Java �ࡣ
	 * 
	 * <p>
	 * ����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;simpleContent>
	 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *     &lt;/extension>
	 *   &lt;/simpleContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "value" })
	public static class Msg {

		@XmlValue
		protected String value;
		@XmlAttribute(name = "ID")
		protected String id;

		/**
		 * ��ȡvalue���Ե�ֵ��
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getValue() {
			return value;
		}

		/**
		 * ����value���Ե�ֵ��
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * ��ȡid���Ե�ֵ��
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getID() {
			return id;
		}

		/**
		 * ����id���Ե�ֵ��
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setID(String value) {
			this.id = value;
		}

	}

}
