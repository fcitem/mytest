package com.spring.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**自定义标签解析类
 * @author fengchao
 *
 */
public class NamespaceHandler extends NamespaceHandlerSupport{

	@Override
	public void init() {
		//注册相应标签的解析器
		registerBeanDefinitionParser("jedis", new JedisDefinitionParser());
	}
	

}
