package com.test.interview.recursionanditeration;

public class Recursion {

    public static void main(String[] args) throws IllegalAccessException {
        long start = System.currentTimeMillis();
        int f = f(40);
        System.out.println(f);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    //实现f(n)：求n步台阶，一共有几种方法
    public static int f(int n) throws IllegalAccessException {
        if(n < 1){
            throw new IllegalAccessException(n + "不能小于1");
        }
        if (n == 1 || n == 2){
            return n;
        }
        return f(n-2) + f(n-1);
    }
}
