/**
 * 系统通用js，包含字段校验等
 * @Author zhou
 * @Date 2014-11-13
 */

/**
 * 此对象作为我们系统的根对象，其他通用的常用的js对象请放到此类下
 */

//初始化
$(function () {
    if (typeof window.__JUST_ONCE_UNDEFINED__ === "undefined") { //TODO:只执行一次的代码块，一般事件处理最好放入此块中。
        window.__JUST_ONCE_UNDEFINED__ = 1;

        //重置条件按钮
        $(".__reset").click(function () {
            $("form input[type=text]").each(function () {
                $(this).val("");
            });
        });

        //text 弹窗
        //ajax-dialog .ajax-dialog-ids (全选多选时带入参数ids=1,2,3...
        $(".ajax-dialog,.ajax-dialog-ids").attr("onclick", "return false").click(function () {
            var params = {};
            if ($(this).hasClass("ajax-dialog-ids")) {
                //选取复选框的值
                var ids = [];
                $("input[type='checkbox']").each(function () {
                    if (this.checked && $(this).attr("data")) {
                        ids.push($(this).attr("data"));
                    }
                });

                ids = ids.join(",");
                params.ids = ids;
            }

            var href = $(this).attr("href");
            $(document.body).showLoading();
            $.get(href, params, function (data) {
                $(document.body).hideLoading();
                if (data.success) {
                    alert(data.message);
                    location.reload();
                } else {
                    alert(data.message);
                }
            }, "json");
        });

        //html 弹窗
        $(".ajax-box").attr("onclick", "return false").click(function () {

            var href = $(this).attr("href");
            var title = $(this).text();
            var data = $(this).attr("ajax-box-data");

            var config = {title: title};

            if (data) {
                var a_1 = data.split(";");
                for (var i = 0; i < a_1.length; i++) {
                    var a_2 = a_1[i].split(":");
                    config[a_2[0]] = a_2[1];
                }
            }

            $(document.body).showLoading();
            $.get(href, function (data) {
                $(document.body).hideLoading();
                System.showDialog(data, config);
            });
        });
    }

    var __VALIDATE_FORM = '#validateForm,#validateAjaxForm';
    //通用的表单校验
    $(__VALIDATE_FORM).bootstrapValidator({
//        live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
//            id 值校验
            primaryId: {
                validators: {
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'ID号须为数字'
                    }
                }
            },
//            用户名
            username: {
                validators: {
                    regexp: {
                        regexp: /^[0-9A-Za-z_]{6,30}$/,
                        message: '用户名须为6-30位字母、下划线或数字'
                    }
                }
            },
//            姓名
            realName: {
                validators: {
                    regexp: {
                        regexp: /^[\u4e00-\u9fa5]{2,5}$/,
                        message: '真实姓名必须是2~5个中文'
                    }
                }
            }
        }
    });


    //复选框 的全选
    var checkAll = $("#_checkAll");
    checkAll.click(function () {
        if (checkAll[0].checked) {
            //全选
            $("input[type='checkbox']").each(function () {
                this.checked = true;
            });
        } else {
            //全不选
            $("input[type='checkbox']").each(function () {
                this.checked = false;
            });

        }
    });

    //自适应窗口变化
    $(window).resize(function () {
        System.updateDialog();
    });
});

