package com.zhangyan.Reflection;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 21:58
 * @Version 1.0
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        Foo foo1=new Foo();
        //Foo这个类也是一个实例对象
        //任何一个类都是class类的实例对象

        //第一种表示，任务一个类都有一个隐含的静态成员变量
        Class c1=Foo.class;

        //第二种已经该类的对象通过getClass方法
        Class c2=foo1.getClass();

        /**
         * 官网 c1,c2表示了Foo类的类类型(class type)
         * 类也是对象，是class类的实例对象
         *
         * 这个对象我们成为该类的类类型
         */
        //不管c1 or c2 都代表Foo的类类型，一个类只可能是class的一个实例对象
        System.out.println(c1==c2);
        //第三种
        Class c3=null;
        try {
            c3=Class.forName("com.zhangyan.Reflection.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2==c3);


        //通过类的类类型创建该类的实例对象
        //---》也就是用c2 c3 c1创建Foo类的对象
        try {
            //前提是需要有无参数的构造方法
           Foo foo = (Foo) c1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

class Foo{}
