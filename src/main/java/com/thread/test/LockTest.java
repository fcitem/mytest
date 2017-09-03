package com.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author fengchao
 * @data 2017年3月28日
 * 测试Lock以及ReentrantReadWriteLock类,具体应用读者写者问题
 */
public class LockTest {
	
	public static void main(String[] args) {
		ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
		WriteLock wlock= lock.writeLock();
		ReadLock rlock= lock.readLock();
		CountDownLatch latch=new CountDownLatch(40);
		for (int i = 0; i < 20; i++) {
            new Thread(new WriteTask(wlock,latch)).start();
            new Thread(new ReaderTask(rlock, latch)).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
class ReaderTask implements Runnable{
	ReadLock lock;
	CountDownLatch latch;
	public ReaderTask(ReadLock lock,CountDownLatch latch) {
		this.lock=lock;
		this.latch=latch;
	}
	@Override
	public void run() {
		latch.countDown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.lock.lock();
		System.out.println(Thread.currentThread().getName()+"正在读");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"读完成");
		this.lock.unlock();
	}
	
}
class WriteTask implements Runnable{

	WriteLock lock;
	CountDownLatch latch;
	public WriteTask(WriteLock lock,CountDownLatch latch) {
		this.lock=lock;
		this.latch=latch;
	}
	@Override
	public void run() {
		latch.countDown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.lock.lock();
		System.out.println(Thread.currentThread().getName()+"正在写");
		System.out.println(Thread.currentThread().getName()+"写完成");
		this.lock.unlock();
	}
}
