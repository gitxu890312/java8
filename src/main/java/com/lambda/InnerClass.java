package com.lambda;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * @author xum890312 简化匿名内部类
 */
public class InnerClass {

	@Test
	public void test1() {
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		TreeSet<Integer> set = new TreeSet<>(com);
	}

	public void test2() {
		//Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		//Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x, y);
		Comparator<Integer> com = (Integer x, Integer y) -> {
			int i = 1;
			return Integer.compare(x, y);
		};
		TreeSet<Integer> set = new TreeSet<>(com);
	}

}
