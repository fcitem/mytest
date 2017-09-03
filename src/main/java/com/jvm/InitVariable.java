package com.jvm;

/**
 * @author fengchao
 * @data 2017年4月14日
 * 测试哪些变量可以未初始化，系统便可以默认初始化默认值
 */
public class InitVariable {

	//非局部变量才可以被系统默认赋初始值
	public String str;
	public int number;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static void main(String[] args) {
		//方法中的局部变量不能默认初始化，需要手动赋值初始化
//		static int num;
		//String string;
		//System.out.println(string);
	}
}
