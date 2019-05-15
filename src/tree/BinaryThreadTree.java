package tree;

import java.util.LinkedList;
import java.util.List;
/**
 * 二叉线索树
 * @author zhang
 *
 * @param <E>
 */

public class BinaryThreadTree<E extends Comparable<E>> {
	private class Node {
		public E val;
		public Node lChild;
		public Node rChild;
		public boolean lTag;//为true时，lChild是下一个结点
		public boolean rTag;//为false时，rChild是右孩子

		public Node() {
			this(null);
		}

		public Node(E e) {
			val = e;
		}
	}

	private Node root;
	private int size;

	// 添加元素
	public void add(E e) {
		if (root == null) {
			root = new Node(e);
		}
		root = add(root, e);
		pre=root;
	}

	private Node add(Node node, E e) {
		if (node == null) {
			node = new Node(e);
		}
		if (e.compareTo(node.val) < 0) {
			node.lChild=add(node.lChild, e);
		} else if (e.compareTo(node.val) > 0) {
			node.rChild=add(node.rChild, e);
		} 
		return node;
	}

	public void test() {
		List<E> list = new LinkedList<>();
		test(root, list);
		System.out.println(list);
	}

	private void test(Node node, List<E> list) {
		if (node == null) {
			return;
		}
		test(node.lChild, list);
		list.add(node.val);
		test(node.rChild, list);
	}
	private Node pre=root;
	// 将结点按中序链接起来
	private void midIte(Node node) {
		if (node == null) {
			return;
		}
		midIte(node.lChild);
		//如果左孩子为null时
		if (node.lChild == null) {
			node.lTag = true;
			//前驱为pre
			node.lChild = pre;
		}
		//当前一结点右孩子为null时
		if (pre.rChild == null) {
			pre.rTag = true;
			//前一结点的后驱为当前结点
			pre.rChild = node;
		}
		//向后移动结点
		pre = node;
		midIte(node.rChild);
	}

	private Node headPrint() {
		Node head = new Node();
		head.lChild = root;//头结点的右孩子为root
		head.lTag = false;
		
		Node p = root;
		while (p.rChild!=null) {
			p = p.rChild;
		}
		head.rTag = true;//右指针域链接右边第一个
		head.rChild = p;
		p.rChild = head;//最后一个指向头
		Node f = root;
		while (!f.lTag) {
			f = f.lChild;
		}
		f.lChild = head;//左边第一个指向头
		return head;
	}

	public void midPrint() {
		midIte(root);//给空指针域赋值，将元素按中序链接
		Node head = headPrint();//头结点
		Node p = head.lChild;//p=root
		List<E> list =new LinkedList<>();
		while (p != head) {
			while (!p.lTag) {//找到左边第一个结点
				p = p.lChild;
			}
			list.add(p.val);
			//当结点有后驱时
			while (p.rTag && p.rChild != head) {
				p = p.rChild;
				list.add(p.val);
			}
			//当结点没有后驱时，下一个就是它的右孩子
			p = p.rChild;
		}
		System.out.println(list);
	}
	
}
