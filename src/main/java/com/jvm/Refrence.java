package com.jvm;

public class Refrence {

	public static void main(String[] args) {
	
		A a=new A();
		a.setName("fc");
		System.out.println(a.getName());
		test(a);
		System.out.println(a.getName());
	}
	static void test(A a){
		A b=new A();
		b.setName("hhj");
		a=b;
	}
}
class A{
	String name;
	public A() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}