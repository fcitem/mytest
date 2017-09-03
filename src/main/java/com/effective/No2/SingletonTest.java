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
	 * @data: 2016年10月6日
	 * @注释：测试通过反射机制调用私有的构造函数破坏单例
	 */
	@Test
	public void testReflact() throws ClassNotFoundException{
		Class<?> obj=Class.forName("com.effective.No2.SingleTon");
		Constructor<?>[] constructor=obj.getDeclaredConstructors();
		try {
			constructor[0].setAccessible(true);   //关闭访问检查，否则不能调用private方法
			Object ton=(SingleTon) constructor[0].newInstance();
			Method methord=obj.getMethod("sayHello");
			methord.invoke(ton);              //成功调用私有构造函数，构造出了一个新的对象
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data: 2016年10月6日
	 * @注释：测试通过构造函数调用的时候检查是否有实例存在，有则抛出异常来保护单例
	 */
	@Test
	public void testReflactWhithException() throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		Class<?> obj=Class.forName("com.effective.No2.SingleTon");
		Constructor<?> constructor=obj.getDeclaredConstructor(String.class);
		try {
			constructor.setAccessible(true);   //关闭访问检查，否则不能调用private方法
			Object ton=(SingleTon) constructor.newInstance("asdas");
			Method methord=obj.getMethod("sayHello");
			methord.invoke(ton);              //成功调用私有构造函数，构造出了一个新的对象
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data: 2016年10月6日
	 * @注释：测试单例在序列化时，控制所有的实例域都是瞬时的，并且必须添加readResolve方法（不是重写或者重载）
	 * 测试结果通过，必须添加readResolve方法，否则每次反序列化会得到一个新对象，破坏单例
	 */
	@Test
	public void testSerializableSingle(){
		writeObject();
		for (int i = 0; i < 5; i++) {
			readObject();           //调用反序列化三次，看每次返回的实例是不是同一个
		}
	}
	public void writeObject(){
		try {
			ObjectOutputStream out=new ObjectOutputStream(buffer);
			out.writeObject(SingleTon.getInstance());    //序列化放在缓存里面
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readObject(){
		ByteArrayInputStream in=new ByteArrayInputStream(buffer.toByteArray());
		try {
			ObjectInputStream input=new ObjectInputStream(in);
			SingleTon ton=(SingleTon) input.readObject();         //反序列化
			System.out.println(ton);
			ton.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data: 2016年10月6日
	 * @注释：对于每个相同的线程返回一个唯一的实例，借助于线程独有的ThreadLocal
	 */
	@Test
	public void testThreadSingle(){
		for (int i = 0; i < 5; i++) {
			new threadSingle();     //创建5个不同的线程，每个线程取两次单例对象
		}
		try {
//设置此线程休眠20秒要等上面的5个线程执行完毕，因为此线程不是后台线程，不会等上面5个线程执行完毕，但为什么此线程结束就杀死其他的非后台线程程序退出了？估计这就是junit的特别之处吧
			Thread.sleep(20000);   
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
