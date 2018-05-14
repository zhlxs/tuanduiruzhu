var number;//入住人数
var firstcheckphotofail;//第一入住人人证比对失败次数
var seccheckphotofail;//第二入住人人证比对失败次数
var current;//当前人证比对序号 1或2
var phonenum = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
var roomNum;
var orderNum;
$(".face_box").hide();
//提示放身份证
function putcard() {
	$(".content_box").show();
	$("#card_myModal").modal("hide");
	$(".content_box").html('<p class="">请在机器下方放置二代居民身份证</p>'
			+ '<div id="idcard"> <img src="' + getRootPath()
			+ 'img/card.png" alt=""></div>'
			+ '<button class="remove" onclick=goIndex()>取消</button>');
	putcard_time();//倒计时
}
function formatDate(date) {
	var str = date.toString().replace(/-/g, "/");
	var d = new Date(str),     
	month = '' + (d.getMonth() + 1),     
	day = '' + d.getDate(),     
	year = d.getFullYear();     
	if (month.length < 2) month = '0' + month;   
	if (day.length < 2) day = '0' + day;     
	return [year, month, day].join('-'); 
} 

//检测身份证
function checkcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/checkcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					console.log('成功');
					if (res == "ok") {
						putcard_time_close();
						$(".content_box")
								.html('<p class="">请稍后，身份证正在读取中，成功提示前请勿拿走身份证</p>'
										+ '<div id="gifcard"><img src="'
										+ getRootPath()
										+ 'img/new_blues.gif" alt=""></div>');
						setTimeout("readcard()", 500);
					} else {

					}
				},
				error : function() {
				}
			});
}

//读取身份证
function readcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/readcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					console.log('成功');
					if (res == "ok") {
						getorder();
					} else {
						$(".content_box").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
						$(".again_btn").on('click', function() {
									putcard();
								});
						readcardfail_time();
					}
				},
				error : function() {
					readcardfail_time();
					$(".content_box").hide();
					$("#card_myModal").modal("show");
					$("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
					$(".again_btn").on('click', function() {
								putcard();
							});
				}
			});
}

