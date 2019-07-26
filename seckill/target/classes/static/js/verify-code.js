    /**
     * [生成4位随机数]
     * @return {[type]} [description]
     */
    function randomCode(){
        var str = "qwertyuiopasdfghjklzxcvbnm0123654789QAZWSXEDCRFVTGBYHNUJMIKOLP";
        // var arr = str.split("");
        // return loopNum(4,arr.length,arr);
        return loopNum(4,str.length,str);
    }

    /**
     * [得取下标值]
     * @param  {[type]} num [description]
     * @return {[type]}     [description]
     */
    function getIndex(num){
        return Math.floor(Math.random()*num);
    }

    /**
     * 数据对象为空
     * @param obj
     * @returns {boolean}
     */
    function isEmpty(obj) {
        if (obj == null || obj == undefined || obj == "")
            return true;
        return false;
    }

    /**
     * [依次拼接相应的数字]
     * @param  {[type]} times  [description]
     * @param  {[type]} length [description]
     * @param  {[type]} arr    [字符串或者数组]
     * @return {[type]}        [description]
     */
    function loopNum(times,length,arr){
        //alert(arr);
        var str = "";
        for (var i = 0; i < times ; i++) {
            if(isEmpty(arr)){
                str += getIndex(length);
            }else if(arr.length > 0){
                str += arr[getIndex(length)];
            }
        }
        return str;
    }

    /**
     * [创建16进制颜色值]
     * @return {[type]} [description]
     */
    function createHexColorValue(){
        // return '#'+ loopNum(3,10,null);
        return '#'+ loopNum(3,10);
    }

    /**
     * [干扰线的随机x坐标值]
     * @return {[type]} [description]
     */
    function lineX(){
        return getIndex(90);
    }

    /**
     * [干扰线的随机y坐标值]
     * @return {[type]} [description]
     */
    function lineY(){
        return getIndex(40);
    }
    /**
     * [干扰线的随机x或y的坐标值]
     * @return {[type]} [description]
     */
    function lineValue(coordinateValue){
        return getIndex(coordinateValue);
    }

    /**
     * [填充验证码干扰线]
     * @param  {[type]} canvasid [canvas标签的id]
     * @param  {[type]} codeValue  [验证码值]
     * @return {[type]}          [description]
     */
    function createVerifyCode(canvasid,codeValue){
        var mycanvas = document.getElementById(canvasid);
        var cxt = mycanvas.getContext('2d');
        cxt.fillStyle = createHexColorValue();
        cxt.fillRect(0,0,90,40);
        
        /*生成干扰线20条*/
        for(var j=0; j<20; j++){
            cxt.strokeStyle = createHexColorValue();
            cxt.beginPath();        //若省略beginPath，则每点击一次验证码会累积干扰线的条数
            // cxt.moveTo(lineX(),lineY());
            // cxt.lineTo(lineX(),lineY());
            cxt.moveTo(lineValue(90),lineValue(40));
            cxt.lineTo(lineValue(90),lineValue(40));
            cxt.lineWidth = 0.5;
            cxt.closePath();
            cxt.stroke();
        }

        cxt.fillStyle = 'red';
        // cxt.fillStyle = createHexColorValue();
        cxt.font = 'bold 20px Arial' ;
        cxt.fillText(codeValue,25,25);   //把codeValue可有randomCode生成的随机数文本填充到canvas中      
    }

