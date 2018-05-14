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
<link rel="stylesheet" href="<%=basePath%>css/checkout.css">
<script type="text/javascript" src="<%=basePath%>js/jinyou.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base.js"></script>
<script src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>js/pulgin/bootstrap.min.js"></script>
<title>退房</title>
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
			<!--读取失败-->
			<div class="content_box" id="readfail" style="display: none;">
				<p class="title">房卡读取失败，房卡已推出，请前去前台处理</p>
				<p class="title">感谢您的理解与支持</p>

				<button class="gb" onclick="goIndex()">关闭</button>
			</div>
			<!--loading-->
			<div class="content_box" id="loading" style="display: none;">
				<p class="title">正在读取房卡信息，请稍后....</p>
				<div id="gifcard">
					<img src="<%=basePath%>img/new_blues.gif" alt="">
				</div>
			</div>
			<!--loading-->
			<div class="content_box" id="loading_out" style="display: none;">
				<p class="title">正在退房，请稍后....</p>
				<div id="gifcard">
					<img src="<%=basePath%>img/new_blues.gif" alt="">
				</div>
			</div>
			<!--退出房卡-->
			<div class="content_box" id="sendcard" style="display: none;">
				<p class="title">退房失败，您的房卡已推出，请勿遗漏</p>
				<button class="gb" onclick="goIndex()">关闭</button>
			</div>
			<!--退房信息-->
			<div class="content_box" id="cardinfo" style="display: none;">
				<p class="title">房卡信息读取成功，您的客房到期时间为：</p>
				<p class="title" id="outTime"></p>
				<p class="title">您确认现在要退房吗？</p>
				<button class=" but_1" onclick="goIndex()">取消</button>
				<button class=" but_2" onclick="checkouting()">确认</button>
			</div>
			<!--回收房卡信息-->
			<div class="content_box" id="recycleinfo" style="display: none;">
				<p class="title">房卡信息读取成功，您以在微信公众号退房</p>
				<p class="title">您确认现在要回收房卡吗？</p>
				<button class=" but_1" onclick="goIndex()">取消</button>
				<button class=" but_2" onclick="recycling()">确认</button>
			</div>
			<!--退房 成功-->
			<div class="content_box" id="successtf" style="display: none;">
				<h4 class="title">
					<i class="icons tf_succ"></i>退房成功
				</h4>
				<!--订单超时 S-->
				<p class="title cs" style="display:none">【您的订单超时，可能会产生一定的额外费用】</p>
				<!--订单超时 E-->

				<p class="title top_tips">请注意携带随身物品，因核查房屋消费，超时消费等</p>
				<p class="title">押金将扣除额外费用，于1到7个工作日原路返还，请您注意查收。</p>
				<p class="title puestions">
					<i class="icons pues_pic"></i>如有疑问，请到前台或拨打0574-55339999咨询
				</p>
				<button class="gb" onclick="goIndex()">关闭</button>
			</div>
			<!--身份证读取失败 和 采样失败   Modal -->
			<div class="modal " id="card_myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<p>3秒(倒计时)</p>
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


	<script type="text/javascript" src="<%=basePath%>js/time.js"></script>
	<script>
		$("#successtf").hide();
		/*       var i = 0;
		      function tab() {
		          let arr = ['successtf','into','readfail','loading','sendcard','cardinfo','loading_out'];
		          $.each(arr,function(k,v){
		              $("#"+v).css('display','none');
		          })
		          console.log(arr[i]);
		          $("#"+arr[i]).css('display','block');
		          i ++
		      } */
	</script>
	<script src="<%=basePath%>js/checkout.js"></script>
	<script type="text/javascript">
		putroomcard();
	</script>
</body>
</html>