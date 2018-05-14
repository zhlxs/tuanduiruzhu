package com.cn.umessage.service;

import java.util.*;
import com.cn.umessage.pojo.Wxpms;

public interface WxpmsService{

    int addBean(Wxpms bean);

    int updateBean(Wxpms bean);

    int deleteBean(String id);

    Wxpms queryBean(String id);
    
    Wxpms queryPmsByMpid(String mpcfgid);

    List<Wxpms> queryAll(Map<String, Object> map);

    long queryCount(Map<String, Object> map);

	int deleteMpId(String id);

}
