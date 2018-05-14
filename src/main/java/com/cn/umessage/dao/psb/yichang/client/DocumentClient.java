package com.cn.umessage.dao.psb.yichang.client;  
  
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
   
  
public class DocumentClient  
{
	private static DocumentClient instance = null;
	public static DocumentClient getInstance() {
	if (instance == null) {
		return new DocumentClient();
	}
		return instance;
	}
	static String url="http://122.189.200.170:9201/tchWebService/services/HotelService";
    private static EndpointReference targetEPR = new EndpointReference(url);  
    private String getAxis2ConfPath()  
    {  
        StringBuilder confPath = new StringBuilder();  
        confPath.append(this.getClass().getResource("/").getPath());  
        confPath.append("repository");  
        return confPath.toString();  
    }  
    private String getAxis2ConfFilePath()  
    {  
        String confFilePath = "";  
        confFilePath = getAxis2ConfPath() + "/axis2.xml";  
        return confFilePath;  
    }
    public synchronized OMElement invokeRampartService(String method,String[] paramStrArray,String[] valStrArray)  
    { 
        Options options = new Options();  
        options.setTo(targetEPR);  
        options.setAction("urn:"+method); 
        ServiceClient sender = null;  
        try  
        {  
            String confPath = getAxis2ConfPath();  
            String confFilePath = getAxis2ConfFilePath();  
            System.out.println("confPath ====== " + confPath);  
            System.out.println("confFilePath ==== " + confFilePath);  
            ConfigurationContext configContext = ConfigurationContextFactory  
                .createConfigurationContextFromFileSystem(confPath,confFilePath); 
            sender = new ServiceClient(configContext, null);  
            sender.setOptions(options);  
            OMFactory fac = OMAbstractFactory.getOMFactory();  
            OMNamespace omNs = fac.createOMNamespace("http://service.tch.com", "");  
            OMElement callMethod = fac.createOMElement(method,omNs);//方法名
            // 对应参数的节点
            //String[] strs = new String[] {"name", "sex", "nation", "birthday", "expired", "pid", "djsj", "hotelno", "roomno", "phone", "address", "photo", "sphoto", "cflag"};
            // 参数值
            //String[] val = new String[] {"王五","3","汉","1990-01-01","2010.01.02-2020.01.02","370102199001018801","2018-04-11 16:17:02","4205000169","603","13411112222","北京市东城区","xxxxx","xxxxxx","N"};
            for (int i = 0; i < paramStrArray.length; i++) {
	            OMElement param = fac.createOMElement(paramStrArray[i],omNs);
	            param.setText(valStrArray[i]);
	            callMethod.addChild(param);
            }
           /* options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
            options.setSoapVersionURI("http://schemas.xmlsoap.org/wsdl/soap");
            options.setExceptionToBeThrownOnSOAPFault(false);*/
            OMElement response = sender.sendReceive(callMethod);  
            System.out.println("response ====>" + response);  
            System.out.println(response.getFirstElement().getText()); 
            return response;
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        finally  
        {  
            if (sender != null)  
                sender.disengageModule("addressing");  
            try  
            {  
                sender.cleanup();  
            }  
            catch (Exception e)  
            {  
            }  
        }
		return null;  
    }  
  
    public static void main(String[] args)  
    {  
        DocumentClient documentClient = new DocumentClient();  
        // 对应参数的节点
        String[] paramStrArray = new String[] {"name", "sex", "nation", "birthday", "expired", "pid", "djsj", "hotelno", "roomno", "phone", "address", "photo", "sphoto", "cflag"};
        // 参数值
        String[] valStrArray = new String[] {"王五","3","汉","1990-01-01","2010.01.02-2020.01.02","370102199001018801","2018-04-11 16:17:02","4205000169","603","13411112222","北京市东城区","xxxxx","xxxxxx","N"};
        documentClient.invokeRampartService("gnlkAdd",paramStrArray,valStrArray);  
    }
}  