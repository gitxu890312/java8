package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.entity.Employee;
/**
 * 
 * @author xum890312
 * 流的三个操作步骤
 * 1.创建流
 * 
 * 2.中间操作
 * 
 * 3.终止操作
 */
public class StreamCreateDemo {

	List<Employee> employes = Arrays.asList(
			new Employee("张三", 18, 5555),
			new Employee("李四", 38, 8888),
			new Employee("王五", 28, 6666),
			new Employee("赵六", 50, 7777),
			new Employee("田七", 8, 9999),
			new Employee("将八", 66, 4444),
			new Employee("久久", 20, 2222)
			);
	//创建流
	@Test
	public void test1() {
		//1.collection 系列集合提供的stream() 或 parallelStream()
		Stream<Employee> parallelStream = employes.parallelStream();
		Stream<Employee> stream = employes.stream();
		System.out.println("------------");
		
		//2.数组创建流 Arrays.stream();
		DoubleStream stream1 = Arrays.stream(new double[] {1.0,2.0});
		Stream<Object> stream2 = Arrays.stream(employes.toArray());
		
		//3.Stream.of 创建流
		Stream<String> stream3 = Stream.of("123","456","789");
		
		//4创建无限流
//		Stream.iterate(0, x->x+2).forEach(System.out::println);;
		Stream.iterate("123", x->x+"1").forEach(x->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(x);	
		});;
	}
	public void test2() {
		
	}
}
