package com.forkjoin.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**利用Forkjoin 计算任务 1+2+...+n
 * @author fengchao
 * 有返回值的异步实现
 */
public class Task extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = 1L;
	private static final int THRESHORT=2; //阈值
	private int start=0;
	private int end=0;
	
	public Task(int start,int end) {
		this.start=start;
		this.end=end;
	}

	@Override
	protected Integer compute() {
		int sum=0;
		boolean isCompute=(end-start)<=THRESHORT;          //是否开始计算
		if(isCompute){
			for (int i = start; i <= end; i++) {
				sum+=i;
			}
		}
		else{           //否则拆分任务
			int middle=(start+end)/2;
			Task leftTask=new Task(start, middle);
			Task rightTak=new Task(middle+1, end);
			//执行子任务 fork为异步调用/invokeAll为同步调用
			leftTask.fork();
			rightTak.fork();
			//同步调用
//			invokeAll(leftTask, rightTak);
			//得到执行结果，不能被中断
			int sumLeft=leftTask.join();
			int sumRight=rightTak.join();
			sum=sumLeft+sumRight;
		}
		return sum;
	}
	public static void main(String[] args) {
		ForkJoinPool pool=new ForkJoinPool();
		Task task=new Task(1,10000);
		long start=System.currentTimeMillis();
		pool.submit(task);
		try {
			System.out.println(task.get());
			System.out.println(System.currentTimeMillis()-start);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
