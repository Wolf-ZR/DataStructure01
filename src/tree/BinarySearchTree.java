package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 二叉搜索树
 * @author zhang
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {
	private class Node{
		public E e;
		public Node left,right;
		public Node (E e){
			this.e=e;
			left=null;
			right=null;
		}
	}
	private Node root;
	private int size;
	public BinarySearchTree() {
		root=null;
		size=0;
	}
	//获取元素个数
	public int size(){
		return size;
	}
	//判断是否为空
	public boolean isEmpty(){
		return size==0;
	}
	//添加
	public void add(E e){
		root=add(e,root);//递归实现
		/*if(root==null){
			root=new Node(e);
			size++;
		}
		Node p=root;
		while(true){
			if(e.compareTo(p.e)>0){
				if(p.right!=null){
					p=p.right;
				}else{
					p.right=new Node(e);
					size++;
					return;
				}
			}else if(e.compareTo(p.e)<0){
				if(p.left!=null){
					p=p.left;
				}else{
					p.left=new Node(e);
					size++;
					return;
				}
			}else{
				return;
			}
		}*/
	}
	//以node为当前树 的根节点添加元素e 并返回该树的根,递归
	private Node add(E e,Node node){
		if(node==null){
			size++;
			return new Node(e);
		}
		//root不是null时
		if(node.e.compareTo(e)>0){
			node.left=add(e,node.left);
		}else if(node.e.compareTo(e)<0){
			node.right=add(e,node.right);
		}
		return node;
	}
	//查询元素
	public boolean contains(E e){
		//return contains(e,root);
		if(size()==0){
			return false;
		}
		Node p=root;
		while(p!=null){
			if(e.compareTo(p.e)>0){
				p=p.right;
			}else if(e.compareTo(p.e)<0){
				p=p.left;
			}else{
				return true;
			}
		}
		return false;
	}
	//以node为当前根节点进行查找元素e，递归实现
	private boolean contains(E e, Node node) {
		if(node==null){
			return false;
		}
		if(node.e.compareTo(e)>0){
			return contains(e,node.left);
		}else if(node.e.compareTo(e)<0){
			return contains(e,node.right);
		}else{
			return true;
		}
		
	}
	//中序输出打印
	public void print(){
		List<E> list=new ArrayList<E>();
		print(list,root);
		System.out.println(list);
	}
	private void print(List<E> list,Node node) {
		if(node==null){
			return;
		}
		print(list,node.left);//左结点
		list.add(node.e);//父结点
		print(list,node.right);//右结点
	}
	//打印某个节点及子节点
	public void print(Node n){
		List<E> list=new ArrayList<E>();
		print(list,n);
		System.out.println(list);
	}
	//计算深度
	public int level(Node node){
		if(node==null){
			return 1;
		}
		int left=0;
		int right=0;
		if(node.left!=null){
			left=level(node.left)+1;
		}
		if(node.right!=null){
			right=level(node.right)+1;
		}
		return Math.max(left,right);
	}
	//前序遍历
	public List<E> preIte(){
		List<E> list=new LinkedList<>();
		preIte(root,list);
		return list;
	}
	private void preIte(Node node,List<E> list){
		if(node==null){
			return;
		}
		list.add(node.e);//父结点
		preIte(node.left,list);//左结点
		preIte(node.right,list);//右结点
	}
	//广度优先遍历（层序遍历）
	public void levelOrder(){
		List<E> list=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		//用辅助队列
		Queue<Node> queue=new LinkedList<>();
		sb.append("");
		queue.add(root);
		while(!queue.isEmpty()){
			Node n=queue.poll();
			list.add(n.e);
			if(n.left!=null){
				queue.add(n.left);
			}
			if(n.right!=null){
				queue.add(n.right);
			}
		}
		System.out.println(list);
	}
	//层序遍历（递归）
	public void levelIte(){
		List<E> list=new LinkedList<>();
		levelIte(root,list);
		System.out.println(list);
	}
	private void levelIte(Node node, List<E> list) {
		if(node==null){
			return;
		}
		list.add(node.e);
		
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		generateString(root,0,sb);
		return sb.toString();
	}
	private void generateString(Node node, int level, StringBuilder sb) {
		if(node==null){
			sb.append(generateSpace(level)+"null\n");
			return;
		}
		generateString(node.left, level+1, sb);
		sb.append(generateSpace(level)+node.e+"\n");
		generateString(node.right, level+1, sb);
		
	}
	private String generateSpace(int level) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<level;i++){
			sb.append("   ");
		}
		return sb.toString();
	}
	
	//获取最小值
	public E minNum(){
		if(size()==0){
			throw new IllegalArgumentException("Tree is Empty!");
		}
		return minNum(root).e;
	}
	private Node minNum(Node node) {
		if(node.left==null){
			return node;
		}
		return minNum(node.left);
	}
	//获得最大值
	public E maxNum(){
		if(size()==0){
			throw new IllegalArgumentException("Tree is Empty!");
		}
		return maxNum(root).e;
	}
	private Node maxNum(Node node) {
		if(node.right==null){
			return node;
		}
		return maxNum(node.right);
	}
	//删除最大值
	public E removeMax(){
		E e=maxNum();
		removeMax(root);
		return e;
	}
	private Node removeMax(Node node) {
		if(node.right==null){
			Node nodeLeft=node.left;
			node.left=null;
			size--;
			return nodeLeft;
		}
		node.right=removeMax(node.right);
		return node;
	}
	//删除最小值
		public E removeMin(){
			E e=minNum();
			removeMin(root);
			return e;
		}
		private Node removeMin(Node node) {
			if(node.left==null
					){
				Node nodeRight=node.right;
				node.right=null;
				size--;
				return nodeRight;
			}
			node.left=removeMin(node.left);
			return node;
		}
	//删除任意值
	public void remove(E e){
		root=remove(root,e);
	}
	private Node remove(Node node, E e) {
		if(node==null){
			return null;
		}
		if(e.compareTo(node.e)>0){
			node.right=remove(node.right,e);
			return node;
		}else if(e.compareTo(node.e)<0){
			node.left=remove(node.left,e);
			return node;
		}else{
			if(node.left==null){
				Node nodeRight=node.right;
				node.right=null;
				size--;
				return nodeRight;
			}else if(node.right==null){
				Node nodeLeft=node.left;
				node.left=null;
				size--;
				return nodeLeft;
			}
			Node success=minNum(node.right);
			Node n=removeMin(node.right);
			success.right=n;
			success.left=node.left;
			return success;
		}
	}
}
