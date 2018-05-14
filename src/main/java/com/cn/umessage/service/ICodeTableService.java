package com.cn.umessage.service;

import com.cn.umessage.pojo.CodeTable;

public interface ICodeTableService {

	String getCodeByTypeANDByName(String type, String name);

	CodeTable getCodeByName(String string,String yxbz);

	
	
}
