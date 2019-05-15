package dyarray;

public class ArrayQueueLoop<E> implements MyQueue<E>{
	private E[] data=null;
	private static final int DEFAULT_CAPACITY=10;
	private int front;
	private int rear;
	private int size;
	public ArrayQueueLoop() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayQueueLoop(int capacity){
		data=(E[])new Object[capacity+1];
		rear=0;
		front=0;
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
		return rear==front?true:false;
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if(size==data.length-1){
			resize();
		}
		if(rear==data.length-1){
			data[rear]=e;
			size++;
			rear=(rear+1)%data.length;
		}else{
			size++;
			data[rear++]=e;
		}
		
		
	}
	public int getCapacity(){
		return data.length;
		
	}
	public void resize(){
			E[] newArr=(E[])new Object[getCapacity()*2];
			int index=0;
			for(int i=front;i!=rear;i=(i+1)%data.length){
				newArr[index++]=data[i];
			}
			data=newArr;
	}
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		E temp=null;
		if(front==data.length-1){
			temp=data[front];
			size--;
			front=(front+1)%data.length;
		}else{
			size--;
			temp=data[front++];
		}
		return temp;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return data[front];
	}

	@Override
	public E getRear() {
		// TODO Auto-generated method stub
		return data[rear-1];
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data=(E[])new Object[DEFAULT_CAPACITY];
		size=0;
		rear=0;
		front=0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		if(isEmpty()){
			sb.append(String.format("ArrayQueueLoop:[] %d/%d",size,data.length));
		}else{
			sb.append("ArrayQueueLoop:[");
			for(int i=front;i!=rear;i=(i+1)%data.length){
				if((i+1)%data.length==rear){
					sb.append(data[i]+"]");
				}else{
					sb.append(data[i]+",");
				}
			}
			sb.append(String.format(" %d/%d",size,data.length));
		}
		
		return sb.toString();
	}

}
