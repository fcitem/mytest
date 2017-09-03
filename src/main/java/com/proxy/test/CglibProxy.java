package com.proxy.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	Object target;
	Enhancer enhancer=new Enhancer();
	public Object getProxy(Object obj){
		this.target=obj;
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("事物开始");
		Object rt=arg3.invokeSuper(arg0, arg2);
		System.out.println("事物结束");
		return rt;
	}
	public static void main(String[] args) {
		CglibProxy proxy=new CglibProxy();
		testClass test=(testClass) proxy.getProxy(new testClass());
		test.say();
	}
}
class testClass{
	public void say(){
		System.out.println("hello world");
	}
}
