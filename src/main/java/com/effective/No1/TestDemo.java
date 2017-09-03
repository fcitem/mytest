package com.effective.No1;

import java.util.HashMap;

public class TestDemo extends test{
	public static TestDemo getPrivateClass(){
		return new TestDemo();
	}
	public  static <K,V> HashMap<K,V> newHashMap(){
		return new HashMap<K,V>();
	}
}
//包访问权限
class test{
	public void sayHello(){
		System.out.println("hello,World");
	}
}