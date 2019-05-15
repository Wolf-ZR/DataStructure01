package heap;

import dyarray.MyQueue;

public class PriorityQueue<E extends Comparable<E>> implements MyQueue<E> {
	private MaxHeap<E> heap;
	public PriorityQueue(){
		heap=new MaxHeap<E>();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return heap.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		heap.add(e);
	}

	@Override
	public E dequeue() {
		E e=heap.findMax();
		
		return e;
	}

	@Override
	public E getFront() {
		return heap.findMax();
	}

	@Override
	public E getRear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		heap.clear();
	}

}
