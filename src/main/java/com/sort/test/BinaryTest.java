package com.sort.test;

/**
 * @author fengchao
 * @data 2017年3月20日
 * 折半查找测试
 */
public class BinaryTest {

	/**
	 * @author fengchao
	 * @data 2017年3月20日
	 * @注释 传入的数组必须是按照一定顺序进行排列好的
	 */
	public static void search(int number,int[] array){
		int min=0;
		int max=array.length-1;
		while(min<=max){
			if(array[(max+min)/2]==number){
				System.out.println("找到元素,在第"+((max+min)/2+1)+"个元素位置");
				break;
			}
			else if(array[(max+min)/2]<number){
				min=(max+min)/2+1;
			}
			else{
				max=(max+min)/2-1;
			}
		}
	}
	public static void main(String[] args) {
		int[] arrays=new int[]{2,5,4,6,3,8,1};
		MaoPaoTest.sort(arrays);
		BinaryTest.search(5,arrays);
	}
}
