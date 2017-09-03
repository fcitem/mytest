package com.thread.test;

import java.util.concurrent.Semaphore;

/**
 * @author fengchao
 * @data 2017年3月28日
 * sempaphore信号量使用测试，模拟池
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		Pool pool=new Pool();
		System.out.println(pool.getSemphore().availablePermits());          //10
		System.out.println(pool.getItem());                   
		System.out.println(pool.getSemphore().availablePermits());              //9
		pool.returnItem(2);
		System.out.println(pool.getSemphore().availablePermits());              //20
	}
}
class Pool{
	private static final int MAX_AVAILABLE=10;            //最大可访问数量，当值为1时可用作相互排斥的锁
	private Semaphore sem=new Semaphore(MAX_AVAILABLE,true);
	private boolean[] array=new boolean[10];
	private Object[] itemArray=new Object[10];
	public Pool() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < array.length; i++) {
			itemArray[i]=i+1;
			array[i]=true;
		}
	}
	public Object getItem(){          //获取一个连接
		try {
			sem.acquire();                  //申请获取可用许可，信号量减一
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < array.length; i++) {
			if(array[i]){
				array[i]=false;              //置于当前状态为不可用状态
				return itemArray[i];
			}
		}
		return null;
	}
	public void returnItem(Object obj){         
		//返回一个连接
		sem.release();                //释放信号量，信号量加一                    
		for (int i=0;i<itemArray.length;i++) {
			if(itemArray[i].equals(obj)){
				array[i]=true;              ////置于当前状态为可用状态
			}
		}
	}
	public Semaphore getSemphore(){
		return this.sem;
	}
}
