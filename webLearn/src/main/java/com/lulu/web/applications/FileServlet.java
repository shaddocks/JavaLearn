package com.lulu.web.applications;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 下载文件
 */
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器能够支持(Content-Disposition)下载我们所需要的东西
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("word.txt", StandardCharsets.UTF_8));
        resp.addHeader("content-Type","application/octet-stream" );
        //将数据写入缓冲区
        int len;
        byte[] buf = new byte[1024];
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream("/Users/haidenabianhaishihai/project/word.txt"));
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len = stream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
            outputStream.flush();
        }
        outputStream.close();
        stream.close();
    }
}
