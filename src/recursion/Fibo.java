package recursion;

public class Fibo {
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.print(fibo(i+1)+" ");
		}
	}
	public static long fibo(int n){
		if(n<=0){
			throw new IllegalArgumentException("非法参数");
		}
		if(n==1||n==2){
			return 1;
		}
		//返回前两项都的和
		return fibo(n-2)+fibo(n-1);
	}
}
