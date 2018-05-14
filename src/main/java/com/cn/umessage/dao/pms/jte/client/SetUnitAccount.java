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
 *         &lt;element name="dcmessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jsmessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "dcmessage", "jsmessage" })
@XmlRootElement(name = "SetUnitAccount")
public class SetUnitAccount {

	@XmlElementRef(name = "dcmessage", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> dcmessage;
	@XmlElementRef(name = "jsmessage", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> jsmessage;

	/**
	 * ��ȡdcmessage���Ե�ֵ��
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getDcmessage() {
		return dcmessage;
	}

	/**
	 * ����dcmessage���Ե�ֵ��
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setDcmessage(JAXBElement<String> value) {
		this.dcmessage = value;
	}

	/**
	 * ��ȡjsmessage���Ե�ֵ��
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getJsmessage() {
		return jsmessage;
	}

	/**
	 * ����jsmessage���Ե�ֵ��
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setJsmessage(JAXBElement<String> value) {
		this.jsmessage = value;
	}

}
