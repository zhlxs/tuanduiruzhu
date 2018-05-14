
package com.cn.umessage.dao.psb.yichang.wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cn.umessage.dao.psb.yichang.wsClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TestResponseReturn_QNAME = new QName("http://service.tch.com", "return");
    private final static QName _GnlkAddPid_QNAME = new QName("http://service.tch.com", "pid");
    private final static QName _GnlkAddNation_QNAME = new QName("http://service.tch.com", "nation");
    private final static QName _GnlkAddPhoto_QNAME = new QName("http://service.tch.com", "photo");
    private final static QName _GnlkAddExpired_QNAME = new QName("http://service.tch.com", "expired");
    private final static QName _GnlkAddSex_QNAME = new QName("http://service.tch.com", "sex");
    private final static QName _GnlkAddPhone_QNAME = new QName("http://service.tch.com", "phone");
    private final static QName _GnlkAddBirthday_QNAME = new QName("http://service.tch.com", "birthday");
    private final static QName _GnlkAddSphoto_QNAME = new QName("http://service.tch.com", "sphoto");
    private final static QName _GnlkAddCflag_QNAME = new QName("http://service.tch.com", "cflag");
    private final static QName _GnlkAddDjsj_QNAME = new QName("http://service.tch.com", "djsj");
    private final static QName _GnlkAddHotelno_QNAME = new QName("http://service.tch.com", "hotelno");
    private final static QName _GnlkAddName_QNAME = new QName("http://service.tch.com", "name");
    private final static QName _GnlkAddRoomno_QNAME = new QName("http://service.tch.com", "roomno");
    private final static QName _GnlkAddAddress_QNAME = new QName("http://service.tch.com", "address");
    private final static QName _CheckOutTfsj_QNAME = new QName("http://service.tch.com", "tfsj");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cn.umessage.dao.psb.yichang.wsClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GnlkAdd }
     * 
     */
    public GnlkAdd createGnlkAdd() {
        return new GnlkAdd();
    }

    /**
     * Create an instance of {@link CheckOut }
     * 
     */
    public CheckOut createCheckOut() {
        return new CheckOut();
    }

    /**
     * Create an instance of {@link GnlkAddResponse }
     * 
     */
    public GnlkAddResponse createGnlkAddResponse() {
        return new GnlkAddResponse();
    }

    /**
     * Create an instance of {@link Test }
     * 
     */
    public Test createTest() {
        return new Test();
    }

    /**
     * Create an instance of {@link TestResponse }
     * 
     */
    public TestResponse createTestResponse() {
        return new TestResponse();
    }

    /**
     * Create an instance of {@link CheckOutResponse }
     * 
     */
    public CheckOutResponse createCheckOutResponse() {
        return new CheckOutResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "return", scope = TestResponse.class)
    public JAXBElement<String> createTestResponseReturn(String value) {
        return new JAXBElement<String>(_TestResponseReturn_QNAME, String.class, TestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "return", scope = GnlkAddResponse.class)
    public JAXBElement<String> createGnlkAddResponseReturn(String value) {
        return new JAXBElement<String>(_TestResponseReturn_QNAME, String.class, GnlkAddResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "pid", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddPid(String value) {
        return new JAXBElement<String>(_GnlkAddPid_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "nation", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddNation(String value) {
        return new JAXBElement<String>(_GnlkAddNation_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "photo", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddPhoto(String value) {
        return new JAXBElement<String>(_GnlkAddPhoto_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "expired", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddExpired(String value) {
        return new JAXBElement<String>(_GnlkAddExpired_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "sex", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddSex(String value) {
        return new JAXBElement<String>(_GnlkAddSex_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "phone", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddPhone(String value) {
        return new JAXBElement<String>(_GnlkAddPhone_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "birthday", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddBirthday(String value) {
        return new JAXBElement<String>(_GnlkAddBirthday_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "sphoto", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddSphoto(String value) {
        return new JAXBElement<String>(_GnlkAddSphoto_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "cflag", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddCflag(String value) {
        return new JAXBElement<String>(_GnlkAddCflag_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "djsj", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddDjsj(String value) {
        return new JAXBElement<String>(_GnlkAddDjsj_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "hotelno", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddHotelno(String value) {
        return new JAXBElement<String>(_GnlkAddHotelno_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "name", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddName(String value) {
        return new JAXBElement<String>(_GnlkAddName_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "roomno", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddRoomno(String value) {
        return new JAXBElement<String>(_GnlkAddRoomno_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "address", scope = GnlkAdd.class)
    public JAXBElement<String> createGnlkAddAddress(String value) {
        return new JAXBElement<String>(_GnlkAddAddress_QNAME, String.class, GnlkAdd.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "return", scope = CheckOutResponse.class)
    public JAXBElement<String> createCheckOutResponseReturn(String value) {
        return new JAXBElement<String>(_TestResponseReturn_QNAME, String.class, CheckOutResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "tfsj", scope = CheckOut.class)
    public JAXBElement<String> createCheckOutTfsj(String value) {
        return new JAXBElement<String>(_CheckOutTfsj_QNAME, String.class, CheckOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "pid", scope = CheckOut.class)
    public JAXBElement<String> createCheckOutPid(String value) {
        return new JAXBElement<String>(_GnlkAddPid_QNAME, String.class, CheckOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "djsj", scope = CheckOut.class)
    public JAXBElement<String> createCheckOutDjsj(String value) {
        return new JAXBElement<String>(_GnlkAddDjsj_QNAME, String.class, CheckOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.tch.com", name = "hotelno", scope = CheckOut.class)
    public JAXBElement<String> createCheckOutHotelno(String value) {
        return new JAXBElement<String>(_GnlkAddHotelno_QNAME, String.class, CheckOut.class, value);
    }

}
