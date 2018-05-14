var time; // 设置一个全局变量
var n = 30 * 1000; // 时间设置(10秒)
time = setTimeout(function () {
    window.location.href = getRootPath();
}, n);
window.top.document.onmousemove = function () {
    clearTimeout(time);
    time = setTimeout(function () {
        window.location.href = getRootPath();
    }, n);
}
window.top.document.onkeydown = function () {
    clearTimeout(time);
    time = setTimeout(function () {
        window.location.href = getRootPath();
    }, n);
}

$(function () {
    $("#cx").on("click", function () {
        window.location.href = getRootPath() + "menu/query";
    });
    $("#tfk").on("click", function () {
        window.location.href = getRootPath() + "menu/checkout";
    });
    $("#tdrz").on("click", function () {
        window.location.href = getRootPath() + "menu/team";
    });
})