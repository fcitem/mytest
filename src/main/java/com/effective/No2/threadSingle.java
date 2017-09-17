package com.effective.No2;

public class threadSingle extends Thread{

	public threadSingle() {
		start();
	}
	@Override
	public void run() {
		System.out.println(test.getInstance());   
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(test.getInstance());  
	}
}
class test{
	private static final ThreadLocal<test> local=new ThreadLocal<test>();
	public static test getInstance(){
		if(local.get()==null){   
			local.set(new test());       
		}
		return local.get();
	}
}
