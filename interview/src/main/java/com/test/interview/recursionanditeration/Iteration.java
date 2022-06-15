package com.test.interview.recursionanditeration;

public class Iteration {

    public static void main(String[] args) throws IllegalAccessException {
        long start = System.currentTimeMillis();
        int loop = loop(100);
        System.out.println(loop);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
    public static int loop(int n) throws IllegalAccessException {
        if(n < 1){
            throw new IllegalAccessException(n + "不能小于1");
        }
        if (n == 1 || n == 2){
            return n;
        }
        int one = 2;
        int two = 1;
        int sum =0;
        for (int i = 3; i <= n; i++){
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;

    }
}
