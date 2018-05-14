package com.cn.umessage.service;

import com.cn.umessage.pojo.DepositInfo;

public interface IDepositInfoService {
	 int insert(DepositInfo record);
	 DepositInfo selectByPrimaryKey(String accnt);
}
