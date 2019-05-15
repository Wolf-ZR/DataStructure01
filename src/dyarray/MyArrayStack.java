package dyarray;

public class MyArrayStack<E> implements MyStack<E>{
	private MyArrayList<E> list;
	public MyArrayStack(){
		this(10);
	}
	public MyArrayStack(int capacity){
		list=new MyArrayList<>(capacity);
	}
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeLast();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.getLast();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list=new MyArrayList<>();
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		if(isEmpty()){
			sb.append(String.format("ArrayStack:bottom[]top %d/%d",getSize(),getCapacity()));
		}else{
			sb.append("ArrayStack:bottom[");
			for(int i=0;i<list.getSize();i++){
				if(i==list.getSize()-1){
					sb.append(list.get(i)+"]");
				}else{
					sb.append(list.get(i)+",");
				}
			}
			sb.append(String.format("top %d/%d \n",getSize(),getCapacity()));
		}
		return sb.toString();
	}
	private int getCapacity() {
		// TODO Auto-generated method stub
		return list.getCapacity();
	}

}
