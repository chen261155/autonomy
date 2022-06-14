package com.autonomy.mall.test;

import com.autonomy.mall.MallApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by botong.chen on 14/6/2022 下午12:02
 */
@Slf4j
public class test1 extends MallApplicationTests {

    @Test
    public void test1(){
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        log.info("i= {}", i);
        log.info("j= {}", j);
        log.info("k= {}", k);
    }

    /*
    * Singleton 单例设计模式
    *           一是某个类只能只有一个实例：构造器私有化
    *           二是它必须自行创建这个实例：含有一个该类静态变量来保存这个唯一的实例
    *           三是它必须自行向整个系统提供这个实例：
    *               对外提供获取该实例对象的方式：
    *                   1）直接暴露
    *                   2）用静态变量的get方法获取
    *常见形式:
    *   饿汉式
    *   懒汉式
    * */


}
