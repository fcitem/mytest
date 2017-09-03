package com.effective.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fengchao
 * @date 2017年1月20日
 * @注释 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点,保证所有等待线程几乎同时执行
 * 
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier;
		barrier=new CyclicBarrier(10, new Runnable() {   //同步辅助类屏障点的执行条件是10条线程都达到await状态
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("���ϵ�ִ��!");
			}
		});
		ExecutorService exc=Executors.newFixedThreadPool(10);
		long start=System.nanoTime();
		for (int i = 0; i < 10; i++) {
			exc.execute(new work(i,barrier));       //开线程池与new Thread的区别不体现在时间上，而是体现在线程内存的利用上面
//			new Thread(new work(i,barrier)).start();
		}
		exc.shutdown();
		System.out.println(System.nanoTime()-start);
	}

}
class work implements Runnable{

	int number;
	CyclicBarrier barrier;
	/**
	 * @param number 
	 * @param barr  同步辅助类
	 */
	public work(int number,CyclicBarrier barr) {
		// TODO Auto-generated constructor stub
		this.number=number;
		this.barrier=barr;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(number);
		try {
			barrier.await();
			System.out.println(System.currentTimeMillis());
			System.out.println("第 "+this.number+" 个任务执行完成");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}