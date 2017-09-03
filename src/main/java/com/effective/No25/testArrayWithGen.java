package com.effective.No25;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testArrayWithGen {

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
	 * @author fengchao
	 * @param <T>
	 * @data: 2016年11月12日
	 * @注释：测试创建泛型数组，参数化类型数组或者类型参数的数组是否合法
	 */
	@Test
	public <T> void test(T obj) {
		//ArrayList<String>[] list=new ArrayList<String>[1];   //泛型数组非法
		//T[] array=new T[2];             //创建参数化类型的数组或者类型参数的数组非法
	}
	public static <T extends Comparable<T>> T max(List<T> list){
		List<Object> testlist=new ArrayList<Object>();
		testlist.add("dfd");
		return null;
	}

}
