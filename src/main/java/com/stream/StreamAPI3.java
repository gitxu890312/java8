package com.stream;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.entity.Employee;
import com.entity.Employee.Status;

/**
 * 规约和收集
 * 
 * @author xum890312
 *
 */
public class StreamAPI3 {
	List<Employee> employes = Arrays.asList(new Employee("张三", 18, 5555), new Employee("李四", 38, 8888),
			new Employee("王五", 28, 6666), new Employee("赵六", 50, 7777), new Employee("田七", 8, 9999),
			new Employee("将八", 66, 4444), new Employee("久久", 20, 2222), new Employee("久久", 20, 2222),
			new Employee("久久", 20, 2222));

	List<Employee> employes1 = Arrays.asList(new Employee("张三", 18, 5555, Status.BUSY),
			new Employee("李四", 38, 8888, Status.FREE), new Employee("王五", 28, 6666, Status.BUSY),
			new Employee("赵六", 50, 7777, Status.VOLICITY), new Employee("田七", 8, 9999, Status.FREE),
			new Employee("将八", 66, 4444, Status.VOLICITY), new Employee("久久", 20, 2222, Status.VOLICITY));

	@Test
	public void test() {
		Employee ee = new Employee("reduce", 100, 0);
		Employee reduce = employes.stream().reduce(new Employee(), (e1, e2) -> {
			ee.setSalary(e1.getSalary() + e2.getSalary());
			return ee;
		});
		System.out.println(reduce);

		Optional<Employee> reduce2 = employes.stream()
				.reduce((x, y) -> new Employee("11", 22, x.getSalary() + y.getSalary()));
		System.out.println(reduce2);
	}

	/**
	 * 收集
	 */
	@Test
	public void test2() {
		List<String> collect = employes.stream().map(item -> item.getName()).collect(Collectors.toList());
		System.out.println(collect);

		Set<String> collect2 = employes.stream().map(item -> item.getName()).collect(Collectors.toSet());
		System.out.println(collect2);
		// 收集成指定的集合类型
		LinkedHashSet<String> collect3 = employes.stream().map(item -> item.getName())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(collect3);
		//
		Long collect4 = employes.stream().collect(Collectors.counting());
		long count = employes.stream().count();
		System.out.println(collect4 == count);
		// 收集平均值
		Double collect5 = employes.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(collect5);

		Double collect6 = employes.stream().map(item -> item.getSalary()).collect(Collectors.summingDouble(ite -> ite));
		System.out.println(collect6);

		List<Employee> employes = Arrays.asList(new Employee("张三", 18, 5555), new Employee("李四", 38, 8888),
				new Employee("王五", 28, 6666), new Employee("赵六", 50, 7777), new Employee("田七", 8, 9999),
				new Employee("将八", 66, 4444), new Employee("久久", 20, 2222));
		Map<String, Double> collect7 = employes.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));
		System.out.println(collect7);

		Map<Status, List<Employee>> collect8 = employes1.stream().collect(Collectors.groupingBy(Employee::getStatus));
		
				Map<Status, Map<String, List<Employee>>> collect9 = employes1.stream().collect(Collectors.groupingBy(e -> e.getStatus(),Collectors.groupingBy((e)->{
					Employee f = ((Employee)e);
					if( f.getAge()>50) {
						return "老年";
					}
					return "青年";
				})));

		System.out.println(collect9);
	}

}
