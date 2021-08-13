layui.use(['layer', "laydate", "form"], function () {
    let layer = layui.layer;
    let laydate = layui.laydate;
    let form = layui.form;

    //执行一个laydate实例
    laydate.render({
        elem: '#birth' //指定元素
    });
})

// 注册用户
function user_register() {
    if ($("#userName").val() !== "" && $("#password").val() !== "" && $("#affirmPassword").val() !== ""
        && $("#staffName").val() !== "" && $("#gender").val() !== "" && $("#phone").val() !== ""
        && $("#birth").val() !== "") {

        $(".username-hint").css("display", "none");
        $(".password-hint").css("display", "none");
        $(".affirmPassword-hint").css("display", "none");
        $(".staffName-hint").css("display", "none");
        $(".gender-hint").css("display", "none");
        $(".phone-hint").css("display", "none");
        $(".birth-hint").css("display", "none");


        if ($("#password").val() !== $("#affirmPassword").val()) {
            $(".affirmPassword-hint").html("两次密码输入不一致");
            $(".affirmPassword-hint").css("display", "inherit");
        } else {
            $(".affirmPassword-hint").html("确认密码不能为空");
            $(".affirmPassword-hint").css("display", "none");

            // 发送注册请求
            $.ajax({
                url: "/user/register",
                type: "post",
                dataType: "json",
                data: $("#register-form").serialize(),
                success: function (data) {
                    if (data.code === "100") {
                        $(".username-hint").html(data.msg);
                        $(".username-hint").css("display", "inherit");
                    } else if (data.code === "300") {
                        $(".password-hint").html(data.msg);
                        $(".password-hint").css("display", "inherit");
                    } else if (data.code === "500") {
                        $(".phone-hint").html(data.msg);
                        $(".phone-hint").css("display", "inherit");
                    } else if (data.code === "200") {
                        layer.msg(data.msg, {icon: 6});
                        setTimeout(function () {
                            let index = parent.layer.getFrameIndex(window.name);  // 获取当前窗口的name
                            parent.layer.close(index);  // 关闭窗口
                        }, 1500);

                    } else if (data.code === "400") {
                        layer.msg(data.msg, {icon: 5});
                    }
                }
            })
        }
    } else {
        if ($("#userName").val() === "") {
            $(".username-hint").html("用户名不能为空");
            $(".username-hint").css("display", "inherit");
        } else {
            $(".username-hint").css("display", "none");
        }
        if ($("#password").val() === "") {
            $(".password-hint").html("密码不能为空");
            $(".password-hint").css("display", "inherit");
        } else {
            $(".password-hint").css("display", "none");
        }
        if ($("#affirmPassword").val() === "") {
            $(".affirmPassword-hint").html("确认密码不能为空");
            $(".affirmPassword-hint").css("display", "inherit");
        } else {
            $(".affirmPassword-hint").css("display", "none");
        }
        if ($("#realName").val() === "") {
            $(".staffName-hint").css("display", "inherit");
        } else {
            $(".staffName-hint").css("display", "none");
        }
        if ($("#gender").val() === "") {
            $(".gender-hint").css("display", "inherit");
        } else {
            $(".gender-hint").css("display", "none");
        }
        if ($("#phone").val() === "") {
            $(".phone-hint").html("联系方式不能为空");
            $(".phone-hint").css("display", "inherit");
        } else {
            $(".phone-hint").css("display", "none");
        }
        if ($("#birth").val() === "") {
            $(".birth-hint").css("display", "inherit");
        } else {
            $(".birth-hint").css("display", "none");
        }
    }
}

$(function () {
    // 鼠标悬浮，密码提示图片变色
    $(".pwdtip-span").hover(function () {
        $(".pwdtip-img").attr("src", "/static/images/pwdtip-hover.png");
    }, function () {
        $(".pwdtip-img").attr("src", "/static/images/pwdtip.png");
    })


    // 单击密码提示图标，显示提示信息
    $(".pwdtip-span").click(function () {
        if ($(".pwdtip-div").css("display") === "none") {
            $(".pwdtip-div").css("display", "");
        } else {
            $(".pwdtip-div").css("display", "none");
        }
    })
})
