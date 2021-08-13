$(function () {
    //bk-sidebar_js_start
    //侧栏展开折叠
    var bkSideBar = $(".bk-sidebar");
    $(".slide-switch").on("click", function () {
        bkSideBar.toggleClass("slide-close slide-open");
        if (bkSideBar.hasClass("slide-close")) {
            $(".flex-subnavs").hide();
        }
    });

    //单级菜单
    bkSideBar.on("click", "li>a", function () {
        // 获取单级菜单li
        let li = $(".menu-li");
        for (let i = 0; i < li.length; i++) {
            // 改变所有菜单颜色
            li[i].children[0].children[0].children[0].style.color = "#8691b7";
            li[i].children[0].children[1].style.color = "#8691b7";
        }
        // 改变当前菜单颜色
        $(this).children()[0].children[0].style.color = "rgb(255,255,255)";
        $(this).children()[1].style.color = "#FFF";

        if ($(this).parents(".bk-sidebar").hasClass("slide-close")) return;
        var _this = $(this).parent();
        var _thisParent = _this.siblings();
        if (_this.hasClass("pure-link")) {
            _this.addClass("open").siblings().removeClass("open");
            // 将所有二级菜单取消选中
            let div = $(".flex-subnavs>a");
            for (let i = 0; i < div.length; i++) {
                div[i].classList.remove("on");
            }
        } else {
            //_this.toggleClass("open").siblings().removeClass("open");
            _this.addClass("open").siblings().removeClass("open");
            _this.find(".flex-subnavs").slideToggle();
        }

        _thisParent.find(".flex-subnavs").slideUp();
    });

    //多级菜单
    bkSideBar.on("click", ".flex-subnavs a", function () {
        $(".flex-subnavs a").removeClass("on");
        $(this).addClass("on");
        if ($(this).parents(".bk-sidebar").hasClass("slide-close")) {
            $(this).parents("li").addClass("open").siblings().removeClass("open")
        }
    });

    // 监听分辨率
    $(window).on('resize', function () {
        var width = $(window).width();
        if (width > 800) {
            bkSideBar.removeClass("slide-close").addClass("slide-open");
        } else {
            bkSideBar.removeClass("slide-open").addClass("slide-close");

        }
    });
    $(window).trigger('resize');
    //bk-sidebar_js_end

    $(".menu-li a")[0].click();
    $(".flex-subnavs a")[0].click();
});