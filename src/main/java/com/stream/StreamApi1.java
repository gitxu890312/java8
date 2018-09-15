package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.entity.Employee;
/**
 * 
 * @author xum890312
 *	filter--接收lambda，从流中排出某些元素
 * limit--截断流，使其元素不超过给定的数量
 * skip(n)---跳过元素，返回一个扔掉了前n个元素的流，若不足n个 返回一个空流，与limit互补
 * distinct--通过元素的equals、和hashcode 去除重复的元素
 *
 */
public class StreamApi1 {
	List<Employee> employes = Arrays.asList(
			new Employee("张三", 18, 5555),
			new Employee("李四", 38, 8888),
			new Employee("王五", 28, 6666),
			new Employee("赵六", 50, 7777),
			new Employee("田七", 8, 9999),
			new Employee("将八", 66, 4444),
			new Employee("久久", 20, 2222),
			new Employee("久久", 20, 2222),
			new Employee("久久", 20, 2222)
			);
	@Test
	public void test1() {
		employes.stream().filter(i -> i.getAge() > 25).forEach(System.out::println);
		System.out.println("-------------------");
		employes.stream().filter(i->i.getAge()>25).limit(1).forEach(System.out::println);
		System.out.println("-------------------");
		employes.stream().filter(i->i.getAge()>25).skip(1).limit(1).forEach(System.out::println);
		System.out.println("-------------------");
		employes.stream().filter(i->i.getAge()<25).forEach(System.out::println);
		System.out.println("-------------------");
		employes.stream().filter(i->i.getAge()<25).distinct().forEach(System.out::println);
		
	}
	/**
	 * map()
	 * flatmap()
	 */
	@Test
	public void test2() {
		Stream<String> map = employes.stream().map(emp->emp.getName());
		map.distinct().forEach(System.out::println);
		
	}
	/**
	 * sort() 自然排序 默认使用comparable接口排序
	 * sort(comparator) 自定义排序
	 */
	@Test
	public void test3() {
		List<String> asList = Arrays.asList("ccc", "ddd", "aaa", "gggg", "fff");
		asList.stream().sorted().forEach(System.out::println);
		System.out.println("-------------");
		asList.stream().sorted(String::compareTo).forEach(System.out::println);
		;
		System.out.println("-------------");
		employes.stream().sorted((e1, e2) -> e1.getAge() - e2.getAge()).forEach(System.out::println);
		;
	}
	/**
	 * 终止操作
	 * 查找与匹配 
	 */
	@Test
	public void test4() {
		
	}
}
