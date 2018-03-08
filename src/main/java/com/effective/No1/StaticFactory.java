package com.effective.No1;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StaticFactory {

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

	/**
	 * 测试面向接口,通过工厂方法的方式获得一个实例对象,但是这个对象不必是public的
	 * 静态工厂返回的类不必是公有的
	 */
	@Test
	public void testReturnPrivate(){
		TestDemo.getPrivateClass().sayHello();
	}

	@Test
	public void testTyjpe(){
		HashMap<String,String> map=TestDemo.newHashMap();
		map.put("fc", "001");
		String.valueOf("d");
	}
}
