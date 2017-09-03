package com.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @author fengchao
 * @date 2017年1月21日
 * @注释  jdk动态代理依赖接口实现
 */
public class JdkProxy implements InvocationHandler {

	Object target;
	public Object getProxy(Object obj){
		this.target=obj;
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("前置代理");
		Object res= method.invoke(target,args);
		System.out.println("后置代理");
		return res;
	}
	public static void main(String[] args) {
		JdkProxy proxy=new JdkProxy();
		targetClass target=new targetClass();
		TestInterface protarget=(TestInterface) proxy.getProxy(target);      //这儿的强制类型转换只能转化为接口类型
		protarget.say();
	}
}
/**
 * @author fengchao
 * @date 2017年1月21日
 * @注释对于非接口实现的类不能通过jdk代理
 */
class targetClass implements TestInterface{
	
	public void say(){
		System.out.println("hello world");
	}
}
