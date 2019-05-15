package recursion;

import java.util.ArrayList;
import java.util.List;
public class Hano {
	static List<Integer> p1=new ArrayList<>();
	static List<Integer> p2=new ArrayList<>();
	static List<Integer> p3=new ArrayList<>();
	public static void execute(List<Integer> from,List<Integer> mid, List<Integer> to,int level){
		if(level==1){
			to.add(0,from.remove(0));
		}else{
			//将除了最后一个，先移动到辅助盘
			execute(from,to,mid,level-1);
			//将最后一个移动到目标盘
			to.add(0,from.remove(0));
			//再将辅助盘的移动到目标盘
			execute(mid,from,to,level-1);
		}
		
	}
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			p1.add(i);
		}
		System.out.println(p1.toString());
		execute(p1,p2,p3,20);
		System.out.println(p3.toString());
	}
}
