package com.jmx.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**管理jmx中Mbean的发布
 * @author fengchao
 *
 */
public class MbeanManager {

	public static void main(String[] args) {
		MBeanServer server=ManagementFactory.getPlatformMBeanServer();
		
		try {
			//对应于Mbean里面展示的域名
			ObjectName name=new ObjectName("com.fc.mbean:name=TestMbean");
			server.registerMBean(new Test(), name);
			//通过一下这种方式可以对jmx接口发起调用
			server.invoke(name, "testCall",new Object[]{"fc"},new String[]{String.class.getName()});
			Thread.sleep(600000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
