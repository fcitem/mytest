package com.sort.test;

import java.util.ArrayList;

/**
 * @author fengchao
 * @data 2017年3月28日
 * 测试死锁
 */
public class mytest {
	
	public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        System.out.println(list.contains(null));
		Object obj=new Object();
		Object obj2=new Object();
		new DeadThread(obj,obj2).start();
		new DeadThread(obj2,obj).start();
		
	}
}
class DeadThread extends Thread{
	Object obj;
	Object obj2;
	public DeadThread(Object obj,Object obj2) {
		this.obj=obj;
		this.obj2=obj2;
	}
	public void run(){

		while(true){
			synchronized (obj) {
				System.out.println("sdsd");
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("hahha");
				}
			}
			
		}
	}
}