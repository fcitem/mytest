package com.jvm;

/**测试类的初始化顺讯
 * @author fengchao
 *
 */
public class InitOrder {

	public InitOrder() {
		this.say();   //调用子类重写实现的方法
	}
	public void say() {
		System.out.println("parent say:hello");
	}
	public static void main(String[] args) {
		new SubClass();
	}
}
class SubClass extends InitOrder{
	private static int stanumber=2;
	private int number=3;
	@Override
	public void say() {
		System.out.println("son say number="+number);   //实例化的时候父类构造函数调用了被重写的方法say,导致引用到了还未赋值的变量。这儿为默认值0
		System.out.println("son say static number="+stanumber);
	}
}
