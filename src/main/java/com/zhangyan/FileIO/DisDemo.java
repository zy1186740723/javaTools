package com.zhangyan.FileIO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 14:14
 * @Version 1.0
 */
public class DisDemo {
    public static void main(String[] args) throws IOException {
        String file="demo/dos.dat";
        IOUtils.printHex(file);
        DataInputStream dis=new DataInputStream(
                new FileInputStream(file)
        );
        int i=dis.readInt();
        System.out.println(i);
        i=dis.readInt();
        System.out.println(i);
        String s=dis.readUTF();
        System.out.println(s);
        dis.close();

    }
}
