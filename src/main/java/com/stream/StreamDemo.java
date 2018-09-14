package com.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.entity.Employee;

public class StreamDemo {

	List<Employee> employes = Arrays.asList(
			new Employee("张三", 18, 5555),
			new Employee("李四", 38, 8888),
			new Employee("王五", 28, 6666),
			new Employee("赵六", 50, 7777),
			new Employee("田七", 8, 9999),
			new Employee("将八", 66, 4444),
			new Employee("久久", 20, 2222)
			);
	@Test
	public void test1() {
		employes.stream().filter(e -> e.getAge() > 38).forEach(i -> System.out.println(i));
		System.out.println();
	}
}
