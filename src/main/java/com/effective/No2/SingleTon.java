package com.effective.No2;

import java.io.Serializable;

public class SingleTon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static transient final SingleTon INSTANCE=new SingleTon();
	private SingleTon(){
		
	}
	private SingleTon(String str) throws Exception{
		if(INSTANCE!=null){
			throw new Exception("�Ѿ�ӵ��һ��ʵ���������ٴδ���");
		}
	}
	public void sayHello(){
		System.out.println("hello");
	}
	public static SingleTon getInstance(){
		return INSTANCE;
	}
	/**
	 * @author fengchao
	 * @data: 2016��10��6��
	 * @ע�ͣ�readResolve��������class�ڷ����л����ض���ǰ�滻�����������ж������Ķ���
	 * ʵ��readResolve������һ��class����ֱ�ӿ��Ʒ��򻯷��ص����ͺͶ�������
	 * ����readResolve����ObjectInputStream�Ѿ���ȡһ��������׼������ǰ����
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
