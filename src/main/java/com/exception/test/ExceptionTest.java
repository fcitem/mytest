package com.exception.test;

import java.lang.reflect.UndeclaredThrowableException;

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
		}catch(UndeclaredThrowableException e){
			System.out.println(e.getUndeclaredThrowable());
		}
		return "hello";
	}
}
