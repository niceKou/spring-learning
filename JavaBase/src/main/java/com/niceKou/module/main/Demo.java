package com.niceKou.module.main;

public class Demo {
    public static void main(String args[]) {

        //1：
        int num = 2147483647 ;
        num += 2 ; // -2147483648  -2147483647
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);

        System.out.println(num) ;

        //2：
        int a  = 3,b = 5;
        System.out.println(a ^ b ^ b );
        System.out.println(b ^ b ^ a );

        //3
        System.out.println("1.0 - 0.1 =  " + (1.0 - 0.1));
        System.out.println("1.0 - 0.2 =  " + (1.0 - 0.2));
        System.out.println("1.0 - 0.3 =  " + (1.0 - 0.3));
        System.out.println("1.0 - 0.4 =  " + (1.0 - 0.4));
        System.out.println("1.0 - 0.5 =  " + (1.0 - 0.5));
        System.out.println("1.0 - 0.6 =  " + (1.0 - 0.6));
        System.out.println("1.0 - 0.7 =  " + (1.0 - 0.7));
        System.out.println("1.0 - 0.8 =  " + (1.0 - 0.8));
        System.out.println("1.0 - 0.9 =  " + (1.0 - 0.9));
        System.out.println("1.0 - 1.0 =  " + (1.0 - 1.0));
        if (0.1 + 0.1 + 0.1 == 0.3) {
            System.out.println("0.1 + 0.1 + 0.1 is equal to 0.3");
        }
        else {
            System.out.println("0.1 + 0.1 + 0.1 is not equal with 0.3");//输出
        }
        if (0.1 + 0.1 == 0.2) {
            System.out.println("0.1 + 0.1 is equal to 0.2");// 输出
        }
        else {
            System.out.println("0.1 + 0.1 is not equal with 0.2");
        }
        System.out.println(0.1f);

        System.out.println(Integer.parseInt("1"));
        System.out.println(Integer.parseInt("2"));

        // 4

        Short s1 = 1;
        Short s2 = s1;
        System.out.println(s1 == s2);
        s1++;
        System.out.println(s1 == s2);

        // 5

        int i = 1, j = 0;
        switch (i) {
            case 1:
                j += 6;
            case 4:
                j += 1;
            default:
                j += 2;
            case 0:
                j += 4;
        }
        System.out.println(j);

    }


}