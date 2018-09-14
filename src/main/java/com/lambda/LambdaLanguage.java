package com.lambda;
/**
 * 
 * @author xum890312
 *Lambda 表达式的基础语法：Java8中引入了一个新的操作符 -> 该操作符称为箭头操作符或Lambda操作符
 * 箭头操作符将Lambda 表达式拆分成两部分
 * 
 * 左侧：表达式的参数列表
 * 右侧：表达式的执行的功能，及Lambda体
 * 
 *  语法格式1：无参数，无返回值
 *  Runnable run = ()->System.out.println("hello lambda");
 *  
 *  语法格式2：一参数，无返回值.若只有一个参数()可以省略不写
 *  (x)->system.out.println(x);
 *  
 *  语法格式3：若有多个参数，有返回值
 *  
 *  Comparator<Integer> com = (x,y)->{
 *  	System.out.println("aabbcc");
 * 		return Integer.compare(x,y);
 *  };
 */
public class LambdaLanguage {

	public void test() {
		Runnable run = ()->System.out.println("hello lambda");
		int i =1;
		
	}
}
