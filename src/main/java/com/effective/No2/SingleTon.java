package com.effective.No2;

import java.io.Serializable;

public class SingleTon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static transient final SingleTon INSTANCE=new SingleTon();
	private SingleTon(){
		
	}
	private SingleTon(String str) throws Exception{
		if(INSTANCE!=null){
			throw new Exception("");
		}
	}
	public void sayHello(){
		System.out.println("hello");
	}
	public static SingleTon getInstance(){
		return INSTANCE;
	}
	/**
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