var System = (System !== undefined) ? System : {};
(function (s) {
    /**
     * 默认的异步表单提交回调处理
     * @type {{}}
     */
    s.DefaultFormCallback = {
        beforeSerialize: function () {
            return true;
        },
        success: function (data) {
            if (data.success) {
                //跳转
//                window.location = data.message;
                alert(data.message);
                location.reload();
            } else {
                //TODO:此处替换为弹窗形式
//                alert(data.message);
                $(document.body).hideLoading();
                alert(data.message);

            }
        },
        error: function () {
//            alert("未知系统异常");
            $(document.body).hideLoading();
            System.showDialog("未知系统异常");
        }

    };

    //更新弹窗位置
    s.updateDialog = function () {
        var container = $("#_DIALOG_CONTAINER");
        var width = container.width(), height = container.height();
        var window_width = $(window).width();
        var window_height = $(window).height();
        var left = (window_width - width) / 2;
        var top = (window_height - height) / 2;
        container.css("left", left).css("top", top);

    };

    s.closeDialog = function () {
        $("#_DIALOG_BLACK_OVERLAY").remove();
        $("#_DIALOG_CONTAINER").remove();
    };

    /**
     * 显示对话框
     * @param param 文本或者url地址
     * @param config 配置参数对象 如 {width:300,height:400}
     */
    s.showDialog = function (param, config) {
        System.closeDialog();

        var width = 400, height = 300;
        if (config && config.width) {
            width = config.width;
        }
        if (config && config.height) {
            height = config.height;
        }

        //计算top,left
        var window_width = $(window).width();
        var window_height = $(window).height();
        var left = (window_width - width) / 2;
        var top = (window_height - height) / 2;

        var style = "width:" + width + ";height:" + height + ";left:" + left + ";top:" + top;


        /**
         * <div class="popup" style="display: block;">
         <i></i>
         <div class="popDet"><!--popDet-->
         <h2 class="popHeader"><span>新增银行图标</span><a href="javascript:" class="cancelPop">取消</a></h2>

         </div><!--/popDet-->
         </div>
         * @type {string}
         */

        var str = '<div id="_DIALOG_BLACK_OVERLAY" class="popup" style="display: block" ><i></i>';
        str += '<div id="_DIALOG_CONTAINER" class="popDet"  style="' + style + '">';
        str += '<h2 class="popHeader"><span>' + (config ? config.title : "") + '</span><a href="javascript:" onclick="System.closeDialog()" class="cancelPop">取消</a></h2>';
        str += '<div id="_DIALOG_CONTENT" style="overflow:auto;height:' + (height - 44) + 'px;">';

        // 接收三种类型的参数: 文本，url
        if (param.match(/(\/\w+)+/) && param.indexOf("</") == -1) {
  			$(document.body).showLoading();            //url
            $.get(param, function (data) {
                str += data;
                str += '</div></div></div>';
                //插入到body中
                $("body").append(str);
                $(document.body).hideLoading();
            });
        } else {
            //text
            str += param;
            str += '</div></div></div>';
            //插入到body中
            $("body").append(str);
        }


    };

    s.errorTips = function (msg) {
        //TODO:显示出错信息
    };

    /**
     * 常用校验
     * @type {{isMobile: Function}}
     */
    s.Validator = {
        isBankAccount: function (str) {
            return str.match(/^[0-9]{16,19}$/);
        },
        validOutPwd: function (password, password1, notFocus) {
            if (!password.val()) {
                System.errorTips("支付密码不能为空");
//                if (!notFocus) password.focus();
                return false;
            }
            if (!password.val().match(/^.{6,16}$/)) {
//                    System.Dialog.showMsg("支付密码长度须为6-16位");
                System.errorTips("支付密码长度须为6-16位");
//                if (!notFocus) password.focus();
                return false;
            }
            if (password1) {
                if (password1.val() !== password.val()) {
//                    System.Dialog.showMsg("两次密码不一致");
                    System.errorTips("两次密码不一致");
//                    if (!notFocus)password1.focus();
                    return false;
                }
            }
            return true;
        },

        validLoginPwd: function (password, password1) {
            if (!password.val()) {
                System.errorTips("新的登录密码不能为空");
//                password.focus();
                return false;
            }
            if (!password.val().match(/^.{6,16}$/)) {
//                    System.Dialog.showMsg("支付密码长度须为6-16位");
                System.errorTips("登录密码长度须为6-16位");
//                password.focus();
                return false;
            }

            if (password1) {
                if (password1.val() !== password.val()) {
//                    System.Dialog.showMsg("两次密码不一致");
                    System.errorTips("两次密码不一致");
//                    password1.focus();
                    return false;
                }
            }
            return true;
        },
        validAuthCode: function (authCodeJQ, notFocus) {
            if (!authCodeJQ.val()) {
                System.errorTips("验证码不能为空");
//                if (!notFocus)authCodeJQ.focus();
                return false;
            }

            if (!System.Validator.isDigital(authCodeJQ.val(), 6)) {
                System.errorTips("验证码须为6位数字");
//                authCodeJQ.focus();
                return false;
            }
            return true;
        },
        isMobile: function (str) {
            return str.match(/^1[3|5|8]\d{9}$/);
        },
        isIdcard: function (str) {
            var reg = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
            return str.match(reg);
        },
        isDigital: function (str, length) {
            var regStr = "^[0-9]{" + length + "}$";
            return str.match(regStr);
        },
        isMoney: function (str) {
            return str.match(/^[0-9]+(\.[0-9]{0,2})?$/);
        }

    }
    /**
     * 校验input标签输入的金额和日期范围，min小于等于max
     * @param config 配置参数对象 如 {min:300,max:400},{min:2010-11-10,max:2011-12-08}
     */
    s.validateMoneyAndDateArea = function(min, max) {
        if(!isNaN(min) && !isNaN(max)) {
            min = parseFloat(min);
            max = parseFloat(max);
        } else {
            min = new Date(min);
            max = new Date(max);
        }
        return min <= max;
    }
    
    s.message = function(message) {
    	alert(message);
    };
    
    s.confirm = function(message) {
    	return confirm(message);
    };
    
    s.warning = function(message) {
    	alert(message);
    };
    
    s.error = function(message) {
    	alert(message);
    };
    /**
     * songjt20160913
     */
    s.closeDialog2 = function () {
        $("#_DIALOG_BLACK_OVERLAY2").remove();
        $("#_DIALOG_CONTAINER2").remove();
    };    
    /**
     * songjt20160913
     */
    s.closeDialog_all = function () {
    	System.closeDialog2();
    	System.closeDialog();
    };    
    
    /**
     * songjt20160913
     */
    s.showDialog2 = function (param, config) {
        System.closeDialog2();

        var width = 400, height = 300;
        if (config && config.width) {
            width = config.width;
        }
        if (config && config.height) {
            height = config.height;
        }

        //计算top,left
        var window_width = $(window).width();
        var window_height = $(window).height();
        var left = (window_width - width) / 2;
        var top = (window_height - height) / 2;

        var style = "width:" + width + ";height:" + height + ";left:" + left + ";top:" + top;


        /**
         * <div class="popup" style="display: block;">
         <i></i>
         <div class="popDet"><!--popDet-->
         <h2 class="popHeader"><span>新增银行图标</span><a href="javascript:" class="cancelPop">取消</a></h2>

         </div><!--/popDet-->
         </div>
         * @type {string}
         */

        var str = '<div id="_DIALOG_BLACK_OVERLAY2" class="popup" style="display: block" ><i></i>';
        str += '<div id="_DIALOG_CONTAINER2" class="popDet"  style="' + style + '">';
        str += '<h2 class="popHeader"><span>' + (config ? config.title : "") + '</span><a href="javascript:" onclick="System.closeDialog_all()" class="cancelPop">取消</a></h2>';
        str += '<div id="_DIALOG_CONTENT2" style="overflow:auto;height:' + (height - 44) + 'px;">';

        // 接收三种类型的参数: 文本，url
        if (param.match(/(\/\w+)+/) && param.indexOf("</") == -1) {
            //url
            $.get(param, function (data) {
                str += data;
                str += '</div></div></div>';
                //插入到body中
                $("body").append(str);
                $(document.body).hideLoading();
            });
        } else {
            //text
            str += param;
            str += '</div></div></div>';
            //插入到body中
            $("body").append(str);
        }


    };
    
})(System);
try{
    Object.preventExtensions(System);
}catch(e){}

