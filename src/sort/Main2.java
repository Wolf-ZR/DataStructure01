package sort;

import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*50);
		}
		System.out.println(Arrays.toString(arr));
		long start=System.currentTimeMillis();
		Bucket.sort(arr);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(Arrays.toString(arr));
	}
}
