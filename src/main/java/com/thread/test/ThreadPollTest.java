package com.thread.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPollTest {

	public static void main(String[] args) {
		AtomicInteger count=new AtomicInteger(1);
//		SynchronouQueue<Runnable> queue=new SynchronousQueue<>();
		BlockingQueue<Runnable> queue=new ArrayBlockingQueue<>(20);
		ThreadPoolExecutor executor=new ThreadPoolExecutor(10,15,1,TimeUnit.MINUTES,queue,Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
		CyclicBarrier barrier=new CyclicBarrier(100);
		for (int i = 0; i < 100; i++) {
			try{
				executor.execute(new runtask(barrier));
			}catch (RejectedExecutionException e) {
				// TODO: handle exception
				count.incrementAndGet();
				System.out.println(Thread.currentThread().getName()+"被拒绝");
				executor.shutdown();
			}
		}
		System.out.println("被拒绝的总数为:"+count);
		executor.shutdown();
	}
}
class runtask implements Runnable{

	CyclicBarrier barrier;
	
	public runtask(CyclicBarrier barrier) {
		this.barrier=barrier;
	}
	@Override
	public void run() {
		try {
			barrier.await();
			System.out.println(System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
