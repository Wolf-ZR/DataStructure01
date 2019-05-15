package dylist;

import dyarray.MyQueue;
/**
 * 单向链表实现队列
 * @author zhang
 *
 * @param <E>
 */
public class LinkedQueue<E> implements MyQueue<E>{
	private MyLinkedList<E> list;
	public LinkedQueue() {
		list=new MyLinkedList<>();
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
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}

	@Override
	public E getRear() {
		// TODO Auto-generated method stub
		return list.getLast();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

}
