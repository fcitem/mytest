package com.rmi.test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author fengchao
 *@see ubutun tw37 javatest里面的测试例子
 */
public class Server {
	public static void main(String[] args) {
		try {
			MyServiceImpl service=new MyServiceImpl();
			LocateRegistry.createRegistry(Integer.valueOf("8888"));
			Naming.bind("rmi://192.168.0.34:8888/MyService",service);
			System.out.println("Naming注册了一个远程对象服务");
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
