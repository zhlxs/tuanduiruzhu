$("#into").show();
function putroomcard() {
	putroomcard_time();
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
					console.log('成功');
					if (res == "ok") {
						$("#into").hide();
						$("#loading").show();
						putroomcard_time_close();
						setTimeout(readcard, 1000);
					} else {

					}
				},
				error : function() {
				}
			});
}

// 读取房卡并确认是否退房
function readcard() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/getcheckinInfo",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					console.log('成功');
					if (res != null && res.outTime!=null) {
						$("#loading").hide();
						$("#cardinfo").show();
						$("#outTime").html(res.outTime + " 下午14:00");
						roomcard_time();
					} 
					if(res.outTime==null){
					
					$("#loading").hide();
						$("#recycleinfo").show();
						$("#outTime").html(res.outTime + " 下午14:00");
						roomcard_time();
					}
                    if(res==null) {
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
					console.log('成功');
					if (res == "ok") {

					} else {

					}
				},
				error : function() {
				}
			});
}

// 正在退房
function checkouting() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkout/checkouting",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					if (res == "ok") {
						console.log('成功');
						$("#cardinfo").hide();
						$("#recycleinfo").hide();
						$("#loading_out").show();
						roomcard_time_close();
						setTimeout(checkoutover, 1000);
					} else {
						outcard();
						$("#cardinfo").hide();
						$("#recycleinfo").hide();
						$("#sendcard").show();
						roomcard_time();
					}
				},
				error : function() {

				}
			});
}


//回收房卡
function recycling() {
	$.ajax({
				type : "post",
				url : getRootPath() + "checkin/recycling",
				dataType : "json",
				data : {

	}			,
				async : false,
				success : function(res) {
					console.log('成功');
					if (res == "ok") {
						console.log('成功');
						$("#cardinfo").hide();
						$("#recycleinfo").hide();
						$("#loading_out").show();
						roomcard_time_close();
						setTimeout(checkoutover, 1000);
					} else {
						outcard();
						$("#cardinfo").hide();
						$("#recycleinfo").hide();
						$("#sendcard").show();
						roomcard_time();
					}
				},
				error : function() {
				}
			});
}

// 退房完成
function checkoutover() {
	$("#loading_out").hide();
	$("#successtf").show();
	roomcard_time();
}

$(function() {

			// 身份认证失败 ，头像身份证不符 模态框
			// if ( ){
			// $("#nopp_myModal").modal("show");
			// $("#nopp_myModal .modal-body
			// .center_box").html('<p>身份证认证失败，您的头像与身份证不匹配</p><p>请重新认证</p>');
			// $(".content_box").hide();
			// }else {

			// }

			// 请勿重复使用同一身份证 模态框
			// if ( ){
			// $("#nopp_myModal").modal("show");
			// $("#nopp_myModal .modal-body
			// .center_box").html('<p>请勿重复使用同一身份证</p>');
			// $(".content_box").hide();
			// }else {

			// }

			// 身份证读取失败 ， 重新读取 模态框
			// if ( ){
			// $("#card_myModal").modal("show");
			// $("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
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