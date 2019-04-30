package com.zhangyan.FileIO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 13:23
 * @Version 1.0
 */
public class FileOutDemo1 {
    public static void main(String[] args) throws IOException {
        //如果文件不存在，直接创建文件
        FileOutputStream out=new FileOutputStream("demo/test1.txt",true);
//        out.write('A');//A字符的低8位
//        out.write('B');
        /**
         * 整型：
         *
         * byte:1个字节 8位 -128~127
         *
         * short ：2个字节 16位
         *
         * int ：4个字节 32位
         *
         * long：8个字节 64位
         *
         * 浮点型：
         *
         * float：4个字节 32 位
         *
         * double ：8个字节 64位
         */
        int a=10;//write只能写低八位，写一和int要写4次
        out.write(a>>>24);
        out.write(a>>>16);
        out.write(a>>>8);
        out.write(a);

        out.write(String.valueOf(10).getBytes("utf-8"));

        //编码的方式要对应，不然会出现乱码
        byte[] utf="英国".getBytes("utf-8");
        out.write(utf);
        out.close();
        //IOUtils.printHex("demo/out.dat");




    }
}
