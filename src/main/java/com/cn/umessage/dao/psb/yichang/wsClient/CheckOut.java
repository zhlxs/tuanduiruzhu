
package com.cn.umessage.dao.psb.yichang.wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="djsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tfsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotelno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pid",
    "djsj",
    "tfsj",
    "hotelno"
})
@XmlRootElement(name = "checkOut")
public class CheckOut {

    @XmlElementRef(name = "pid", namespace = "http://service.tch.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pid;
    @XmlElementRef(name = "djsj", namespace = "http://service.tch.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> djsj;
    @XmlElementRef(name = "tfsj", namespace = "http://service.tch.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tfsj;
    @XmlElementRef(name = "hotelno", namespace = "http://service.tch.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hotelno;

    /**
     * Gets the value of the pid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPid() {
        return pid;
    }

    /**
     * Sets the value of the pid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPid(JAXBElement<String> value) {
        this.pid = value;
    }

    /**
     * Gets the value of the djsj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDjsj() {
        return djsj;
    }

    /**
     * Sets the value of the djsj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDjsj(JAXBElement<String> value) {
        this.djsj = value;
    }

    /**
     * Gets the value of the tfsj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTfsj() {
        return tfsj;
    }

    /**
     * Sets the value of the tfsj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTfsj(JAXBElement<String> value) {
        this.tfsj = value;
    }

    /**
     * Gets the value of the hotelno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHotelno() {
        return hotelno;
    }

    /**
     * Sets the value of the hotelno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHotelno(JAXBElement<String> value) {
        this.hotelno = value;
    }

}
