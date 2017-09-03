package com.sort.test;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] array){
		int endIndex=array.length-1;
		int startIndex=0;
		/*int position=startIndex;
		int end=endIndex;*/
 		boolean flag=false;
		while(startIndex!=endIndex&&endIndex>0) {
			if(array[startIndex]>array[endIndex]){
				int temp=array[startIndex];
				array[startIndex]=array[endIndex];
				array[endIndex]=temp;
				flag=!flag;
			}
			else if(!flag){
				endIndex--;
			}
			else if(flag){
				startIndex++;
			}
		};
		if(array.length>1){
			sort(Arrays.copyOf( array, startIndex+1));
			sort(Arrays.copyOfRange(array, startIndex+1,array.length));
		}
		else{
			return;
		}
	}
	
	/**
	 * @author fengchao
	 * @data 2017年3月17日
	 * @注释 不需要中间数组内存空间
	 */
	public static void sort2(int[] array,int startIndex,int endIndex){
		int position=startIndex;              //待排序序列的起始索引
		int end=endIndex;                    //待排序序列的终止索引
 		boolean flag=false;
		while(startIndex<endIndex) {
			if(array[startIndex]>array[endIndex]){
				int temp=array[startIndex];
				array[startIndex]=array[endIndex];
				array[endIndex]=temp;
				flag=!flag;
			}
			else if(!flag){
				endIndex--;
			}
			else if(flag){
				startIndex++;
			}
		};
		if(end-position>1){        //代排序数组长度大于1
			sort2(array,position,startIndex);          //对中间变量的前面部分进行递归排序
			sort2(array,startIndex+1,end);             //对中间变量的后面部分进行排序
		}
		else{
			return;
		}
	}
	public static void main(String[] args) {
		int[] numbers=new int[]{2,5,4,6,3,8,1,7,9,6};
		QuickSort.sort2(numbers,0,numbers.length-1);
		for (int m : numbers) {
			System.out.println(m);
		}
	}
}
