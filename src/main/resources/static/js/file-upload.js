layui.use(["form", 'layer', 'upload'], function () {
    let form = layui.form;
    let upload = layui.upload;

    upload.render({
        elem: '#upload-file',
        url: '/api/upload/',
        auto: false, //选择文件后不自动上传
        bindAction: '#submit-file', //指向一个按钮触发上传
        // 其他参数
        data: {
            title: function () {
                return $("#title").val();
            },
            desc: function () {
                return $("#desc").val();
            },
        }
    });
})
