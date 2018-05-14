var ruzhurenshu = 0;
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
                        html += "<div class='team_rooms' onclick='skipRoomDetail(" + "\"" + result[i].orderNum + "\"" + "," + "\"" + result[i].roomCode + "\"" + "," + "\"" + result[i].inTime + "\"" + "," + "\"" + result[i].outTime + "\"" + ")'>";
                        html += "<p class='orde_num'>订单编号:#<span>" + result[i].orderNum + "</span></p>"
                        html += "<div class='rooms_info clearfix'>";
                        html += "<div class='r_i_left fl'>";
                        html += "<h4>房间数量</h4>";
                        html += "<p class='btms'>" + result[i].rooms + "</p>";
                        html += "</div>";
                        html += "<div class='r_i_center clearfix'>";
                        html += "<h4>入住天数</h4>";
                        html += "<div class='fl'>";
                        html += "<p>入住</p>";
                        html += "<p>" + result[i].inTime + "</p>";
                        html += "</div>";
                        html += "<div class='btms'>";
                        html += "<p>" + result[i].days + "</p>";
                        html += "</div>";
                        html += "<div class='fr'>";
                        html += "<p>离店</p>";
                        html += "<p>" + result[i].outTime + "</p>";
                        html += "</div>";
                        html += "</div>";
                        html += "<div class='r_i_right fr'>";
                        html += "<h4>入住人数</h4>";
                        html += "<p class='btms'>" + result[i].adults + "</p>";
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

function skipRoomDetail(orderNo, roomCode, inTime, outTime) {
    $.ajax({
        type: "post",
        url: getRootPath() + "checkin/getAvailableRoom",
        dataType: "json",
        data: {
            "orderNo": orderNo,
            "roomCode": roomCode,
            "inTime": inTime,
            "outTime": outTime
        },
        async: false,
        success: function (result) {
            var html = "";
            if ("" != result && null != result) {
                var countTotal = result.length;//记录长度
                var count = 0;
                for (var i = 0; i < result.length; i++) {
                    if ('R' == result[i].roomState) {
                        html += "<div class='single before_lr' onclick='skipIdCard(" + result[i].roomNumber + ")'>";
                        html += "<h4>" + result[i].roomDescription + "</h4>";
                        html += "<p>" + result[i].roomNumber + "房</p>";
                        html += "</div>";
                    } else {
                        count++;
                    }
                }
                if (count == countTotal) {
                    alert("当前没有可用房间信息")
                } else {
                    document.getElementById("showAllRoomType").innerHTML = html;
                    $("#orders").hide();
                    $("#allRoom").show();
                }
            } else {
                alert("当前没有可用房间信息")
            }
        }
    })
}

function skipIdCard(roomNumber) {
    $("#allRoom").hide();
    $("#chooseNum").show();
    $("#showChooseNum").html('<div class="p_nums" onclick="commit(1)">'
        // +'<input type="hidden" value="1" id="chooseOne"/>'
        + '1人'
        + '</div>'
        + '<div class="p_nums" onclick="commit(2)">'
        // +'<input type="hidden" value="2" id="chooseTwo"/>'
        + '2人'
        + '</div>');
}


function commit(count) {
    // count 是入住人数
    ruzhurenshu = count;
        $("#chooseNum").hide();
        $("#idcard").show();
        $("#idcard").html('<p class="title">请在机器下方放置二代身份证</p>'
            + '<div>'
            + '<img src="' + getRootPath() + 'img/card.png" alt="">'
            + '</div>'
            + '<button class="remove">关闭</button>');
        putcard_time();//倒计时-->调用checkcard

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
        data: {},
        async: false,
        success: function (res) {
            console.log('成功');
            if (res == "ok") {
                //采集照片
                photo();

            } else {
                $("#idcard").hide();
                $("#card_myModal").modal("show");
                $("#card_myModal .modal-body p").html("身份证读取失败，请重新读取");
                $(".again_btn").on('click', function () {
                    commit();
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
                commit();
            });
        }
    });
}

function putcard() {
    $("#idcard").show();
    $("#card_myModal").modal("hide");
    $(".content_box").html('<p class="">请在机器下方放置二代居民身份证</p>'
        + '<div id="idcard"> <img src="' + getRootPath()
        + 'img/card.png" alt=""></div>'
        + '<button class="remove" onclick=goIndex()>取消</button>');
    putcard_time();//倒计时
}


/*function photo(){
    $("#face_box").show();
    // $(".rooms_content").hide();
    $(".content_box").hide();
    $("#card_myModal").modal("hide");
    $("#nopp_myModal").modal("hide");
    setTimeout(function(){
        startVedio();
        openHtjc();
        getErrInfo();
        photo_time();//倒计时
    },500);
}*/

function photo() {
    $("#face_box").show();
    // $(".rooms_content").hide();
    $("#idcard").hide();
    $("#card_myModal").modal("hide");
    $("#nopp_myModal").modal("hide");

    setTimeout(photo2, 500);

}

function photo2() {
    getFaceB64A();//开启自动拍照
    photo_time();//倒计时
}



//入住人人证比对
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
                //if (number == 1) {
                    // roomcarding();//制作房卡
                //}
                // if (number == 2) {//第二入住人
                //     current = 2;
                //     commit2();
                // }
                if(ruzhurenshu>1){
                    putcard_time_close()
                    ruzhurenshu++;
                    $("#chooseNum").hide();
                    $("#idcard").show();
                    $("#idcard").html('<p class="title">请在机器下方放置二代身份证</p>'
                        + '<div>'
                        + '<img src="' + getRootPath() + 'img/card.png" alt="">'
                        + '</div>'
                        + '<button class="remove">关闭</button>');
                    putcard_time();//倒计时-->调用checkcard
                }
            } else {
                alert("失败")
                if(ruzhurenshu>1){
                    $("#chooseNum").hide();
                    $("#idcard").show();
                    $("#idcard").html('<p class="title">请在机器下方放置二代身份证</p>'
                        + '<div>'
                        + '<img src="' + getRootPath() + 'img/card.png" alt="">'
                        + '</div>'
                        + '<button class="remove">关闭</button>');
                    putcard_time();//倒计时-->调用checkcard
                }
                 // $(".content_box").hide();
                //  $("#card_myModal").modal("show");
                //  $("#card_myModal .modal-body p").html("人证比对失败，请重试");
                //  $(".again_btn").on('click', function() {
                //     closephoto();
                // });
                 photofaild_time();//倒计时
            }
        },
        error : function() {

        }
    });
}

$(function(){
    LoadParam();//加载摄像头配置
    openDevice();//默认打开设备，避免拍照时打开等待时间
})