package com.test.interview.test;

import com.test.interview.InterviewApplicationTests;
import org.junit.Test;

/**
 * Created by botong.chen on 14/6/2022 下午3:55
 */
public class VariableIncreateTest extends InterviewApplicationTests {

    @Test
    public void variableIncreateTest(){
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i =" + i);
        System.out.println("j =" + j);
        System.out.println("k =" + k);
        //输出的结果是i=4 j=1 k=11
    }
}
