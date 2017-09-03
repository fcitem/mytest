package com.sort.test;

/**
 * @author fengchao
 *选择排序
 */
public class ChoiceTest {

	/**
	 * @author fengchao
	 * @data 2017年3月15日
	 * @注释 有点类似冒泡
	 */
	public static void sort1(int[] array){
		int temp=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				temp=array[i];
				if(array[j]<temp){
					int number=array[i];
					array[i]=array[j];
					array[j]=number;
				}
			}
		}
	}
	/**
	 * @author fengchao
	 * @data 2017年3月15日
	 * @注释 另一种选择排序
	 */
	public static void sort(int[] array){
		int position=0;
		for (int i = 0; i < array.length; i++) {
			position=i;
			for (int j = position+1; j < array.length; j++) {
				if(array[position]>array[j]){
					position=j;
				}
			}
			int temp=array[i];
			array[i]=array[position];
			array[position]=temp;
		}
	}
	public static void main(String[] args) {
		int[] numbers=new int[]{2,5,4,6,3,8,1,7,6};
		ChoiceTest.sort(numbers);
		for (int m : numbers) {
			System.out.println(m);
		}
	}
}
