package com.zhangyan.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 22:48
 * @Version 1.0
 */
public class ClassUtil {
    //获取成员函数的信息
   public static void printClassMessage(Object obj){
       //要获取类的信息 首先要获取类的类型
       Class c=obj.getClass();
       //获取类的名称
       System.out.println("类的名称是："+c.getName());
       /**
        * Method类，方法对象
        * 一个成员方法就是一个Method对象
        * getMethod获取的是所有public函数，包括父类继承而来的
        * getDeclareMethods获取的是所有类该类自己的声明方法，不问访问权限
        */
       Method[] ms=c.getMethods();
       for (int i = 0; i < ms.length; i++) {
           //得到方法的返回值来兴的类类型
           Class returnType=ms[i].getReturnType();
           System.out.print(returnType.getName()+" ");
           //得到方法的名称
           System.out.print(ms[i].getName()+"(");
           //获得参数类型
           Class[] paramTypes=ms[i].getParameterTypes();
           for (Class paramType : paramTypes) {
               System.out.print(paramType.getName()+",");
           }
           System.out.println(")");
       }}


    /**
     * 成员变量也是对象
     * java.lang.reflect.filed
     * 封装了关于成员变量的操作
     * getFields是获取所有Public类的成员变量的信息
     * getDeclaredFields
     */
    public static void printFieldMessage(Object obj) {
        System.out.println("成员变量的信息");
        Class c=obj.getClass();
        Field[] fs= c.getClass().getDeclaredFields();
        for (Field field : fs) {
            Class filedType=field.getType();
            String typeName=filedType.getName();
            //得到成员变量的名称
            String fieldName=field.getName();
            System.out.println(typeName+" "+fieldName);
        }
    }

    public static void printConMessage(Object obj){
        Class c=obj.getClass();
        /**
         * 构造函数也是对象
         * 封装了构造函数的信息
         * 获得公有的构造方法 getConstructors()
         * getDeclaredConstructors()获得所有的构造函数
         *
         */
        //Constructor[] cs=c.getConstructors();
        Constructor[] cs=c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName()+"(");
            //获取构造函数的参数列表
            Class[] paramType=constructor.getParameterTypes();
            for (Class aClass : paramType) {
                System.out.print(aClass.getName()+",");
            }
            System.out.println(")");
        }


    }
}
