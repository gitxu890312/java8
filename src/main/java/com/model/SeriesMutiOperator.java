package com.model;

import com.model.service.AddOperator;
import com.model.service.SubOperator;
import com.model.service.impl.AddOperatorImpl;
import com.model.service.impl.MutiOperatorImpl;

/**
 * @Author xuming
 * @date 2019/2/16
 * @Version v1.0.0
 */
public class SeriesMutiOperator<T extends AddOperator & SubOperator> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        //AddOperatorImpl没有同时实现两个泛型接口，不满足条件编译会报错
//        SeriesMutiOperator<AddOperatorImpl> addser = new SeriesMutiOperator<AddOperatorImpl>();

        //编译通过，MutiOperatorImpl实现了两个泛型接口
        SeriesMutiOperator<MutiOperatorImpl> muti = new SeriesMutiOperator<>();

    }
}
