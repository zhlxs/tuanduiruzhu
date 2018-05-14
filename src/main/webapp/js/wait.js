$(function(){
    // $(".center").height($(".center").width());
    $("body").on("click",function(){
        window.location.href=getRootPath()+"menu/index";
    });
    $('.carousel').carousel({ interval: 15000, pause: 'none'});
})
