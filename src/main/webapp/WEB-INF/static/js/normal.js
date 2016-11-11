// JavaScript Document



$(function() {
    var aa="-190";
    var slideBar=$('.slideBar');
    var MIN_WINDOW_SIZE=800;

    function setFrameworkLayout() {
        var window_width = $(window).width();
        var window_height = $(window).height();
        if(window_width<MIN_WINDOW_SIZE){
            return;
        }
        //设置头部
        //设置头部
        $('.adminHead').css({'width':(window_width-212)+'px','height':'110px'});
        $('.navBars').css({'width':(window_width-212-20)+'px'});

        $('.adminContent').css({'width':window_width,'height':(window_height-110)+'px'});
        $('.conLeft').css({'height':(window_height-110)+'px','float':'left'});
        $('.conNav').css({'width':(window_width-190-20)+'px','float':'left'})

        //内容页
        nn("conRight",aa);

        //左边菜单高度
        slideBar.css({'height':(window_height-110-100)+'px','float':'left'});
    }

    function nn(className,num){
        $('.'+className).css({'width':($(window).width()+parseInt(num))+'px','height':($(window).height()-110-46)+'px','overflowY':'auto'});
    }


    $('body').css({'padding':0,'margin':0,'overflowX':'auto','overflowY':'hidden'});
    setFrameworkLayout();

    //窗口缩放时自适应
//    window.onresize=function(){
//        setFrameworkLayout();
//    };
    $(window).resize(function(){
        setFrameworkLayout();
    });

	//菜单悬浮样式
	$(".ulNav ul li").hover(function(){
		$(this).addClass("hover");
	},function(){
		$(this).removeClass("hover");
	});
	

	//左边导航二级菜单
	$(".afir").click(function(){
		$(this).toggleClass("on");
		$(this).next().toggle();
	});

	
	//左边导航伸缩
	$(".conLeft a.flex").click(function(){
		$(this).toggleClass("goLeft");
		$(".nextA,.prevA").toggle();
		if($(this).css("left")=="190px"){
			$(".conLeft").width(0);
			$(this).css("left","0px");
			$(".conRight").removeClass("conR01").addClass("conR02");
			nn("conR02","0");

            aa="0";
            setFrameworkLayout();
		}
		else {
			$(".conLeft").width(190);
			$(this).css("left","190px");
			$(".conRight").removeClass("conR02").addClass("conR01");

            aa="-190";
            setFrameworkLayout();
		}
	});


    //
//    $(".delList span").click(function(){
//        $(this).parent().hide();
//    });
//
//    //新增银行模板
//    $(".bankModel p span").click(function(){
//        $(this).addClass("on").parent().siblings().children("span").removeClass("on");
//        $(this).parent().css("background","#e6ecf4").siblings().css("background","")
//    });
//
//    //导出银行模板
//    $(".exportModel").click(function(){
//        $(".popup").show();
//        $(".popDet").css("marginTop",(-$(".popDet").outerHeight()/2));
//    });
//
//    //关闭弹窗
//    $(".cancelPop").click(function(){
//        $(this).parents(".popup").hide();
//    });


    //网银在线 on/off
    /*$(".confHead span.fleft i.on").click(function(){
        $(this).toggleClass("off");
    })*/
    //添加新通道 radio
    $(".inputRadio em").click(function(){
        $(this).addClass("on").parent().siblings(".inputRadio").children("em").removeClass("on")
    })

});












