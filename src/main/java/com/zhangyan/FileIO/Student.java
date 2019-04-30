package com.zhangyan.FileIO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author: zhangyan
 * @Date: 2019/4/22 23:08
 * @Version 1.0
 */
public class Student implements Serializable {
    private String no;
    private String name;
    private transient int age;//该元素不会进行虚拟机默认的序列化操作

    public Student(String no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();//把虚拟机能默认序列化的元素进行操作
        s.writeInt(age);//自己完成age的虚拟化

    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();//虚拟机默认能反序列的进行操作
        this.age=s.readInt();//完成age的反序列化操作


    }
}