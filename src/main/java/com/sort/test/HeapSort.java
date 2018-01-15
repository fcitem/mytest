package com.sort.test;

/**堆排序
 * @author fengchao
 */
public class HeapSort {

	/**
	 * @param array 初始待排无需数组
	 * @param rule 排序规则:1/从大到小;2/从小到大
	 */
	public static void sort(int[] array,int rule){
		if(rule==1){
			descSort(array);
		}
	}
	/**降序排序
	 * @param array
	 */
	private static void descSort(int[] array){
		for (int j =0;j<array.length;j++) {
			swapHeap(array,array.length-j);
		}
		for (int i : array) {
			System.out.println(i);
		}
	}
	
	/**最后一个节点与根节点交换
	 * @return
	 */
	private static void popElement(int[] array,int length){
		array[0]=array[length-1]+array[0];
		array[length-1]=array[0]-array[length-1];
		array[0]=array[0]-array[length-1];
	}
	/**交换元素
	 * @param array
	 * @param startPosition 开始堆调整位置,从第一半长度的非叶子节点开始调整(因为叶子节点要占一半,所以从一半的位置调整,也就是第一个非叶子节点)
	 */
	private static void swapHeap(int[] array,int length){
		int startPosition=length/2;
		for (int i = startPosition-1; i >=0; i--) {
			int k=i;
			//左节点
			if(array.length>i*2+1){   //有左节点
				k=2*i+1;   //k始终放较大元素的位置
				if(array.length>2*i+2){   //有右节点
					if(array[k]<array[2*i+2]){
						k=2*i+2;
					}
				}
			}
			if(array[k]>array[i]){   //左节点>右节点>父节点,将最大的节点与父节点交换
				array[i]=array[i]+array[k];
				array[k]=array[i]-array[k];
				array[i]=array[i]-array[k];
				adjustHeap(array, i);
			}
		}
		popElement(array,length);
		
	}
	/**
	 * 每交换一个元素后调整堆
	 * @param position 待调整的位置
	 */
	private static void adjustHeap(int[] array,int position){
		int prElement=array[position];
		for (int i = position*2+1;i<array.length;) {   //从左子树开始,没有左子树的话就没有右子树就不需要调整
			int max=i;
			if((i+1)<array.length){    //有右子树
				if(array[i]<array[i+1]){   //右子树大于左子树
					max=i+1;
				}
				if(array[max]>prElement){   //调整
					array[position]=array[max];
					array[max]=prElement;
					i=2*max+1;    //对交换的节点继续调整
				}
				else{    //不需要调整
					break;
				}
			}else{
				i=2*max+1;
			}
		}
	}
	public static void main(String[] args) {
		int[] tests=new int[]{3,8,2,5,1,9};
		sort(tests, 1);
	}
}
