package com.cn.umessage.dao;

import java.util.List;

import com.cn.umessage.pojo.Advertising;

public interface AdvertisingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advertising record);

    int insertSelective(Advertising record);

    Advertising selectByPrimaryKey(Integer id);
    
    List<Advertising> selectAll();

    int updateByPrimaryKeySelective(Advertising record);

    int updateByPrimaryKeyWithBLOBs(Advertising record);

    int updateByPrimaryKey(Advertising record);
}