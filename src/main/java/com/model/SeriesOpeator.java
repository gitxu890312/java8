package com.model;

import com.model.service.AddOperator;

/**
 * @Author xuming
 * @date 2019/2/16
 * @Version v1.0.0
 */
public class SeriesOpeator<T extends AddOperator> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
