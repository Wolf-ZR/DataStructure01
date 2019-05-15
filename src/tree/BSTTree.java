package tree;

public class BSTTree<E extends Comparable<E>> implements Set<E>{
	private BinarySearchTree<E> tree;
	
	public BSTTree() {
		tree=new BinarySearchTree<>();
	}

	@Override
	public void add(E e) {//O(logn)
		// TODO Auto-generated method stub
		tree.add(e);
	}

	@Override
	public void remove(E e) {//O(logn)
		// TODO Auto-generated method stub
		tree.remove(e);
	}

	@Override
	public boolean contains(E e) {//O(logn)
		// TODO Auto-generated method stub
		return tree.contains(e);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tree.isEmpty();
	}

}
