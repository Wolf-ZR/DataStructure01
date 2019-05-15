package AVLTree;

import hash.HashTable;

import java.util.ArrayList;

import tree.BSTTree;
import tree.FileOperation;
import tree.RBTree;

public class Main {
	public static void main(String[] args) {
		rbTree();
		hashTable();
		
		
	}
	public static void rbTree(){
		RBTree<String, Integer> tree=new RBTree<>();
		ArrayList<String> words=new ArrayList<>();
		FileOperation.readFile("E:/qqfile/a-tale-of-two-cities.txt", words);
		for (String string : words) {
			if(tree.contains(string)){
				tree.add(string,tree.get(string)+1);
			}else{
				tree.add(string,1);
			}
		}
		long start=System.currentTimeMillis();
		for (String word : words) {
			if(tree.contains(word)){
				tree.get(word);
			}
			
		}
		long end=System.currentTimeMillis();
		System.out.println("红黑树用时："+(end-start)+"毫秒");
	}
	public static void hashTable(){
		HashTable<String, Integer> tree=new HashTable<>();
		ArrayList<String> words=new ArrayList<>();
		FileOperation.readFile("E:/qqfile/a-tale-of-two-cities.txt", words);
		for (String string : words) {
			if(tree.contains(string)){
				tree.add(string,tree.get(string)+1);
			}else{
				tree.add(string,1);
			}
		}
		long start=System.currentTimeMillis();
		for (String word : words) {
			if(tree.contains(word)){
				tree.get(word);
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("hash表用时："+(end-start)+"毫秒");
	}
}
