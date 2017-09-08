package com.proxy.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

/**jdk动态代理依赖接口实现
 * @author fengchao
 * @date 2017年1月21日
 * 此类相当于动态代理中的h实现
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
		System.out.println(proxy.getClass().getName());          //代理类的名字
		return res;
	}
	public static void main(String[] args) {
		JdkProxy proxy=new JdkProxy();
		targetClass target=new targetClass();
		TestInterface protarget=(TestInterface) proxy.getProxy(target);      //这儿的强制类型转换只能转化为接口类型
		protarget.say();
//		JdkProxy.writeProxyToDisk("E:/$Proxy11.class");
	}
	/**将jdk动态代理生成的代理类写入硬盘测试
	 * @param path
	 */
	public static void writeProxyToDisk(String path){
		byte[] classFile=ProxyGenerator.generateProxyClass(
                "com.sun.proxy.$Proxy0", new Class[]{ TestInterface.class},17);
        FileOutputStream out = null;  
          
        try {  
            out = new FileOutputStream(path);  
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        } 
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
