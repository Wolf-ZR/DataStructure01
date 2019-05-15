package sort;
/**
 * 计数排序
 * @author zhang
 *
 */
public class Counting {
	public static void sort(int[] arr){
		int max=findMax(arr);//找到最大值
		int min=findMin(arr);//找到最小值
		int m=max-min+1;//数字的范围
		int[] counts=new int[m];//创建一个数字范围大小的数组
		for(int i=0;i<arr.length;i++){
			counts[arr[i]-min]++;//每个索引对应的数字，值为数字的数量
		}
		int index=0;
		for(int i=0;i<counts.length;){
			//将数组中的对应数字依次取出
			if(counts[i]!=0){
				arr[index]=i+min;
				counts[i]--;
				index++;
				continue;
			}else{
				i++;
			}
		}
	}

	private static int findMax(int[] arr) {
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		return max;
	}

	private static int findMin(int[] arr) {
		int min=arr[0];
		for(int i=0;i<arr.length;i++){
			if(min>arr[i]){
				min=arr[i];
			}
		}
		return min;
	}
}
