$(function () {
    layui.use(["table", "element", "laytpl"], function () {
        let table = layui.table;
        let tpl = layui.laytpl;
        let $ = layui.$;

        //执行渲染
        table.render({
            elem: '#demo',
            height: 500, //容器高度
            url: "/role/getRole",
            method: "post",
            page: true,
            limit: 20,
            limits: [20, 30, 50],
            cols: [[
                {checkbox: true},
                {field: 'id', title: 'ID'},
                {field: 'roleName', title: '角色名称'},
                {fixed: 'right', title: "操作", align: 'center', toolbar: '#barDemo'}
            ]],
            id: "roleTable",
        });

        //工具条事件
        table.on('tool(test)', function (obj) {
            let data = obj.data; //获得当前行数据
            let layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            let tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if (layEvent === 'edit') { // 编辑
                alert(data.id);
            } else if (layEvent === 'del') { // 删除
                layer.confirm('确定删除角色?', {icon: 3, title: "提示"}, function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if (layEvent === 'permission') { // 权限分配
                //do something
                layer.open({
                    type: 2,
                    title: "权限分配",
                    shade: 0.5,
                    area: ["550px", "450px"],
                    content: ["/role/permission?roleId=" + data.id + "&roleName=" + data.roleName],
                })

                //同步更新缓存对应的值
            } else if (layEvent === 'LAYTABLE_TIPS') {
                layer.alert('Hi，头部工具栏扩展的右侧图标。');
            }
        });

        // 搜索
        $("#search-role").click(function () {
            table.reload('roleTable', {
                url: "/role/getRole",
                method: "post",
                where: { //设定异步数据接口的额外参数，任意设
                    roleName: $("#roleName").val(),
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        })
    })
})
