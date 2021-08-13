layui.config({
    base: "/static/eleTree/layui/lay/mymodules/"
}).use(['jquery', 'table', 'eleTree', 'code', 'element', 'layer'], function () {
    let $ = layui.jquery;
    let eleTree = layui.eleTree;
    let layer = layui.layer;
    let roleId = $("#roleId").val();
    let el = eleTree.render({
        elem: '.ele1',
        showCheckbox: true,
        defaultExpandAll: true,
        //showLine: true,
        url: "/role/getRolePermission",
        where: {roleId},
        method: "post",
    });

    // 提交权限
    $("#submit-permission").click(function () {
        let nodes = el.getChecked(false, true);
        let menuIds = [];

        for (let i = 0; i < nodes.length; i++) {
            console.log(nodes[i].label);
            menuIds.push(nodes[i].id);
        }

        // 发送请求
        $.ajax({
            url: "/role/savePermission",
            type: "post",
            dataType: "json",
            data: {"roleId":roleId, "menuIds":menuIds},
            traditional: true,
            success: function (data) {
                if (data.code === "200") {
                    let index = parent.layer.getFrameIndex(window.name);  // 获取当前窗口的name
                    parent.layer.close(index);  // 关闭窗口
                    parent.layer.msg(data.msg, {icon:6, time:1500});
                } else {
                    layer.msg(data.msg, {icon:5, time:1500});
                }
            }
        })
    })
});

