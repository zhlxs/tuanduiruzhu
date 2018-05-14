package com.cn.umessage.dao;

import java.util.*;
import com.cn.umessage.pojo.Wxpms;

public interface WxpmsDaoMapper{

    int addBean(Wxpms bean);

    int updateBean(Wxpms bean);

    int deleteBean(String id);

    Wxpms queryBean(String id);

    List<Wxpms> queryAll(Map<String, Object> map);

    long queryCount(Map<String, Object> map);

	int deleteMpId(String id);

	Wxpms queryPmsByMpid(String mpcfgid);

}
