package com.exception.test;

public class ExceptionTest {

	public static void main(String[] args) {
		String ss=ExceptionTest.getStr();
		System.out.println(ss);
	}
	@SuppressWarnings("null")
	public static String getStr(){
		String str=null;
		try{
			str.charAt(1);
		}catch(Exception e){
			System.out.println(e);
		}
		return "hello";
	}
}
