var number;//入住人数
var current = 1;//当前人证比对序号 1或2
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
        $.ajax({
            type: "post",
            url: getRootPath() + "checkin/getGroupOrders",
            dataType: "json",
            data: {
                "phone": $(".to_send").val()
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
                    alert("未检测到相关订单,请重新查询")
                }
            }
        })
    });


});

function skipRoomDetail(orderid) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/testSession",
        dataType: "json",
        data: {
            "orderid": orderid,
        },
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                // var countTotal = result.length;//记录长度
                // var count = 0;
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='skipIdCard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='skipIdCard2(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
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

function skipRoomDetail2(orderid) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/testSession",
        dataType: "json",
        data: {
            "orderid": orderid,
        },
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                // var countTotal = result.length;//记录长度
                // var count = 0;
                for (var i = 0; i < result.length; i++) {
                    if (result[i].count == "0") {
                        html += "<div class='single before_lr' onclick='skipIdCard(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "</div>";
                    } else if (result[i].count == "1") {//已录入模块
                        html += "<div class='single after_lr' onclick='skipIdCard2(" + result[i].roomname + ")'>";
                        html += "<h4>" + result[i].roomtype + "</h4>";
                        html += "<p>房间号:" + result[i].roomname + "</p>";
                        html += "</div>";
                    } else {//以入住2人不可再点
                        html += "<div class='single before_lr'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>房间号:" + result[i].roomNumber + "</p>";
                        html += "</div>";
                    }
                }
                document.getElementById("showAllRoomType").innerHTML = html;
                $("#chooseNum").hide();
                $("#allRoom").show();
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}

function skipIdCard(roomname) {
    $("#allRoom").hide();
    $("#chooseNum").show();
    $("#showChooseNum").html('<div class="p_nums" onclick="putcard(1,' + roomname + ')">'
        + '1人'
        + '</div>'
        + '<div class="p_nums" onclick="putcard(2,' + roomname + ')">'
        + '2人'
        + '</div>');
}

function skipIdCard2(roomname) {
    $("#allRoom").hide();
    $("#chooseNum").show();
    $("#showChooseNum").html('<div class="p_nums" onclick="putcard(1,' + roomname + ')">'
        + '1人'
        + '</div>');
}

//提示放身份证
function putcard(num, roomname) {
    number = num;
    $("#chooseNum").hide();
    $("#idcard").show();
    $("#idcard").html('<p class="title">请在机器下方放置二代身份证</p>'
        + '<div>'
        + '<img src="' + getRootPath() + 'img/card.png" alt="">'
        + '</div>'
        + '<button class="remove" onclick=goIndex()>取消</button>');
    putcard_time(roomname);//倒计时-->调用checkcard

}


//检测身份证
function checkcard(roomname) {
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
                setTimeout("readcard(roomname)", 500);
            } else {

            }
        },
        error: function () {
        }
    });
}

//读取身份证
function readcard(roomname) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/readCardRorGroup",
        dataType: "json",
        data: {},
        async: false,
        success: function (res) {
            console.log('成功');
            if (res == "ok") {
                //采集照片
                photo(roomname);

            } else {
                $("#idcard").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
                $(".again_btn").on('click', function () {
                    putcard();
                });
                readcardfail_time();
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

// function photo() {
//     $("#face_box").show();
//     // $(".rooms_content").hide();
//     $("#idcard").hide();
//     $("#card_myModal").modal("hide");
//     $("#nopp_myModal").modal("hide");
//
//     setTimeout(photo2, 500);
//
// }
//
// function photo2() {
//     getFaceB64A();//开启自动拍照
//     photo_time();//倒计时
// }

//新摄像头采集照片
function photo() {
    $(".face_box").show();
    $(".rooms_content").hide();
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
    alert(321)
    // closeDevice();
    // $(".to_pays").hide();
    // $(".content_box").hide();
    // $(".face_box").hide();
    // $("#card_myModal").modal("hide");
    // $(".rooms_content").show();
    // order_time();//订单倒计时
}

//第一入住人人证比对
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
                if (number == 1) {
                    // roomcarding();
                    alert("入住成功")
                }
                if (number == 2) {
                    alert("number==2")
                    current = 2;
                    secputcard();
                }
            } else {
                $(".face_box").hide();
                $("#idcard").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("人证比对失败，请重试");
                $(".again_btn").on('click', function () {
                    closephoto();
                });
                photofaild_time();//倒计时
            }
        },
        error: function () {
            alert("error");
        }
    });

}

