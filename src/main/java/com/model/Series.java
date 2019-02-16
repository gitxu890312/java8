package com.model;

import com.model.service.AddOperator;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author xuming
 * @date ${date}
 * @Version v1.0.0
 */
public class Series<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * 函数参数的泛型
     * @param e
     * @param <E>
     */
    public <E> void muti(E e){
        System.out.println(e);
    }

    /**
     * 返回值的泛型
     * @param obejct
     * @return
     */
    public  T calc(Object obejct){
        return t;
    }

    /**
     * 多个参数泛型
     * @param m
     * @param n
     * @param <M>
     * @param <N>
     */
    public <M extends AddOperator,N,P> P testMuti(M m,N n,P p){
        System.out.println(m+""+n);
        return p;
    }

    /**
     * 方法的泛型和类的泛型并不是同一个类型
     * @param t
     * @param <T>
     */
    public <T> void testSame(T t){
        System.out.println(t);
    }
    public static <T> void testStatic(Object o,T t){
        System.out.println(o);
        System.out.println( t);
    }
    public static void main(String[] args) {
        Series.testStatic(new ArrayList<>(),"aaaa");
        System.out.println("------------------");
        Series<Double> series = new Series<>();
        series.setT(444.0);
        System.out.println(series.getT());
        System.out.println("------------------");
        series.muti(new Date());
        System.out.println("------------------");
        System.out.println(series.calc(new ArrayList<>()));
        System.out.println("------------------");
        series.testSame(new Date());
    }

}
