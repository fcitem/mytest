package com.arraylist.test;

import java.util.ArrayList;
import java.util.List;

public class TestArraylist {

	public static void main(String[] args) {
//		ArrayList<Integer> list=new ArrayList<Integer>();
//		for (int i = 0; i < 10; i++) {
//			list.add(i);
//		}
//		System.out.println(list.size());
//		list.remove(0);
//		System.out.println(list.size());
		String name=new String("herllo");     //变量存储的是引用，而不是引用本身！及存的是引用字符串的引用的地址
		System.out.println(name.getClass().hashCode());
		new TestArraylist().test(name);
		System.out.println(name.getClass().hashCode());
		System.out.println(name);
		StringBuilder builder=new StringBuilder("sds");
		new TestArraylist().testStringBuilder(builder);
		System.out.println(builder);
		TestArraylist.testIterator();
	}
	public void test(String str){
		str="fc";
		System.out.println(str.getClass().hashCode());
	}
	public void testStringBuilder(StringBuilder builder){
		builder.append("sds");
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
