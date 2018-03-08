package com.effective.No1;

import java.util.HashMap;

public class TestDemo implements DemoInterface{
	public static DemoInterface getPrivateClass(){
		//返回一个非共有类的实例
		return new Test();
	}
	public  static <K,V> HashMap<K,V> newHashMap(){
		return new HashMap<K,V>();
	}
	@Override
	public void sayHello() {
	}
}
/**默认的包访问权限
 * @author fengchao
 */
class Test implements DemoInterface{
	public void sayHello(){
		System.out.println("hello,World");
	}
}
