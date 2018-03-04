package com.jvm;

public class Base {
	
	public static int test(){
		int i=0;
		try{
			return i;
		}finally {
			System.out.println(++i);
		}
	}
	public void print(){
		int number=1;
		long lnumber=number;
	}
	public static void main(String[] args) {
		int number=test();
		int num1=3,num2=0,num3=2;
		int answer=num1>0?num2>0?num3>0?33:22:11:33;
		System.out.println("返回值为:"+number);
		System.out.println(answer);
//		int a=150,b=150;           
		Integer a=150,b=150;      //integer不同于int,Integer对于大于128的int会重新创建，低于128的直接复用
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}

}
/**构造器调用构造器用this()
 * @author fengchao
 *
 */
class Son extends Base{
	public Son() {
	}
	public Son(String str){
		this();
	}
	public void say(){
		test();
		print();
	}
}
