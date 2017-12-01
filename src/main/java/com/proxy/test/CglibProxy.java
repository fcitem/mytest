package com.proxy.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**Cglib动态代理实现
 * Cglib是通过生成子类的方式生成代理类，可以解决方法内部调用方法走代理
 * @author fengchao
 *
 */
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
	/**
	 * 方法内部调用其它方法会依然被代理，private不行
	 */
	public void say(){
		test();
		System.out.println("hello world");
	}
	public void test(){
		System.out.println("hihi");
	}
}
