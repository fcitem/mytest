package com.ticket.test;

public class SaleThread implements Runnable {

	int count=15;
	Object obj=new Object();
	volatile boolean hasTicket=true;
	public SaleThread() {
	}
	@Override
	public void run() {
		while(hasTicket){
			synchronized (obj) {
				if(count--<=0){
					hasTicket=false;
				}
				else{
					System.out.println("第"+Thread.currentThread().getName()+"窗口出票成功,还剩"+count+"张余票");
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
