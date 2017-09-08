package com.jvm;

public class Gctest {

	//4:2:2
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] array1,array2,array3,array4;
		array1=new byte[2 *1024*1024];
		array2=new byte[2 *1024*1024];
		array3=new byte[4 *1024*1024];         //出现Minor GC
		array4=new byte[2 *1024*1024];
	}
}
