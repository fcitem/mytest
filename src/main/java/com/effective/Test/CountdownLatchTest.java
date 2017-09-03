package com.effective.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fengchao
 * @date 2017年1月20日
 * @注释 锁存器
 */
public class CountdownLatchTest {

	/**
	 * @author fengchao
	 * @date 2016年12月26日
	 * @param concurreny 并发执行的数量
	 * @param thread 线程
	 */
	public static long time(Executor executor,int concurrency){
		CountDownLatch ready =new CountDownLatch(concurrency);
		CountDownLatch start =new CountDownLatch(1);      //初始化start
		CountDownLatch done =new CountDownLatch(concurrency);
		long startnaons=0;
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new countwork(i,ready,start,done));
		}
		try {
			ready.await();          //等待
			startnaons=System.nanoTime();
			start.countDown();      //start-1到零，开始执行
			done.await();       // 等待
			System.out.println("执行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return System.nanoTime()-startnaons;
	}
	public static void main(String[] args) {     //corePoolSize 线程池初始化时能够执行的数量    //maximumPoolSize 最大执行数量 
		Executor exc=new ThreadPoolExecutor(10,10, 3000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(10));
		time(exc, 10);
	}
}

class countwork implements Runnable{

	int number ;

	CountDownLatch ready,start,done;
	public countwork(int number,CountDownLatch ready,CountDownLatch start,CountDownLatch done) {
		this.number=number;
		this.ready=ready;
		this.start=start;
		this.done=done;
	}
	@Override
	public void run() {
		ready.countDown();
		try {
			System.out.println("第 "+number+" 个线程启动");
			start.await();
			System.out.println("第 "+number+" 个线程执行");
			done.countDown();
			System.out.println("第 "+number+" 个线程执行完成");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}