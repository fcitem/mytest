package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengchao
 * @data 2017年3月21日
 * 测试泛型的编译时构造
 */
public class GenericTest<T extends Base> {

	public void test(Class<? extends GenericTest> clas){
		System.out.println("hello");
	}
	public static void main(String[] args) {
		new GenericTest().test(Generic.class);
		//泛型只是存在于编译期，运行时会被擦除
		ArrayList<String> list=new ArrayList<String>();
	}
}
class Generic extends GenericTest{
	
}