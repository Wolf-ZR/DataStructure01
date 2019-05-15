package sort;
/**
 * 选择排序
 * @author zhang
 * 平均时间复杂度O(n^2)
 * 最好时间复杂度O(n^2)
 * 最坏时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 稳定性：不稳定
 * 数据量大，方差大，平均分布 2397ms
 * 数据量大，方差大，近乎有序 255ms
 * 数据量大，方差小，平均分布 403ms
 * 数据量大，方差小，近乎有序 262ms
 */
public class Select {
	public static void sort(int[] arr){
		//对特殊值过滤
		if(arr==null||arr.length==0||arr.length==1){
			return;
		}
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
}
