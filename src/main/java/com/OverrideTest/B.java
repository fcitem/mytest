package com.OverrideTest;

class B extends A {
	//重载父类的方法
	public String show(B obj) {
		return ("B and B");
	}
	//重写父类的方法
	public String show(A obj){
		return ("B and A");
	}
}
