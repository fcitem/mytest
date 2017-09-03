package com.jvm;

import java.io.PrintStream;

public class ABtest {

	public static void method(int a,int b){
		System.out.println("a="+100);
		System.out.println("b="+200);
		System.exit(0);
	}
	public static void main(String[] args) {
		int a=10;
		int b=20;
		method2(a,b);
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	public static void method2(int a,int b){
		PrintStream out=new PrintStream(System.out){
			public void println(String str){
				if("a=10".equals(str)){
					str="a="+100;
				}
				else if("b=20".equals(str)){
					str="b="+200;
				}
				super.println(str);
			}
		};
	    System.setOut(out);
	}
}
