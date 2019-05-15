package dylist;

import dyarray.MyStack;
/**
 * 单项链表实现栈
 * @author zhang
 *
 * @param <E>
 */
public class LinkedStack<E> implements MyStack<E>{
	private MyLinkedList<E> list;
	public LinkedStack(){
		list=new MyLinkedList<>();
	}
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

}
