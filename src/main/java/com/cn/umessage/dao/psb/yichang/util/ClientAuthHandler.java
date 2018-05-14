package com.cn.umessage.dao.psb.yichang.util;

import java.io.IOException;  

import javax.security.auth.callback.Callback;  
import javax.security.auth.callback.CallbackHandler;  
import javax.security.auth.callback.UnsupportedCallbackException;  
   
import org.apache.ws.security.WSPasswordCallback;  
  
public class ClientAuthHandler implements CallbackHandler  
{  
    private final static String USERNAME = "tch";  
    private final static String PASSWORD = "whtc027WS";  
  
    /** 
     * 〈一句话功能简述〉 〈功能详细描述〉 
     *  
     * @see javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[]) 
     * @param callbacks 
     * @throws IOException 
     * @throws UnsupportedCallbackException 
     */  
    @Override  
    public void handle(Callback[] callbacks) throws IOException,  
        UnsupportedCallbackException  
    {  
        System.out.println("客户端 wss4j内容加密并发送到服务端......");  
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];  
        pc.setIdentifier(USERNAME); 
        pc.setPassword(PASSWORD);  
         
    }  
  
}  