//查询订单
function getorder() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/getorder",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					console.log('成功');
					if (res.length == 1) {
						$(".content_box").hide();
						var order = res[0];
						$("#roomtype").html(order.roomType);
						$("#intime").html(formatDate(order.inTime));
						$("#outtime").html(formatDate(order.outTime));
						$("#days").html(order.days);
						$(".rooms_content").show();

						order_time();//倒计时
						current = 1;//当前操作人默认序号为1
					}
					if (res.length > 1) {
						//系统 查询到订单  多个
						$(".content_box")
								.html('<p class="">系统查询到多条订单信息，请到前台办理入住</p>'
										+ '<p class="">感谢您的理解与支持。</p>'
										+ '<button class="gb" onclick=goIndex()>关闭</button>');
						order_time();//倒计时
					}
					if (res.length == 0) {
						//系统未查询到订单
						$(".content_box")
								.html('<p class="">系统未查询到您的订单信息，请到前台办理入住</p>'
										+ '<p class="">感谢您的理解与支持。</p>'
										+ '<button class="gb" onclick=goIndex()>关闭</button>');
						order_time();//倒计时
					}
				},
				error : function() {
					//系统未查询到订单
					$(".content_box")
							.html('<p class="">系统未查询到您的订单信息，请到前台办理入住</p>'
									+ '<p class="">感谢您的理解与支持。</p>'
									+ '<button class="gb" onclick=goIndex()>关闭</button>');
					order_time();//倒计时
				}
			});
}
//支付判断
function pay() {
	payinfoclose_time();
	$.ajax({
		type : "post",
		url : getRootPath() + "checkin/getpayinfo",
		dataType : "json",
		data : {

	}	,
		async : false,
		success : function(res) {
			console.log('成功');
			if (res != null) {
				if (res.isPay) {//已付房费
					photo();
				} else {//未付房费
					pay_time();//支付倒计时
					$(".rooms_content").hide();
					$(".content_box").show();
					$(".to_pays").hide();
					// 选择支付页面  和 点击 支付方式的效果
					$(".content_box")
							.html('<p class="black">您的订单未支付/您的订单还有押金未支付，请选择以下方式支付</p> '
									+ '<div class="pays">'
									+ '<div class="zfb  ">'
									+ '<span class="icons"></span>支付宝支付'
									+ '</div>'
									+ '<div class="wx ">'
									+ '<span class="icons"></span>微信支付'
									+ '</div>'
									+ '</div>'
									+ '<button class="pay_remove" onclick="closephoto()">返回</button>');
					$(".zfb").on("click", function() {
						payclose_time();//关闭支付倒计时
						payinfo_time();//支付详情倒计时
						$.ajax({
							type : "post",
							url : getRootPath() + "checkin/getpay",
							dataType : "json",
							data : {
								"type" : "zfb"
							},
							async : false,
							success : function(result) {
								console.log('成功');
								if (result != null) {

									$(".content_box").hide();
									$(this).addClass("zf_zctive").find("i")
											.show();
									$(this).siblings().removeClass("zf_zctive")
											.find("i").hide();
									//document.getElementById("imgUrl").src=result.imgUrl;
									$("#imgUrl").attr("src", result.imgUrl);
									$("#roomrate").html("￥" + res.roomRate);
									$("#deposit").html("￥" + res.deposit);
									$("#totalfree").html("￥" + res.totalFree);
									$(".pay_ma")
											.html("<span class='icons zfb_pay'></span>支付宝支付");
									$(".to_pays").show();

								} else {

								}
							},
							error : function() {
							}
						});

					});
					$(".wx").on("click", function() {
						payclose_time();//关闭支付倒计时
						payinfo_time();//支付详情倒计时
						$.ajax({
							type : "post",
							url : getRootPath() + "checkin/getpay",
							dataType : "json",
							data : {
								"type" : "wx"
							},
							async : false,
							success : function(result) {
								if (result != null) {
									$(".content_box").hide();
									$(this).addClass("zf_zctive").find("i")
											.show();
									$(this).siblings().removeClass("zf_zctive")
											.find("i").hide();
									//document.getElementById("imgUrl").src=result.imgUrl;
									$("#imgUrl").attr("src", result.imgUrl);
									$("#roomrate").html("￥" + res.roomRate);
									$("#deposit").html("￥" + res.deposit);
									$("#totalfree").html("￥" + res.totalFree);
									$(".pay_ma")
											.html("<span class='icons wx_pay'></span>微信支付");
									$(".to_pays").show();

								} else {

								}
							},
							error : function() {
							}
						});

					});

				}
			}
		},
		error : function() {

		}
	});
}

//支付完成
function payover() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/pay",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					console.log('成功');
					if (res == "ok") {
						payinfoclose_time();
						$(".to_pays").hide();
						$(".content_box").hide();
						$(".face_box").hide();
						$("#card_myModal").modal("hide");
						//alert("支付完成-即将跳转采集摄像头");
						photo();
					} else {

					}
				},
				error : function() {

				}
			});
}

//采集照片
/*function photo() {

	$(".face_box").show();
	$(".rooms_content").hide();
	$(".content_box").hide();
	$("#card_myModal").modal("hide");
	$("#nopp_myModal").modal("hide");

	setTimeout(photo2, 500);

}*/
/*function photo2() {
	getFaceB64A();//开启自动拍照
	photo_time();//倒计时
}*/


//新摄像头采集照片
function photo(){
	$(".face_box").show();
	$(".rooms_content").hide();
	$(".content_box").hide();
	$("#card_myModal").modal("hide");
	$("#nopp_myModal").modal("hide");
	setTimeout(function(){
		openHtjc();
		getErrInfo();
		photo_time();//倒计时
	},500);
}

function failphoto() {
	$(".face_box").hide();
	closeDevice();

	$(".again_btn").on('click', function() {
				closephoto();
			});
	$("#card_myModal").modal("show");
	$("#card_myModal .modal-body p").html("采样失败，请您脸部对准摄像头");
	photofaild_time();//倒计时
}

