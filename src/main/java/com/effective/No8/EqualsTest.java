package com.effective.No8;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EqualsTest {

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
	 * @data: 2016��10��9��
	 * @ע�ͣ�������дequals�ĶԳ��� a.equals(b)��b.equals(a)���У�����������map�����������л��д�
	 */
	@Test
	public void test() {
		IgnoreCase str=new IgnoreCase("Fc");
		String s="fc";
		System.out.println(str.equals(s));
	}

}
