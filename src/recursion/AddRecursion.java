package recursion;

public class AddRecursion {
	public static void main(String[] args) {
		System.out.println(add(100));
	}
	public static int add(int num){
		if(num==1){
			return 1;
		}
		//等于它前面的总和加它本身
		return add(num-1)+num;
	}
}