function closephoto() {
	$(".to_pays").hide();
	$(".content_box").hide();
	$(".face_box").hide();
	$("#card_myModal").modal("hide");
	$(".rooms_content").show();
	order_time();//订单倒计时	
}

function closephoto2() {
	closeDevice();
	$(".to_pays").hide();
	$(".content_box").hide();
	$(".face_box").hide();
	$("#card_myModal").modal("hide");
	$(".rooms_content").show();
	order_time();//订单倒计时	
}

//第一入住人人证比对
function firstcheckphoto(str) {
	
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/checkphoto",
				dataType : "json",
				data : {
					"str" : str
				},
				async : false,
				success : function(res) {
					console.log('成功');
					if (res == "ok") {
						
						$(".face_box").hide();
						if (number == 1) {
							roomcarding();
						}
						if (number == 2) {
							current = 2;
							secputcard();
						}
					} else {
						$(".face_box").hide();
						$(".content_box").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p").html("人证比对失败，请重试");
						$(".again_btn").on('click', function() {
									closephoto();
								});
						photofaild_time();//倒计时          
					}
				},
				error : function() {
					alert("error");
				}
			});

}

//第二入住人人证比对
function seccheckphoto(str) {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/seccheckphoto",
				dataType : "json",
				data : {
					"str" : str
				},
				async : false,
				success : function(res) {
					if (res == "ok") {
						roomcarding();
					} else {
						$(".face_box").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p")
								.html("第二入住人人证比对失败，请重试");
						$(".again_btn").on('click', function() {
									
									closephoto();
								});
						photofaild_time();//倒计时          
					}
				},
				error : function() {

				}
			});
}

//提示第二入住人放身份证
function secputcard() {
	$(".content_box").show();
	$("#card_myModal").modal("hide");
	$(".content_box").html('<p class="">请第二入住人在机器下方放置二代居民身份证</p>'
			+ '<div id="idcard"> <img src="' + getRootPath()
			+ 'img/card.png" alt=""></div>'
			+ '<button class="remove" onclick=goIndex()>取消</button>');
	secputcard_time();//倒计时
}

//检测第二入住人身份证
function seccheckcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/checkcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
						secputcard_time_close();
						$(".content_box")
								.html('<p class="">请稍后，身份证正在读取中，成功提示前请勿拿走身份证</p>'
										+ '<div id="gifcard"><img src="'
										+ getRootPath()
										+ 'img/new_blues.gif" alt=""></div>');
						setTimeout("secreadcard()", 500);
					} else {

					}
				},
				error : function() {
				}
			});
}

//第二入住人读取身份证
function secreadcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/secreadcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
						photo();
					}
					if (res == "fail") {
						$(".content_box").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p")
								.html("第二入住人身份证读取失败，请重新读取");
						$(".again_btn").on('click', function() {
									secputcard();
								});
						secreadcardfail_time();
					}
					if (res == "same") {
						$(".content_box").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p").html("请勿重复使用同一身份证");
						$(".again_btn").on('click', function() {
									secputcard();
								});
						secreadcardfail_time();
					}
				},
				error : function() {
					readcardfail_time();
					$(".content_box").hide();
					$("#card_myModal").modal("show");
					$("#card_myModal .modal-body p").html("第二入住人身份证读取失败，请重新读取");
					$(".again_btn").on('click', function() {
								secputcard();
							});
				}
			});
}

//正在制作房卡
function roomcarding() {
	//login加载内容  制作房卡
	
	$(".face_box").hide();
	$(".content_box").show();
	$(".content_box").html('<p class="">正在制作房卡，请稍后...</p>'
			+ '<div id="gifcard"><img src="' + getRootPath()
			+ 'img/new_blues.gif" alt=""></div>');
	setTimeout(roomcard, 500);
}

function roomcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/roomcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res != null) {
						roomcardover(res);
					}
				},
				error : function() {
					//系统 未知故障  多个
					$(".content_box").show();
					$(".content_box")
							.html('<p class="">办理入住失败，请您到前台办理</p>'
									+ '<p class="">感谢您的理解与支持。</p>'
									+ '<button class="gb" onclick=goIndex()>关闭</button>');
					recycling();
					roomcard_time();//倒计时
				}
			});
}
//回收失败房卡
function recycling() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/recycling",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
					} else {

					}
				},
				error : function() {
				}
			});
}

