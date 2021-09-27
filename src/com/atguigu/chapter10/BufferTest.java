package com.atguigu.chapter10;

import com.company.exception.ApiException;

import java.nio.ByteBuffer;
import java.util.Scanner;

public class BufferTest {

    private final static int BUFFER = 1024 * 1024 *1024;
    public static void main(String[] args) throws Exception {
        String info = "dsds";
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕！");
        Scanner scanner =new Scanner(System.in);
        //会产生阻塞
        scanner.next();
        System.out.println("直接内存开始释放！");
        byteBuffer = null;
        System.gc();
        scanner.next();
    }
}
