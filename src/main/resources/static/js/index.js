$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    complete: function (XMLHttpRequest, textStatus) {
        // 通过XMLHttpRequest取得响应头，sessionStatus，
        let sessionStatus = XMLHttpRequest.getResponseHeader("sessionStatus");
        if (sessionStatus === "timeout") {
            // 如果超时 ，跳转登录页面
            window.location.href = "/logout";
        }
    }
});

// 注销
function logout() {
    window.location.href = "/logout";
}

$(function () {
    // tab标签过多时，中间页面重新设置高度
    $(".layui-unselect").click(function () {
        // 获取tab的高度
        let ulHeight = $(".layui-tab-title").height();
        let height = Number(ulHeight + 11);

        // 重新设置高度
        $(".layui-tab-content").css("height", "calc(100% - " + height + "px)");
    })
})


layui.use('element', function () {
    let element = layui.element;
    let $ = layui.$;

    // 点击菜单，跳转页面
    $(".second_menu").click(function () {
        // 获取菜单名
        let title = this.title;
        // 获取菜单url，即tab标签的lay-id
        let tab_id = this.getAttribute('url');

        // 获取tab标签
        let li = $(".layui-tab-title li");

        // 遍历已有的tab标签
        for (let i = 0; i < li.length; i++) {
            // 如果当前tab标签已打开，则直接切换过去
            if (li[i].getAttribute("lay-id") === tab_id) {
                element.tabChange('demo', tab_id);
                return;
            }
        }

        // 如果标签未打开，则发起请求，打开页面
        $.ajax({
            url: tab_id,
            type: "post",
            data: "",
            success: function (data) {
                element.tabAdd('demo', {
                    title: title,
                    content: data,
                    id: tab_id
                });
                element.tabChange('demo', tab_id);
            },
            error: function (xhr) {
                debugger;
                if (xhr.status === '200') {
                    location.href = "/logout";
                }
            }
        })
    })

    // 切换tab
    element.on('tab(demo)', function (data) {
        // 获取tab的lay-id
        let lay_id = this.getAttribute("lay-id"); //当前Tab标题所在的原始DOM元素

        // 遍历所有二级菜单
        $(".second_menu").each(function () {
            // 获取二级菜单的一级菜单
            let _parent = $(this).parent().parent();
            // 删除所有二级菜单的类名
            $(this).removeClass("on");

            // 判断当前tab的lay-id跟菜单的lay-id是否相等
            if ($(this).attr('url') === lay_id) {
                // 如果当前菜单不是打开状态
                if (_parent.attr("class") !== "menu-li open") {
                    // 在菜单上添加open类名，并删除其他菜单的open类名
                    _parent.addClass("open").siblings().removeClass("open");
                    // 展开二级菜单
                    $(this).parent().parent().find(".flex-subnavs").slideToggle();
                    // 二级菜单添加on类名
                    $(this).addClass("on");
                    // 合上其他菜单
                    $(this).parent().parent().siblings().find(".flex-subnavs").slideUp();
                } else {
                    $(this).addClass("on");
                }
            }
        })
        // 遍历所以一级菜单，改变菜单颜色
        $(".menu-li").each(function () {
            $(this).children()[0].children[0].children[0].style.color = "#8691b7";
            $(this).children()[0].children[1].style.color = "#8691b7";
        });

        // 遍历打开的菜单，改变菜单颜色
        $(".menu-li.open").each(function () {
            $(this).children()[0].children[0].children[0].style.color = "rgb(255,255,255)";
            $(this).children()[0].children[1].style.color = "rgb(255,255,255)";
        });

    });
})