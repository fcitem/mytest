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
			throw new Exception("已经拥有一个实例对象不能再次创建");
		}
	}
	public void sayHello(){
		System.out.println("hello");
	}
	public static SingleTon getInstance(){
		return INSTANCE;
	}
	/**
	 * @author fengchao
	 * @data: 2016年10月6日
	 * @注释：readResolve方法允许class在反序列化返回对象前替换、解析在流中读出来的对象。
	 * 实现readResolve方法，一个class可以直接控制反序化返回的类型和对象引用
	 * 方法readResolve会在ObjectInputStream已经读取一个对象并在准备返回前调用
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
