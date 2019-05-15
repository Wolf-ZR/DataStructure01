package sort;
/**
 * 归并排序
 * @author zhang
 * 平均时间复杂度O(nlogn)
 * 最好时间复杂度O(nlogn)
 * 最坏时间复杂度O(nlogn)
 * 空间复杂度O(n)
 * 稳定性：稳定
 * 数据量大，方差大，平均分布 15ms
 * 数据量大，方差大，近乎有序 9ms
 * 数据量大，方差小，平均分布 15ms
 * 数据量大，方差小，近乎有序 10ms
 */
public class Merge {
	public static void sort(int[] arr){
		mergeSort(arr,0,arr.length-1);
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if(l>=r&&r-l<15){
			//如果划分的数组大小小于16，用插入排序
			Insert.sort(arr,l,r);
			return;
			
		}
		int mid=(r+l)/2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		//如果左边的最大值大于右边的最小值
		if(arr[mid]>arr[mid+1]){
			merge(arr,l,mid,r);
		}
		
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] temp=new int[r-l+1];//临时数组
		for(int i=l;i<=r;i++){
			temp[i-l]=arr[i];
		}
		int j=mid+1;
		int i=l;
		for(int k=l;k<=r;k++){
			if(i>mid){//如果所半边越界
				arr[k]=temp[j-l];
				j++;
			}else if(j>r){//如果右半边越界
				arr[k]=temp[i-l];
				i++;
			}else if(temp[i-l]<=temp[j-l]){
				arr[k]=temp[i-l];
				i++;
			}else{
				arr[k]=temp[j-l];
				j++;
			}
		}
	}
}
