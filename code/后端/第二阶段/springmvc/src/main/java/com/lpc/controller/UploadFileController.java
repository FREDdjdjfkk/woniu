package com.lpc.controller;

import com.lpc.util.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 演示文件上传
 */
@Controller
@RequestMapping("file")
public class UploadFileController {

    /**
     * 实现文件上传接口
     */
    @RequestMapping("uploadFile")
    @ResponseBody
    public ResultObj uploadFile(MultipartFile imgFile) throws IOException {
//        System.out.println(imgFile);

        String originalFilename = imgFile.getOriginalFilename();//获取上传文件原文件名称
        System.out.println(originalFilename);
        long size = imgFile.getSize();//表示上传文件大小
        System.out.println(size);
        String contentType = imgFile.getContentType(); //上传文件类型
        System.out.println(contentType);
        String name = imgFile.getName(); //获取表单中输入项 name属性值
        System.out.println(name);
        InputStream is = imgFile.getInputStream(); //获取上传文件输入流对象
        System.out.println(is);
        //https://img2.baidu.com/it/u=552882499,1044214449&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=889
        return ResultObj.ok(imgFile.getOriginalFilename());
    }
}