package com.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fengchao
 * @data 2017年3月28日
 * @注释 通过ReentrantLock的方式实现读者写者问题
 */
public class ReentrantLockTest {
	ReentrantLock readlock=new ReentrantLock();          //读锁
	ReentrantLock writelock=new ReentrantLock();            //写锁
	Condition canread= readlock.newCondition();      //获取读锁的条件
	Condition canwrite=writelock.newCondition();     //获取写锁的条件
	CountDownLatch latch=new CountDownLatch(20);
	public void test(){
		ReaderTask task=new ReaderTask();
		for (int i = 0; i < 20; i++) {
           /* new Thread(new WriteTask()).start();*/
            new Thread(task).start();
		}
		try {
			latch.await();
//			canwrite.signalAll();
//			canread.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ReentrantLockTest().test();
	}
	class ReaderTask implements Runnable{
		@Override
		public void run() {
			latch.countDown();
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.wait();
				writelock.lock();
				System.out.println(Thread.currentThread().getName()+"正在读");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"读完成");
				notifyAll();
				writelock.unlock();          //写锁加锁互斥
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	class WriteTask implements Runnable{

		@Override
		public void run() {
			latch.countDown();
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			writelock.lock();
			readlock.lock();
			System.out.println(Thread.currentThread().getName()+"正在写");
			System.out.println(Thread.currentThread().getName()+"写完成");
			notifyAll();
			writelock.unlock();
			readlock.unlock();
		}
	}

}
