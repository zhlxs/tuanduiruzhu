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
<link rel="stylesheet" href="<%=basePath%>css/police.css">
<script type="text/javascript" src="<%=basePath%>js/jinyou.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base.js"></script>
<script src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>

<title>公安信息</title>
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
			<div class="content_box">
				<p class="title">根据治安管理处罚法规定，<span style="color:red;">请如实填写住客人数</span>，如出现隐瞒不报等相关情况，<br/><br/>酒店有权上报当地治安管理部门，并记录信用档案。<br/><br/>三人以上(包括三人)请到前台办理</p>
				<a href="#" class="remove" onclick="getcard()">确定</a>
			</div>



		</div>
	</div>
	<script src="<%=basePath%>js/police.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/time.js"></script>
</body>
</html>