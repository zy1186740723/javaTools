package com.zhangyan.FileIO;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 23:06
 * @Version 1.0
 */
public class EncodeDemo {

    public static void main(String[] args) throws  Exception{

        String s="慕课ABC";
        //UTF-8 中文3个字节，英文一个字节
        byte[] bytes=s.getBytes();
        for (byte aByte : bytes) {
            //把字节转化为int，以16进制的行事显示,&0xff只留下后8位
            System.out.print(Integer.toHexString(aByte&0xff)+" ");

            //System.out.print(Integer.toHexString(aByte));
        }
        System.out.println();
        //gbk编码中文占用2个字节，英文占用1个字节
        byte[] bytes1=s.getBytes("gbk");
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        //JAVA是双字节编码，utf-16e 中文两个字节 英文也是两个字节
        /**
         * 当你的字节序列是某种编码，想把字节序列变成字符串
         * 也需要用这种编码方式，否在会出现乱码
         */

        System.out.println();
        String str1=new String(bytes1);
        System.out.println(str1);
        String str2=new String(bytes1,"gbk");
        System.out.println(str2);

        /**
         * 文本文件    就是字节序列
         * 可以使任意编码的字节序列
         * 如果在中文机器上直接创建文本文件，只能识别ansi编码
         *
         */

    }
}
