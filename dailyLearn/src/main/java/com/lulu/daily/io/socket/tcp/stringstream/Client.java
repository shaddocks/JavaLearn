package com.lulu.daily.io.socket.tcp.stringstream;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 9999);
                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))
        ){
            writer.write("lulu\n");
            writer.write("yxf\n");
            writer.flush();
            //调用Socket.shutdownOutput()方法后，客户端输出的数据都将被发送，并加上 TCP 的正常连接终止序列（-1，也就是服务端终止循环的判断条件)，这样服务端读取数据时就不会被阻塞了。
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
