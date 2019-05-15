package sort;

import java.util.List;

import dylist.LinkedList;

/**
 * 基数排序
 * @author zhang
 *
 */
public class Cardinal {
	public static void sort(int[] arr){
		LinkedList<Integer>[] lists=new LinkedList[10];
		for(int i=0;i<lists.length;i++){
			lists[i]=new LinkedList<>();
		}
		int max=findMax(arr);
		int count=0;
		while(max>0){
			max/=10;
			count++;
		}
		int c=0;//位数
		while(count!=c){
			//将数字添加到相应的桶中
			for(int i=0;i<arr.length;i++){
				int index=digit(arr[i],c);
				lists[index].addLast(arr[i]);
			}
			//将数字从相应的桶中取出
			int k=0;
			for(int i=0;i<lists.length;){
				if(lists[i].getSize()>0){
					arr[k++]=lists[i].removeFirst();//每个桶都是先进先出
				}else{
					i++;
				}
			}
			
			c++;
		}
		
	}
	//digit==0表示个位,==1表示十位。。。
	private static int digit(int num,int digit){
		int re=0;
		for(int i=0;i<=digit;i++){
			re=num%10;
			num/=10;
		}
		return re;
	}
	//找到数组中的最大值
	private static int findMax(int[] arr) {
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		return max;
	}
}
