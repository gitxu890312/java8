package com.inter.method;

public interface MyFaction {

	default public String hello() {
		return "interface";
	}
	public static void show() {
		System.out.println("show()");
	}
}
