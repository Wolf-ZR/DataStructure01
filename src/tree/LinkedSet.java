package tree;

import dylist.LinkedList;


/**
 * 基于链表实现的集合
 * @author zhang
 *
 * @param <E>
 */
public class LinkedSet<E> implements Set<E> {
	
	

	private LinkedList<E> list;
	public LinkedSet() {
		list=new LinkedList<>();
	}
	@Override
	public void add(E e) {
		if(!list.contains(e)){
			list.addLast(e);
		}
	}

	@Override
	public void remove(E e) {
		
		list.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return list.contains(e);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<list.getSize();i++){
			sb.append(list.get(i)+",");
		}
		sb.append("]");
		return sb.toString();
	}
}
