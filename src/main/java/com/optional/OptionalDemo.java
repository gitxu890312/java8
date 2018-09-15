package com.optional;

import java.util.Optional;

import org.junit.Test;

/**
 * 
 * @author xum890312
 * 防止空指针异常的类
 */
public class OptionalDemo {

	@Test
	public void test() {
		Optional<String> of = Optional.of("123");
		System.out.println(of.get());
		System.out.println(of.isPresent());
		System.out.println(of.orElse("456"));
		System.out.println("-----------");
		Optional<Object> empty = Optional.empty();
		System.out.println(empty.isPresent());
		System.out.println(empty.orElse("111"));
//		System.out.println(empty.get());
		
		System.out.println("-----------");
		
		Optional<Object> ofNullable = Optional.ofNullable(null);
			
	}
}
