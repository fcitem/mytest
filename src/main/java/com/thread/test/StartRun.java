package com.thread.test;

/**
 *测试start和run方法的区别
 * @author fengchao
 *
 */
public class StartRun {

	public static void main(String[] args) {
		Thread t=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("b");
			}
		});
		//start方法相当于新开线程执行任务。那么输出结果依赖于哪个线程执行快
		//t.start();
		//run方法相当于普通方法调用。那么输出结果一定是按顺序执行输出
		t.run();
		System.out.println("a");
	}
}
