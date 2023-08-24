package com.lulu.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        if (is.read(bytes) == 0) throw new IOException();
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus code = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, code);
        is.close();
        return responseEntity;
    }

    @RequestMapping("/upload")
    public String upload(MultipartHttpServletRequest request, HttpSession session) throws IOException {
        MultipartFile photo = request.getFile("photo");
        //获取上传的文件的文件名
        if (photo == null) return "converter/index";
        String filename = photo.getOriginalFilename();
        assert filename != null;
        String hzName = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("photo");
        System.out.println(path);
        File file = new File(path);
        if (!file.exists() && file.mkdir()) System.out.println("create");
        String finalPath = path + File.separator + filename;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "converter/success";
    }
}
