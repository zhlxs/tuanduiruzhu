package com.cn.umessage.dao;

import com.cn.umessage.pojo.RoomInfo;

public interface RoomInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomInfo record);

    int insertSelective(RoomInfo record);

    RoomInfo selectByPrimaryKey(Integer id);
    
    RoomInfo selectByRoomno(String roomno);

    int updateByPrimaryKeySelective(RoomInfo record);

    int updateByPrimaryKey(RoomInfo record);
}