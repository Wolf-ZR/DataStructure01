package sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author zhang
 * 平均时间复杂度O(nlogn)
 * 最好时间复杂度O(nlogn)
 * 最坏时间复杂度O(n^2)
 * 空间复杂度O(n)
 * 稳定性：不稳定
 * 数据量大，方差大，平均分布 17ms
 * 数据量大，方差大，近乎有序 17ms
 * 数据量大，方差小，平均分布 177ms
 * 数据量大，方差小，近乎有序 177ms
 */
public class Quick {
	public static void sort(int[] arr){
		quickSort3(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if(r-l<=15){
			Insert.sort(arr,l,r);
			return;
		}
		int p=partition(arr,l,r);
		quickSort(arr, l, p-1);
		quickSort(arr, p+1,r);
	}
	private static void quickSort2(int[] arr,int l,int r){
		if(r-l<=15){
			Insert.sort(arr,l,r);
			return;
		}
		
		int p=partition2(arr,l,r);
		quickSort2(arr, l, p-1);
		quickSort2(arr, p+1,r);
	}
	private static void quickSort3(int[] arr,int l,int r){
		if(r-l<=15){
			Insert.sort(arr,l,r);
			return;
		}
		swap(arr,l,(int)(Math.random()*(r-l))+l);
		int lt=l;
		int i=l+1;
		int gt=r+1;
		int t=arr[l];
		while(i<gt){
			//大的放后面
			if(arr[i]>t){
				swap(arr, i,gt-1);
				gt--;
			}else if(arr[i]<t){//小的放前面
				swap(arr,lt+1, i);
				lt++;
				i++;
			}else{//等于放中间
				i++;
			}
		}
		//将l放在中间
		swap(arr,l,lt);
		quickSort2(arr, l, lt-1);
		quickSort2(arr,gt,r);
	}
	private static int partition2(int[] arr, int l, int r) {
		swap(arr,l,(int)(Math.random()*(r-l+1)+l));
		int j=r;
		int v=arr[l];
		int i=l+1;
		while(i<j){
			while(j>=l+1&&arr[j]>v){
				j--;
			}
			while(arr[i]<v&&i<=r){
				i++;
			}
			if(i>j){
				break;
			}
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr,l,j);
		return j;
	}

	private static int partition(int[] arr, int l, int r) {
		swap(arr,l,(int)(Math.random()*(r-l+1)+l));
		int j=l;
		int v=arr[l];
		for(int i=l+1;i<=r;i++){
			if(arr[i]<=v){
				swap(arr,i,j+1);
				j++;
			}
		}
		swap(arr,l,j);
		return j;
	}

	private static void swap(int[] arr,int i, int j) {
		if(i>=j){
			return;
		}
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
