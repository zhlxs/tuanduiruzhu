package com.cn.umessage.service.impl;

import com.cn.umessage.pojo.Testtdrz;
import com.cn.umessage.service.TestServicetdrz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServicetdrzImpl implements TestServicetdrz {

    @Override
    public List<Testtdrz> getOrder(String phone) {
        List<Testtdrz> arrayList = new ArrayList<>();
        if (phone.equals("13466652024")) {
            //第一笔订单
            Testtdrz tt = new Testtdrz();
            //订单号
            tt.setOrderid("000001");
            //房间总数量
            tt.setRoomcount("10");
            //预定房间号,用逗号隔开
            tt.setRoomnum("1001-大床房,1002-标准房,1003-总统房,1004-情侣房,1005-主题房,1006-多人套房,1007-亲子套房,1008-海景房");
            //房间类型
            tt.setRoomtype("大床房");
            //房间最大入住人数
            tt.setRoombigper("2");
            tt.setStarttime("2018-05-09");
            tt.setEndtime("2018-05-19");
            tt.setNum("10");
            tt.setPersoncount("20");
            arrayList.add(tt);
            //第二笔订单
            Testtdrz tt2 = new Testtdrz();
            //订单号
            tt2.setOrderid("000002");
            //房间总数量
            tt2.setRoomcount("10");
            //预定房间号,多个房间用逗号隔开,房间和房类用-隔开
            tt2.setRoomnum("2001-大床房,2002-标准房,2003-总统房,2004-情侣房,2005-主题房,2006-多人套房,2007-亲子套房,2008-海景房");
            //房间类型
            tt2.setRoomtype("大床房");
            //房间最大入住人数
            tt2.setRoombigper("2");
            tt2.setStarttime("2018-05-09");
            tt2.setEndtime("2018-05-19");
            tt2.setNum("10");
            tt2.setPersoncount("20");

            arrayList.add(tt2);
            return arrayList;

        }
        return null;
    }

}
