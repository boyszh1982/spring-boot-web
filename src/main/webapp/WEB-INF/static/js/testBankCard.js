 //Description:  银行卡号Luhm校验

    //Luhm校验规则：16位银行卡号（19位通用）:

    // 1.将未带校验位的 15（或18）位卡号从右依次编号 1 到 15（18），位于奇数位号上的数字乘以 2。
    // 2.将奇位乘积的个十位全部相加，再加上所有偶数位上的数字。
    // 3.将加法和加上校验位能被 10 整除。

    // 需要在页面引用Jquery.js    

    //bankno为银行卡号 banknoInfo为显示提示信息的DIV或其他控件
    function luhmCheck(bankno){
        var lastNum=bankno.substr(bankno.length-1,1);//取出最后一位（与luhm进行比较）

        var first15Num=bankno.substr(0,bankno.length-1);//前15或18位
        var newArr=new Array();
        for(var i=first15Num.length-1;i>-1;i--){    //前15或18位倒序存进数组
            newArr.push(first15Num.substr(i,1));
        }
        var arrOdd=new Array();  //奇数位*2的积 <9
        var arrOdd2=new Array(); //奇数位*2的积 >9

        var arrEven=new Array();  //偶数位数组
        for(var j=0;j<newArr.length;j++){
            if((j+1)%2==1){//奇数位
                if(parseInt(newArr[j])*2<9)
                arrOdd.push(parseInt(newArr[j])*2);
                else
                arrOdd2.push(parseInt(newArr[j])*2);
            }
            else //偶数位
            arrEven.push(newArr[j]);
        }

        var odd_child1=new Array();//奇数位*2 >9 的分割之后的数组个位数
        var odd_child2=new Array();//奇数位*2 >9 的分割之后的数组十位数
        for(var h=0;h<arrOdd2.length;h++){
            odd_child1.push(parseInt(arrOdd2[h])%10);
            odd_child2.push(parseInt(arrOdd2[h])/10);
        }        

        var sumOdd=0; //奇数位*2 < 9 的数组之和
        var sumEven=0; //偶数位数组之和
        var sumOddChild1=0; //奇数位*2 >9 的分割之后的数组个位数之和
        var sumOddChild2=0; //奇数位*2 >9 的分割之后的数组十位数之和
        var sumTotal=0;
        for(var m=0;m<arrOdd.length;m++){
            sumOdd=sumOdd+parseInt(arrOdd[m]);
        }

        for(var n=0;n<arrEven.length;n++){
            sumEven=sumEven+parseInt(arrEven[n]);
        }

        for(var p=0;p<Odd_child1.length;p++){
            sumOddChild1=sumOddChild1+parseInt(odd_child1[p]);
            sumOddChild2=sumOddChild2+parseInt(odd_child2[p]);
        }      
        //计算总和
        sumTotal=parseInt(sumOdd)+parseInt(sumEven)+parseInt(sumOddChild1)+parseInt(sumOddChild2);

        //计算Luhm值
        var k= parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;        
        var luhm= 10-k;

        if(lastNum==luhm){
        $("#banknoInfo").html("Luhm验证通过");
        return true;
        }
        else{
        $("#banknoInfo").html("银行卡号必须符合Luhm校验");
        return false;
        }        
    }