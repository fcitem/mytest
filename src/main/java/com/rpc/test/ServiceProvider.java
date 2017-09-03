package com.rpc.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceProvider implements Server {

	
	/**
	 * 返回当前运行环境的处理器数量
	 */
	private static ExecutorService executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	public static final HashMap<String,Class<?>> serviceRegistry=new HashMap<String,Class<?>>();   //存放注册的server
	public static boolean isRunning=false;
	public static int port;
	public ServiceProvider(int port) {
		ServiceProvider.port=port;
	}
	@Override
	public void stop() {
		ServiceProvider.isRunning=false;
		executor.shutdown();            //停止所有正在执行的活动任务
	}
	@Override
	public void start() {
		ServerSocket server=null;
		try {
			server=new ServerSocket();
			server.bind(new InetSocketAddress(port));          //创建套接字地址
			while (true) {
				executor.execute(new Task(server.accept()));   //当一个客户端连接达到，便交给线程池管理执行
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 注册服务
	 * @see com.rpc.test.Server#register(java.lang.Class, java.lang.Class)
	 */
	@Override
	public void register(Class<?> serviceInterface, Class<?> serviceImpl) {
		// TODO Auto-generated method stub
		serviceRegistry.put(serviceInterface.getName(), serviceImpl);
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}

	@Override
	public int getPort() {
		return port;
	}
}
/**
 * @author fengchao
 * 线程池执行的任务
 */
class Task implements Runnable{

	Socket client=null;
	public Task(Socket client) {
		this.client=client;
	}
	@Override
	public void run() {
		ObjectOutputStream output=null;
		ObjectInputStream input=null;
		try {
			input=new ObjectInputStream(client.getInputStream());
			String serviceName=input.readUTF();
			String methodName=input.readUTF();
			Class<?>[] parameterTypes=(Class<?>[]) input.readObject();
			Object[] arguments=(Object[]) input.readObject();
			Class<?> serviceClass=ServiceProvider.serviceRegistry.get(serviceName);   //根据相关服务名字获取注册的服务类
			if (serviceClass==null) {
				throw new ClassNotFoundException(serviceName+"未找到");
			}
			Method method=serviceClass.getMethod(methodName, parameterTypes);      //获取服务类的方法
			Object result=method.invoke(serviceClass.newInstance(),arguments);      //反射调用服务类的相应方法
			output=new ObjectOutputStream(client.getOutputStream());            //序列化
			output.writeObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
