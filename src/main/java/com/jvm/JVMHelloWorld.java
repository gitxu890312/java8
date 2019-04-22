package com.jvm;

/**
 * @Author xuming
 * @date 2019/3/3
 * @Version v1.0.0
 */
public class JVMHelloWorld {

    public void methodOne(int i){
        int j=1;
        int sum = i+j;
        Object obj = new Object();
        methodTwo();
        System.out.println("mehtodOne");
    }

    public int methodTwo(){
        int m = 0;
        int j =2;
        int sum = m+j;
        return sum;
    }
}
