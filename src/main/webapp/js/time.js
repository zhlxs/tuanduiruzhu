 function startTime(){
            var today=new Date();
            var week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
            var year=today.getFullYear();
            var month=today.getMonth()+1;
            var date=today.getDate();
            var day=today.getDay();
            var h=today.getHours();
            var m=today.getMinutes();
            var s=today.getSeconds();
            // add a zero in front of numbers<10
            h=checkTime(h);
            m=checkTime(m);
            s=checkTime(s);
            $("#date_1").html(" "+year+"-"+month+"-"+date+"  ");
            $("#time_1").html(" "+h+":"+m+":"+s+" ");
            $("#week_1").html("  "+week[day]+"  ");
            t=setTimeout('startTime()',1000);
           }
           
           function checkTime(i){
           if (i<10)  
             {i="0" + i}
             return i
           }
           
           
          
          
           startTime();