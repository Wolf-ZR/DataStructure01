package sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 桶排序
 * 
 * @author zhang
 * 
 */
public class Bucket {
	public static void sort(int[] arr) {	
		int bc=findMax(arr)/10+1;
		List<Integer>[] lists=new ArrayList[bc];
		for(int i=0;i<lists.length;i++){
			lists[i]=new ArrayList<>();
		}
		//将数据放入桶内
		for(int i=0;i<arr.length;i++){
			lists[arr[i]/10].add(arr[i]);
		}
		int index=0;
		for(int i=0;i<lists.length;){
			//将桶内数据进行排序
			Collections.sort(lists[i]);
			if(lists[i].size()>0){
				arr[index++]=lists[i].remove(0);
			}else{
				i++;
			}
		}
		
	}
	// 找到数组中的最大值
	private static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
}
