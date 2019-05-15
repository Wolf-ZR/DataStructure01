package reflect;

import tree.LinkedSet;
import tree.Set;
import dyarray.MyList;
import dylist.LinkedList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K, V> {
	private class Node{
		public K k;
		public V v;
		public Node left,right;
		public Node(K k, V v) {
			this.k = k;
			this.v = v;
			left=null;
			right=null;
		}
		public Node(){
			this(null,null);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return k+":"+v;
		}
		
	}
	private Node root;
	private int size;
	
	public BSTMap() {
		root=null;
		size=0;
	}
	//辅助寻找方法
	private Node getNode(K k){
		return getNode(root,k);
	}
	private Node getNode(Node node,K k){
		if(node==null){
			return null;
		}
		if(k.compareTo(node.k)<0){
			return getNode(node.left,k);
		}else if(k.compareTo(node.k)>0){
			return getNode(node.right,k);
		}else{
			return node;
		}
	}
	@Override
	public void add(K k, V v) {
		root=add(root,k,v);
	}
	private Node add(Node node,K k,V v){
		if(node==null){
			size++;
			return new Node(k,v);
		}
		if(k.compareTo(node.k)<0){
			node.left=add(node.left,k,v);
		}else if(k.compareTo(node.k)>0){
			node.right=add(node.right,k,v);
		}else{
			node.v=v;
		}
		return node;
	}
	@Override
	public V remove(K k) {
		Node n=getNode(k);
		if(n==null){
			return null;
		}
		root=remove(root,k);
		return n.v;
	}

	private Node remove(Node node, K k) {
		if(node==null){
			return null;
		}
		if(k.compareTo(node.k)<0){
			return remove(node.left,k);
		}else if(k.compareTo(node.k)>0){
			return remove(node.right,k);
		}else{
			//左子树为null
			if(node.left==null){
				Node right=node.right;
				node=null;
				return right;
			}
			//右子树为null
			if(node.right==null){
				Node left=node.right;
				node=null;
				return left;
			}
			Node tim=min(node.right);
			tim.right=removeMin(node.right);
			tim.left=node.left;
			return tim;
		}
	}
	//找到最小值
	private Node min(Node node){
		if(node.left==null){
			return node;
		}else{
			return min(node.left);
		}
	}
	//删除最小值
	private Node removeMin(Node node){
		if(node.left==null){
			Node nodeRight=node.right;
			node=null;
			size--;
			return nodeRight;
		}
		node.left=removeMin(node.left);
		return node;
	}
	@Override
	public boolean contains(K k) {
		return getNode(k)!=null;
	}

	@Override
	public V get(K k) {
		return getNode(k).v;
	}

	@Override
	public void set(K k, V v) {
		Node n=getNode(k);
		if(n==null){
			throw new IllegalArgumentException();
		}
		n.v=v;
	}

	@Override
	public Set keys() {
		Set<K> set=new LinkedSet<>();
		midOrder(root,set);
		return set;
	}
	//返回keys的中序遍历
	private void midOrder(Node node, Set<K> set) {
		if(node==null){
			return;
		}
		midOrder(node.left,set);
		set.add(node.k);
		midOrder(node.right,set);
	}
	@Override
	public MyList<V> values() {
		MyList<V> list=new LinkedList<>();
		midOrder(root,list);
		return list;
	}
	//中序遍历返回所有值
	private void midOrder(Node node,MyList<V> list){
		if(node==null){
			return;
		}
		midOrder(node.left,list);
		list.addLast(node.v);
		midOrder(node.right,list);
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

}
