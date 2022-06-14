package com.test.interview.singleton;

import com.test.interview.InterviewApplicationTests;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by botong.chen on 14/6/2022 下午3:02
 */
public class Singleton1Test extends InterviewApplicationTests {

    @Test
    public void singletonTest1(){
        Singleton1 s = Singleton1.INSTANCE;
        System.out.println(s);
    }
    @Test
    public void singletonEnumTest1(){
        SingletonEnum s = SingletonEnum.INSTANCE;
        System.out.println(s);
    }

    @Test
    public void singletonTest2(){
        Singleton2 s = Singleton2.INSTANCE;
        System.out.println(s);
    }

    @Test
    public void singletonTest3() throws ExecutionException, InterruptedException {
        /*Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);*/
        Callable<Singleton3> c = new Callable<Singleton3>() {

            @Override
            public Singleton3 call() throws Exception {
                return Singleton3.getInstance();
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton3> f1 = es.submit(c);
        Future<Singleton3> f2 = es.submit(c);

        Singleton3 s1 = f1.get();
        Singleton3 s2 = f2.get();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        es.shutdown();
    }
}