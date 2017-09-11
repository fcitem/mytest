package com.jvm;

public class Gctest {

	//4:2:2
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] array1,array2,array3,array4;
		array1=new byte[2 *1024*1024];
		array2=new byte[2 *1024*1024];
		array3=new byte[4 *1024*1024];         //出现Minor GC
		array4=new byte[2 *1024*1024];
		System.gc();
	}
	/* 即使手动调用System.gc()也不会执行,只会在系统内存不足的情况下才会调用
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("finalize 执行了");
		super.finalize();
	}
}
