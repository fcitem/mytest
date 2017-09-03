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
 * @data:2016��10��5��
 * @ע�ͣ��мǵ�һ��Ӧ���ṩ���еĹ��췽������̬��������ͨ��������
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
	 * @data: 2016��10��5��
	 * @ע�ͣ����Ծ�̬�������صĶ�����಻�������Ƿǹ��е�
	 */
	@Test
	public void testReturnPrivate(){
		TestDemo.getPrivateClass().sayHello();
	}

	/**
	 * @author fengchao
	 * @data: 2016��10��5��
	 * @ע�ͣ����Ծ�̬�����ķ��ͷ����е������Ƶ��������ݷ���ֵȷ�����Ͳ���
	 */
	@Test
	public void testTyjpe(){
		HashMap<String,String> map=TestDemo.newHashMap();
		map.put("fc", "001");
	}
}
