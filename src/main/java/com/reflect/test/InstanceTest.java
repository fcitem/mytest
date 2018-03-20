package com.reflect.test;

/**测试class.forname方法与newinstance方法实例化区别
 * @author fengchao
 *
 */
public class InstanceTest {
	public static void main(String[] args) {
		try {
			//forName方法加载class字节流到内存为静态块分配内存并设置默认值，不会触发初始化
			Class<?> classObj= Class.forName("com.reflect.test.Test");
//			Method method=classObj.getMethod("sayHello");
			//newInstance方法会引发初始化块和初始化方法
			classObj.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
