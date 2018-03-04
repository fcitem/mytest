package com.jvm;

/**函数调用传值
 * @author fengchao
 *
 */
public class Refrence {

	public static void main(String[] args) {
	
		A a=new A();
		a.setName("fc");
		System.out.println(a.getName());
		test(a);
		System.out.println(a.getName());
	}
	/**a是A对象的一个副本
	 * @param a
	 */
	static void test(A a){
		A b=new A();
		b.setName("hhj");
		a=b;         //只是改变的副本的指向,原始值的指向没有改变
	}
}
class A{
	String name;
	public A() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}