package com.model.service.impl;

import com.model.service.AddOperator;
import com.model.service.SubOperator;

/**
 * @Author xuming
 * @date 2019/2/16
 * @Version v1.0.0
 */
public class MutiOperatorImpl implements AddOperator,SubOperator {
    @Override
    public void add() {
        System.out.println("muti add");
    }

    @Override
    public void sub() {
        System.out.println("muti sub");
    }
}
