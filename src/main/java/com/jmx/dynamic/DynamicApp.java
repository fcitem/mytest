package com.jmx.dynamic;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class DynamicApp {

	public static void main(String[] args) {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

		try {
			// 对应于Mbean里面展示的域名
			ObjectName name = new ObjectName("com.fc.dynamic:name=TestDynamicMbean");
			server.registerMBean(new MyDynamicMbean(), name);
			// 通过一下这种方式可以对jmx接口发起调用
//			server.invoke(name, "testCall", new Object[] { "fc" }, new String[] { String.class.getName() });
			Thread.sleep(600000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
