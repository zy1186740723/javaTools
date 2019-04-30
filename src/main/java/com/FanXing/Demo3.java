package com.FanXing;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 21:29
 * @Version 1.0
 */


/**
 * public void showKeyValue1(Generic<Number> obj){
 *     Log.d("泛型测试","key value is " + obj.getKey());
 * }
 * 泛型通配符
 * Generic<Integer> gInteger = new Generic<Integer>(123);
 * Generic<Number> gNumber = new Generic<Number>(456);
 *
 * showKeyValue(gNumber);
 *
 * // showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
 * // cannot be applied to Generic<java.lang.Number>
 * // showKeyValue(gInteger);

 */
public class Demo3<T> {
    //此处’？’是类型实参，而不是类型形参 。重要说三遍！
    // 此处’？’是类型实参，而不是类型形参 ！ 此处’？’
    // 是类型实参，而不是类型形参

    /**
     * 此处的？和Number、String、Integer一样都是一种实际的类型，
     * 可以把？看成所有类型的父类。是一种真实的类型。
     * @param obj
     */
    public static void showKeyValue1(Demo1<?> obj){
        System.out.println(obj.getKey());
    }




    public static void main(String[] args) {
        /**
         * 可以解决当具体类型不确定的时候，这个通配符就是 ?  ；当操作类型时，不需要使用类型的具体功能时，
         * 只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
         */
        Demo1<Integer> demo1=new Demo1<Integer>(12345);
        Demo1<Number> demo11=new Demo1<Number>(345);
        Demo3.showKeyValue1(demo1);
        Demo3.showKeyValue1(demo11);
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
}


