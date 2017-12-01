package com.jmx.mbean;

/**Mbean接口,这个必需要
 * 名字必须以MBean结尾
 * @author fengchao
 */
public interface TestMBean {

	/**测试jmx调用的方法
	 * @param name
	 */
	public void testCall(String name);
	
	/**通过jmx获取结果返回
	 * @return
	 */
	public String myGreet();
}
