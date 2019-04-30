package com.zhangyan.FileIO;

import java.io.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/23 13:24
 * @Version 1.0
 */
public class ObjectSeria2 {
    public static void main(String[] args) throws Exception {
        /**
         * 序列化
         */
//        ObjectOutputStream oos=new ObjectOutputStream(
//                new FileOutputStream("E:\\java\\BFtest\\demo\\obj1.dat"));
//        Foo2 foo2=new Foo2();
//        oos.writeObject(foo2);
//        oos.flush();
//        oos.close();
        /**对子类的对象进行序列化操作时，
         * 如果其父类没有实现序列化接口，
         * 其父类的构造函数会被调用
         *
         */
        ObjectInputStream ois=new ObjectInputStream(
                new FileInputStream("E:\\java\\BFtest\\demo\\obj1.dat"));
        Foo2 foo2=(Foo2)ois.readObject();
        System.out.println(foo2);
        ois.close();

    }
}

/**
 * 一个类实现了序列化接口，其子类都能进行序列化
 */
class Foo implements Serializable{
    public Foo(){
        System.out.println("f00......");
    }
}

class Foo1 extends Foo{
    public Foo1(){
        System.out.println("foo1.....");
    }
}

class Foo2 extends Foo1{
    public Foo2(){
        System.out.println("foo2.....");
    }
}
class Bar {
    public Bar(){
        System.out.println("bar");
    }
}
