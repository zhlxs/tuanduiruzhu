package com.cn.umessage.service.impl;

import java.util.*;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cn.umessage.dao.WxpmsDaoMapper;
import com.cn.umessage.pojo.Wxpms;
import com.cn.umessage.service.WxpmsService;

@Service("wxPmsService")
public class WxpmsServiceImpl  implements WxpmsService {

    @Resource
    private WxpmsDaoMapper wxpmsDao;

    public int addBean(Wxpms bean){
        return wxpmsDao.addBean(bean);
    }

    public int updateBean(Wxpms bean){
        return wxpmsDao.updateBean(bean);
    }

    public int deleteBean(String id){
        return wxpmsDao.deleteBean(id);
    }

    public Wxpms queryBean(String id){
        return wxpmsDao.queryBean(id);
    }

    public List<Wxpms> queryAll(Map<String, Object> map){
        return wxpmsDao.queryAll(map);
    }

    public long queryCount(Map<String, Object> map){
        return wxpmsDao.queryCount(map);
    }

	public int deleteMpId(String id) {
		return wxpmsDao.deleteMpId(id);
	}

	public Wxpms queryPmsByMpid(String mpcfgid) {
		return wxpmsDao.queryPmsByMpid(mpcfgid);
	}

}
