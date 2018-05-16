//开始活体监测
function openHtjc(){
    var htjcObj = document.getElementById("CommonLiveDetectionOCX");
    htjcObj.StartLiveDetection();
}
function startVedio(){
    var htjcObj = document.getElementById("CommonLiveDetectionOCX");
    htjcObj.StartVedio();
}

function stopVedio(){

    var htjcObj = document.getElementById("CommonLiveDetectionOCX");
    htjcObj.StopVedio();
}
function getErrInfo(){
    var htjcObj = document.getElementById("CommonLiveDetectionOCX");
}
function checkHtjc(ULONG){
    if(ULONG<0){
        alert("检测未通过,请重试");
        photo();
        var imageTbody= document.getElementById("imageTbody");
        var imageTable= document.getElementById("imageTable");
        imageTable.removeChild(imageTbody);
        imageTbody = document.createElement("tbody");
        imageTbody.setAttribute("id","imageTbody");
        imageTable.appendChild(imageTbody);
    }else if(ULONG==0){
        alert("打开摄像头失败");
        var imageTbody= document.getElementById("imageTbody");
        var imageTable= document.getElementById("imageTable");
        imageTable.removeChild(imageTbody);
        imageTbody = document.createElement("tbody");
        imageTbody.setAttribute("id","imageTbody");
        imageTable.appendChild(imageTbody);
    }
    else{
        //alert("检测通过");
        var imageTbody= document.getElementById("imageTbody");
        var imageTable= document.getElementById("imageTable");

        imageTable.removeChild(imageTbody);
        imageTbody = document.createElement("tbody");
        imageTbody.setAttribute("id","imageTbody");
        var ua = navigator.userAgent;
        var s = "MSIE";
        var i = ua.indexOf(s)
        var ieValue = parseFloat(ua.substr(i + s.length));
        for(var t=0;t<1;t++){
            //获取控件对象
            var htjcObj = document.getElementById("CommonLiveDetectionOCX");
            var row=document.createElement("tr");
            var row2=document.createElement("tr");
            var srcHeader = "data:image/gif;base64,";
            var imageNormal = document.createElement("img");
            //创建正常照片td
            var srcNormal = htjcObj.GetQualifiedImageByIndex(t);
            var divNormal=document.createElement("div");
            divNormal.innerHTML = srcNormal;
            divNormal.setAttribute("ondblclick","copyInner(this.innerHTML)");
            divNormal.setAttribute("style","border-bottom: 1px; border-left: 1px; border-top: 1px; border-right: 1px;");

            var tdNormal =document.createElement("td");
            tdNormal.innerHTML= "正常图像"+(t+1)+":";
            tdNormal.appendChild(divNormal);
            row.appendChild(tdNormal);
            console.log("1111"+srcNormal);
            document.getElementById("img").src = "data:image/png;base64," + srcNormal;
            if(current == 1){
                firstcheckphoto(srcNormal);
            }else{
                seccheckphoto(srcNormal);
            }



            //创建缩略图
            var srcShrink = htjcObj.GetShrinkQualifiedImageByIndex(t);
            var divShrink=document.createElement("div");
            divShrink.innerHTML = srcShrink;
            divShrink.setAttribute("ondblclick","copyInner(this.innerHTML)");
            divShrink.setAttribute("style","border-bottom: 1px; border-left: 1px; border-top: 1px; border-right: 1px;");

            var tdShrink =document.createElement("td");
            tdShrink.innerHTML= "缩略图像"+(t+1)+":";
            tdShrink.appendChild(divShrink);
            row2.appendChild(tdShrink);
            console.log("2222"+srcShrink);
            document.getElementById("img2").src = "data:image/png;base64," + srcShrink;
            //将row放到tbody中
            //imageTbody.appendChild(row);
            //imageTbody.appendChild(row2);
        }
        imageTable.appendChild(imageTbody);
        $(".face_box").hide();
    }
}

function copyInner(info){
    window.clipboardData.setData("Text",info);
    alert("复制成功！");
}


function toDoThisWork(thisId){
    document.getElementById(thisId).value = document.getElementById(thisId).value;
}