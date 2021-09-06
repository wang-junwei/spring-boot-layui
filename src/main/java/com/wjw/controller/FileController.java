package com.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wjw
 * @Date: 2021/8/20 8:50
 */
@Controller
@RequestMapping("/file")
public class FileController {

    /**
     * 上传文件页面
     * @return 页面
     */
    @PostMapping("/upload")
    public String fileUpload() {
        return "/views/file_upload";
    }
}
