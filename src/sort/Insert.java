package sort;
/**
 * 插入排序
 * @author zhang
* 平均时间复杂度O(n^2)
 * 最好时间复杂度O(n)
 * 最坏时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 稳定性：稳定
 * 数据量大，方差大，平均分布 706ms
 * 数据量大，方差大，近乎有序 2ms
 * 数据量大，方差小，平均分布 608ms
 * 数据量大，方差小，近乎有序 3ms
 */
public class Insert {
	public static void sort(int[] arr){
		int temp=0;
		int j=0;
		for(int i=1;i<arr.length;i++){
			temp=arr[i];
			for(j=i;j>0&&arr[j-1]>temp;j--){
				arr[j]=arr[j-1];
			}
			arr[j]=temp;
		}
	}

	public static void sort(int[] arr, int l, int r) {
		if(l>=r){
			return;
		}
		int temp=0;
		int j=0;
		for(int i=l+1;i<=r;i++){
			temp=arr[i];
			for(j=i;j>l&&arr[j-1]>temp;j--){
				arr[j]=arr[j-1];
			}
			arr[j]=temp;
		}
	}
}
