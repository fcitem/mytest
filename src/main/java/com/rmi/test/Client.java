package com.rmi.test;

import java.lang.reflect.Method;
import java.rmi.Naming;
import java.rmi.Remote;

public class Client {
	public static void main(String[] args) {
		String url="rmi://192.168.0.34:8888/MyService";
		try {
//			Context context=new InitialContext();
//			Object service=context.lookup(url);
			Remote service=Naming.lookup(url);
			Method methords=service.getClass().getMethod("service", java.lang.String.class);
			System.out.println(methords.invoke(service, "hello"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
