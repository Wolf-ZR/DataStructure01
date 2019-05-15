package sort;

import heap.MaxHeap;

/**
 * 堆排序
 * @author zhang
 * 平均时间复杂度O(nlogn)
 * 最好时间复杂度O(nlogn)
 * 最坏时间复杂度O(nlogn)
 * 空间复杂度O(n)
 * 稳定性：不稳定
 * 数据量大，方差大，平均分布 2397ms
 * 数据量大，方差大，近乎有序 255ms
 * 数据量大，方差小，平均分布 403ms
 * 数据量大，方差小，近乎有序 262ms
 */
public class Heap {
	public static void sort(Integer[] arr){
		MaxHeap<Integer> heap=new MaxHeap<>(arr);
		for(int i=arr.length-1;i>=0;i--){
			arr[i]=heap.extractMax();
		}
	}
}
