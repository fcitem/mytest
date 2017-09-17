package com.effective.No1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	@Test
	public void testReturnPrivate(){
		TestDemo.getPrivateClass().sayHello();
	}

	@Test
	public void testTyjpe(){
		HashMap<String,String> map=TestDemo.newHashMap();
		map.put("fc", "001");
	}
}
