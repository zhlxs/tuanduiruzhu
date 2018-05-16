var number;//入住人数
var current = 1;//当前人证比对序号 1或2
var qjphone = 0;//全局手机号
var qjroomnum = 0;//全局房间号
$(function () {
    //显示手机输入框
    $("#phones").show()

    var n = '';
    $(".add_del").on("click", function () {
        $(".to_send").val("");
        n = '';
    });
    $(".one_del").on("click", function () {
        var nLength = $(".to_send").val().length;
        //    console.log(nLength , n);
        $(".to_send").val(n.substr(0, nLength - 1));
        n = $(".to_send").val();
    });
    $(".num_bg").on("click", function () {
        n += $(this).text().toString();
        if (n.length > 11) {
            n.substring(0, 11);
        } else {
            $(".to_send").val(n);
        }
    });


    $(".sure_num").on("click", function () {
        qjphone = $(".to_send").val();
        $.ajax({
            type: "post",
            url: getRootPath() + "checkin/getGroupOrders",
            dataType: "json",
            data: {
                "phone": qjphone
            },
            async: false,
            success: function (result) {
                var html = "";
                if ("" != result && null != result) {
                    for (var i = 0; i < result.length; i++) {
                        html += "<div class='team_rooms' onclick='skipRoomDetail(" + "\"" + result[i].orderid + "\"" + ")'>";
                        html += "<p class='orde_num'>订单编号:#<span>" + result[i].orderid + "</span></p>"
                        html += "<div class='rooms_info clearfix'>";
                        html += "<div class='r_i_left fl'>";
                        html += "<h4>房间数量</h4>";
                        html += "<p class='btms'>" + result[i].roomcount + "</p>";
                        html += "</div>";
                        html += "<div class='r_i_center clearfix'>";
                        html += "<h4>入住天数</h4>";
                        html += "<div class='fl'>";
                        html += "<p>入住</p>";
                        html += "<p>" + result[i].starttime + "</p>";
                        html += "</div>";
                        html += "<div class='btms'>";
                        html += "<p>" + result[i].num + "</p>";
                        html += "</div>";
                        html += "<div class='fr'>";
                        html += "<p>离店</p>";
                        html += "<p>" + result[i].endtime + "</p>";
                        html += "</div>";
                        html += "</div>";
                        html += "<div class='r_i_right fr'>";
                        html += "<h4>入住人数</h4>";
                        html += "<p class='btms'>" + result[i].personcount + "</p>";
                        html += "</div>";
                        html += "</div>";
                        html += "</div>";
                    }
                    document.getElementById("orderDetail").innerHTML = html;
                    $("#phones").hide();
                    $("#orders").show();

                } else {
                    html += "<div class='team_rooms'>";
                    html += "<p class='orde_num'>订单编号:#<span>无</span></p>"
                    html += "<div class='rooms_info clearfix'>";
                    html += "<div class='r_i_left fl'>";
                    html += "<h4>房间数量</h4>";
                    html += "<p class='btms'>无</p>";
                    html += "</div>";
                    html += "<div class='r_i_center clearfix'>";
                    html += "<h4>入住天数</h4>";
                    html += "<div class='fl'>";
                    html += "<p>入住</p>";
                    html += "<p>无</p>";
                    html += "</div>";
                    html += "<div class='btms'>";
                    html += "<p>无</p>";
                    html += "</div>";
                    html += "<div class='fr'>";
                    html += "<p>离店</p>";
                    html += "<p>无</p>";
                    html += "</div>";
                    html += "</div>";
                    html += "<div class='r_i_right fr'>";
                    html += "<h4>入住人数</h4>";
                    html += "<p class='btms'>无</p>";
                    html += "</div>";
                    html += "</div>";
                    html += "</div>";

                    document.getElementById("orderDetail").innerHTML = html;
                    $("#phones").hide();
                    $("#orders").show();
                }
            },
            error: function () {
                var html = "";
                html += "<div class='team_rooms'>";
                html += "<p class='orde_num'>订单编号:#<span>无</span></p>"
                html += "<div class='rooms_info clearfix'>";
                html += "<div class='r_i_left fl'>";
                html += "<h4>房间数量</h4>";
                html += "<p class='btms'>无</p>";
                html += "</div>";
                html += "<div class='r_i_center clearfix'>";
                html += "<h4>入住天数</h4>";
                html += "<div class='fl'>";
                html += "<p>入住</p>";
                html += "<p>无</p>";
                html += "</div>";
                html += "<div class='btms'>";
                html += "<p>无</p>";
                html += "</div>";
                html += "<div class='fr'>";
                html += "<p>离店</p>";
                html += "<p>无</p>";
                html += "</div>";
                html += "</div>";
                html += "<div class='r_i_right fr'>";
                html += "<h4>入住人数</h4>";
                html += "<p class='btms'>无</p>";
                html += "</div>";
                html += "</div>";
                html += "</div>";

                document.getElementById("orderDetail").innerHTML = html;
                $("#phones").hide();
                $("#orders").show();
            }
        })
    });
});


