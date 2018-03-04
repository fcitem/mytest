package com.dateType.test;

/**
 * @author fengchao
 * @data 2017年3月24日
 * 测试基本数据类型的大小以及测试改变各种引用类型的值
 */
public class DateType {

	public static void main(String[] args) {
		System.out.println("基本数据类型:boolean系统未提供size方法");
		System.out.println("基本数据类型:byte二进制位数为"+Byte.SIZE);
		System.out.println("基本数据类型:short二进制位数为"+Short.SIZE);
		System.out.println("基本数据类型:char二进制位数为"+Character.SIZE);
		System.out.println("基本数据类型:int二进制位数为"+Integer.SIZE);
		System.out.println("基本数据类型:float二进制位数为"+Float.SIZE);
		System.out.println("基本数据类型:long二进制位数为"+Long.SIZE);
		System.out.println("基本数据类型:double二进制位数为"+Double.SIZE);
		float fnumber=3.14f;
		float fnum=4.56f;
		short st=2;
		byte bb=12;
		System.out.println("int类型范围max:"+Integer.MAX_VALUE);
		System.out.println("double类型范围max:"+Double.MAX_VALUE);
		System.out.println("double类型范围min:"+Double.MIN_VALUE);
		System.out.println("long类型范围max:"+Long.MAX_VALUE);
		System.out.println(fnumber+fnum+st+bb);
		Integer num=5;
		String str=new String("fc");
		testRef(num);
		testRef(str);
		System.out.println(str);
		System.out.println(num);
		System.out.println(Integer.MAX_VALUE);
		//注意计算机底层存的所有数据是补码形式,这儿产生溢出，负数的补码（按位取反+1）故结果是-2
		int nn=2147483647*2;
		System.out.println(Integer.toBinaryString(2147483647));
		System.out.println(nn);
	}
	/**
	 * @author fengchao
	 * @data 2017年3月24日
	 * @注释 不能改变原有变量的值，因为Integer类型是final的，不能改变，其它的同理
	 */
	public static void testRef(Integer number){
		number+=number;
	}
	public static void testRef(String number){
		number="hello";
	}
}
