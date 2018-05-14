package com.cn.umessage.dao;

import com.cn.umessage.pojo.CodeTable;

public interface CodeTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeTable record);

    int insertSelective(CodeTable record);

    CodeTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeTable record);

    int updateByPrimaryKey(CodeTable record);

    CodeTable getCodeByTypeANDByName(CodeTable codetable);

	CodeTable getCodeByName(CodeTable codetable);


}