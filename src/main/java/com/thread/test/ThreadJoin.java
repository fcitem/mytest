package com.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * 测试join方法
 * 
 * @author fengchao
 * @data 2017年3月24日
 */
public class ThreadJoin {

	public static void main(String[] args) {
		/*
		 * Thread thread=new Thread(new Mythread(0)); Thread thread2=new
		 * Thread(new Mythread(1)); thread.joi; thread2.start();
		 */
		Mythread t2 = new Mythread(2);
		t2.start();
		Mythread thread = new Mythread(1, t2);
		thread.start();
		Thread notify = new Thread(new NotifyThread(thread));
		notify.start();
	}
}

class Mythread extends Thread {

	int number;
	Mythread thread2; // 子线程1

	public Mythread(int num, Mythread thread2) {
		this.number = num;
		this.thread2 = thread2;
	}

	public Mythread(int num) {
		this.number = num;
		this.thread2 = null;
	}

	@Override
	public void run() {
		try {
			if (thread2 != null) {
				thread2.join();
			} else {
				TimeUnit.SECONDS.sleep(30);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("第" + number + "个线程执行");
	}

	public void notifyThread() {
		synchronized (thread2) {
			if (thread2 != null) {
				thread2.notifyAll();
			}
		}
	}
}

class NotifyThread implements Runnable {

	private Mythread thread;

	public NotifyThread(Mythread t) {
		this.thread = t;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.notifyThread();
	}
}
