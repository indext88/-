//日期格式化，将毫秒转为 XXXX-XX-XX 的格式
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
                : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;

}

function showLogin() {
    if ($("#userNameInfo").html().trim() == "") {
        $("#userNameInfo").html("登陆");
        $("#userNameInfo").parent().attr("href", $("#loginUrl").val());
        $("#Regist_start_").attr("style", "display:in-line");
    } else {
        $("#yourOrder").attr("style", "display:in-line");
        $("#logout").attr("style", "display:in-line");
        $("#personalCenter").attr("style", "display:in-line");
    }
}


function getRootPath() {
    //获取当前网址，如： http://localhost:8088/test/test.jsp
    var curPath = window.document.location.href;
    //获取主机地址之后的目录，如： test/test.jsp
    var pathName = window.document.location.pathname;
    var pos = curPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8088
    var localhostPath = curPath.substring(0, pos);
    //获取带"/"的项目名，如：/test
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    console.log(localhostPath + projectName);
    return (localhostPath + projectName);//发布前用此
}

