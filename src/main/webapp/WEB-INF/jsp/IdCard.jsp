<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=basePath%>css/common.css">
<link rel="stylesheet" href="<%=basePath%>css/pulgin/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/IdCard.css">
<script src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>js/pulgin/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jinyou.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base.js"></script>
<script type="text/javascript" src="<%=basePath%>js/photo2.js"></script>

<title>取房卡</title>
</head>
<body ondragstart="return false">
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
					<a href="<%=basePath%>menu/index"> <span class="icons"></span>&nbsp;&nbsp;<span>首页</span>
					</a>
				</div>
				<div class="fr right ">
					<!--倒计时-->
					<span class="" id="countdown_1"></span>
				</div>
			</div>
			<!--提示读取身份证-->
			<div class="id_card content_box">
				<p class="">请在机器下方放置二代居民身份证</p>
                <div id="idcard">
                    <img src="<%=basePath%>img/card.png" alt="">
                </div>
                <button class="sxt_remove">取消</button>
			</div>



			<!--刷脸-->
			<div class="face_box" style="display: none;" >
				<p class="face">请将您的脸部对准下方摄像头</p>
				<div id="picture">
						<OBJECT ID="CommonLiveDetectionOCX" width=100% height=100%
						name="htjcObj"
						CLASSID="CLSID:F968BF6F-304F-435D-A387-A9AB273D1FD7"></OBJECT>
						<img id="img" src="" style="display: none;">
        				<img id="img2" src="" style="display: none;">
				</div>
				<div >
			<table id="imageTable">
				<tbody id="imageTbody">
				</tbody>
			</table>
		</div>
				<button class="sxt_remove" onclick="closephoto2()">返回</button>

			</div>




			<!--  支付钱页面  -->
			<div class="to_pays" style="display: none;">
				<p class="title col-md-12 col-lg-12 ">
					<span class="t_one col-md-4 col-lg-4">房费： <i id="roomrate">
							￥880</i></span> <span class="t_two col-md-4 col-lg-4">住宿押金：<i
						id="deposit"> ￥40</i></span> <span class="t_three col-md-4 col-lg-4">共需支付：<i
						style="color: #ff5a00;font-weight: 600; font-style:italic;"
						id="totalfree"> ￥920</i></span>
				</p>
				<div id="pay_ma">
					<img src="" alt="" id="imgUrl">
				</div>
				<div class=" pay_ma">
					<span class="icons zfb_pay"></span>支付宝支付
				</div>

				<div class="btns_btm2">
					<button class="" onclick="pay()">返回</button>
					<!-- <button class="" onclick="payover()">支付完成</button> -->
				</div>
			</div>

			<!--房间展示-->
			<!--<div class="show_room" style="display: none;">
                <div class="sr_left"></div>
                <div class="sr_center"></div>
                <div class="sr_right"></div>
            </div>-->

			<!--发送短信-->
			<div class="phones" style="display: none;">
				<p class="">将房间信息发送到该手机</p>
				<div id="numbers">
					<span class="icons"></span> <input class="to_send" type="tel"
						maxlength="11" id="mobile" placeholder="请输入手机号"
						disabled="disabled">
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
						<button class="one_del">
							<img src="<%=basePath%>img/one_del.png" alt="">
						</button>
					</div>
				</div>
				<div class="footer_btn">
					<button class="back_num" onclick="goIndex()">关闭</button>
					<button class="sure_num" onclick="send()">确定</button>
				</div>
			</div>

			<!--房间内容-->
			<div class="rooms_content" style="display: none;">
				<div class="col-md-12 col-lg-12">
					<div class="col-md-4 col-lg-4">
						<p class="fs">房型</p>
						<p class="line" >
							<label id="roomtype"></label>
						</p>
					</div>
					<div class="col-md-4 col-lg-4 days">
						<p class="fs">入住天数</p>
						<p>
							<span class="col-md-4 col-lg-4"> <i class="l_l">入住</i> <i><label
									id="intime"></label></i>
							</span> <span class="col-md-4 col-lg-4"> <i
								style="color: rgba(0,0,0,0);">&nbsp;</i> <i><label
									id="days"></label></i>
							</span> <span class="col-md-4 col-lg-4"> <i class="l_l">离店</i> <i><label
									id="outtime"></label></i>
							</span>
						</p>
					</div>
					<div class="col-md-4 col-lg-4" >
						<p class="fs">
							<i style="color: red;">*</i>入住人数
						</p>
						<div class="line1">
							<label>
								<div class="rzrs1">
									<span class="col-md-6 col-lg-6">
										<input name="people" type="radio" value="1"/>1人	
									</span>
								</div>
							</label>
							<label>
								<div class="rzrs2">
									<span class="col-md-6 col-lg-6">
							 			<input name="people" type="radio" value="2" />2人
									</span>
								</div>
							</label>
						 </div>
					</div>
				</div>
				<div class="rooms_con_btn clearfix">
					<button class="fl getcard" disabled onclick="pay()">取房卡</button>
					<button class="fr" onclick="goIndex()">关闭</button>
				</div>
			</div>

		</div>

		<!--身份证读取失败 和 采样失败   Modal -->
		<div class="modal " id="card_myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
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
						<button type="button" class="btn btn-default again_btn"
							data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>

		<!--身份证认证失败 和 请勿使用同一人   Modal -->
		<div class="modal " id="nopp_myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
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
						<button type="button" class="btn btn-default again_btn"
							data-dismiss="modal">关闭</button>
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

	<script src="<%=basePath%>js/IdCard.js"></script>
	<!-- <script language="JavaScript" for="stdfcectl"
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
            $(".face_box").hide();
        	$(".content_box").show();
        	if(current==2){
                $(".content_box").html('<p class="">第二入住人正在进行人证比对，请稍后...</p><div id="gifcard"><img src="'+getRootPath()+'img/new_blues.gif" alt=""></div>');
            }
        	if(current==1){
            $(".content_box").html('<p class="">正在进行人证比对，请稍后...</p><div id="gifcard"><img src="'+getRootPath()+'img/new_blues.gif" alt=""></div>');
        	}


        	 if(current==2){
              	seccheckphoto(str);
              }
            if(current==1){
            	firstcheckphoto(str);

            }


        }
        else
        {
        	failphoto();
            // 采集失败，可以在这里进行相应处理
        }
    </script> -->




    <script type="text/javascript" for="CommonLiveDetectionOCX" event="LiveDetectStatusEvent(ULONG)">
		checkHtjc(ULONG);
	</script>







	<script type="text/javascript">

       putcard();
       </script>
	<script type="text/javascript" src="<%=basePath%>js/time.js"></script>
</body>
</html>