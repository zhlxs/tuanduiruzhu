package com.cn.umessage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.umessage.dao.CodeTableMapper;
import com.cn.umessage.pojo.CodeTable;
import com.cn.umessage.pojo.RoomIdentityInfo;
import com.cn.umessage.service.ICodeTableService;
import com.cn.umessage.service.IRoomIdentityInfoService;
import com.sun.org.apache.bcel.internal.classfile.Code;

@Service("CodeTableService")
public class CodeTableServiceImpl implements ICodeTableService{
    @Resource
    public CodeTableMapper codeTableMapper;

	@Override
	public String getCodeByTypeANDByName(String type, String name) {
		CodeTable  codetable = new CodeTable();
		codetable.setDmlx(type);
		codetable.setDmmc(name);
		return codeTableMapper.getCodeByTypeANDByName(codetable).getDmzm();
	}

	@Override
	public CodeTable getCodeByName(String name,String yxbz) {
		CodeTable  codetable = new CodeTable();
		codetable.setDmlxmc(name);
		codetable.setYxbz(yxbz);
		// TODO Auto-generated method stub
		return codeTableMapper.getCodeByName(codetable);
	} 
    
}
