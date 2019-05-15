package dyarray;

public class ArrayStackDoubleEnd<E> implements MyStack<E>{
	private E[] data;
	private static final int DEFAULT_CAPACITY=10;
	public static final int L=0;
	public static final int R=1;
	private int right;
	private int left;
	private int size;
	
	public ArrayStackDoubleEnd() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayStackDoubleEnd(int capacity){
		data=(E[])new Object[capacity];
		left=-1;
		right=data.length;
		size=0;
	}
	public void push(int which,E e){
		if(size==data.length){
			//扩容
			resize();
		}
		if(which==L){
			data[++left]=e;
		}else{
			data[--right]=e;
		}
		size++;
	}
	
	private void resize() {
		// TODO Auto-generated method stub
		if(size==data.length){
			E[] newArr=(E[])new Object[getCapacity()*2];
			for (int i=0;i<=left;i++) {
				newArr[i]=data[i];
			}
			for(int i=data.length;i>=right;i--){
				newArr[i]=data[i];
			}
			data=newArr;
		}else if(size<=data.length/4&&data.length>DEFAULT_CAPACITY){
			E[] newArr=(E[])new Object[getCapacity()/2];
			for (int i=0;i<=left;i++) {
				newArr[i]=data[i];
			}
			for(int i=data.length;i>=right;i--){
				newArr[i]=data[i];
			}
			data=newArr;
		}
	}
	public int getCapacity(){
		return data.length;
	}
	public int getSize(int which){
		if(which==L){
			return left+1;
		}else{
			return data.length-right;
		}
	}
	public E peek(int which){
		if(isEmpty(which)){
			throw new IllegalArgumentException("栈以空");
		}
		if(which==L){
			return data[left];
		}else{
			return data[right];
		}
	}
	public E pop(int which){
		if(isEmpty(which)){
			throw new IllegalArgumentException("栈以空");
		}
		size--;
		if(which==L){
			return data[left--];
		}else{
			return data[right++];
		}
		
	}
	private boolean isEmpty(int which) {
		// TODO Auto-generated method stub
		if(which==L){
			return left==-1?true:false;
		}else{
			return (right==data.length)?true:false;
		}
	}
	public void clear(int which){
		if(which==L){
			size-=(left+1);
			left=-1;
		}else{
			size-=(data.length-right);
			right=data.length;
		}
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if(isEmpty()){
			sb.append(String.format("ArrayStackDoubleEnd:bottom[]top[]bottom %d/%d",size,data.length));
		}else{
			sb.append("ArrayStackDoubleEnd:bottom[");
			for(int i=0;i<=left;i++){
				if(i==left){
					sb.append(data[i]+"]top[");
				}else{
					sb.append(data[i]+",");
				}
			}
			
			for(int i=right;i<data.length;i++){
				if(i==data.length-1){
					sb.append(data[i]);
				}else{
					sb.append(data[i]+",");
				}
				
			}
			sb.append(String.format("]bottom %d/%d",size,data.length));
		}
		return sb.toString();
	}
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		if(getSize(0)>getSize(1)){
			push(1,e);
		}else{
			push(0,e);
		}
	}
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E temp=null;
		if(getSize(0)>getSize(1)){
			temp=pop(0);
		}else{
			temp=pop(1);
		}
		return temp;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return isEmpty(0)&&isEmpty(1)?true:false;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		E temp=null;
		if(getSize(0)>getSize(1)){
			temp=peek(0);
		}else{
			temp=peek(1);
		}
		return temp;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data=(E[])new Object[DEFAULT_CAPACITY];
	}

}
