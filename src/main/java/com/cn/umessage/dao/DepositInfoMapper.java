package com.cn.umessage.dao;

import com.cn.umessage.pojo.DepositInfo;

public interface DepositInfoMapper {
    int deleteByPrimaryKey(String accnt);

    int insert(DepositInfo record);

    int insertSelective(DepositInfo record);

    DepositInfo selectByPrimaryKey(String accnt);

    int updateByPrimaryKeySelective(DepositInfo record);

    int updateByPrimaryKey(DepositInfo record);
}