function jumpTo(url) {
	window.location = url;
}

var Logger = {
	
	log : function(message) {
		try {
			window.console.log(message);
		} catch (e) {
			
		}
	}
		
};

var HttpUtils = {
	postJson : function(url, jsonData, callback) {
		$.ajax({
			type : "POST",
			url : url,
			data : JSON.stringify(jsonData),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(msg) {
				if (callback) {
					callback(msg);
				}
			}
		});
	}
};

var UploadFileUtils = {
	getFiles : function(event) {
		try {
			return event.target.files;
		} catch (e) {
			
		}
		return null;
	},
	getFirstFile : function(event) {
		try {
			return event.target.files[0];
		} catch (e) {
			
		}
		return null;
	},
	getName : function(file) {
		return file.name;
	},
	getType : function(file) {
		return file.type;
	},
	getSize : function(file) {
		return file.size;
	},
	getLastModified : function(file) {
		return file.lastModified;
	},
	getLastModifiedDate : function(file) {
		return file.lastModifiedDate;
	}
};

var ImageUploadUtils = {
	SizeUnit : {kb:"kb", mb:"mb"},
	// allowedFileTypes : ['image/png', 'image/gif', 'image/jpeg', 'image/jpg', 'image/bmp'],
    allowedFileTypes : ['image/png', 'image/jpeg', 'image/jpg'],
	validate : function(file, settings) {
		var allowedFileTypes = null;
		if (settings && settings.allowedFileTypes) {
			allowedFileTypes = settings.allowedFileTypes;
		} else {
			allowedFileTypes = this.allowedFileTypes;
		}
		var typeMatches = false;
		for (var i = 0; i < allowedFileTypes.length; i++) {
			if (allowedFileTypes[i] == file.type.toLowerCase()) {
				typeMatches = true;
				break;
			}
		}
		if (!typeMatches) {
			alert('图片文件格式为[jpg,png,jpeg]!');
			return false;
		}
        if(file.size>5*1024*1024){
            alert('图片文件不能超过5M!');
            return false;
        }
		
		/*
		var maxWidth = settings && settings.maxWidth;
		var maxHeight = settings && settings.maxHeight;
		if (maxWidth) {
			System.warning('上传图片宽度不能超过' + maxWidth);
			return false;
		}
		if (maxHeight) {
			System.warning('上传图片高度不能超过' + maxHeight);
			return false;
		}*/
		return true;
	},
	showImage : function(file, callback) {
		try {
			var fileReader = new FileReader();
			fileReader.readAsDataURL(file);
			fileReader.onload = function(file) {
				return function(e) {
					if (callback) {
						callback(this.result);
					}
				};
			}(file);
		} catch (e) {
			
		}
	}	
};

