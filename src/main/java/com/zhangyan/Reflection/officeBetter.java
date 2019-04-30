package com.zhangyan.Reflection;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 22:18
 * @Version 1.0
 */
public class officeBetter {

    public static void main(String[] args) {
        try {
            //动态加载类 在运行时刻加载
            Class c=Class.forName("com.zhangyan.Reflection.Office");
            //通过类类型，创建对象
            OfficeAble oa= (OfficeAble)c.newInstance();
            oa.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        try {
            String encode= Base64.getEncoder().encodeToString("Son".getBytes("UTF-8"));
            System.out.println("Son".getBytes("UTF-8"));
            System.out.println(encode);
            byte[] decode = Base64.getDecoder().decode(encode);
            System.out.println(new String(decode,"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
