package com.lulu.daily.io.socket.tcp.bytestream;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (
                //1.连接服务器
                Socket socket = new Socket("127.0.0.1", 9999);
                //2.获得输出流
                OutputStream outputStream = socket.getOutputStream()
        ) {
            /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.flush();//字符流需要手动刷新*/
            outputStream.write("hello world".getBytes());
            //3.结束标志，告诉服务器已经写完了
            //可以后续继续获取输入流，读入数据
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
