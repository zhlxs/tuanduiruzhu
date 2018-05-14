package com.cn.umessage.dao;

import com.cn.umessage.pojo.RoomOrderInfo;

public interface RoomOrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomOrderInfo record);

    int insertSelective(RoomOrderInfo record);

    RoomOrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomOrderInfo record);

    int updateByPrimaryKey(RoomOrderInfo record);
}