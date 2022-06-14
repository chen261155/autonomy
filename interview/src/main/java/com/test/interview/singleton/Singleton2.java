package com.test.interview.singleton;

import lombok.Data;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by botong.chen on 14/6/2022 下午3:10
 */
@Data
public class Singleton2 {

    public static final Singleton2 INSTANCE ;
    private String info;

    static {
        try {
            Properties pro = new Properties();
            pro.load(Singleton2.class.getClassLoader().getResourceAsStream("application.yml"));
            INSTANCE = new Singleton2(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Singleton2(String info){
        this.info = info;
    }
}
