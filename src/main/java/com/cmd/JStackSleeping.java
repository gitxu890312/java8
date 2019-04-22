package com.cmd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuming
 * @date 2019/2/16
 * @Version v1.0.0
 */
public class JStackSleeping {
    public static Object lock = new Object();
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Task task1 =  new Task();
        Task task2 = new Task();
        pool.execute(task1);
        pool.execute(task2);

    }

   static class Task implements  Runnable{
        int i=9;
       @Override
       public void run() {
            while (true){
                synchronized (lock){
                    calc();
                }
            }
       }
       public void calc(){
            i++;
       }
   }
}