function skipRoomDetail(orderid) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getGroupRoom",
        dataType: "json",
        data: {
            "orderid": orderid,
        },
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else {//以入住2人不可再点
                        html += "<div class='single before_lr'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>房间号:" + result[i].roomNumber + "</p>";
                        html += "</div>";
                    }
                }
                document.getElementById("showAllRoomType").innerHTML = html;
                $("#orders").hide();
                $("#allRoom").show();
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}

//提示放身份证
function putcard(roomname) {
    qjroomnum = roomname;
    number = 1;
    $("#allRoom").hide();
    $("#idcard").show();
    $("#idcard").html('<p class="title">请在机器下方放置二代身份证</p>'
        + '<div>'
        + '<img src="' + getRootPath() + 'img/card.png" alt="">'
        + '</div>'
        + '<button class="remove" onclick="fanhuiroomDetail()">返回</button>');
    putcard_time3();//倒计时-->调用checkcard

}


//检测身份证
function checkcard() {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/checkcardRorGroup",
        dataType: "json",
        data: {},
        async: false,
        success: function (res) {
            console.log('成功');
            if (res == "ok") {
                putcard_time_close();
                $("#idcard").html('<p class="">请稍后，身份证正在读取中，成功提示前请勿拿走身份证</p>'
                    + '<div id="gifcard"><img src="'
                    + getRootPath()
                    + 'img/new_blues.gif" alt=""></div>');
                setTimeout("readcard()", 500);
            } else {

            }
        },
        error: function () {
        }
    });
}

//读取身份证
function readcard() {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/readCardRorGroup",
        dataType: "json",
        data: {
            "roomnum": qjroomnum
        },
        async: false,
        success: function (res) {
            console.log('成功');
            if (res == "ok") {
                //采集照片
                photo();

            } else if(res == "fail"){
                $("#idcard").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
                /*$(".again_btn").on('click', function () {
                    putcard();
                });*/
                readcardfail_time2();
            }else{
                $("#idcard").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("身份证重复录入");
                /*$(".again_btn").on('click', function () {
                    putcard();
                });*/
                readcardfail_time2();
            }
        },
        error: function () {
            readcardfail_time();
            $("#idcard").hide();
            $("#card_myModal").modal("show");
            $("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
            $(".again_btn").on('click', function () {
                putcard();
            });
        }
    });
}

//新摄像头采集照片
function photo() {
    $(".face_box").show();
    // $(".rooms_content").hide();
    $("#idcard").hide();
    $("#card_myModal").modal("hide");
    $("#nopp_myModal").modal("hide");
    setTimeout(function () {
        openHtjc();
        getErrInfo();
        photo_time();//倒计时
    }, 500);
}

function failphoto() {
    $(".face_box").hide();
    closeDevice();

    $(".again_btn").on('click', function () {
        closephoto();
    });
    $("#card_myModal").modal("show");
    $("#card_myModal .modal-body p").html("采样失败，请您脸部对准摄像头");
    photofaild_time();//倒计时
}

function closephoto() {
    alert(123)
    // $(".to_pays").hide();
    // $(".content_box").hide();
    // $(".face_box").hide();
    // $("#card_myModal").modal("hide");
    // $(".rooms_content").show();
    // order_time();//订单倒计时
}

