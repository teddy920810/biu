package com.abc.controller;

import com.abc.annotation.PermInfo;
import com.abc.util.FileHandleUtil;
import com.abc.vo.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@PermInfo(value = "文件上传")
@RestController
@RequestMapping("/file")
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * 测试文件上传
     */
    @PostMapping("/upload")
    public Json upload(@RequestBody MultipartFile file) throws IOException {
        String oper = "upload file";
        String fileURL = FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename());
        return Json.result(oper, true)
                .data("url",fileURL);
    }
}
