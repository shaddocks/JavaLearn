package com.lulu.daily.io.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) {
        try (
                //1.9998准备接收数据
                DatagramSocket socket = new DatagramSocket(9998)
        ) {
            byte[] buf = "bye".getBytes();
            //2.构建一个DataGramPacket对象，准备发送数据
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 9999);
            //3.发送
            socket.send(packet);
            buf = new byte[1024 * 64];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println(new String(buf, 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
