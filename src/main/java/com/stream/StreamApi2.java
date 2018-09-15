package com.stream;

import static org.hamcrest.CoreMatchers.any;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

import com.entity.Employee;
import com.entity.Employee.Status;

/**
 * 
 * @author xum890312
 * stream的查找与匹配
 */
public class StreamApi2 {

	List<Employee> employes = Arrays.asList(
			new Employee("张三", 18, 5555,Status.BUSY),
			new Employee("李四", 38, 8888,Status.FREE),
			new Employee("王五", 28, 6666,Status.BUSY),
			new Employee("赵六", 50, 7777,Status.VOLICITY),
			new Employee("田七", 8, 9999,Status.FREE),
			new Employee("将八", 66, 4444,Status.VOLICITY),
			new Employee("久久", 20, 2222,Status.VOLICITY)
			);
	/**
	 * 
	 */
	@Test
	public void test() {
		//allMatch 所有的元素都满足条件时返回true
		boolean allMatch = employes.stream().allMatch(item->item.getStatus()==Status.BUSY);
		System.out.println(allMatch);
		System.out.println("-------------");
		//anyMatch 只有一个满足条件既返回true
		boolean anyMatch = employes.stream().anyMatch(item->item.getStatus()==Status.FREE);
		System.out.println(anyMatch);
		System.out.println("-------------");
		//none所有的元素都不匹配 返回true
		boolean noneMatch = employes.stream().noneMatch(item->item.getStatus()==null);
		System.out.println(noneMatch);
		System.out.println("-------------");
		//findFirst 返回第一个元素
		Optional<Employee> findFirst = employes.stream().findFirst();
		System.out.println(findFirst.get());
		System.out.println("-------------");
		//返回任意一个元素 随机性较差
		Optional<Employee> findAny = employes.parallelStream().findAny();
		System.out.println(findAny.get());
		System.out.println("-------------");
		
		long count = employes.stream().filter(item->item.getStatus()==Status.BUSY).count();
		System.out.println(count);
		System.out.println("-----------------");
		//取最大的元素
		 Optional<Employee> max = employes.stream().max((e1,e2)-> (int)(e1.getSalary()-e2.getSalary()));
		System.out.println(max.get());
	}
}
