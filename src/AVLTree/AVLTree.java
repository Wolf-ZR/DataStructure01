package AVLTree;

import reflect.Map;
import tree.LinkedSet;
import tree.Set;
import dyarray.ArrayList;
import dyarray.MyArrayList;
import dyarray.MyList;
import dylist.LinkedList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
	private class Node {
		public K k;
		public V v;
		public Node left, right;
		public int height;

		public Node(K k, V v) {
			this.k = k;
			this.v = v;
			left = null;
			right = null;
			height = 1;
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return k + ":" + v;
		}

	}

	private Node root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	// 获取高度
	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	// 获取平衡因子
	private int getBalanceFator(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	// 判断该树是一颗二分搜索树
	public boolean isBinarySearch() {
		MyList<K> list = new MyArrayList<>();
		midOrderKey(root, list);
		for (int i = 1; i < list.getSize(); i++) {
			if (list.get(i).compareTo(list.get(i - 1)) < 0) {
				return false;
			}
		}
		return true;
	}

	// 中序遍历所有的键
	private void midOrderKey(Node node, MyList<K> list) {
		if (node == null) {
			return;
		}
		midOrderKey(node.left, list);
		list.addLast(node.k);
		midOrderKey(node.right, list);
	}

	// 判断该树是一颗平衡二叉树
	public boolean isBalance() {
		return isBalance(root);
	}

	private boolean isBalance(Node node) {
		if (node == null) {
			return true;
		}
		//System.out.println(node.k+":"+getBalanceFator(node));
		if (Math.abs(getBalanceFator(node)) > 1) {
			return false;
		}
		return isBalance(node.left) && isBalance(node.right);
	}

	// 辅助寻找方法
	private Node getNode(K k) {
		return getNode(root, k);
	}

	private Node getNode(Node node, K k) {
		if (node == null) {
			return null;
		}
		if (k.compareTo(node.k) < 0) {
			return getNode(node.left, k);
		} else if (k.compareTo(node.k) > 0) {
			return getNode(node.right, k);
		} else {
			return node;
		}
	}

	@Override
	public void add(K k, V v) {
		root = add(root, k, v);
	}

	private Node add(Node node, K k, V v) {
		if (node == null) {
			size++;
			return new Node(k, v);
		}
		if (k.compareTo(node.k) < 0) {
			node.left = add(node.left, k, v);
		} else if (k.compareTo(node.k) > 0) {
			node.right = add(node.right, k, v);
		} else {
			node.v = v;
		}
		// 更新高度
		node.height =1+Math.max(getHeight(node.left), getHeight(node.right));
		// 平衡因子
		int balance = getBalanceFator(node);
		// 左侧的左侧
		if (balance > 1 && getBalanceFator(node.left) >= 0) {
			return rightRoll(node); 
		}
		// 左侧的右侧
		if (balance > 1 && getBalanceFator(node.left) < 0) {
			node.left = leftRoll(node.left);
			return rightRoll(node);
		}
		// 右侧的右侧
		if (balance < -1 && getBalanceFator(node.right)<=0) {
			return leftRoll(node);
		}
		// 右侧的左侧
		if (balance < -1 && getBalanceFator(node.right)>0) {
			node.right = rightRoll(node.right);
			return leftRoll(node);
		}
		return node;
	}

	// 右旋LL
	private Node rightRoll(Node node) {
		Node x = node.left;
		node.left=x.right;
		x.right=node;
		node.height =1+Math.max(getHeight(node.left),getHeight(node.right));
		x.height =1+Math.max(getHeight(node.left),getHeight(node.right));
		return x;
	}

	// 左旋RR
	private Node leftRoll(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		node.height =1+Math.max(getHeight(node.left), getHeight(node.right));
		x.height =1+Math.max(getHeight(node.left), getHeight(node.right));
		return x;
	}

	// 左右旋LR

	// 右左旋RL

	@Override
	public V remove(K k) {
		Node n = getNode(k);
		if (n == null) {
			return null;
		}
		root = remove(root, k);
		return n.v;
	}

	private Node remove(Node node, K k) {
		if (node == null) {
			return null;
		}
		Node re = null;
		if (k.compareTo(node.k) < 0) {
			node.left = remove(node.left, k);
			re = node;
		} else if (k.compareTo(node.k) > 0) {
			node.right = remove(node.right, k);
			re = node;
		} else {
			// 左子树为null
			if (node.left == null) {
				Node right = node.right;
				node = null;
				size--;
				re = right;
			} else if (node.right == null) {
				Node left = node.right;
				node = null;
				size--;
				re = left;
			} else {
				Node tim = min(node.right);
				tim.right = remove(node.right, tim.k);
				tim.left = node.left;
				re = tim;
			}
		}
		if (re == null) {
			return null;
		}
		//删除之后只有re结点的高度有变化
		//从最后一个结点回溯
		// 更新高度
		re.height =1+Math.max(getHeight(re.left), getHeight(re.right));
		// 平衡因子
		int balance = getBalanceFator(re);
		// 左侧的左侧
		if (balance > 1 && getBalanceFator(re.left) >= 0) {
			return rightRoll(re);
		}
		// 左侧的右侧
		if (balance > 1 && getBalanceFator(re.left) < 0) {
			re.left = leftRoll(re.left);
			return rightRoll(re);
		}
		// 右侧的右侧
		if (balance < -1 && getBalanceFator(re.right) <= 0) {
			return leftRoll(re);
		}
		// 右侧的左侧
		if (balance < -1 && getBalanceFator(re.right) > 0) {
			re.right = rightRoll(re.right);
			return leftRoll(node);
		}
		return re;
	}
	// 找到最小值
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return min(node.left);
		}
	}
	// 删除最小值
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node nodeRight = node.right;
			node = null;
			size--;
			return nodeRight;
		}
		node.left = removeMin(node.left);
		return node;
	}

	@Override
	public boolean contains(K k) {
		return getNode(k) != null;
	}

	@Override
	public V get(K k) {
		return getNode(k).v;
	}

	@Override
	public void set(K k, V v) {
		Node n = getNode(k);
		if (n == null) {
			throw new IllegalArgumentException();
		}
		n.v = v;
	}

	@Override
	public Set keys() {
		Set<K> set = new LinkedSet<>();
		midOrder(root, set);
		return set;
	}

	// 返回keys的中序遍历
	private void midOrder(Node node, Set<K> set) {
		if (node == null) {
			return;
		}
		midOrder(node.left, set);
		set.add(node.k);
		midOrder(node.right, set);
	}

	@Override
	public MyList<V> values() {
		MyList<V> list = new LinkedList<>();
		midOrder(root, list);
		return list;
	}

	// 中序遍历返回所有值
	private void midOrder(Node node, MyList<V> list) {
		if (node == null) {
			return;
		}
		midOrder(node.left, list);

		list.addLast(node.v);

		midOrder(node.right, list);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

}