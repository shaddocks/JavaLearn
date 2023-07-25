package com.lulu.daily.io.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class BufferTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        byte[] bytes = "lulu".getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put(bytes);
        System.out.println(new String(buffer.array(), 0, bytes.length));
    }
}
