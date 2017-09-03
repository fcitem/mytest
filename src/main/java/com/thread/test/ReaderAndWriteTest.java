package com.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderAndWriteTest {

	ReentrantLock readlock=new ReentrantLock();          //读锁
	ReentrantLock writelock=new ReentrantLock();            //写锁
	Condition canread= readlock.newCondition();      //获取读锁的条件
	Condition canwrite=writelock.newCondition();     //获取写锁的条件
	CountDownLatch latch=new CountDownLatch(40);
	class ReaderTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				readlock.lock();
			}
		}
		
	}
	class WriteTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
