package com.cn.umessage.utils;


import javax.annotation.Resource;
import javax.swing.Spring;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.umessage.service.ICodeTableService;

public class CodeTableUtis {
	
	@Resource
    //字典
    private ICodeTableService codeTableService;
	/**
	 * <pre>getCodeByTypeANDByName(通过type 和名称查询对应的Code)   
	 * 创建人：MaQiang   
	 * 创建时间：2018年3月30日 下午5:12:34    
	 * 修改人：MaQiang  
	 * 修改时间：2018年3月30日 下午5:12:34    
	 * 修改备注： 
	 * @param type 类型  [mz(名族),qfjg(签发机关),qzzl(签证种类),rjka(入境口岸),zjlx(证件类型),zjlx1(外宾证件)
	 * zy(职业),gj(国家),xb(性别)]
	 * @param name name
	 * @return</pre>
	 */
	
	public  String  getCodeByTypeANDByName(String type,String name){
		
		String code= codeTableService.getCodeByTypeANDByName(type,name);
		if(code==null){
			code="";
		}
		return code;
	}
}