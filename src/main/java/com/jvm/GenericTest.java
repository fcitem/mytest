package com.jvm;

import java.util.ArrayList;

/**
 * @author fengchao
 * @data 2017年3月21日
 * 测试泛型的编译时构造
 */
public class GenericTest<T extends Base<T>> {

	public void test(T clas){
		System.out.println("hello");
	}
	public static void main(String[] args) {
		new GenericTest<Generic>().test(new Generic());
		//泛型只是存在于编译期，运行时会被擦除
		ArrayList<String> list=new ArrayList<String>();
		System.out.println(list.size());
	}
}
class Generic extends Base<Generic>{
	
}