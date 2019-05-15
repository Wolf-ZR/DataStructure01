package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Main {
	public static void main(String[] args) {
		Integer[] s={5,6,7,8,9};
		MaxHeap<Integer> heap=new MaxHeap<>(s);
		for(int i=0;i<5;i++){
			System.out.println(heap.extractMax());
		}
	}
	public static void trie(){
		Trie t=new Trie();
		t.add("cat");
		t.add("zhang");
		t.add("rui");
		t.add("dog");
		System.out.println(t.contains("cat"));
		System.out.println(t.isPreFix("ca"));
		TreeMap map=new TreeMap<>();
	}
}
