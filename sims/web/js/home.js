$(function(){
    var $add = $("#addSdudent > span"),
        $alter = $("#updateInfo > span"),
        $del = $("#deleteInfo > span"),
        msg = $("#msg").text();

    // 添加学生信息表单的显示/隐藏事件
    $add.on("click",function(){
        $("#addSdudent").hide();
    });
    $("#add").on("click",function(){
        $("#addSdudent").show();
    });
    // 修改学生信息表单的显示/隐藏事件
    $alter.on("click",function(){
        $("#updateInfo").hide();
    });
    $("#update").on("click",function(){
        $("#updateInfo").show();
    });
    // 删除学生信息表单的显示/隐藏事件
    $del.on("click",function(){
        $("#deleteInfo").hide();
    });
    $("#delete").on("click",function(){
        $("#deleteInfo").show();
    });

    //添加学生信息表单的拖拽事件
    $("#drag1").mousedown(function(event){
        var event=event||window.event;
        var pageX=event.pageX||event.clientX+document.documentElement.scrollLeft;
        var pageY=event.pageY||event.clientY+document.documentElement.scrollTop;
        var spaceX=pageX-parseInt($("#addSdudent").offset().left);
        var spaceY=pageY-parseInt($("#addSdudent").offset().top);
        $(document).mousemove(function(event){
            var event=event||window.event;
            var pageX=event.pageX||event.clientX+document.documentElement.scrollLeft;
            var pageY=event.pageY||event.clientY+document.documentElement.scrollTop;
            var l=parseInt(pageX-spaceX);
            var t=parseInt(pageY-spaceY);
            $("#addSdudent").offset({left:l,top:t});
            if(window.getSelection){
                window.getSelection().removeAllRanges();
            }else{
                document.selection.empty();
            }
        });
    });
    $(document).mouseup(function(){
        $(document).unbind("mousemove");
    });
    //修改学生信息表单的拖拽事件
    $("#drag2").mousedown(function(event){
        var event=event||window.event;
        var pageX=event.pageX||event.clientX+document.documentElement.scrollLeft;
        var pageY=event.pageY||event.clientY+document.documentElement.scrollTop;
        var spaceX=pageX-parseInt($("#updateInfo").offset().left);
        var spaceY=pageY-parseInt($("#updateInfo").offset().top);
        $(document).mousemove(function(event){
            var event=event||window.event;
            var pageX=event.pageX||event.clientX+document.documentElement.scrollLeft;
            var pageY=event.pageY||event.clientY+document.documentElement.scrollTop;
            var l=parseInt(pageX-spaceX);
            var t=parseInt(pageY-spaceY);
            $("#updateInfo").offset({left:l,top:t});
            if(window.getSelection){
                window.getSelection().removeAllRanges();
            }else{
                document.selection.empty();
            }
        });
    });
    $(document).mouseup(function(){
        $(document).unbind("mousemove");
    });
    //删除学生信息表单的拖拽事件
    $("#drag3").mousedown(function(event){
        var event=event||window.event;
        var pageX=event.pageX||event.clientX+document.documentElement.scrollLeft;
        var pageY=event.pageY||event.clientY+document.documentElement.scrollTop;
        var spaceX=pageX-parseInt($("#deleteInfo").offset().left);
        var spaceY=pageY-parseInt($("#deleteInfo").offset().top);
        $(document).mousemove(function(event){
            var event=event||window.event;
            var pageX=event.pageX||event.clientX+document.documentElement.scrollLeft;
            var pageY=event.pageY||event.clientY+document.documentElement.scrollTop;
            var l=parseInt(pageX-spaceX);
            var t=parseInt(pageY-spaceY);
            $("#deleteInfo").offset({left:l,top:t});
            if(window.getSelection){
                window.getSelection().removeAllRanges();
            }else{
                document.selection.empty();
            }
        });
    });
    $(document).mouseup(function(){
        $(document).unbind("mousemove");
    });

    //返回结果信息
    if(msg != ''){
        alert(msg);
    }
});