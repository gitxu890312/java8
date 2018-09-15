package com.inter.method;
/**
 * 
 * @author xum890312
 * 当父类和接口中有相同的函数时，以类中的函数为主，接口中的会被忽略
 * 类优先原则
 */
public class InterfaceDemo /*extends MyClass*/ implements MyFaction,MyFaction2{
	public String hello() {
		//调用指定接口的默认实现
		return MyFaction2.super.hello();
	}
	public static void main(String[] args) {
		
		InterfaceDemo demo = new InterfaceDemo();
		System.out.println(demo.hello());
//		System.out.println(demo);
	}
}
