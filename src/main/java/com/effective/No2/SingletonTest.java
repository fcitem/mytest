package com.effective.No2;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingletonTest {

	ByteArrayOutputStream buffer=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		buffer=new ByteArrayOutputStream();
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
	 * @throws ClassNotFoundException 
	 * @data: 2016��10��6��
	 * @ע�ͣ�����ͨ��������Ƶ���˽�еĹ��캯���ƻ�����
	 */
	@Test
	public void testReflact() throws ClassNotFoundException{
		Class<?> obj=Class.forName("com.effective.No2.SingleTon");
		Constructor<?>[] constructor=obj.getDeclaredConstructors();
		try {
			constructor[0].setAccessible(true);   //�رշ��ʼ�飬�����ܵ���private����
			Object ton=(SingleTon) constructor[0].newInstance();
			Method methord=obj.getMethod("sayHello");
			methord.invoke(ton);              //�ɹ�����˽�й��캯�����������һ���µĶ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data: 2016��10��6��
	 * @ע�ͣ�����ͨ�����캯�����õ�ʱ�����Ƿ���ʵ�����ڣ������׳��쳣����������
	 */
	@Test
	public void testReflactWhithException() throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		Class<?> obj=Class.forName("com.effective.No2.SingleTon");
		Constructor<?> constructor=obj.getDeclaredConstructor(String.class);
		try {
			constructor.setAccessible(true);   //�رշ��ʼ�飬�����ܵ���private����
			Object ton=(SingleTon) constructor.newInstance("asdas");
			Method methord=obj.getMethod("sayHello");
			methord.invoke(ton);              //�ɹ�����˽�й��캯�����������һ���µĶ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data: 2016��10��6��
	 * @ע�ͣ����Ե��������л�ʱ���������е�ʵ������˲ʱ�ģ����ұ������readResolve������������д�������أ�
	 * ���Խ��ͨ�����������readResolve����������ÿ�η����л���õ�һ���¶����ƻ�����
	 */
	@Test
	public void testSerializableSingle(){
		writeObject();
		for (int i = 0; i < 5; i++) {
			readObject();           //���÷����л����Σ���ÿ�η��ص�ʵ���ǲ���ͬһ��
		}
	}
	public void writeObject(){
		try {
			ObjectOutputStream out=new ObjectOutputStream(buffer);
			out.writeObject(SingleTon.getInstance());    //���л����ڻ�������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readObject(){
		ByteArrayInputStream in=new ByteArrayInputStream(buffer.toByteArray());
		try {
			ObjectInputStream input=new ObjectInputStream(in);
			SingleTon ton=(SingleTon) input.readObject();         //�����л�
			System.out.println(ton);
			ton.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data: 2016��10��6��
	 * @ע�ͣ�����ÿ����ͬ���̷߳���һ��Ψһ��ʵ�����������̶߳��е�ThreadLocal
	 */
	@Test
	public void testThreadSingle(){
		for (int i = 0; i < 5; i++) {
			new threadSingle();     //����5����ͬ���̣߳�ÿ���߳�ȡ���ε�������
		}
		try {
//���ô��߳�����20��Ҫ�������5���߳�ִ����ϣ���Ϊ���̲߳��Ǻ�̨�̣߳����������5���߳�ִ����ϣ���Ϊʲô���߳̽�����ɱ�������ķǺ�̨�̳߳����˳��ˣ����������junit���ر�֮����
			Thread.sleep(20000);   
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
