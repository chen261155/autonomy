package com.test.interview.singleton;

/**
 * Created by botong.chen on 14/6/2022 下午3:47
 *  在内部类被加载和初始化时，才创建INSTANCE实例对象
 *  静态内部类不会自动随着外部类的加载和初始化而初始化，它是单独去加载和初始化的
 *  因为是在内部类加载和初始化的，创建的，因此线程是安全的
 */
public class Singleton4 {
    private Singleton4(){

    }
    private static class Inner{
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return Inner.INSTANCE;
    }
}
