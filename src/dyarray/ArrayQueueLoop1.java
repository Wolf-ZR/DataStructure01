package dyarray;

public class ArrayQueueLoop1<E> implements MyQueue<E> {
	private E[] arr;
	private int front;
	private int rear;
	private int size;
	private static final int DEFAULT_CAPACITY=10;
	public ArrayQueueLoop1(){
		this(DEFAULT_CAPACITY);
	}
	public ArrayQueueLoop1(int capacity){
		arr=(E[])new Object[capacity+1];
		front=0;
		rear=0;
		size=0;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0?true:false;
	}
	private void resize(int capacity) {
		// TODO Auto-generated method stub
		E[] newArr=(E[])new Object[capacity];
		for(int i=0;i<Math.min(newArr.length,arr.length);i++){
			newArr[i]=arr[i];
		}
		arr=newArr;
	}
	@Override
	public void enqueue(E e) {
		if(size==arr.length-1){
			resize(2*arr.length);
		}
		if(rear==arr.length){
			arr[rear]=e;
			rear=(rear+1)%arr.length;
		}else{
			arr[rear]=e;
			rear++;
		}
		size++;
	}

	@Override
	public E dequeue() {
		E temp=null;
		if(front==arr.length){
			temp=arr[front];
			front=(front+1)%arr.length;
		}else{
			temp=arr[front];
			front++;
		}
		size--;
		return temp;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return arr[front];
	}

	@Override
	public E getRear() {
		// TODO Auto-generated method stub
		return arr[rear];
	}

	@Override
	public void clear() {
		arr=(E[])new Object[DEFAULT_CAPACITY];
		front=0;
		rear=0;
		size=0;
	}

}
