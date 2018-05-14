package com.cn.umessage.pojo;

public class CodeTable {
    private Integer id;

    private String dmlx;

    private String dmlxmc;

    private String dmmc;

    private String dmzm;

    private String yxbz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDmlx() {
        return dmlx;
    }

    public void setDmlx(String dmlx) {
        this.dmlx = dmlx == null ? null : dmlx.trim();
    }

    public String getDmlxmc() {
        return dmlxmc;
    }

    public void setDmlxmc(String dmlxmc) {
        this.dmlxmc = dmlxmc == null ? null : dmlxmc.trim();
    }

    public String getDmmc() {
        return dmmc;
    }

    public void setDmmc(String dmmc) {
        this.dmmc = dmmc == null ? null : dmmc.trim();
    }

    public String getDmzm() {
        return dmzm;
    }

    public void setDmzm(String dmzm) {
        this.dmzm = dmzm == null ? null : dmzm.trim();
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz == null ? null : yxbz.trim();
    }
}