package com.lulu.daily.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class BufferTest {

    public static final String name = "lulu";
    public static void main(String[] args) {
        test04();
    }

    /**
     * 分配缓冲区
     */
    public static void test01() {
        byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
        //byte[] bytes = name.getBytes(StandardCharsets.UTF_8);//直接内存
        ByteBuffer buffer = ByteBuffer.allocate(100);//JVM内部内存
        buffer.put(bytes);
        System.out.println(new String(buffer.array(), 0, bytes.length));
    }

    public static void test02() {
        byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        buffer.put(bytes);
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 2);
        System.out.println(new String(dst));
        System.out.println(buffer.position());
        if (buffer.hasRemaining()) {
            System.out.println(buffer.remaining());
        }
        buffer.clear();//变为写模式
        if (buffer.hasRemaining()) {
            System.out.println(buffer.remaining());
        }
    }

    public static void test03() {
        try (
                RandomAccessFile file = new RandomAccessFile("../temp.txt", "rw");
                FileChannel channel = file.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(10);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                byte[] dst = new byte[buffer.limit()];
                buffer.get(dst);
                System.out.println(new String(dst));
                System.out.println("------");
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 可分散读，合并写
     */
    public static void test04() {
        try (
                RandomAccessFile file = new RandomAccessFile("../temp.txt", "rw");
                FileChannel channel = file.getChannel()
        ) {
            ByteBuffer buf1 = ByteBuffer.allocate(3);
            ByteBuffer buf2 = ByteBuffer.allocate(3);
            ByteBuffer buf3 = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{buf1, buf2, buf3});
            buf1.flip();
            buf2.flip();
            buf3.flip();
            byte[] b1 = new byte[buf1.limit()];
            byte[] b2 = new byte[buf2.limit()];
            byte[] b3 = new byte[buf3.limit()];
            buf1.get(b1);
            buf2.get(b2);
            buf3.get(b3);
            System.out.println(new String(b1));
            System.out.println(new String(b2));
            System.out.println(new String(b3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
