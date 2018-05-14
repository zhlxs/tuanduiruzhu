package com.cn.umessage.dao;

import com.cn.umessage.pojo.CheckOutRoom;

public interface CheckOutRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckOutRoom record);

    int insertSelective(CheckOutRoom record);

    CheckOutRoom selectByPrimaryKey(Integer id);
    
    CheckOutRoom selectByAccnt(String accnt);

    int updateByPrimaryKeySelective(CheckOutRoom record);

    int updateByPrimaryKey(CheckOutRoom record);
}