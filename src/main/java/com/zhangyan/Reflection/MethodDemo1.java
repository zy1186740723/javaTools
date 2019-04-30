package com.zhangyan.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 23:50
 * @Version 1.0
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        //要获取一个方法
        //1\获取类的信息,获取类的信息首先要获取类类型
        A a=new A();
        Class c1=a.getClass();
        //2、获取方法 名称和参数列表来决定
        /**
         * getMethod获取的public的方法
         * getDeclaredMethods自己声明的放啊
         */
        try {
            Method m=c1.getMethod("print",new Class[]{int.class,int.class});
            //方法的反射操作
            //a.print 反射用m对象进行方法调用
            //方法没有返回值，返回null
            Object o= m.invoke(a,new Object[]{10,20});
            System.out.println("===============");
            Method m1=c1.getMethod("print",new Class[]{String.class,String.class});
            //用方法进行反射操作
            o=m1.invoke(a,"Hellow","woRlD");



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
class  A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a,String b){
        System.out.println(a.toUpperCase()+","+b.toUpperCase());
    }
}