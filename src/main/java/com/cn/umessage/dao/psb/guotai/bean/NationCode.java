package com.cn.umessage.dao.psb.guotai.bean;

public class NationCode {
	public synchronized static String getNationCode(String nationName){
		String nationCode = "";
		switch (nationName) {
		case "汉":
			nationCode = "01";
			break;
		case "蒙古":
			nationCode = "02";
			break;
		case "回":
			nationCode = "03";
			break;
		case "藏":
			nationCode = "04";
			break;
		case "维吾尔":
			nationCode = "05";
			break;
		case "苗":
			nationCode = "06";
			break;
		case "彝":
			nationCode = "07";
			break;
		case "壮":
			nationCode = "08";
			break;
		case "布依":
			nationCode = "09";
			break;
		case "朝鲜":
			nationCode = "10";
			break;
		case "满":
			nationCode = "11";
			break;
		case "侗":
			nationCode = "12";
			break;
		case "瑶":
			nationCode = "13";
			break;
		case "白":
			nationCode = "14";
			break;
		case "土家":
			nationCode = "15";
			break;
		case "哈尼":
			nationCode = "16";
			break;
		case "哈萨克":
			nationCode = "17";
			break;
		case "傣":
			nationCode = "18";
			break;
		case "黎":
			nationCode = "19";
			break;
		case "傈僳":
			nationCode = "20";
			break;
		case "佤":
			nationCode = "21";
			break;
		case "畲":
			nationCode = "22";
			break;
		case "高山":
			nationCode = "23";
			break;
		case "拉祜":
			nationCode = "24";
			break;
		case "水":
			nationCode = "25";
			break;
		case "东乡":
			nationCode = "26";
			break;
		case "纳西":
			nationCode = "27";
			break;
		case "景颇":
			nationCode = "28";
			break;
		case "柯尔克孜":
			nationCode = "29";
			break;
		case "土":
			nationCode = "30";
			break;
		case "达斡尔":
			nationCode = "31";
			break;
		case "仫佬":
			nationCode = "32";
			break;
		case "羌":
			nationCode = "33";
			break;
		case "布朗":
			nationCode = "34";
			break;
		case "撒拉":
			nationCode = "35";
			break;
		case "毛难":
			nationCode = "36";
			break;
		case "仡佬":
			nationCode = "37";
			break;
		case "锡伯":
			nationCode = "38";
			break;
		case "阿昌":
			nationCode = "39";
			break;
		case "普米":
			nationCode = "40";
			break;
		case "塔吉克":
			nationCode = "41";
			break;
		case "怒":
			nationCode = "42";
			break;
		case "乌孜别克":
			nationCode = "43";
			break;
		case "俄罗斯":
			nationCode = "44";
			break;
		case "鄂温克":
			nationCode = "45";
			break;
		case "德昂":
			nationCode = "46";
			break;
		case "保安":
			nationCode = "47";
			break;
		case "裕固":
			nationCode = "48";
			break;
		case "京":
			nationCode = "49";
			break;
		case "塔塔尔":
			nationCode = "50";
			break;
		case "独龙":
			nationCode = "51";
			break;
		case "鄂伦春":
			nationCode = "52";
			break;
		case "赫哲":
			nationCode = "53";
			break;
		case "门巴":
			nationCode = "54";
			break;
		case "珞巴":
			nationCode = "55";
			break;
		case "基诺":
			nationCode = "56";
			break;	
		case "穿青人":
			nationCode = "57";
			break;	
		default:
			nationCode = "00";//未知
			break;
		}
		return nationCode;
	}
}