package com.sort.test;

/**
 * @author fengchao
 * 冒泡排序
 */
public class MaoPaoTest {

	public static void sort(int[] array){
		for (int j = 0; j < array.length; j++) {
			int i;
			for (i = 0; i < array.length-1; i++) {
				if(array[i]>array[i+1]){
					array[i]=array[i+1]+array[i];                    //放两者总和
					array[i+1]=array[i]-array[i+1];                 //总和减去后面一个便是前面一个元素,及较大的元素
					array[i]=array[i]-array[i+1];                  //总和减去较大的元素便是较大的元素，放在前面，以实现两者的交换不需要内存空间
				}
			}
			if(array[i-1]>array[i]){
				array[i]=array[i+1]+array[i];                    //放两者总和
				array[i+1]=array[i]-array[i+1];                 //总和减去后面一个便是前面一个元素,及较大的元素
				array[i]=array[i]-array[i+1];                  //总和减去较大的元素便是较大的元素，放在前面，以实现两者的交换不需要内存空间
			}
		}
	}
	public static void main(String[] args) {
		int[] numbers=new int[]{2,5,4,6,3,8,1};
		MaoPaoTest.sort(numbers);
		for (int m : numbers) {
			System.out.println(m);
		}
	}
}
