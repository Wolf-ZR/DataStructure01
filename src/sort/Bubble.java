package sort;
/**
 * 冒泡排序
 * @author zhang
 * 数据量大，方差大，平均分布 3531ms
 * 数据量大，方差大，近乎有序 1ms
 * 数据量大，方差小，平均分布 3552ms
 * 数据量大，方差小，近乎有序 2ms
 * 最好时间复杂度O(n)
 * 最差时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 
 */
public class Bubble {
	public static void sort(int[] arr){
		int temp=0;
		boolean flag=false;//对已经有序的优化
		for(int i=0;i<arr.length-1;i++){
			for(int j=1;j<arr.length-i;j++){
				if(arr[j-1]>arr[j]){
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
					flag=true;
				}
			}
			if(!flag){
				return;
			}
		}
	}
}
