package com.cn.umessage.pojo;

public class Testtdrz {
    private String orderid;//订单号
    private String roomnum;//房间号
    private String roomtype;//房间类型
    private String roombigper;//房间最大入住人数
    private String roomcount;//预定房间数量
    private String starttime;
    private String endtime;
    private String num;
    private String personcount;

    public String getPersoncount() {
        return personcount;
    }

    public void setPersoncount(String personcount) {
        this.personcount = personcount;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getRoombigper() {
        return roombigper;
    }

    public void setRoombigper(String roombigper) {
        this.roombigper = roombigper;
    }

    public String getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(String roomcount) {
        this.roomcount = roomcount;
    }

    @Override
    public String toString() {
        return "Testtdrz{" +
                "orderid='" + orderid + '\'' +
                ", roomnum='" + roomnum + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", roombigper='" + roombigper + '\'' +
                ", roomcount='" + roomcount + '\'' +
                '}';
    }
}
