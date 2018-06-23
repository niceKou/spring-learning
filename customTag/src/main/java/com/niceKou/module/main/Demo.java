package com.niceKou.module.main;

public class Demo {
    public static void main(String args[]) {
        int num = 2147483647 ;

        num += 2 ; // -2147483648  -2147483647
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);

        System.out.println(num) ;
    }
}
