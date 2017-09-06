package com.jvm;

/**
 * @author fengchao
 * @data 2017年4月14日
 *重载方法，javap反编译查看方法调用指令
 *invokevirtual指令
 */
public class Overload {
	
	class Daughter extends Overload{
		
	}
	class Son extends Overload{
		
	}
	public void test(Overload p){
		System.out.println("parent");
	}
	public void test(Daughter d){
		System.out.println("daughter");
	}
	public void test(Son s){
		System.out.println("son");
	}
	
	public static void main(String[] args) {
		Overload p=new Overload();
		Overload d=p.new Daughter();
		Son s=p.new Son();
		p.test(d);
		p.test(s);
	}

}
