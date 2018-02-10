package com.reflect.test;

public class Test {

	private static String strField="3";
	public String pubField="1";
	static{
		System.out.println("strField="+strField);
		System.out.println("run static block and not method");
	}
	{
		strField="2";
		System.out.println(strField);
	}
	public Test() {
		System.out.println("run constructor method");
	}
	public void sayHello(){
		System.out.println("hello");
	}
}
