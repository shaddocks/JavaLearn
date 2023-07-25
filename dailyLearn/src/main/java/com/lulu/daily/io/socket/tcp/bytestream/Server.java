package com.lulu.daily.io.socket.tcp.bytestream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (
                //1.在本机9999端口监听，等待连接，可返回多个socket
                ServerSocket serverSocket = new ServerSocket(9999);
                //2.当没有客户端连接时会阻塞，有时则返回Socket对象
                Socket socket = serverSocket.accept();
                //3.通过socket读取客户端写入到数据通道的数据，会阻塞
                InputStream inputStream = socket.getInputStream()
        ) {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //4.IO读取
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
