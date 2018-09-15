package com.lambda;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

import com.entity.Employee;

/**
 * 
 * @author xum890312
 * 方法引用：若lambda体中的功能已经有方法实现了，我们可以直接使用 ”方法引用“
 * 方法引用必须要保证引用方法和要实现的方法的签名要一致
 * 
 * 主要有三种语法格式：
 * 1.对象::实例方法名
 * 
 * 2.类::静态方法名
 * 
 * 3.类::实例方法名
 */
public class MethodRefDemo {

	@Test
	public void test1() {
		
		//对象::实例方法名
		Consumer<String> str = x->System.out.println(x);
		//直接应用prinln函数
		Consumer<String> str1 = System.out::println;
	}
	@Test
	public void test2() {
		//对象::实例方法名
		Employee ee = new Employee();
		Supplier<String> sup = ()->ee.getName();
		Supplier<String> sup1=ee::getName;
		Supplier<Integer> sup2 = ee::getAge;
	}
	@Test
	public void test3() {
		//类::静态方法名
		Comparator<Integer> com = (x,y)->Integer.compare(x, y);
		Comparator<Integer> com1 = Integer::compare;
 	}
	@Test
	public void test4() {
	//类::实例方法名 当lambda表达式的第一个参数是调用方，并且第二个参数是 函数的参数时，可以使用此方式
		BiPredicate<String, String> bp = (x,y)->x.equals(y);
		BiPredicate<String, String> bp1 = String::equals;

	}
	@Test
	//构造器引用
	public void test5() {
		Supplier<Employee> sup = ()->new Employee();
		Supplier<Employee> sup1 = Employee::new;
	}
}
