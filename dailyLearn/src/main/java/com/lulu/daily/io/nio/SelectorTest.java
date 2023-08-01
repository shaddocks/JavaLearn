package com.lulu.daily.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelectorTest {

    public static void main(String[] args) throws IOException {
        //1.获取通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        //2.切换非阻塞模式
        channel.configureBlocking(false);
        //3.绑定连接
        channel.bind(new InetSocketAddress(9999));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并指定监听接收事件
        channel.register(selector, SelectionKey.OP_ACCEPT);

        selector.close();
        channel.close();
    }
}