function closephoto2() {
    //alert(321)
    // closeDevice();
    // $(".to_pays").hide();
    // $(".content_box").hide();
    // $(".face_box").hide();
    // $("#card_myModal").modal("hide");
    // $(".rooms_content").show();
    // order_time();//订单倒计时
    stopVedio();
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getGroupRoom",
        dataType: "json",
        data: {},
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else {//以入住2人不可再点
                        html += "<div class='single before_lr'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>房间号:" + result[i].roomNumber + "</p>";
                        html += "</div>";
                    }
                }
                document.getElementById("showAllRoomType").innerHTML = html;
                $("#card_myModal").modal("hide");
                $(".face_box").hide();
                $("#allRoom").show();
                startVedio();//默认打开设备，避免拍照时打开等待时间
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}

//入住人人证比对
function firstcheckphoto(str) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/checkphotoForGroup",
        dataType: "json",
        data: {
            "str": str
        },
        async: false,
        success: function (res) {
            console.log('成功');
            if (res == "ok") {
                $(".face_box").hide();
                $.ajax({
                    type: "post",
                    url: getRootPath() + "checkin/groupCheckIn",
                    dataType: "json",
                    data: {},
                    async: false,
                    success : function(result){
                        var html = "";
                        if ("" != result && null != result) {
                            alert("入住成功,继续选房入住")
                            for (var i = 0; i < result.length; i++) {
                                if (result[i].count == "0") {
                                    html += "<div class='single before_lr' onclick='putcard(" + result[i].roomname + ")'>";
                                    html += "<h4>" + result[i].roomtype + "</h4>";
                                    html += "<p>房间号:" + result[i].roomname + "</p>";
                                    html += "<p>入住人数:" + result[i].count + "/2</p>";
                                    html += "</div>";
                                } else if (result[i].count == "1") {//已录入模块
                                    html += "<div class='single after_lr' onclick='putcard(" + result[i].roomname + ")'>";
                                    html += "<h4>" + result[i].roomtype + "</h4>";
                                    html += "<p>房间号:" + result[i].roomname + "</p>";
                                    html += "<p>入住人数:" + result[i].count + "/2</p>";
                                    html += "</div>";
                                } else {//以入住2人不可再点
                                    html += "<div class='single before_lr'>";
                                    html += "<h4>" + result[i].roomtype + "</h4>";
                                    html += "<p>房间号:" + result[i].roomname + "</p>";
                                    html += "<p>入住人数:" + result[i].count + "/2</p>";
                                    html += "</div>";
                                }
                            }
                            document.getElementById("showAllRoomType").innerHTML = html;
                            $(".face_box").hide();
                            $("#allRoom").show();
                        }
                    },
                    error : function(){

                    }
                })
            } else {
                $(".face_box").hide();
                $("#idcard").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("人证比对失败，请重试");
                $(".again_btn").on('click', function () {
                    closephoto2();
                });
                photofaild_time();//倒计时
            }
        },
        error: function () {
            alert("比对失败");
            closephoto2();
        }
    });

}

$(function () {
    $(".face_box").hide();
    startVedio();//默认打开设备，避免拍照时打开等待时间
})


function fanhuishoujihao() {
    $("#phones").show();
    $("#orders").hide();
}

