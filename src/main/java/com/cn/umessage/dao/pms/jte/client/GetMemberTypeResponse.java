package com.cn.umessage.dao.pms.jte.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element name="GetMemberTypeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getMemberTypeResult" })
@XmlRootElement(name = "GetMemberTypeResponse")
public class GetMemberTypeResponse {

	@XmlElementRef(name = "GetMemberTypeResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> getMemberTypeResult;

	/**
	 * ��ȡgetMemberTypeResult���Ե�ֵ��
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getGetMemberTypeResult() {
		return getMemberTypeResult;
	}

	/**
	 * ����getMemberTypeResult���Ե�ֵ��
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setGetMemberTypeResult(JAXBElement<String> value) {
		this.getMemberTypeResult = value;
	}

}
