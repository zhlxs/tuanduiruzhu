package com.cn.umessage.service;


import com.cn.umessage.pojo.Testtdrz;

import java.util.List;

public interface TestServicetdrz {
    /**
     * 团队入住第一步,根据手机号查询订单列表.
     * 返回值:  订单号(支持多个)----该订单总房间数
     * @param phone
     * @return
     */
    List<Testtdrz> getOrder(String phone);
}
