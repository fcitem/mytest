package com.jmx.dynamic;

import java.util.Iterator;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.ReflectionException;

/**动态Mbean，所有的属性和方法都在运行时定义
 * @author fengchao
 *
 */
public class MyDynamicMbean implements DynamicMBean{

	private String name="fc";
	private String password="123456";
	@Override
	public Object getAttribute(String attribute)
			throws AttributeNotFoundException, MBeanException, ReflectionException {
		if("name".equals(attribute)){
			return getName();
		}else{
			return getPassword();
		}
	}

	@Override
	public void setAttribute(Attribute attribute)
			throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
		if("name".equals(attribute.getName())){
			this.setName(attribute.getValue().toString());
		}else{
			this.setPassword(attribute.getValue().toString());
		}
	}

	@Override
	public AttributeList getAttributes(String[] attributes) {
		AttributeList list=new AttributeList();
		list.add(new Attribute("name",getName()));
		list.add(new Attribute("password",getPassword()));
		return list;
	}

	@Override
	public AttributeList setAttributes(AttributeList attributes) {
		Iterator<Object> it=attributes.iterator();
		while(it.hasNext()){
			Attribute obj=(Attribute) it.next();
			try {
				setAttribute(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Object invoke(String actionName, Object[] params, String[] signature)
			throws MBeanException, ReflectionException {
		if("getMyGreet".equals(actionName)){
			return getMyGreet();
		}
		return null;
	}

	public String getMyGreet() {
		return "Welcome you visit me";
	}
	
	@Override
	public MBeanInfo getMBeanInfo() {
		try {
			MBeanAttributeInfo[] mBeanAttributeInfos=new MBeanAttributeInfo[]{new MBeanAttributeInfo("name","用户名",getClass().getMethod("getName"),getClass().getMethod("setName",String.class)),new MBeanAttributeInfo("password","密码",getClass().getMethod("getPassword"),getClass().getMethod("setPassword",String.class))};
			MBeanOperationInfo[] mBeanOperationInfos=new MBeanOperationInfo[]{new MBeanOperationInfo("获取问候",getClass().getMethod("getMyGreet"))};
			MBeanInfo info=new MBeanInfo(getClass().getName(),"TestDynamic",mBeanAttributeInfos,null,mBeanOperationInfos,null);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
