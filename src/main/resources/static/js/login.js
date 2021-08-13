layui.use(['layer', "laydate", "form"], function () {
    let layer = layui.layer;
    let laydate = layui.laydate;
    let form = layui.form;

    //执行一个laydate实例
    laydate.render({
        elem: '#birth' //指定元素
    });
})

// 显示密码
function show_pwd(obj) {
    let node = obj.parentNode;
    // node.children[1].setAttribute("type", "text");
    obj.className = "bk-icon icon-eye";
    obj.style.color = "#2e58ff";
    $("#pwd").attr("type", "text");
}

// 隐藏密码
function mouseup(obj) {
    let node = obj.parentNode;
    // node.children[1].setAttribute("type", "password");
    obj.className = "bk-icon icon-eye-slash";
    obj.style.color = "";
    $("#pwd").attr("type", "password");
}

// 打开注册页
function user_register_page() {
    layer.open({
        type: 2,
        title: " ",
        shade: 0.5,
        area: ["455px", "80%"],
        content: ["/user/registerPage"],
    })
}

// 登录
function doLogin() {
    if ($("#userName").val() !== "" && $("#pwd").val() !== "") {
        $(".username-hint").css("display", "none");
        $(".pwd-hint").css("display", "none");
        $.ajax({
            url: "/doLogin",
            type: "post",
            dataType: "json",
            data: $("#login-form").serialize(),
            success: function (data) {
                if (data.code === "200") {
                    window.location.href = data.url;
                } else {
                    $(".err-span").html(data.msg);
                }
            }
        })
    } else {
        if ($("#userName").val() === "") {
            $(".username-hint").css("display", "inherit");
        } else {
            $(".username-hint").css("display", "none");
        }
        if ($("#pwd").val() === "") {
            $(".pwd-hint").css("display", "inherit");
        } else {
            $(".pwd-hint").css("display", "inherit");
        }
    }
}

// 绑定回车
$(function () {
    // session失效
    if (window.top !== window) {
        window.top.location = "/login";
    }

    // 回车键
    $(document).keydown(function (e) {
        if (e.keyCode === 13) {
            doLogin();
        }
    });

    // 获取cookie
    let cookie = document.cookie;
    if (cookie) {
        // 分割cookie
        let cookies = cookie.split(";");

        // 遍历cookie
        for (let i = 0; i < cookies.length; i++) {
            let coo = cookies[i].split("=");

            // 填充用户名
            if (coo[0].trim() === "userName") {
                $("#userName").val(coo[1]);
            // 填充密码
            } else if (coo[0].trim() === "password") {
                let password = decodeURIComponent(coo[1]);
                $("#pwd").val(password);
                $("#remember").attr("checked", true);
            }
        }
    }
})