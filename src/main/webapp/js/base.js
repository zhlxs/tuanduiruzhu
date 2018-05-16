//获取项目相对路径
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

//跳转首页
function goIndex() {
    window.location.href=getRootPath()+"menu/index";
}

//不执行操作
function noDo(){

}
var num;
var time;
var isstart=1;//倒计时    0关闭   1打开
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown(label,func1,func2,state){
    if(isstart==0&&state=="starting"){//停止
        isstart=1;
        $("#"+label).html("");return;
    }
    if(num!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num+"秒(倒计时)</font>");
        num = num-1;
        func2();
        //每秒执行一次
        time = setTimeout("countdown('"+label+"',"+func1+","+func2+",'starting')",1000);

    }else{//跳转
        func1();
    }

}

//==================警方提示倒计时===================================
var num_police;
var time_police;
var isstart_police;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_police(label,func1,func2){
    if(isstart_police==0){//停止

        $("#"+label).html("");return;
    }
    if(num_police!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_police+"秒(倒计时)</font>");
        num_police = num_police-1;
        func2();
        //每秒执行一次
        time_police = setTimeout("countdown_police('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================取房卡放身份证提示倒计时===================================
var num_card;
var time_card;
var isstart_card;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_card(label,func1,func2){
    if(isstart_card==0){//停止
        $("#"+label).html("");return;
    }
    if(num_card!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_card+"秒(倒计时)</font>");
        num_card = num_card-1;
        func2();
        //每秒执行一次
        time_card = setTimeout("countdown_card('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================查询房卡放身份证提示倒计时===================================
var num_card2;
var time_card2;
var isstart_card2;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_card2(label,func1,func2){
    if(isstart_card2==0){//停止
        $("#"+label).html("");return;
    }
    if(num_card2!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_card2+"秒(倒计时)</font>");
        num_card2 = num_card2-1;
        func2();
        //每秒执行一次
        time_card2 = setTimeout("countdown_card2('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================身份证读取失败倒计时===================================
var num_cardfaild;
var time_cardfaild;
var isstart_cardfaild;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_cardfaild(label,func1,func2){
    if(isstart_cardfaild==0){//停止

        $("#"+label).html("");return;
    }
    if(num_cardfaild!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_cardfaild+"秒(倒计时)</font>");
        num_cardfaild = num_cardfaild-1;
        func2();
        //每秒执行一次
        time_cardfaild = setTimeout("countdown_cardfaild('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}




//==================单个订单显示倒计时===================================
var num_order;
var time_order;
var isstart_order;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_order(label,func1,func2){
    if(isstart_order==0){//停止

        $("#"+label).html("");return;
    }
    if(num_order!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_order+"秒(倒计时)</font>");
        num_order = num_order-1;
        func2();
        //每秒执行一次
        time_order = setTimeout("countdown_order('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================无订单显示倒计时===================================
var num_noorder;
var time_noorder;
var isstart_noorder;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_noorder(label,func1,func2){
    if(isstart_noorder==0){//停止

        $("#"+label).html("");return;
    }
    if(num_noorder!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_noorder+"秒(倒计时)</font>");
        num_noorder = num_noorder-1;
        func2();
        //每秒执行一次
        time_noorder = setTimeout("countdown_noorder('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}





//==================多订单显示倒计时===================================
var num_twoorder;
var time_twoorder;
var isstart_twoorder;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_twoorder(label,func1,func2){
    if(isstart_twoorder==0){//停止

        $("#"+label).html("");return;
    }
    if(num_twoorder!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_twoorder+"秒(倒计时)</font>");
        num_twoorder = num_twoorder-1;
        func2();
        //每秒执行一次
        time_twoorder = setTimeout("countdown_twoorder('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================拍照倒计时===================================
var num_photo;
var time_photo;
var isstart_photo;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_photo(label,func1,func2){
    if(isstart_photo==0){//停止

        $("#"+label).html("");return;
    }
    if(num_photo!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_photo+"秒(倒计时)</font>");
        num_photo = num_photo-1;
        func2();
        //每秒执行一次
        time_photo = setTimeout("countdown_photo('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================拍照失败倒计时===================================
var num_photofaild;
var time_photofaild;
var isstart_photofaild;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_photofaild(label,func1,func2){
    if(isstart_photofaild==0){//停止

        $("#"+label).html("");return;
    }
    if(num_photofaild!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_photofaild+"秒(倒计时)</font>");
        num_photofaild = num_photofaild-1;
        func2();
        //每秒执行一次
        time_photofaild = setTimeout("countdown_photofaild('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================身份证单次比对失败倒计时===================================
var num_idcardfaild;
var time_idcardfaild;
var isstart_idcardfaild;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_idcardfaild(label,func1,func2){
    if(isstart_idcardfaild==0){//停止

        $("#"+label).html("");return;
    }
    if(num_idcardfaild!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_idcardfaild+"秒(倒计时)</font>");
        num_idcardfaild = num_idcardfaild-1;
        func2();
        //每秒执行一次
        time_idcardfaild = setTimeout("countdown_idcardfaild('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================房卡信息显示倒计时===================================
var num_roomcard;
var time_roomcard;
var isstart_roomcard;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_roomcard(label,func1,func2){
    if(isstart_roomcard==0){//停止

        $("#"+label).html("");return;
    }
    if(num_roomcard!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_roomcard+"秒(倒计时)</font>");
        num_roomcard = num_roomcard-1;
        func2();
        //每秒执行一次
        time_roomcard = setTimeout("countdown_roomcard('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================房卡制作失败倒计时===================================
var num_roomcardfaild;
var time_roomcardfaild;
var isstart_roomcardfaild;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_roomcardfaild(label,func1,func2){
    if(isstart_roomcardfaild==0){//停止

        $("#"+label).html("");return;
    }
    if(num_roomcardfaild!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_roomcardfaild+"秒(倒计时)</font>");
        num_roomcardfaild = num_roomcardfaild-1;
        func2();
        //每秒执行一次
        time_roomcardfaild = setTimeout("countdown_roomcardfaild('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//==================身份证多次比对倒计时===================================
var num_twoidcardfaild;
var time_twoidcardfaild;
var isstart_twoidcardfaild;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_twoidcardfaild(label,func1,func2){
    if(isstart_twoidcardfaild==0){//停止

        $("#"+label).html("");return;
    }
    if(num_twoidcardfaild!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_twoidcardfaild+"秒(倒计时)</font>");
        num_twoidcardfaild = num_twoidcardfaild-1;
        func2();
        //每秒执行一次
        time_twoidcardfaild = setTimeout("countdown_twoidcardfaild('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}




//==================支付倒计时===================================
var num_pay;
var time_pay;
var isstart_pay;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_pay(label,func1,func2){
    if(isstart_pay==0){//停止

        $("#"+label).html("");return;
    }
    if(num_pay!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_pay+"秒(倒计时)</font>");
        num_pay = num_pay-1;
        func2();
        //每秒执行一次
        time_pay = setTimeout("countdown_pay('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}




//==================支付详情倒计时===================================
var num_payinfo;
var time_payinfo;
var isstart_payinfo;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_payinfo(label,func1,func2){
    if(isstart_payinfo==0){//停止

        $("#"+label).html("");return;
    }
    if(num_payinfo!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_payinfo+"秒(倒计时)</font>");
        num_payinfo = num_payinfo-1;
        func2();
        //每秒执行一次
        time_payinfo = setTimeout("countdown_payinfo('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}



//==================同一身份证提示倒计时===================================
var num_onlycard;
var time_onlycard;
var isstart_onlycard;
//倒计时   倒计时结束后执行方法func1    倒计时过程中执行方法func2
function countdown_onlycard(label,func1,func2){
    if(isstart_onlycard==0){//停止

        $("#"+label).html("");return;
    }
    if(num_onlycard!=0){//持续进行
        $("#"+label).html("<font color='red'>"+num_onlycard+"秒(倒计时)</font>");
        num_onlycard = num_onlycard-1;
        func2();
        //每秒执行一次
        time_onlycard = setTimeout("countdown_onlycard('"+label+"',"+func1+","+func2+")",1000);

    }else{//跳转
        func1();
    }

}


//警方提示倒计时
function police_time(){
    isstart_card=0;//放身份证提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_police=1;//警方提示倒计时
    num_police=30;
    countdown_police("countdown_1",goIndex,noDo);//启动倒计时
}

function police_time_close(){
    isstart_police=0;
}


//取房卡放身份证倒计时
function putcard_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时

    isstart_card=1;//放身份证提示倒计时
    num_card=30;
    countdown_card("countdown_1",goIndex,checkcard);//启动倒计时
}
function putcard_time3(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时

    isstart_card=1;//放身份证提示倒计时
    num_card=60;
    countdown_card("countdown_1",goIndex3,checkcard);//启动倒计时
}

function putcard_time_close(){
    isstart_card=0;//放身份证提示倒计时
}

//读身份证失败倒计时
function readcardfail_time(){
    isstart_police=0;//警方提示倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_cardfaild=1;//身份证读取失败倒计时
    num_cardfaild=3;
    countdown_cardfaild("countdown_2",putcard,noDo);//启动倒计时
}

//读身份证失败倒计时
function readcardfail_time2(){
    isstart_police=0;//警方提示倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_cardfaild=1;//身份证读取失败倒计时
    num_cardfaild=3;
    countdown_cardfaild("countdown_2",fhRoomDetail,noDo);//启动倒计时
}


//手机号填写错误倒计时
function mobilefail_time(){
    isstart_police=0;//警方提示倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_cardfaild=1;//身份证读取失败倒计时
    num_cardfaild=3;
    countdown_cardfaild("countdown_2",sendSMS,noDo);//启动倒计时
}


//短信发送倒计时
function sms_time(){
    isstart_police=0;//警方提示倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_cardfaild=1;//身份证读取失败倒计时
    num_cardfaild=3;
    countdown_cardfaild("countdown_2",goIndex,noDo);//启动倒计时
}


//取房卡第二入住人放身份证倒计时
function secputcard_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时

    isstart_card=1;//放身份证提示倒计时
    num_card=30;
    countdown_card("countdown_1",goIndex,seccheckcard);//启动倒计时
}

function secputcard_time_close(){
    isstart_card=0;//放身份证提示倒计时
}




//第二入住人读身份证失败倒计时
function secreadcardfail_time(){
    isstart_police=0;//警方提示倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_cardfaild=1;//身份证读取失败倒计时
    num_cardfaild=3;
    countdown_cardfaild("countdown_2",secputcard,noDo);//启动倒计时
}




//查询房卡信息放身份证倒计时
function putcard_time2(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时
    isstart_card=0;

    isstart_card2=1;//放身份证提示倒计时
    num_card2=30;
    countdown_card2("countdown_1",goIndex,checkcard);//启动倒计时
}

function putcard_time_close2(){
    isstart_card2=0;//放身份证提示倒计时
}

//显示订单倒计时
function order_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时



    isstart_order=1;//单个订单显示倒计时
    num_order=30;
    countdown_order("countdown_1",goIndex,noDo);//启动倒计时
}


//发短信倒计时
function smsinfo_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时



    isstart_order=1;//单个订单显示倒计时
    num_order=60;
    countdown_order("countdown_1",goIndex,noDo);//启动倒计时
}

//支付倒计时
function pay_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_order=0;//单个订单显示倒计时

    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时



    isstart_pay=1;//支付倒计时
    num_pay=30;
    countdown_pay("countdown_1",closephoto,noDo);//启动倒计时
}


function payclose_time(){
    isstart_pay=0;//支付倒计时
}

//支付详情倒计时
function payinfo_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_pay=0;//支付倒计时

    isstart_onlycard=0;//同一身份证提示倒计时




    isstart_payinfo=1;//支付详情倒计时
    num_payinfo=120;
    countdown_payinfo("countdown_1",closephoto,payover);//启动倒计时
}


function payinfoclose_time(){
    isstart_payinfo=0;//支付倒计时
}

//拍照倒计时
function photo_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时




    isstart_photo=1;//拍照倒计时
    num_photo=30;
    countdown_photo("countdown_1",closephoto2,noDo);//启动倒计时
}

function photo_time_close(){
    isstart_photo=0;//房卡退房日期提示倒计时关闭
}

//拍照失败倒计时
function photofaild_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时





    isstart_photofaild=1;//拍照失败倒计时
    num_photofaild=3;
    countdown_photofaild("countdown_2",closephoto2,noDo);//启动倒计时
}


//房卡退房日期提示倒计时关闭
function roomcard_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_roomcard=1;//房卡信息显示倒计时
    num_roomcard=30;
    countdown_roomcard("countdown_1",goIndex,noDo);//启动倒计时
}

function roomcard_time_close(){
    isstart_roomcard=0;//房卡退房日期提示倒计时关闭
}

//提示插入房卡倒计时
function putroomcard_time(){
    isstart_police=0;//警方提示倒计时
    isstart_cardfaild=0;//身份证读取失败倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时


    isstart_card=1;//插入房卡倒计时打开
    num_card=30;
    countdown_card("countdown_1",goIndex,checkroomcard);//启动倒计时
}

function putroomcard_time_close(){
    isstart_card=0;//插入房卡倒计时关闭
}

//提示插入房卡倒计时
function readcardfaild_time(){
    isstart_police=0;//警方提示倒计时
    isstart_roomcard=0;//房卡信息显示倒计时
    isstart_card=0;//放身份证提示倒计时
    isstart_noorder=0;//无订单显示倒计时
    isstart_twoorder=0;//多订单显示倒计时
    isstart_order=0;//单个订单显示倒计时
    isstart_photo=0;//拍照倒计时
    isstart_idcardfaild=0;//身份证单次比对失败倒计时
    isstart_photofaild=0;//拍照失败倒计时
    isstart_roomcardfaild=0;//房卡制作失败倒计时
    isstart_twoidcardfaild=0;//身份证多次比对倒计时
    isstart_pay=0;//支付倒计时
    isstart_payinfo=0;//支付详情倒计时
    isstart_onlycard=0;//同一身份证提示倒计时



    isstart_cardfaild=1;//身份证读取失败倒计时
    num_roomcard=3;
    countdown_cardfaild("countdown_2",putcard,noDo);//启动倒计时
}
