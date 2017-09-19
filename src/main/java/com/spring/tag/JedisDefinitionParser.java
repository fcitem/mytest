package com.spring.tag;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**标签解析器
 * @author fengchao
 *
 */
public class JedisDefinitionParser extends AbstractBeanDefinitionParser{

	@Override
	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		// TODO Auto-generated method stub
		element.getAttribute("");
		element.getElementsByTagName("");
		return null;
	}

}