//第二入住人人证比对
function seccheckphoto(str) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/seccheckphotoForGroup",
        dataType: "json",
        data: {
            "str": str
        },
        async: false,
        success: function (res) {
            if (res == "ok") {
                // roomcarding();
                alert("第二入住人成功")
            } else {
                $(".face_box").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p")
                    .html("第二入住人人证比对失败，请重试");
                $(".again_btn").on('click', function () {

                    closephoto();
                });
                photofaild_time();//倒计时
            }
        },
        error: function () {

        }
    });
}

//提示第二入住人放身份证
function secputcard() {
    /*$("#idcard").show();
    // $(".content_box").show();
    $("#card_myModal").modal("hide");
    $(".content_box").html('<p class="">请第二入住人在机器下方放置二代居民身份证</p>'
        + '<div> <img src="' + getRootPath()
        + 'img/card.png" alt=""></div>'
        + '<button class="remove" onclick=goIndex()>取消</button>');
    secputcard_time();//倒计时*/
alert("提示放入第二身份证")
    $("#idcard").show();
    $("#card_myModal").modal("hide");
    $("#idcard").html('<p class="title">请第二入住人在机器下方放置二代居民身份证</p>'
        + '<div>'
        + '<img src="' + getRootPath() + 'img/card.png" alt="">'
        + '</div>'
        + '<button class="remove" onclick=goIndex()>取消</button>');
    secputcard_time();//倒计时-->调用seccheckcard
}

//检测第二入住人身份证
function seccheckcard() {
    alert("检测第二身份证")
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/checkcardRorGroup",
        dataType: "json",
        data: {},
        async: false,
        success: function (res) {
            if (res == "ok") {
                secputcard_time_close();
                $("#idcard")
                    .html('<p class="">请稍后，身份证正在读取中，成功提示前请勿拿走身份证</p>'
                        + '<div id="gifcard"><img src="'
                        + getRootPath()
                        + 'img/new_blues.gif" alt=""></div>');
                setTimeout("secreadcard()", 500);
            } else {

            }
        },
        error: function () {
        }
    });
}

//第二入住人读取身份证
function secreadcard() {
    alert("读取第二身份证")
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/secreadcardRorGroup",
        dataType: "json",
        data: {},
        async: false,
        success: function (res) {
            if (res == "ok") {
                photo();
            }
            if (res == "fail") {
                $(".content_box").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p")
                    .html("第二入住人身份证读取失败，请重新读取");
                $(".again_btn").on('click', function () {
                    secputcard();
                });
                secreadcardfail_time();
            }
            if (res == "same") {
                $(".content_box").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("请勿重复使用同一身份证");
                $(".again_btn").on('click', function () {
                    secputcard();
                });
                secreadcardfail_time();
            }
        },
        error: function () {
            readcardfail_time();
            $(".content_box").hide();
            $("#card_myModal").modal("show");
            $("#card_myModal .modal-body p").html("第二入住人身份证读取失败，请重新读取");
            $(".again_btn").on('click', function () {
                secputcard();
            });
        }
    });
}

// $(".remove").on("click",function(){
//     window.location.href=getRootPath()+"menu/index";
// })
$(function () {
    $(".face_box").hide();
    startVedio();//默认打开设备，避免拍照时打开等待时间
})