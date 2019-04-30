package com.zhangyan.FileIO;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 23:54
 * @Version 1.0
 *
 * 提供文件内容的访问，既可以读文件也可以写文件
 * 支持随机访问文件，可以访问文件的任何位置、
 * 两种操作模式 rw r
 * 文件指针，打开文件时指针在开头 pointer-0
 * raf.write(int)---> 只写一个字节 后八位 同时指针指向下一个位置，
 * 准备再次写入
 * raf.read()一个字节
 * 文件读写完成后一定要关闭
 *
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws  Exception{
        File demo=new File("demo");
        if (!demo.exists())
            demo.mkdir();
        File file=new File(demo,"raf.dat");
        if (!file.exists())
            file.createNewFile();

        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        //指针的位置
        System.out.println(raf.getFilePointer());

        //write只写一个字节，而一个char是两个字节
        raf.write('a');
        System.out.println(raf.getFilePointer());
        raf.write('B');
        System.out.println(raf.getFilePointer());
        int i=0x7fffffff;
        //用write，每次写一个字节，得写四次
        raf.write(i>>>24);
        raf.write(i>>>16);
        raf.write(i>>>8);
        raf.write(i);
        System.out.println(raf.getFilePointer());
        raf.writeInt(i);
        System.out.println(raf.getFilePointer());
        String s="中";//java的编码方式
        raf.write(s.getBytes());
        System.out.println(raf.length());

        //读文件，必须把指针移动到头部
        raf.seek(0);
        byte[] buf=new byte[(int)raf.length()];
        //把文件中的内容读取到buf
        raf.read(buf);

        System.out.println(Arrays.toString(buf));
        String s1=new String(buf);
        System.out.println(s1);
        for (byte b : buf) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }




    }
}
