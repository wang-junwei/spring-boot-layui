$(function () {
    layui.use(["table", "element"], function () {
        let table = layui.table;
        let $ = layui.$;

        //执行渲染
        table.render({
            elem: '#demo',
            height: 500, //容器高度
            url: "/user/getUser",
            method: "post",
            page: true,
            limit: 50,
            limits: [50, 100, 200],
            cols: [[
                {checkbox: true},
                {field: 'id', title: 'ID', width: 80},
                {field: 'userName', title: '用户名'},
                {field: 'realName', title: '姓名'},
                {field: 'gender', title: '性别'},
                {field: 'phone', title: '联系方式'},
                {field: 'birth', title: '出生日期', templet:'<div>{{ layui.util.toDateString(d.birth, "yyyy-MM-dd") }}</div>'},
                {field: 'roleName', title: '角色', templet:'<div>{{ d.role.roleName }}</div>'},
                {fixed: 'right', title: "操作", align: 'center', toolbar: '#barDemo'}
            ]],
            id: "userTable",
        });

        //工具条事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            let data = obj.data; //获得当前行数据
            let layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            let tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if (layEvent === 'detail') { //查看
                alert(data.id);
            } else if (layEvent === 'del') { //删除
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if (layEvent === 'edit') { //编辑
                //do something

                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    , title: 'xxx'
                });
            } else if (layEvent === 'LAYTABLE_TIPS') {
                layer.alert('Hi，头部工具栏扩展的右侧图标。');
            }
        });

        // 搜索
        $("#search-user").click(function () {
            table.reload('userTable', {
                url: "/user/getUser",
                method: "post",
                where: { //设定异步数据接口的额外参数，任意设
                    userName: $("#userName").val(),
                    realName: $("#realName").val(),
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        })
    })
})