function fanhuiorders() {

    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getGroupOrders",
        dataType: "json",
        data: {
            "phone": qjphone
        },
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                for (var i = 0; i < result.length; i++) {
                    html += "<div class='team_rooms' onclick='skipRoomDetail(" + "\"" + result[i].orderid + "\"" + ")'>";
                    html += "<p class='orde_num'>订单编号:#<span>" + result[i].orderid + "</span></p>"
                    html += "<div class='rooms_info clearfix'>";
                    html += "<div class='r_i_left fl'>";
                    html += "<h4>房间数量</h4>";
                    html += "<p class='btms'>" + result[i].roomcount + "</p>";
                    html += "</div>";
                    html += "<div class='r_i_center clearfix'>";
                    html += "<h4>入住天数</h4>";
                    html += "<div class='fl'>";
                    html += "<p>入住</p>";
                    html += "<p>" + result[i].starttime + "</p>";
                    html += "</div>";
                    html += "<div class='btms'>";
                    html += "<p>" + result[i].num + "</p>";
                    html += "</div>";
                    html += "<div class='fr'>";
                    html += "<p>离店</p>";
                    html += "<p>" + result[i].endtime + "</p>";
                    html += "</div>";
                    html += "</div>";
                    html += "<div class='r_i_right fr'>";
                    html += "<h4>入住人数</h4>";
                    html += "<p class='btms'>" + result[i].personcount + "</p>";
                    html += "</div>";
                    html += "</div>";
                    html += "</div>";
                }
                document.getElementById("orderDetail").innerHTML = html;
                $("#allRoom").hide();
                $("#orders").show();

            } else {
                html += "<div class='team_rooms'>";
                html += "<p class='orde_num'>订单编号:#<span>无</span></p>"
                html += "<div class='rooms_info clearfix'>";
                html += "<div class='r_i_left fl'>";
                html += "<h4>房间数量</h4>";
                html += "<p class='btms'>无</p>";
                html += "</div>";
                html += "<div class='r_i_center clearfix'>";
                html += "<h4>入住天数</h4>";
                html += "<div class='fl'>";
                html += "<p>入住</p>";
                html += "<p>无</p>";
                html += "</div>";
                html += "<div class='btms'>";
                html += "<p>无</p>";
                html += "</div>";
                html += "<div class='fr'>";
                html += "<p>离店</p>";
                html += "<p>无</p>";
                html += "</div>";
                html += "</div>";
                html += "<div class='r_i_right fr'>";
                html += "<h4>入住人数</h4>";
                html += "<p class='btms'>无</p>";
                html += "</div>";
                html += "</div>";
                html += "</div>";

                document.getElementById("orderDetail").innerHTML = html;
                $("#allRoom").hide();
                $("#orders").show();
            }
        },
        error: function () {
            var html = "";
            html += "<div class='team_rooms'>";
            html += "<p class='orde_num'>订单编号:#<span>无</span></p>"
            html += "<div class='rooms_info clearfix'>";
            html += "<div class='r_i_left fl'>";
            html += "<h4>房间数量</h4>";
            html += "<p class='btms'>无</p>";
            html += "</div>";
            html += "<div class='r_i_center clearfix'>";
            html += "<h4>入住天数</h4>";
            html += "<div class='fl'>";
            html += "<p>入住</p>";
            html += "<p>无</p>";
            html += "</div>";
            html += "<div class='btms'>";
            html += "<p>无</p>";
            html += "</div>";
            html += "<div class='fr'>";
            html += "<p>离店</p>";
            html += "<p>无</p>";
            html += "</div>";
            html += "</div>";
            html += "<div class='r_i_right fr'>";
            html += "<h4>入住人数</h4>";
            html += "<p class='btms'>无</p>";
            html += "</div>";
            html += "</div>";
            html += "</div>";

            document.getElementById("orderDetail").innerHTML = html;
            $("#allRoom").hide();
            $("#orders").show();
        }
    })
}

function fanhuiroomDetail() {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getGroupRoom",
        dataType: "json",
        data: {},
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else {//以入住2人不可再点
                        html += "<div class='single before_lr'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>房间号:" + result[i].roomNumber + "</p>";
                        html += "</div>";
                    }
                }
                document.getElementById("showAllRoomType").innerHTML = html;
                $("#idcard").hide();
                $("#allRoom").show();
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}

function goIndex3(){
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getGroupRoom",
        dataType: "json",
        data: {},
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else {//以入住2人不可再点
                        html += "<div class='single before_lr'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>房间号:" + result[i].roomNumber + "</p>";
                        html += "</div>";
                    }
                }
                document.getElementById("showAllRoomType").innerHTML = html;
                $("#idcard").hide();
                $("#allRoom").show();
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}

$("#sfrzgb").on("click",function(){
    fhRoomDetail();
})

function fhRoomDetail(){
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getGroupRoom",
        dataType: "json",
        data: {},
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='putcard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "<p>入住人数:" + result[i].count + "/2</p>";
                        html += "</div>";
                    } else {//以入住2人不可再点
                        html += "<div class='single before_lr'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>房间号:" + result[i].roomNumber + "</p>";
                        html += "</div>";
                    }
                }
                document.getElementById("showAllRoomType").innerHTML = html;
                $("#card_myModal").modal("hide");
                // $("#idcard").hide();
                $("#allRoom").show();
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}