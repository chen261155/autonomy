package com.test.interview.singleton;

/**
 * Created by botong.chen on 14/6/2022 下午2:59
 * 饿汉式
 *  在类初始化时直接创建实例对象，不管是否需要这个对象
 *  1)构造器私有化
 *  2）自行创建，并且静态变量保存
 *  3）向外提供这个实例
 *  4）强调这是一个单例，我们可以用final修改
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){

    }
}
