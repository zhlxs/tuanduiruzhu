package com.cn.umessage.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cn.umessage.pojo.IdCard;
import com.cn.umessage.utils.HttpRequestUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cn.umessage.service.IPersonCardService;
import com.cn.umessage.utils.Base64Image;
import com.cn.umessage.utils.HttpUtils;
import com.cn.umessage.utils.InitConfig;

@Service("personCardService")
public class PersonCardServiceImpl implements IPersonCardService {
    //自封装人证比对调用接口
    private static final String url = "http://39.104.68.154:8091/wxxq/idcard/comparison";
    private static String partnerKey = "C864DA52F1E9471292EA97E14C879031";

    @Override
    public void savePhoto(String cardNo, String str, String orderNo, String type) {
        // TODO Auto-generated method stub
        String photoPath = InitConfig.PHOTO_PATH;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestr = sdf.format(date);
        String path = photoPath + "/" + datestr + "/" + orderNo + "/" + type
                + "/" + cardNo + "/";
        System.out.println("=================path==============" + path);
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        Base64Image.GenerateImage(str, path + "caiji.bmp");

        String cardPath = photoPath + "/" + datestr + "/tmp/" + cardNo + ".bmp";
        File file = new File(cardPath);
        file.renameTo(new File(photoPath + "/" + datestr + "/" + orderNo + "/"
                + type + "/" + cardNo + "/card.bmp"));
    }

    @Override
    public boolean Comparison(String cardNo, String orderNo, String type, IdCard idCard) {
        boolean flag = false;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestr = sdf.format(date);
        String photoPath = InitConfig.PHOTO_PATH;
        String cardphoto = Base64Image.GetImageStr(
                photoPath + "/" + datestr + "/" + orderNo + "/" + type
                        + "/" + cardNo + "/card.bmp").replaceAll(
                "\r\n", "");
        String collectphoto = Base64Image.GetImageStr(
                photoPath + "/" + datestr + "/" + orderNo + "/" + type
                        + "/" + cardNo + "/caiji.bmp").replaceAll(
                "\r\n", "");
        Map<String, String> map = new HashMap<>();
        map.put("partnerkey", partnerKey);
        map.put("cardname", idCard.getName());
        map.put("cardnum", idCard.getCardNum());
        map.put("cardstartdate", idCard.getStartTime());
        map.put("cardenddate", idCard.getEndTime());
        map.put("cardphoto", cardphoto);
        map.put("collectphoto", collectphoto);
        map.put("cardtype", "1");
        map.put("choice", "2");


        JSONObject jsonObject = null;
        try {
            String send = HttpRequestUtil.send(url, map, "utf-8");
            jsonObject = JSONObject.parseObject(send);
            if (jsonObject.getString("status").equals("0")) {
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) {
        PersonCardServiceImpl p = new PersonCardServiceImpl();
        // p.Comparison();
    }

}
