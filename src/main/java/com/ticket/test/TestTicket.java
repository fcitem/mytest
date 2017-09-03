package com.ticket.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author fengchao
 * @data 2017年3月28日
 * 卖票测试类
 */
public class TestTicket {

	/**
	 * @author fengchao
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @data 2017年3月17日
	 * @注释 测试runnable方法实现的卖票
	 */
	/*public static void main(String[] args) {
		ExecutorService service= Executors.newCachedThreadPool();
		SaleThread sale=new SaleThread();
		for (int j = 0; j < 5; j++) {
			service.submit(sale);
		}
		service.shutdown();
	}*/
	/**
	 * @author fengchao
	 * @data 2017年3月22日
	 * @注释 测试FutureTask实现的卖票
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service= Executors.newFixedThreadPool(10);
		SaleCallable<Integer> callable=new SaleCallable<Integer>();
//		Future<Integer> ret1=service.submit(callable);
//		Future<Integer> ret2=service.submit(callable);
//		Future<Integer> ret3=service.submit(callable);
//		Future<Integer> ret4=service.submit(callable);
//		Future<Integer> ret5=service.submit(callable);
		FutureTask<Integer> ret2=new FutureTask<>(callable);
		FutureTask<Integer> ret3=new FutureTask<>(callable);
		FutureTask<Integer> ret4=new FutureTask<>(callable);
		FutureTask<Integer> ret5=new FutureTask<>(callable);
		FutureTask<Integer> ret6=new FutureTask<>(callable);
		service.submit(ret2);
		service.submit(ret3);
		service.submit(ret4);
		service.submit(ret5);
		service.submit(ret6);
		while(ret2.get()==0||ret3.get()==0||ret4.get()==0||ret5.get()==0||ret6.get()==0){
			ret2.cancel(true);
			ret3.cancel(true);
			ret4.cancel(true);
			ret5.cancel(true);
			ret6.cancel(true);
			break;
		}
		if(ret2.isCancelled()==true){
			System.out.println("ret2出票失败，没有足够的票");
		}if(ret3.isCancelled()==true){
			System.out.println("ret3出票失败，没有足够的票");
		}if(ret4.isCancelled()==true){
			System.out.println("ret4出票失败，没有足够的票");
		}if(ret5.isCancelled()==true){
			System.out.println("ret5出票失败，没有足够的票");
		}if(ret6.isCancelled()==true){
			System.out.println("ret6出票失败，没有足够的票");
		}
		
//		for (int i = 0; i < 5; i++) {
//			ret=(FutureTask<Integer>) service.submit(callable);
//			new Thread(ret).start();
//			System.err.println("i===="+i);
//		}
		service.shutdown();
	}
}
