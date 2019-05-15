package sort;
/**
 * 希尔排序
 * @author zhang
 *
 */
public class Shell {
	public static void sort(int[] arr){
		int gap=arr.length/2;
		//当间隔大于等于1时
		while(gap>=1){
			int temp=0;
			int j=0;
			//插入排序
			for(int i=gap;i<arr.length;i+=gap){
				temp=arr[i];
				for(j=i;j>0&&arr[j-gap]>temp;j-=gap){
					arr[j]=arr[j-gap];
				}
				arr[j]=temp;
			}
			gap/=2;
		}
	}
}