/*
 * Usage:
 * 
$('#queryBtn').bind('click', function() {
	listSearch('brandAuth');
});
 */
function listSearch(formId) {
	$('#' + formId).ajaxSubmit({
        success: function(data) {
        	$('.mainCon').empty().append($(data).find('.mainCon').html());
        }
    });
}

function handlePagination(formId) {
	$(document).on('click', '.fenye a', function(e) {
		e.preventDefault();
		adjustPagination(this, formId);
	});
	
	/*
	$(document).on('change', '.fenye select', function(e) {
		selectAdjustPagination(this.value, formId);
	});
	*/
}

function adjustPagination(jumpele, formId) {
	var jumpurl = jumpele.href;
	var offsetIndex = jumpurl.indexOf('?offset=');
	if (offsetIndex < 0) {
		offsetIndex = jumpurl.indexOf('&offset=');
	}
	var maxIndex = jumpurl.lastIndexOf('&');
	var offset = jumpurl.substring(offsetIndex + 8, maxIndex);
	var max = jumpurl.substring(maxIndex + 5);
	$('#' + formId + ' input[name="offset"]').val(offset);
	$('#' + formId + ' input[name="max"]').val(max);
	listSearch(formId);
}

function selectAdjustPagination(max, formId) {
	$('#' + formId + ' input[name="offset"]').val('0');
	$('#' + formId + ' input[name="max"]').val(max);
	listSearch(formId);
}