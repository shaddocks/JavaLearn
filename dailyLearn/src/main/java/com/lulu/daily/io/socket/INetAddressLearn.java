package com.lulu.daily.io.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class INetAddressLearn {

    public static void main(String[] args) throws UnknownHostException {
        //1.世实际上是通过host文件或者。。获得主机名和ip
        InetAddress host1 = InetAddress.getLocalHost();
        System.out.println(host1);
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
    }

}
