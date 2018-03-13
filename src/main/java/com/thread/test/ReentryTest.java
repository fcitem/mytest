package com.thread.test;

/**测试可重入锁和不可重入锁(自旋锁)
 * @author fengchao
 */
public class ReentryTest{

	Reentryable reentry;     //锁
	public ReentryTest(Reentryable reenTry) {
		this.reentry=reenTry;
	}
	public void test(){
		try {
			reentry.lock();
			System.out.println("test run .............");
			reentry.unlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Reentryable lock=new NotReentry();
		ReentryTest reentryTest=new ReentryTest(lock);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						lock.lock();      //获取锁
						reentryTest.test();
						Thread.sleep(2000);
						lock.unlock();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
/**不可重入锁或自旋锁
 * @author fengchao
 */
class NotReentry implements Reentryable{
	private boolean isLocked;
	/**
	 * 获取锁的方法
	 * @throws InterruptedException 
	 */
	public synchronized void lock() throws InterruptedException{
		while (isLocked) {
			this.wait();
		}
		isLocked=true;
	}
	/**
	 * 释放锁
	 */
	public synchronized void unlock(){
		isLocked=false;
		notifyAll();
	}
}
/**可重入锁,ReentrantLock是代表
 * @author fengchao
 */
class ReentryLock implements Reentryable{
	private boolean isLocked;    //是否加锁
	private Thread thread;     //已经上锁的线程
	private int count;      //加锁次数
	public synchronized void lock() throws InterruptedException{
		Thread t=Thread.currentThread();
		while(isLocked&&thread!=t){
			wait();
		}
		isLocked=true;
		count++;
		thread=t;
	}
	public synchronized void unlock(){
		if(count==0){
			isLocked=false;
			notify();
		}else{
			count--;
		}
	}
}
