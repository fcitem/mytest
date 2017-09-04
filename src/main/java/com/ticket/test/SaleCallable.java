package com.ticket.test;

import java.util.concurrent.Callable;

/**模拟售票流程
 * @author fengchao
 * @date 2017年7月17日
 */
public class SaleCallable<V> implements Callable<Integer> {

	private int count = 15;
	Object obj = new Object();

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		while (count > 0) {
			System.out.println(Thread.currentThread().getName() + "窗口正在申请购票");
			Thread.sleep(1000);
			synchronized (obj) {
				if (count > 0) {
					System.out.println("第" + Thread.currentThread().getName() + "窗口出票成功,还剩" + --count + "张余票");
			   }
			}
		}
		return Integer.valueOf(count);
	       /*System.out.println(Thread.currentThread().getName()+"子线程在进行计算");
	        Thread.sleep(1000);
	        int sum = 0;
	        for(int i=0;i<100;i++)
	            sum += i;
	        return sum;*/
	    }
	}
