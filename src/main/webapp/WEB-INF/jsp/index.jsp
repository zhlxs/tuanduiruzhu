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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="<%=basePath%>css/common.css">
<link rel="stylesheet" href="<%=basePath%>css/index.css">

<script type="text/javascript" src="<%=basePath%>js/jinyou.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base.js"></script>

<title>首页</title>
</head>
<body ondragstart="return false" style="height:100%;">
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
			<!--有网状态-->
			<div class="has_wifi content_box clearfix">
				<div id="qfk" class="fl">
					<button>
						<span class="icons"></span>
						<p>取房卡</p>
					</button>
				</div>
				<div id="cx">
					<button>
						<span class="icons"></span>
						<p>查询</p>
					</button>
				</div>
				<div id="tfk" class="fr">
					<button>
						<span class="icons"></span>
						<p>退房卡</p>
					</button>
				</div>
				<div id="tdrz" class="">
					<button >
						<span class="icons"></span>
						<p>团队入住</p>
					</button>
				</div>
				<div class="no_title">
					<p class="no_cards">
						<i style="color: red;"></i>房卡已发完，请到前台办理取房卡，谢谢您的理解与支持
					</p>
					<p class="no_kc">
						<i style="color: red;"></i>卡槽已满，请到前台办理退房卡，谢谢您的理解与支持
					</p>
				</div>
				
			</div>

			<!--无网状态-->
			<div class="no_wifi content_box clearfix">
				<div class="wifis">
					<span class="icons"></span>
					<p>没有网了，请联系前台来给我检查网络</p>
				</div>
			</div>
		</div>

        	<div class="btm">
			<p>扫描二维码</p>
			<p>可在酒店公众号进行订房</p>
			<img src="<%=basePath%>img/code.jpg" alt="">		

		</div>
	</div>
	<script src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>
	<script src="<%=basePath%>js/index.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/time.js"></script>
	<script type="text/javascript">
	$(".btm").show();
		if ("${netState}" == "ok") {
			//网络正常
			$(".has_wifi").show();
			$(".no_wifi").hide();
		} else {
			//网络异常
			$(".has_wifi").hide();
			$(".no_wifi").show();
		}

		//房卡已发完 ， 房卡状态 和 提示信息
		var fangka = "${isHasCard}";
		if (fangka == "ok") {
			$(".no_cards").hide();
			$("#qfk button span").css(
					{
						"background" : "url('" + getRootPath()
								+ "/img/Roomcard.png') no-repeat",
						"background-size" : "100% 100%"
					});
			$("#qfk button p").css("color", "#000");
			$("#qfk").on("click", function() {
				//显示警告通知
				window.location.href = getRootPath() + "menu/notice";
			});
		} else {
			$(".no_cards").show();
			$("#qfk button span").css(
					{
						"background" : "url('" + getRootPath()
								+ "/img/no_Roomcard.png') no-repeat",
						"background-size" : "100% 100%"
					});
			$("#qfk button p").css("color", "#a3a2a2");
		}

		//卡槽满 ，退房卡不能操作
		var kacao = "${isRecycleAvail}";
		if (kacao == "ok") {
			$(".no_kc").hide();
			$("#tfk button span").css(
					{
						"background" : "url('" + getRootPath()
								+ "/img/check-out.png') no-repeat",
						"background-size" : "100% 100%"
					});
			$("#tfk button p").css("color", "#000");
			$("#tfk").on("click", function() {
				window.location.href = getRootPath() + "menu/checkout";
			});
		} else {
			$(".no_kc").show();
			$("#tfk button span").css(
					{
						"background" : "url('" + getRootPath()
								+ "/img/no_checkout.png') no-repeat",
						"background-size" : "100% 100%"
					});
			$("#tfk button p").css("color", "#a3a2a2");
		}
	</script>
</body>
</html>