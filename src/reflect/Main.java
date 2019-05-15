package reflect;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.FileOperation;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> words=new ArrayList<>();
		FileOperation.readFile("E:/qqfile/pride-and-prejudice.txt", words);
		//LinkedMap<String, Integer> map=new LinkedMap<>();
		BSTMap<String, Integer> map=new BSTMap<>();
		long start=System.currentTimeMillis();
		for (int i = 0; i < words.size(); i++) {
			String word= words.get(i);
			if(map.contains(word)){
				map.set(word,map.get(word)+1);
			}else{
				map.add(word, 1);
			}
			
		}
		long end=System.currentTimeMillis();
		double time=(end-start)/1000.0;
		System.out.println("用时："+time);
		System.out.println(map.keys());
		
	}
}
