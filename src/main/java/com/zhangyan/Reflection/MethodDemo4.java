package com.zhangyan.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 0:04
 * @Version 1.0
 */
public class MethodDemo4 {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        ArrayList<String> list1=new ArrayList<>();

        Class c1=list.getClass();
        Class c2=list1.getClass();
        System.out.println(c1==c2);
        //反射都是编译之后的操作
        /**
         * java集合中的泛型，是防止错误输入的，是在编译阶段有效
         * 绕过编译就无效了
         * 通过方法的反射来绕过编译
         */
        try {
            Method m=c2.getMethod("add", Object.class);
            m.invoke(list1,100);//绕过了泛型
            System.out.println(list1.size());
            //不能使用foreach遍历，会有类型转化错误



        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
