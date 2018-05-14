package com.cn.umessage.pojo;

import java.io.Serializable;
import java.util.*;

public class Wxpms  implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String mpcfgid;
    private String pmskey;
    private String pmsname;
    private String pmsurl;
    private String pmsclient;
    private String appkey;
    private String secret;
    private String username;
    private String passwords;
    private String encoding;
    private String bookNum;
    private String qcurl;
    private Date ts;
    private Integer num1;
    private String str1;
    private String str2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMpcfgid() {
        return mpcfgid;
    }

    public void setMpcfgid(String mpcfgid) {
        this.mpcfgid = mpcfgid;
    }

    public String getPmskey() {
        return pmskey;
    }

    public void setPmskey(String pmskey) {
        this.pmskey = pmskey;
    }

    public String getPmsname() {
        return pmsname;
    }

    public void setPmsname(String pmsname) {
        this.pmsname = pmsname;
    }

    public String getPmsurl() {
        return pmsurl;
    }

    public void setPmsurl(String pmsurl) {
        this.pmsurl = pmsurl;
    }

    public String getPmsclient() {
        return pmsclient;
    }

    public void setPmsclient(String pmsclient) {
        this.pmsclient = pmsclient;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getQcurl() {
        return qcurl;
    }

    public void setQcurl(String qcurl) {
        this.qcurl = qcurl;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Wxpms other = (Wxpms) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String toString() {
       return "Wxpms [id="+ id +"]";
    }

}
