package com.effective.No2;

public class threadSingle extends Thread{

	public threadSingle() {
		start();
	}
	@Override
	public void run() {
		System.out.println(test.getInstance());   //��ǰ�̵߳�һ�λ�ȡ����
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(test.getInstance());  //��ǰ�̵߳�2�λ�ȡ�������Ƚϵ�ַ�ó���������ͬһ������
	}
}
class test{
	//����һ���̱߳��ر���,ÿ���߳�Ĭ�ϵı����Ŷ�ThreadLocal��һ������
	private static final ThreadLocal<test> local=new ThreadLocal<test>();
	public static test getInstance(){
		if(local.get()==null){   //�����ǰ�̵߳�ThreadLocal�е�testΪ����ʵ����
			local.set(new test());       //��ʵ������Ķ�����뵱ǰ�̵߳�ThreadLocal�����У��Ա㵱ǰ�߳���һ�����ж�
		}
		return local.get();
	}
}
