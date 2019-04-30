package com.zhangyan.Reflection;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 22:39
 * @Version 1.0
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        Class c1=int.class;//int的类类型
        Class c2=String.class;//Stirng 的类类型
        Class c3=double.class;
        Class c5=void.class;
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());


    }
}
