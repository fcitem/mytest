package com.arraylist.test;

public class testArraylist {

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
		new testArraylist().test(name);
		System.out.println(name.getClass().hashCode());
		System.out.println(name);
		StringBuilder builder=new StringBuilder("sds");
		new testArraylist().testStringBuilder(builder);
		System.out.println(builder);
	}
	public void test(String str){
		str="fc";
		System.out.println(str.getClass().hashCode());
	}
	public void testStringBuilder(StringBuilder builder){
		builder.append("sds");
	}
}
