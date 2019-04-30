package com.zhangyan.FileIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 13:59
 * @Version 1.0
 */
public class DosDemo {
    public static void main(String[] args) throws IOException {
        String file="demo/dos.dat";
        DataOutputStream dos=new DataOutputStream(
                new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeUTF("中国");

        //utf-16be
        dos.writeChars("中国");
        dos.close();
        IOUtils.printHex(file);


    }
}
