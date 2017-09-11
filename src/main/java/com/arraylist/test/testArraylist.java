package com.arraylist.test;

import java.util.ArrayList;
import java.util.List;

public class TestArraylist {

	public static void main(String[] args) {
		String name=new String("herllo");     //变量存储的是引用，而不是引用本身！及存的是引用字符串的引用的地址
		System.out.println(name.getClass().hashCode());
		new TestArraylist().test(name);
		System.out.println(name.getClass().hashCode());
		System.out.println(name);
		StringBuilder builder=new StringBuilder("sds");
		new TestArraylist().testStringBuilder(builder);
		System.out.println(builder);
		TestArraylist.testIterator();
		new TestArraylist().testFinal();
	}
	public int returnfinal(){
		int number=1;
		try{
			return number;
		}finally {
			++number;
		}
	}
	public void test(String str){
		str="fc";
		System.out.println(str.getClass().hashCode());
	}
	public void testStringBuilder(StringBuilder builder){
		builder.append("sds");
	}
	public synchronized final void testFinal() {
		synchronized (this) {
			System.out.println("this is final");
		}
	}
	public static void testIterator(){
		List<String> list=new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		for (String string : list) {
			if("2".equals(string)){
				list.remove(string);
			}
		}
	}
}
