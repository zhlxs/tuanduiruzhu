package com.cn.umessage.dao;

import com.cn.umessage.pojo.RoomIdentityInfo;

public interface RoomIdentityInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomIdentityInfo record);

    int insertSelective(RoomIdentityInfo record);

    RoomIdentityInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomIdentityInfo record);

    int updateByPrimaryKey(RoomIdentityInfo record);
}