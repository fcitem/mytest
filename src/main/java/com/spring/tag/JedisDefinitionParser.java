package com.spring.tag;

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import redis.clients.jedis.JedisPool;

/**标签解析器
 * @author fengchao
 *
 */
public class JedisDefinitionParser extends AbstractSingleBeanDefinitionParser{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getBeanClass(Element element) {
		return JedisPool.class;
	}


	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		String host=element.getAttribute("host");
		String port=element.getAttribute("port");
		String password=element.getAttribute("password");
		String timeout=element.getAttribute("timeout");
		String beanName=element.getAttribute("ref");
		if(beanName!=null&&!"".equals(beanName)){
//			BeanDefinition definition=parserContext.getRegistry().getBeanDefinition(beanName);
			Object reference=new RuntimeBeanReference(beanName);
			builder.addConstructorArgValue(reference);
		}
		builder.addConstructorArgValue(host);
		builder.addConstructorArgValue(port);
		if(timeout!=null&&!timeout.isEmpty()){
			builder.addConstructorArgValue(timeout);
		}
		if(password!=null&&!password.isEmpty()){
			builder.addConstructorArgValue(password);
		}
	}

	/*@Override
	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		Jedis jedis=new Jedis();
		String host=element.getAttribute("host");
		String port=element.getAttribute("port");
		String password=element.getAttribute("password");
		String timeout=element.getAttribute("timeout");
		String beanName=element.getAttribute("ref");
		
		if(beanName!=null&&!"".equals(beanName)){
			BeanDefinition definition=parserContext.getRegistry().getBeanDefinition(beanName);
			Object reference=new RuntimeBeanReference(beanName);
			JedisPool pool=(JedisPool) reference;
		}
		return null;
	}*/

}
