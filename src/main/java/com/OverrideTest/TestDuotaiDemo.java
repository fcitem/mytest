package com.OverrideTest;

public class TestDuotaiDemo {
	public static void main(String[] args) {
		 A a1 = new A();
	     A a2 = new B();
	     B b = new B();
	     C c = new C();   
	     D d = new D();
	     System.out.println(a1.show(b));  //A and A
	     System.out.println(a1.show(c));  //A and A
//	     System.out.println(a1.show(a2));   //动态单分派,根据传进去参数的声明类型确定重写方法
	     System.out.println(a1.show(d));  //A and D
	     System.out.println(a2.show(b));  //B and A
	     System.out.println(a2.show(c));  //B and A
	     System.out.println(a2.show(d));  //A and D
	     System.out.println(b.show(b));   //B and B
	     System.out.println(b.show(c));   //B and B
	     System.out.println(b.show(d));   //A and D
	}
}
