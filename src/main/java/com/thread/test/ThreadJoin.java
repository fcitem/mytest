package com.thread.test;

/**
 * @author fengchao
 * @data 2017年3月24日
 * 测试join方法
 */
public class ThreadJoin {

	public static void main(String[] args) {
		/*Thread thread=new Thread(new Mythread(0));
		Thread thread2=new Thread(new Mythread(1));
		thread.joi;
		thread2.start();*/
		Mythread t2=new Mythread(2);
		Mythread t3=new Mythread(3);
		t2.start();
		t3.start();
		Mythread thread=new Mythread(1, t2, t3);
		thread.start();
	}
}
class Mythread extends Thread{

	int number;
	Mythread thread2;
	Mythread thread3;
	public Mythread(int num,Mythread thread2,Mythread thread3) {
		this.number=num;
		this.thread2=thread2;
		this.thread3=thread3;
	}
	public Mythread(int num) {
		this.number=num;
		this.thread2=null;
		this.thread3=null;
	}
	@Override
	public void run() {
		while(true){
			try {
				if(thread2!=null&&thread3!=null){
					thread3.join();
					thread2.join();
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("第"+number+"个线程执行");
	}
}
