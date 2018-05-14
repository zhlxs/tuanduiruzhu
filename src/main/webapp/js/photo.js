var szIdCard = "000000000000000000";
var szSerise = "000000000000000000000000000000";

var dev_type = 1

function LoadParam() {
	document.getElementById('parm').value = "";
	var szParam = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<param>\n    <Infrared>1</Infrared>\n    <imgWidth>640</imgWidth>\n    <imgHeight>480</imgHeight>\n    <imgCompress>85</imgCompress>\n    <pupilDistMin>0</pupilDistMin>\n    <pupilDistMax>300</pupilDistMax>\n    <isActived>2</isActived>\n    <nirCount>1</nirCount>\n    <liveThreshold>0.7</liveThreshold>\n    <isAudio>1</isAudio>\n    <isText>1</isText>\n    <timeOut>30</timeOut>\n    <version>1.1.7.2</version>\n    <deviceIdxCol>0</deviceIdxCol>\n    <deviceIdxNir>1</deviceIdxNir>\n    <definitionAsk>10</definitionAsk>\n    <compareFacePos>0</compareFacePos>\n    <headLeft>30</headLeft>\n    <headRight>-30</headRight>\n    <headLow>-30</headLow>\n    <headHigh>30</headHigh>\n    <eyeDegree>10</eyeDegree>\n    <mouthDegree>30</mouthDegree>\n    <edage1>0.01</edage1>\n    <edage2>0.99</edage2>\n    <goodOne>0</goodOne>\n    <track>0</track>\n    <AlphaLayerType>3</AlphaLayerType>\n</param>\n";
	document.getElementById('parm').value = szParam;
}

function openDevice() {
	document.getElementById("reta").value = "";
	var szParam = document.getElementById('parm').value;
	var s = stdfcectl.openDevice(szParam);
	document.getElementById("reta").value = s;
}

function closeDevice() {
	document.getElementById("reta").value = "";
	var s = stdfcectl.closeDevice();
	document.getElementById("reta").value = s;
}

function checkDevice() {
	document.getElementById("reta").value = "";
	var s = stdfcectl.checkDevice();
	document.getElementById("reta").value = s;
}

function getFaceB64A() {
	var szParam = document.getElementById('parm').value;
	var s = stdfcectl.getFaceB64A(szIdCard, szSerise, szParam);
	document.getElementById("reta").value = s;

}

function getFaceB64B() {
	document.getElementById("data").value = "";
	document.getElementById("datr").value = "";
	document.getElementById("reta").value = "";
	var szParam = document.getElementById('parm').value;
	var s = stdfcectl.getFaceB64B(szIdCard, szSerise, szParam);
	document.getElementById("reta").value = s;
}

function liveCheck() {
	var s = stdfcectl.RealTimeLiveDetect(1, 10);

}

function showImgA() {
	var s = document.getElementById("data").value;
	stdfcectl.showImgA(szIdCard, szSerise, s);
}

function cropImage() {
	var src = document.getElementById("data").value;
	var cImg = stdfcectl.cropImage(src, 400, 300);
	document.getElementById("datr").value = cImg;
	stdfcectl.showImgA(szIdCard, szSerise, cImg);
}

function genIDCardPhoto() {
	var src = document.getElemlentById("data").value;
	var cImg = stdfcectl.GenerateIDCardPhoto(src);
	document.getElementById("datr").value = cImg;
	stdfcectl.showImgA(szIdCard, szSerise, cImg);
}