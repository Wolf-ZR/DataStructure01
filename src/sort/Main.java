package sort;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] arr=new int[50000];
		Random random=new Random();
		for(int i=0;i<arr.length;i++){
			arr[i]=random.nextInt(20);
			
		}
		//System.out.println(Arrays.toString(arr));
		//Arrays.sort(arr);
		long start=System.currentTimeMillis();
		Quick.sort(arr);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		//System.out.println(Arrays.toString(arr));
	}
}
