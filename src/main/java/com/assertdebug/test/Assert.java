package com.assertdebug.test;

/**
 * @author fengchao
 * @data 2017年3月23日
 * 测试断言机制，默认运行时是关闭的，用-ea开启
 */
public class Assert {
	public static void test(int number){
		assert number>0:"assert faile";
		System.out.println("assert success");
	}
	public static void main(String[] args) {
		Assert.test(-5);
	}
}
