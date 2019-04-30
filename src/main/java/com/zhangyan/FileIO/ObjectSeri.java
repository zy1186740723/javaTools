package com.zhangyan.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: zhangyan
 * @Date: 2019/4/22 23:11
 * @Version 1.0
 */
public class ObjectSeri {
    public static void main(String[] args) throws  Exception{
        String file="E:\\java\\BFtest\\ObjectSeriaDemo.txt";
        //1对象序列化
//        ObjectOutputStream oos=new ObjectOutputStream(
//                new FileOutputStream(file));
//        Student student1=new Student("10001","张三",10);
//        oos.writeObject(student1);
//        oos.flush();
//        oos.close();
        ObjectInputStream ooi=new ObjectInputStream(
                new FileInputStream(file));
        Student student=(Student) ooi.readObject();
        System.out.println(student);
        ooi.close();

    }
}
