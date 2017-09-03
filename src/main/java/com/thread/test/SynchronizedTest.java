package com.thread.test;

/**
 * @author fengchao
 * @data 2017年3月24日
 * 测试同步synchronizd的作用
 */
public class SynchronizedTest {

	/*static volatile boolean flag=true;*/              //加上volatile关键字后能够保证所有线程对变量的改变对其它线程是可见的
	static boolean flag=true;
	public synchronized static boolean isFlag() {//加上synchronized关键字后能够保证所有线程对变量的改变对其它线程是可见的,也就是synchronized在这种情况下是为了线程间的通信，而不是为了互斥
		return flag;
	}
	public synchronized static void setFlag(boolean flag) {
		SynchronizedTest.flag = flag;
	}
	/**
	 * @author fengchao
	 * @data 2017年3月24日
	 * @注释 未对变量加同步导致后台线程对变量的改变让主线程无法看到。
	 */
//	public static void main(String[] args) throws InterruptedException {
//		Thread t=new Thread(new Runnable() {
//			public void run() {
//				// TODO Auto-generated method stub
//				while(flag){
//					;
//				}
//				System.out.println("over");
//			}
//		});
//		t.start();
//		Thread.sleep(1000);
//		SynchronizedTest.flag=false;
//	}
	public static void main(String[] args) {
		Thread t1=new Thread(new mytest());
		Thread t2=new Thread(new mytest2());
		t1.start();
		t2.start();
	}
	static class mytest implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isFlag()){
				
			}
			System.out.println("over");
		}
	}
	static class mytest2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
				setFlag(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}