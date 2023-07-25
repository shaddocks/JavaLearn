package com.lulu.daily.io.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver {

    public static void main(String[] args) {
        byte[] buf = new byte[1024 * 64];
        //2.构建一个DataGramPacket对象，准备接受数据，一个数据包最大64k
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try (
                //1.创建一个DataGramSocket对象，在9999准备接受数据
                DatagramSocket socket = new DatagramSocket(9999)
        ){
            //3.调用接收方法，将通过网络传输的DatagramPacket对象填充到packet对象
            //如没有数据包发送到本机端口，就会阻塞等待
            socket.receive(packet);
            //4.拆包 实际接收到的数据字节长度 以及接收到的数据
            int len = packet.getLength();
            byte[] data = packet.getData();
            System.out.println(new String(data, 0, len));
            //---回复消息给B端
            //将需要发送的数据，封装到DatagramPacket对象
            data = "hello sender".getBytes();
            packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9998);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
