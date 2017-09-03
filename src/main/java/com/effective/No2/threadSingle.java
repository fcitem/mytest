package com.effective.No2;

public class threadSingle extends Thread{

	public threadSingle() {
		start();
	}
	@Override
	public void run() {
		System.out.println(test.getInstance());   //当前线程第一次获取单例
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(test.getInstance());  //当前线程第2次获取单例，比较地址得出，它们是同一个对象
	}
}
class test{
	//创建一个线程本地变量,每个线程默认的保持着对ThreadLocal的一个引用
	private static final ThreadLocal<test> local=new ThreadLocal<test>();
	public static test getInstance(){
		if(local.get()==null){   //如果当前线程的ThreadLocal中的test为空则实例化
			local.set(new test());       //将实例化后的对象存入当前线程的ThreadLocal副本中，以便当前线程下一次做判断
		}
		return local.get();
	}
}
