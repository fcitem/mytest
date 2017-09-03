package com.parentToSon.test;

public class Test {

	public static void main(String[] args) {
//		ParentClass pp=new ParentClass();
//		SonClass son=(SonClass)pp;
		ParentClass pp=new SonClass();
		SonClass son=(SonClass) pp;
		son.sayHello();
	}
}
