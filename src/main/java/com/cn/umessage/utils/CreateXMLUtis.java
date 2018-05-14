package com.cn.umessage.utils;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXMLUtis {
	
   /* public static void main(String[] args) {
        FileWriter out = null;
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        	Date startTime = new Date();
            out = new FileWriter( "D:\\LGY"+sdf.format(startTime)+".xml" );  //写入文件
            //测试是否成功
            createNBXMLDocument("1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
            		"1", "1", "1", "1", "1", "1", "1",
            		"1","1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
            		"1", "1", "1", "1", "1", "1", "1", "1","1").write( out );
            
//            OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
//            format.setEncoding("GBK");
//            XMLWriter writer = new XMLWriter( System.out, format );
//            writer.write( createDocument() );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if (out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }*/
    public static boolean createNBXML(String lgyLKSX,String lgyYWLX, String lgyJLS
    		,String lgyZJLX,String lgySFZH,String lgyXM,String lgyXB,String lgyCSRQ,
    		String lgyFH,String lgyMZ,String lgyJG,String lgyZZ,String lgyZY,String lgyLCSY,
    		String lgyLDSJ,String lgyHCL,String lgyHCQ,String lgyLKCL,String lgyXM1,
    		String lgyXM2,String lgyGJ,String lgyQZZL,String lgyQZHM,String lgyTLQX,String lgyQFJG,
    		String lgyRJRQ,String lgyRJKA,String lgyJDDW,String lgyJDR,String lgyJWL,String lgyJWQ,
    		String lgyBZ,String lgyZP,String lgySMG){
    	FileWriter out = null;
    	boolean bool=false;
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        	Date startTime = new Date();
        	String photoPath = InitConfig.XML_PATH;
            out = new FileWriter( photoPath+"\\LGY"+sdf.format(startTime)+".xml" );  //写入文件
            String lvcode = InitConfig.LV_CODE;
            SimpleDateFormat sdfs = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
            //测试是否成功
            createNBXMLDocument(lvcode,lgyLKSX,lgyYWLX,lgyJLS,sdf.format(startTime),lgyZJLX,lgySFZH,lgyXM,lgyXB,lgyCSRQ,
            		lgyFH,lgyMZ,lgyJG,lgyZZ,lgyZY,lgyLCSY,sdfs.format(startTime),lgyLDSJ,lgyHCL,lgyHCQ,lgyLKCL,lgyXM1,
            		lgyXM2,lgyGJ,lgyQZZL,lgyQZHM, lgyTLQX, lgyQFJG,
            		lgyRJRQ, lgyRJKA,lgyJDDW, lgyJDR, lgyJWL,lgyJWQ,
            		lgyBZ,lgyZP,lgySMG).write( out );
            
//            OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
//            format.setEncoding("GBK");
//            XMLWriter writer = new XMLWriter( System.out, format );
//            writer.write( createDocument() );
            bool = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            bool = false;
        }finally{
            if (out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    	
		return bool;
    }
    
    
    /**
     * <pre>createNBXMLDocument(创建NBXML文件)   
     * 创建人：MaQiang   
     * 创建时间：2018年3月29日 下午3:12:40    
     * 修改人：MaQiang  
     * 修改时间：2018年3月29日 下午3:12:40    
     * 修改备注： 
     * @param lgyLGDM 旅馆代码
     * @param lgyLKSX 旅客属性
     * @param lgyYWLX 业务类型
     * @param lgyJLS 记录数
     * @param lgyZKLSH 流水号
     * @param lgyZJLX 证件类型
     * @param lgySFZH 身份证号
     * @param lgyXM 姓名
     * @param lgyXB 性别
     * @param lgyCSRQ 出生日期
     * @param lgyFH 序号
     * @param lgyMZ 民族
     * @param lgyJG 籍贯
     * @param lgyZZ 住址
     * @param lgyZY 职业
     * @param lgyLCSY 来此事由
     * @param lgyRZSJ 入住时间
     * @param lgyLDSJ 离店时间
     * @param lgyHCL 何处来
     * @param lgyHCQ 何处去
     * @param lgyLKCL 旅客车辆
     * @param lgyXM1 英文姓
     * @param lgyXM2 英文名
     * @param lgyGJ 国籍
     * @param lgyQZZL 签证种类
     * @param lgyQZHM 签证号码
     * @param lgyTLQX 停留期限
     * @param lgyQFJG 签发机关
     * @param lgyRJRQ 入境日期
     * @param lgyRJKA 入境口岸
     * @param lgyJDDW 接待单位
     * @param lgyJDR 接待人
     * @param lgyJWL 境外来
     * @param lgyJWQ 境外去
     * @param lgyBZ 备注
     * @param lgyZP 照片
     * @param lgySMG 扫描搞
     * @return xml文件
     */
    public static Document createNBXMLDocument(String lgyLGDM,String lgyLKSX,String lgyYWLX, String lgyJLS
    		,String lgyZKLSH,String lgyZJLX,String lgySFZH,String lgyXM,String lgyXB,String lgyCSRQ,
    		String lgyFH,String lgyMZ,String lgyJG,String lgyZZ,String lgyZY,String lgyLCSY,
    		String lgyRZSJ,String lgyLDSJ,String lgyHCL,String lgyHCQ,String lgyLKCL,String lgyXM1,
    		String lgyXM2,String lgyGJ,String lgyQZZL,String lgyQZHM,String lgyTLQX,String lgyQFJG,
    		String lgyRJRQ,String lgyRJKA,String lgyJDDW,String lgyJDR,String lgyJWL,String lgyJWQ,
    		String lgyBZ,String lgyZP,String lgySMG) {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("GBK");
        Element Package = document.addElement( "Package" );
        Element PackageHead = Package.addElement("PackageHead");

        PackageHead.addElement( "lgyLGDM" ).addAttribute("Name", "旅馆代码").setText(lgyLGDM);
        PackageHead.addElement( "lgyLKSX" ).addAttribute("Name", "旅客属性").setText(lgyLKSX);
        PackageHead.addElement( "lgyYWLX" ).addAttribute("Name", "业务类型").setText(lgyYWLX);
        PackageHead.addElement( "lgyJLS" ).addAttribute("Name", "记录数").setText(lgyJLS);
        Element data =Package.addElement( "Data" );
        Element record = data.addElement( "Record" );
        record.addElement( "lgyZKLSH" ).addAttribute("Name", "流水号").setText(lgyZKLSH);
        record.addElement( "lgyZJLX" ).addAttribute("Name", "证件类型").setText(lgyZJLX);
        record.addElement( "lgySFZH" ).addAttribute("Name", "身份证号").setText(lgySFZH);
        record.addElement( "lgyXM" ).addAttribute("Name", "姓名").setText(lgyXM);
        record.addElement( "lgyXB" ).addAttribute("Name", "性别").setText(lgyXB);
        record.addElement( "lgyCSRQ" ).addAttribute("Name", "出生日期").setText(lgyCSRQ);
        record.addElement( "lgyFH" ).addAttribute("Name", "房号").setText(lgyFH);
        record.addElement( "lgyMZ" ).addAttribute("Name", "民族").setText(lgyMZ);
        record.addElement( "lgyJG" ).addAttribute("Name", "籍贯").setText(lgyJG);
        record.addElement( "lgyZZ" ).addAttribute("Name", "住址").setText(lgyZZ);
        record.addElement( "lgyZY" ).addAttribute("Name", "职业").setText(lgyZY);
        record.addElement( "lgyLCSY" ).addAttribute("Name", "来此事由").setText(lgyLCSY);
        record.addElement( "lgyRZSJ" ).addAttribute("Name", "入住时间").setText(lgyRZSJ);
        record.addElement( "lgyLDSJ" ).addAttribute("Name", "离店时间").setText(lgyLDSJ);
        record.addElement( "lgyHCL" ).addAttribute("Name", "何处来").setText(lgyHCL);
        record.addElement( "lgyHCQ" ).addAttribute("Name", "何处去").setText(lgyHCQ);
        record.addElement( "lgyLKCL" ).addAttribute("Name", "旅客车辆").setText(lgyLKCL);
        record.addElement( "lgyXM1" ).addAttribute("Name", "英文姓").setText(lgyXM1);
        record.addElement( "lgyXM2" ).addAttribute("Name", "英文名").setText(lgyXM2);
        record.addElement( "lgyGJ" ).addAttribute("Name", "国籍").setText(lgyGJ);
        record.addElement( "lgyQZZL" ).addAttribute("Name", "签证种类").setText(lgyQZZL);
        record.addElement( "lgyQZHM" ).addAttribute("Name", "签证号码").setText(lgyQZHM);
        record.addElement( "lgyTLQX" ).addAttribute("Name", "停留期限").setText(lgyTLQX);
        record.addElement( "lgyQFJG" ).addAttribute("Name", "签发机关").setText(lgyQFJG);
        record.addElement( "lgyRJRQ" ).addAttribute("Name", "入境日期").setText(lgyRJRQ);
        record.addElement( "lgyRJKA" ).addAttribute("Name", "入境口岸").setText(lgyRJKA);
        record.addElement( "lgyJDDW" ).addAttribute("Name", "接待单位").setText(lgyJDDW);
        record.addElement( "lgyJDR" ).addAttribute("Name", "接待人").setText(lgyJDR);
        record.addElement( "lgyJWL" ).addAttribute("Name", "境外来").setText(lgyJWL);
        record.addElement( "lgyJWQ" ).addAttribute("Name", "境外去").setText(lgyJWQ);
        record.addElement( "lgyBZ" ).addAttribute("Name", "备注").setText(lgyBZ);
        record.addElement( "lgyZP" ).addAttribute("Name", "照片").setText(lgyZP);
        record.addElement( "lgySMGName" ).addAttribute("Name", "扫描搞").setText(lgySMG);

        return document;
    }
    
    /**
     * <pre>createWBXMLDocument(创建WBXML文件)   
     * 创建人：MaQiang   
     * 创建时间：2018年3月29日 下午3:12:40    
     * 修改人：MaQiang  
     * 修改时间：2018年3月29日 下午3:12:40    
     * 修改备注： 
     * @param lgyLGDM 	旅馆代码
     * @param lgyLKSX 	旅客属性
     * @param lgyYWLX 	业务类型
     * @param lgyJLS 	记录数
     * @param lgyZKLSH 	流水号
     * @param lgyZJLX 	证件类型
     * @param lgySFZH 	身份证号
     * @param lgyXM 	姓名
     * @param lgyXB 	性别
     * @param lgyCSRQ 	出生日期
     * @param lgyFH 	序号
     * @param lgyMZ 	民族
     * @param lgyJG 	籍贯
     * @param lgyZZ 	住址
     * @param lgyZY 	职业
     * @param lgyLCSY 	来此事由
     * @param lgyRZSJ 	入住时间
     * @param lgyLDSJ 	离店时间
     * @param lgyHCL 	何处来
     * @param lgyHCQ 	何处去
     * @param lgyLKCL 	旅客车辆
     * @param lgyXM1 	英文姓
     * @param lgyXM2 	英文名
     * @param lgyGJ 	国籍
     * @param lgyQZZL 	签证种类
     * @param lgyQZHM 	签证号码
     * @param lgyTLQX 	停留期限
     * @param lgyQFJG 	签发机关
     * @param lgyRJRQ 	入境日期
     * @param lgyRJKA 	入境口岸
     * @param lgyJDDW 	接待单位
     * @param lgyJDR 	接待人
     * @param lgyJWL 	境外来
     * @param lgyJWQ 	境外去
     * @param lgyBZ 	备注
     * @param lgyZP 	照片
     * @param lgySMG 	扫描搞
     * @return xml文件
     */
    public static Document createWBXMLDocument(String lgyLGDM,String lgyLKSX,String lgyYWLX, String lgyJLS
    		,String lgyZKLSH,String lgyZJLX,String lgySFZH,String lgyXM,String lgyXB,String lgyCSRQ,
    		String lgyFH,String lgyMZ,String lgyJG,String lgyZZ,String lgyZY,String lgyLCSY,
    		String lgyRZSJ,String lgyLDSJ,String lgyHCL,String lgyHCQ,String lgyLKCL,String lgyXM1,
    		String lgyXM2,String lgyGJ,String lgyQZZL,String lgyQZHM,String lgyTLQX,String lgyQFJG,
    		String lgyRJRQ,String lgyRJKA,String lgyJDDW,String lgyJDR,String lgyJWL,String lgyJWQ,
    		String lgyBZ,String lgyZP,String lgySMG) {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("GBK");
        Element Package = document.addElement( "Package" );
        Element PackageHead = Package.addElement("PackageHead");

        PackageHead.addElement( "lgyLGDM" ).addAttribute("Name", "旅馆代码").setText(lgyLGDM);
        PackageHead.addElement( "lgyLKSX" ).addAttribute("Name", "旅客属性").setText(lgyLKSX);
        PackageHead.addElement( "lgyYWLX" ).addAttribute("Name", "业务类型").setText(lgyYWLX);
        PackageHead.addElement( "lgyJLS" ).addAttribute("Name", "记录数").setText(lgyJLS);
        Element data =Package.addElement( "Data" );
        Element record = data.addElement( "Record" );
        record.addElement( "lgyZKLSH" ).addAttribute("Name", "流水号").setText(lgyZKLSH);
        record.addElement( "lgyZJLX" ).addAttribute("Name", "证件类型").setText(lgyZJLX);
        record.addElement( "lgySFZH" ).addAttribute("Name", "身份证号").setText(lgySFZH);
        record.addElement( "lgyXM" ).addAttribute("Name", "姓名").setText(lgyXM);
        record.addElement( "lgyXB" ).addAttribute("Name", "性别").setText(lgyXB);
        record.addElement( "lgyCSRQ" ).addAttribute("Name", "出生日期").setText(lgyCSRQ);
        record.addElement( "lgyFH" ).addAttribute("Name", "房号").setText(lgyFH);
        record.addElement( "lgyMZ" ).addAttribute("Name", "民族").setText(lgyMZ);
        record.addElement( "lgyJG" ).addAttribute("Name", "籍贯").setText(lgyJG);
        record.addElement( "lgyZZ" ).addAttribute("Name", "住址").setText(lgyZZ);
        record.addElement( "lgyZY" ).addAttribute("Name", "职业").setText(lgyZY);
        record.addElement( "lgyLCSY" ).addAttribute("Name", "来此事由").setText(lgyLCSY);
        record.addElement( "lgyRZSJ" ).addAttribute("Name", "入住时间").setText(lgyRZSJ);
        record.addElement( "lgyLDSJ" ).addAttribute("Name", "离店时间").setText(lgyLDSJ);
        record.addElement( "lgyHCL" ).addAttribute("Name", "何处来").setText(lgyHCL);
        record.addElement( "lgyHCQ" ).addAttribute("Name", "何处去").setText(lgyHCQ);
        record.addElement( "lgyLKCL" ).addAttribute("Name", "旅客车辆").setText(lgyLKCL);
        record.addElement( "lgyXM1" ).addAttribute("Name", "英文姓").setText(lgyXM1);
        record.addElement( "lgyXM2" ).addAttribute("Name", "英文名").setText(lgyXM2);
        record.addElement( "lgyGJ" ).addAttribute("Name", "国籍").setText(lgyGJ);
        record.addElement( "lgyQZZL" ).addAttribute("Name", "签证种类").setText(lgyQZZL);
        record.addElement( "lgyQZHM" ).addAttribute("Name", "签证号码").setText(lgyQZHM);
        record.addElement( "lgyTLQX" ).addAttribute("Name", "停留期限").setText(lgyTLQX);
        record.addElement( "lgyQFJG" ).addAttribute("Name", "签发机关").setText(lgyQFJG);
        record.addElement( "lgyRJRQ" ).addAttribute("Name", "入境日期").setText(lgyRJRQ);
        record.addElement( "lgyRJKA" ).addAttribute("Name", "入境口岸").setText(lgyRJKA);
        record.addElement( "lgyJDDW" ).addAttribute("Name", "接待单位").setText(lgyJDDW);
        record.addElement( "lgyJDR" ).addAttribute("Name", "接待人").setText(lgyJDR);
        record.addElement( "lgyJWL" ).addAttribute("Name", "境外来").setText(lgyJWL);
        record.addElement( "lgyJWQ" ).addAttribute("Name", "境外去").setText(lgyJWQ);
        record.addElement( "lgyBZ" ).addAttribute("Name", "备注").setText(lgyBZ);
        record.addElement( "lgyZP" ).addAttribute("Name", "照片").setText(lgyZP);
        record.addElement( "lgySMG" ).addAttribute("Name", "扫描搞").setText(lgySMG);

        return document;
    }

    /**
     * <pre>createNBLDXMLDocument(这里用一句话描述这个方法的作用)   
     * 创建人：MaQiang   
     * 创建时间：2018年4月16日 下午7:49:10    
     * 修改人：MaQiang  
     * 修改时间：2018年4月16日 下午7:49:10    
     * 修改备注： 
     * @param lgyLGDM 旅馆代码
     * @param lgyLKSX 旅客属性
     * @param lgyYWLX 业务类型
     * @param lgyJLS  记录数
     * @param lgySFZH 身份证号
     * @param lgyFH	      房间号
     * @param lgyLDSJ 离店时间
     * @return</pre>
     */
    public static Document createNBLDXMLDocument(String lgyLGDM,String lgyLKSX,String lgyYWLX, String lgyJLS
    		,String lgySFZH,String lgyFH,String lgyLDSJ) {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("GBK");
        Element Package = document.addElement( "Package" );
        Element PackageHead = Package.addElement("PackageHead");

        PackageHead.addElement( "lgyLGDM" ).addAttribute("Name", "旅馆代码").setText(lgyLGDM);
        PackageHead.addElement( "lgyLKSX" ).addAttribute("Name", "旅客属性").setText(lgyLKSX);
        PackageHead.addElement( "lgyYWLX" ).addAttribute("Name", "业务类型").setText(lgyYWLX);
        PackageHead.addElement( "lgyJLS" ).addAttribute("Name", "记录数").setText(lgyJLS);
        Element data =Package.addElement( "Data" );
        Element record = data.addElement( "Record" );
        record.addElement( "lgySFZH" ).addAttribute("Name", "身份证号").setText(lgySFZH);
        record.addElement( "lgyFH" ).addAttribute("Name", "房间号").setText(lgyFH);
        record.addElement( "lgyLDSJ" ).addAttribute("Name", "离店时间").setText(lgyLDSJ);

        return document;
        
    }
    /**
     * 退房
     * <pre>createNBLDXML(内宾离店XML  )   
     * 创建人：MaQiang   
     * 创建时间：2018年4月1日 下午9:56:19    
     * 修改人：MaQiang  
     * 修改时间：2018年4月1日 下午9:56:19    
     * 修改备注：  
     * @param lgySFZH 身份证号
     * @param lgyFH 房间号
     * @return</pre>
     */
    public static boolean createNBLDXML(String lgySFZH,String lgyFH,int i){
    	FileWriter out = null;
    	boolean bool=false;
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        	Date startTime = new Date();
        	String photoPath = InitConfig.XML_PATH;
            out = new FileWriter( photoPath+"\\LGY"+sdf.format(startTime)+i+".xml" );  //写入文件
            String lvcode = InitConfig.LV_CODE;
            SimpleDateFormat sdfs = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
            //测试是否成功
            createNBLDXMLDocument(lvcode, "L", "NB", "1", lgySFZH, lgyFH,sdfs.format(startTime) ).write( out );
            
            bool = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            bool = false;
        }finally{
            if (out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    	
		return bool;
    }

}