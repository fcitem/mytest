package com.rpc.test;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String str) {
		// TODO Auto-generated method stub
		return "hello "+str;
	}

}
