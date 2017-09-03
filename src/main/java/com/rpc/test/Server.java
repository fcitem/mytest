package com.rpc.test;

/**
 * @author fengchao
 * 服务类接口
 */
public interface Server {

	public void stop();
	
	public void start();
	
	public void register(Class<?> serviceInterface,Class<?> serviceImpl);
	
	public boolean isRunning();
	
	public int getPort();
}
