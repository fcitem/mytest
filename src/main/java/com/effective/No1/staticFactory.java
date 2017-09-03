package com.effective.No1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author fengchao
 * @data:2016年10月5日
 * @注释：切记第一反应就提供共有的构造方法，静态工厂方法通常更合适
 */
public class staticFactory {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	/**
	 * @author fengchao
	 * @data: 2016年10月5日
	 * @注释：测试静态工厂返回的对象的类不仅可以是非公有的
	 */
	@Test
	public void testReturnPrivate(){
		TestDemo.getPrivateClass().sayHello();
	}

	/**
	 * @author fengchao
	 * @data: 2016年10月5日
	 * @注释：测试静态工厂的泛型方法中的类型推导，及根据返回值确定泛型参数
	 */
	@Test
	public void testTyjpe(){
		HashMap<String,String> map=TestDemo.newHashMap();
		map.put("fc", "001");
	}
}