//制作房卡完成
function roomcardover(checkin) {
	//login加载内容  制作房卡
	//入住办理完成页面
	$(".content_box").show();
	$(".content_box").html('<p class="">入住办理完成，请在机器下方取走您的房卡</p>'
			+ '<div class="room_card"> ' + '<p class="rc_top">滨江壹号大酒店</p> '
			+ '<p class="rc_center">房间号<i>' + checkin.roomNum + '</i> </p> '
			+ '<p class="rc_btm"> ' + '<span>入住：<i>' + formatDate(checkin.inTime)
			+ '</i></span> ' + '<span>退房：<i>' + formatDate(checkin.outTime)
			+ '</i></span> ' + '</p> ' + '</div> ' +

			'<div class="btns_btm"> '
			+ '<button class="" onclick="sendSMS()">发送到手机</button> '
			+ '<button class="" onclick=goIndex()>关闭</button> ' + '</div>');
	roomNum = checkin.roomNum;
	orderNum = checkin.orderNum;
	roomcard_time();//倒计时
}

//支付信息
$(".to_pays").hide();
//摄像头页面

$(".phones").hide();
$(".parm").hide();
$(".reta").hide();
$(".data").hide();
$(".datr").hide();
$(".rooms_content").hide();

$('input[type=radio][name=people]').change(function() {
			if (this.value == '1' || this.value == '2') {
				number = this.value;
				$(".getcard").attr("disabled", false);
			} else {
				$(".getcard").attr("disabled", true);
			}
		});

//显示发送短信界面
function sendSMS() {
	$(".rooms_content").hide();
	smsinfo_time();
	roomcard_time_close();
	$("#card_myModal").modal("hide");
	$(".content_box").hide();
	$(".phones").show();
	$(".rooms_content").hide();
}
//发送短信
function send() {
	var mobile = $("#mobile").val();
	if (phonenum.test(mobile)) {
		$.ajax({
					type : "post",
					url : getRootPath() + "checkin/sendSMS",
					dataType : "json",
					data : {
						"mobile" : mobile,
						"roomNum" : roomNum,
						"orderNum" :orderNum
					},
					async : false,
					success : function(res) {
						if (res == "ok") {
							sms_time();
							$(".content_box").hide();
							$("#card_myModal").modal("show");
							$("#card_myModal .modal-body p")
									.html("房间信息已发送到您的手机，请查收！");
							$("#card_myModal .modal-body .again").css(
									"background", "rgba(0,0,0,0)");
							$(".again_btn").on('click', function() {
										goIndex();
									});
						} else {
							mobilefail_time();
							$(".content_box").hide();
							$("#card_myModal").modal("show");
							$("#card_myModal .modal-body p")
									.html("房间信息发送失败，请重试！");
							$(".again_btn").on('click', function() {
										sendSMS();
									});
						}
					},
					error : function() {
					}
				});
	} else {
		mobilefail_time();
		$(".content_box").hide();
		$("#card_myModal").modal("show");
		$(".rooms_content").hide();
		$("#card_myModal .modal-body p").html("手机号填写错误，请检查");
		$(".again_btn").on('click', function() {
					sendSMS();
				});
	}
}

$(function() {
	//发送短信
	// $(".phones").show();
	var n = '';
	$(".add_del").on("click", function() {
				$(".to_send").val("");
				n = '';
			});
	$(".one_del").on("click", function() {
				var nLength = $(".to_send").val().length;
				$(".to_send").val(n.substr(0, nLength - 1));
				n = $(".to_send").val();
			});
	$(".num_bg").on("click", function() {
				n += $(this).text().toString();
				if (n.length > 11) {
					n.substring(0, 11);
				} else {
					$(".to_send").val(n);
				}
			});
	$(".face_box").hide();
	startVedio();//默认打开设备，避免拍照时打开等待时间
	})