package com.thread.test;

public interface Reentryable {

	/**加锁
	 * @throws InterruptedException
	 */
	public void lock() throws InterruptedException;
	
	/**
	 *释放锁 
	 */
	public void unlock();
}
