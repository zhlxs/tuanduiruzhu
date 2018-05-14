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
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=basePath%>css/common.css">
<link rel="stylesheet" href="<%=basePath%>css/pulgin/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/query.css">
<script src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>js/pulgin/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jinyou.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base.js"></script>
<script type="text/javascript" src="<%=basePath%>js/query.js"></script>
<script type="text/javascript" src="<%=basePath%>js/photo1.js"></script>

<title>查询</title>
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

			<!--插入房卡-->
			<div class="into content_box" id="into">
				<p class="title">请在机器下方插入房卡</p>
				<div>
					<img src="<%=basePath%>img/Plug-incard.png" alt="">
				</div>
				<button class="remove" onclick="goIndex()">关闭</button>
			</div>
			<!--loading-->
			<div class="content_box" id="loading" style="display: none;">
				<p class="title">正在读取房卡信息，请稍后....</p>
				<div id="gifcard">
					<img src="<%=basePath%>img/new_blues.gif" alt="">
				</div>
			</div>
			<!--读取失败-->
			<div class="content_box" id="readfail" style="display: none;">
				<p class="title">房卡读取失败，房卡已退出，请前去前台处理</p>
				<p class="title">感谢您的理解与支持</p>

				<button class="gb" onclick="goIndex()">关闭</button>
			</div>
			<!--房卡弹出-->
			<div class="content_box" id="sendcard" style="display: none;">
				<p class="">房卡以弹出，请在机器下方取走您的房卡</p>
				<div class="room_card">
					<p class="rc_top">北京广西大厦</p>
					<p class="rc_center">
						房间号<i>8888</i>
					</p>
					<p class="rc_btm">
						<span>入住：<i>2018年1月23日</i></span><span>退房：<i>2018年1月25日</i></span>
					</p>
				</div>
				<div class="no_title">
					<p class="no_cards">
						<i style="color: red;"></i>房卡已发完，请到前台办理取房卡，谢谢您的理解与支持
					</p>
				</div>
				<div class="btns_btm">
					<button class="" onclick="goIndex()">关闭</button>
				</div>

			</div>
			<!--插入房卡-->
			<div class="content_box" id="idcard" style="display: none;">
				<p class="title">请在机器下方放置二代身份证</p>
				<div>
					<img src="<%=basePath%>img/card.png" alt="">
				</div>
				<button class="remove" onclick="goIndex()">关闭</button>
			</div>
			<!--人脸识别-->
			<div class="content_box" id="face_box" style="display: none;">
				<p class="face">请将您的脸部对准下方摄像头</p>
				<div id="picture">
						<OBJECT ID="CommonLiveDetectionOCX" width=100% height=100% name="htjcObj"
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
				<button class="sxt_remove" onclick="goIndex()">返回</button>
			</div>

			<!--非入住人-->
			<div class="content_box" id="cardinfo" style="display: none;">
				<p class="title">因检测到您非入住人，为了客户安全，已将您的房卡锁定，如是本人，请您到前台重新办理房卡</p>
				<p class="title">感谢您的理解与支持</p>
				<button class="gb" onclick="goIndex()">关闭</button>
			</div>
			<!--弹出框提示-->
			<!--<div class="modal" id="card_myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                    <div class="modal-header">
                        <p >30秒倒计时</p>
                    </div>
                    <div class="modal-body">
                        <i class="icons again"></i>
                        <p>采样失败，请您脸部对准摄像头</p>
                        <! <p>身份证认证失败，您的头像与身份证不匹配</p>
                        <p>请重新认证</p> -->
			<!--<p>请勿重复使用同一人身份证</p>
                        -->
			<!--</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default again_btn" data-dismiss="modal">确定</button>
                    </div>
                    </div>
                </div>
            </div>-->

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
							<p>3秒(倒计时)</p>
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
	<script src="<%=basePath%>js/query.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/time.js"></script>


	<script language="JavaScript" for="stdfcectl"
		event="GetImageEvent(RetCode)">
		// 采集成功回调
		if (0 == RetCode) {
			// 获取数据
			var str = stdfcectl.GetImageData();
			document.getElementById("data").value = str;

			//var str2 = stdfcectl.GetImageData(1);
			//document.getElementById("datr").value = str2;

			// 延时显示照片，因为js是单线程
			//setTimeout("showImgA()", 3000);
			closeDevice();
			$("#loading").html(
					'<p class="">正在人证比对，请稍后....</p>'
							+ '<div id="gifcard"><img src="' + getRootPath()
							+ 'img/new_blues.gif" alt=""></div>');
			$("#face_box").hide();
			$("#loading").show();
			querycheckphoto(str);
			photo_time_close();
		} else {
			failphoto();
			// 采集失败，可以在这里进行相应处理
		}
	</script>
	<script type="text/javascript">
		$("#into").show();
	</script>
	<script type="text/javascript" for="CommonLiveDetectionOCX" event="LiveDetectStatusEvent(ULONG)">
		checkHtjc(ULONG);
	</script>
</body>
</html>