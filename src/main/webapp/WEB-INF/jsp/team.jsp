<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>css/common.css">
    <link rel="stylesheet" href="<%=basePath%>css/pulgin/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/team.css">
    <script type="text/javascript" src="<%=basePath%>js/base.js"></script>
    <script src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>js/pulgin/bootstrap.min.js"></script>
    <%--<script src="<%=basePath%>js/photo1.js"></script>--%>
    <script src="<%=basePath%>js/photo.js"></script>
    <title>团队入住</title>
</head>
<body>
<div class="box">
    <div class="content">
        <div class="times clearfix">
            <div class="fl left">
                    <span id="date_1" class="time_ymd"></span>&nbsp;&nbsp; <span
                        id="time_1"></span>
            </div>
            <div class="fr right">
                <span id="week_1" class="todays"></span>
            </div>
        </div>
        <div class="header clearfix">
            <div class="fl left">
                <a href="<%=basePath%>menu/index">
                    <span class="icons"></span>&nbsp;&nbsp;<span>首页</span>
                </a>
            </div>
            <div class="fr right ">
                <span class="" id="countdown_1"></span>
            </div>
        </div>

        <!-- 订单信息 -->
        <div class="content_box" id="orders">
            <div class="order_info" id="orderDetail">
                <!-- 一 -->

            </div>
            <div class="footer">
                <input type="button" value="关闭" class="btn_gb">
                <%--<input type="button" value="确定" class="btn_qd">--%>
            </div>
        </div>
        <!--发送短信-->
        <div class="phones content_box" id="phones">
            <p class="">请输入订单预留手机号</p>
            <div id="numbers">
                <span class="icons"></span>
                <input class="to_send" disabled type="tel" maxlength="11" placeholder="请输入手机号">
            </div>
            <div class="num_box">
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">1</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">2</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">3</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">4</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">5</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">6</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">7</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">8</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">9</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="add_del">清除</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="num_bg">0</button>
                </div>
                <div class="col-md-4 col-lg-4 nums">
                    <button class="one_del"><img src="<%=basePath%>img/one_del.png" alt=""></button>
                </div>
            </div>
            <div class="footer_btn">
                <input type="button" class="back_num" value="返回">
                <input type="button" class="sure_num" value="确定">
            </div>
        </div>

        <!-- 房间信息 -->
        <div class="content_box" id="allRoom">
            <div class="all_rooms clearfix" id="showAllRoomType">
                <!-- before_lr 未录入 -->
                <!-- after_lr 已录入 -->

                <%--<div class="single after_lr">
                    <h4>商务标准间</h4>
                    <p>1066房</p>
                </div>--%>


            </div>
            <div class="footer">
                <input type="button" value="关闭" class="btn_gb">
                <input type="button" value="确定" class="btn_qd">
            </div>
        </div>

        <!-- 可选人数 -->
        <div class="content_box" id="chooseNum">
            <div class="choose_num">
                <h4>请选择入住人数</h4>
                <div class="choose_box clearfix" id="showChooseNum">

                    <%--<div class="p_nums">
                        3人
                    </div>
                    <div class="p_nums">
                        4人
                    </div>
                    <div class="p_nums fr">
                        5人
                    </div>--%>
                </div>
                <!-- <div class="footer_btn"> -->
                <input type="button" class="btn_choose_back" value="返回">
                <input type="button" class="btn_choose_sure" value="确定">
                <!-- </div> -->
            </div>
        </div>

        <!--读取身份证-->
        <div class="content_box" id="idcard">

        </div>

        <!--人脸识别-->
        <div class="content_box" id="face_box">
            <p class="face">请将您的脸部对准摄像头</p>
            <%--<div id="picture">--%>
                <%--<OBJECT ID="CommonLiveDetectionOCX" width=1200 height=860 name="htjcObj"--%>
                        <%--CLASSID="CLSID:F968BF6F-304F-435D-A387-A9AB273D1FD7"></OBJECT>--%>
                <%--<img id="img" src="">--%>
                <%--<img id="img2" src="">--%>
            <%--</div>--%>
            <div id="picture">
                <OBJECT ID="stdfcectl" width=100% height=100%
                        CLASSID="CLSID:FC3899CF-1DDA-4F3D-917C-AA7A7385320B"></OBJECT>
            </div>
            <button class="back">返回</button>
        </div>

        <!--身份证读取失败 和 采样失败   Modal -->
        <div class="modal " id="card_myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <p id="countdown_2"></p>
                    </div>
                    <div class="modal-body">
                        <i class="icons again"></i>
                        <p>身份证读取失败，请重新读取</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default again_btn" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>

        <!--身份证认证失败 和 请勿使用同一人   Modal -->
        <div class="modal " id="nopp_myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <p id="countdown_3"></p>
                    </div>
                    <div class="modal-body">
                        <i class="icons nopp"></i>
                        <div class="center_box">
                            <p>身份证认证失败，您的头像与身份证不匹配</p>
                            <p>请重新认证</p>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default again_btn" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
<textarea id="parm" style="word-wrap:normal;" cols="57" rows="8"></textarea>
&nbsp;&nbsp;
<textarea id="reta" cols="57" rows="8"></textarea>
&nbsp;&nbsp;
<br />
<br />
<textarea id="data" cols="57" rows="8"></textarea>
<textarea id="datr" cols="57" rows="8"></textarea>
&nbsp;&nbsp;
<script src="<%=basePath%>js/team.js"></script>


<script>
    var arr = ['idcard', 'face_box', 'chooseNum', 'allRoom', 'orders', 'phones'];
    $.each(arr, function (k, v) {
        $("#" + v).css('display', 'none');
    })

    var i = 0;

    function tab() {
        var arr = ['idcard', 'face_box', 'chooseNum', 'allRoom', 'orders', 'phones'];
        $.each(arr, function (k, v) {
            $("#" + v).css('display', 'none');
        })
        $("#" + arr[i]).css('display', 'block');
        if (i == 6) {
            $("#card_myModal").modal("show");
        }
        if (i == 7) {
            $("#nopp_myModal").modal("show");
        }
        i++
    }

    //可选房间信息 
    $(".before_lr").on("click", function (e) {
        //     if(e&&e.stopPropagation){//非IE
        // 　　  e.stopPropagation();
        // 　　}else{//IE
        // 　　  window.event.cancelBubble=true;
        // 　　}
        console.log($(this).children("h4").html()); //可选房间的型号
        console.log($(this).children("p").html()); //可选房间 房间号
    });
</script>

<%--<script type="text/javascript" for="CommonLiveDetectionOCX" event="LiveDetectStatusEvent(ULONG)">--%>
    <%--checkHtjc(ULONG);--%>
<%--</script>--%>


<script language="JavaScript" for="stdfcectl"
        event="GetImageEvent(RetCode)">
    // 采集成功回调
    if (0 == RetCode)
    {
        // 获取数据
        var str = stdfcectl.GetImageData();
        document.getElementById("data").value = str;

        //var str2 = stdfcectl.GetImageData(1);
        //document.getElementById("datr").value = str2;


        // 延时显示照片，因为js是单线程
        //setTimeout("showImgA()", 3000);
        closeDevice();
        $("#face_box").hide();
        $("#idcard").show();
        $("#idcard").html('<p class="">正在进行人证比对，请稍后...</p><div id="gifcard"><img src="'+getRootPath()+'img/new_blues.gif" alt=""></div>');
            firstcheckphoto(str);
    }
    else
    {
        failphoto();
        // 采集失败，可以在这里进行相应处理
    }
</script>



</body>
</html>