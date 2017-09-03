package com.sort.test;

/**
 * @author fengchao
 *基数排序测试
 */
public class RadixTest {

	/**
	 * @author fengchao
	 * @data 2017年3月20日
	 * @注释 根据给定的位数在数列的个位上求余数从而按余数对数列进行排序
	 */
	public static int[] Calculate(int[] array,int number){
		for (int i = 0; i < array.length; i++) {
			int j;
			for (j = 0; j < array.length-1; j++) {
				if(array[j]%number>array[j+1]%number){
					int temp =array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			if(array[j-1]%number>array[j]%number){
				int temp =array[j-1];
				array[j-1]=array[j];
				array[j-1]=temp;
			}
		}
		return array;
	}
	/**
	 * @author fengchao
	 * @data 2017年3月20日
	 * @注释 根据给定的位数在数列的指定分位上（按其它十分位或百分位排序）求余数从而按余数对数列进行排序
	 */
	public static int[] CalculateUnit(int[] array,int number){
		for (int i = 0; i < array.length; i++) {
			int j;
			for (j = 0; j < array.length-1; j++) {
				if((array[j]-array[j]%(number/10))%number>(array[j+1]-array[j+1]%(number/10))%number){      //当前数减去前面已经排过的位数
					int temp =array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			if((array[j-1]-array[j-1]%(number/10))%number>(array[j]-array[j]%(number/10))%number){
				int temp =array[j-1];
				array[j-1]=array[j];
				array[j-1]=temp;
			}
		}
		return array;
	} 
	/**
	 * @author fengchao
	 * @data 2017年3月20日
	 * @注释 计算数组序列里面最大数的位数
	 */
	public static int byteNumber(int[] array){
		int maxnumber=array[0];
		int m=10;
		int temp=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]>maxnumber) {
				maxnumber=array[i];
			}
		}
		while(maxnumber/m>0){
			temp+=1;
			m*=10;
		}
		temp++;
		return temp;
	}
	
	public static void test(int[] array){
		int digit=byteNumber(array);
		Calculate(array, 10);         //按个位排序
		int num=100;
		for (int i =0 ; i <digit;i++) {
			CalculateUnit(array, num);  //按其它十分位或百分位排序直到排到最高位
			num*=10;
		}
	}
	public static void main(String[] args) {
		int[] arrays=new int[]{2,556,41,62,32,84,1};
		RadixTest.test(arrays);
		for (int i : arrays) {
			System.out.println(i);
		}
	}
}
