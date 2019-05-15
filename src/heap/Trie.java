package heap;

import java.util.List;
import java.util.TreeMap;

import dylist.LinkedList;

public class Trie {
	private class Node{
		public boolean isWord;
		public TreeMap<Character,Node> nexts;
		public Node(boolean isWord){
			this.isWord=isWord;
			nexts=new TreeMap<>();
		}
		public Node(){
			this(false);
		}
	}
	private Node root;
	private int size;
	public Trie(){
		root=new Node();
		size=0;
	}
	//添加
	public void add(String word){
		Node cur=root;
		for(int i=0;i<word.length();i++){
			if(cur.nexts.get(word.charAt(i))==null){
				cur.nexts.put(word.charAt(i),new Node());
			}
			cur=cur.nexts.get(word.charAt(i));
		}
		//避免重复
		if(!cur.isWord){
			cur.isWord=true;
			size++;
		}
		
	}
	//是否包含
	public boolean contains(String word){
		Node cur=root;
		for(int i=0;i<word.length();i++){
			if(cur.nexts.get(word.charAt(i))==null){
				return false;
			}else{
				cur=cur.nexts.get(word.charAt(i));
			}
		}
		return cur.isWord;
	}
	//是否包含前缀
	public boolean isPreFix(String pre){
		Node cur=root;
		for(int i=0;i<pre.length();i++){
			if(cur.nexts.get(pre.charAt(i))==null){
				return false;
			}else{
				cur=cur.nexts.get(pre.charAt(i));
			}
		}
		return true;
	}
}
