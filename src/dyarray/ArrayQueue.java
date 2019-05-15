package dyarray;

public class ArrayQueue<E> implements MyQueue<E>{
	private MyList<E> list;
	public ArrayQueue() {
		this(10);
	}
	public ArrayQueue(int capacity) {
		list=new MyArrayList<>(capacity);
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
		list=new MyArrayList<>();
	}

}
