package com.jmx.mbean;

/**必须有个名字和接口中"MBean"的前缀相同
 * @author fengchao
 *
 */
public class Test implements TestMBean {

	@Override
	public void testCall(String name) {
		System.out.println("hello:"+name+",你已经成功通过jmx对我发起了调用");
	}

	@Override
	public String myGreet() {
		return "Welcome you visit me";
	}

}
