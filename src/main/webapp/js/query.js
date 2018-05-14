function putroomcard() {
	putroomcard_time();
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

// 检测房卡
function checkroomcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkout/checkroomcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
						putroomcard_time_close();
						$("#into").hide();
						$("#loading").show();
						setTimeout("readcard()", 500);
					} else {

					}
				},
				error : function() {
				}
			});
}

// 读取房卡并查询入住单
function readcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/getcheckinInfo",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res != null) {
						putcard();
					} else {
						outcard();
						$("#loading").hide();
						$("#readfail").show();
						roomcard_time();

					}
				},
				error : function() {
					outcard();
					$("#loading").hide();
					$("#readfail").show();
					roomcard_time();
				}
			});
}

function outcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkout/outCard",
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

function putcard() {
	$("#card_myModal").modal("hide");
	$("#loading").hide();
	$("#idcard").show();
	putcard_time2();
}

// 检测身份证
function checkcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/checkcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
						$("#loading")
								.html('<p class="">请稍后，身份证正在读取中，成功提示前请勿拿走身份证</p>'
										+ '<div id="gifcard"><img src="'
										+ getRootPath()
										+ 'img/new_blues.gif" alt=""></div>');

						$("#idcard").hide();
						$("#loading").show();
						putcard_time_close2();
						setTimeout("readidcard()", 500);
					} else {

					}
				},
				error : function() {
				}
			});
}

// 读取身份证
function readidcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/queryreadcard",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
						$("#loading").hide();
						photo();
					}
					if (res == "fail") {// 身份证读取失败
						readcardfail_time();
						$("#loading").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
						$(".again_btn").on('click', function() {
									putcard();
								});
					}
					if (res == "other") {// 非入住人
						$("#loading").hide();
						$("#cardinfo").show();
						roomcard_time();
						recycling();
					}
				},
				error : function() {

				}
			});
}

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

function photo() {
	$("#card_myModal").modal("hide");
	$("#face_box").show();
	setTimeout(function(){
		
		openHtjc();
		getErrInfo();
		photo_time();//倒计时
	},500);
	//setTimeout("photo2()", 500);
}


function failphoto() {
	closeDevice();
	$("#face_box").hide();
	$(".again_btn").on('click', function() {
				closephoto();
			});
	$("#card_myModal").modal("show");
	$("#card_myModal .modal-body p").html("采样失败，请您脸部对准摄像头");
	photofaild_time();// 倒计时
}

function closephoto() {
	photo();
}

// 人证比对
function querycheckphoto(str) {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/querycheckphoto",
				dataType : "json",
				data : {
					"str" : str
				},
				async : false,
				success : function(res) {
					if (res == "ok") {
						
						$(".content_box")
								.html('<p class="">正在查询您的房间信息,请勿离开</p>'
										+ '<div id="gifcard"><img src="'
										+ getRootPath()
										+ 'img/new_blues.gif" alt=""></div>');
						setTimeout("queryover()", 500);
					} else {
						$(".content_box").hide();
						$("#card_myModal").modal("show");
						$("#card_myModal .modal-body p").html("人证比对失败，请重试");
						$(".again_btn").on('click', function() {
									closephoto();
								});
						photofaild_time();// 倒计时
					}
				},
				error : function(e) {

				}
			});
}

// 查询结束
function queryover() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/getcheckinInfo",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {

					if (res != null) {

					$("#sendcard").html('<p class="">查询完成，请在机器下方取走您的房卡</p>'
										+ '<div class="room_card"> '
										+ '<p class="rc_top">滨江壹号大酒店</p> '
										+ '<p class="rc_center">房间号<i>'
										+ res.roomNum
										+ '</i> </p> '
										+ '<p class="rc_btm"> '
										+ '<span>入住：<i>'
										+ formatDate(res.inTime)
										+ '</i></span> '
										+ '<span>退房：<i>'
										+ formatDate(res.outTime)
										+ '</i></span> '
										+ '</p> '
										+ '</div> '
										+

										'<div class="btns_btm"> '
										+ '<button class="" onclick=goIndex()>关闭</button> '
										+ '</div>');

						$.ajax({
									type : "post",
									url : getRootPath() + "checkout/outCard",
									dataType : "json",
									data : {

						}			,
									async : false,
									success : function(res) {
										
										if (res == "ok") {	
											$("#face_box").hide();
											$("#loading").hide();
											
											$("#sendcard").show();
											
											
											
											roomcard_time();// 倒计时
											
										}
									},
									error : function() {

									}
								});
					}
				},
				error : function() {

				}
			});

}

$(function() {
	putroomcard();
	startVedio();
	//LoadParam();// 加载摄像头配置
	//sopenDevice();// 默认打开设备，避免拍照时打开等待时间
		// 身份认证失败 ，头像身份证不符 模态框
		// if ( ){
		// $("#nopp_myModal").modal("show");
		// $("#nopp_myModal .modal-body
		// .center_box").html('<p>身份证认证失败，您的头像与身份证不匹配</p><p>请重新认证</p>');
		// $(".content_box").hide();
		// }else {

		// }

		// 采样失败 ， 脸部对准摄像头 模态框
		// if ( ){
		// $("#card_myModal").modal("show");
		// $("#card_myModal .modal-body p").html("采样失败，请您脸部对准摄像头");
		// $(".content_box").hide();
		// }else {

		// }

	});