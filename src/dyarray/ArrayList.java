package dyarray;

public class ArrayList<E> implements MyList<E>{
	private E[] arr;
	private int size;
	private static final int DEFAULT_CAPACITY=10;
	public ArrayList(){
		this(DEFAULT_CAPACITY);
	}
	public ArrayList(int capacity){
		arr=(E[])new Object[capacity];
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

	@Override
	public void add(int index,E e) {
		if(index<0||index>size){
			throw new IllegalArgumentException("角标异常");
		}
		if(size==arr.length){
			resize(2*arr.length);
		}
		for(int i=size;i>index;i--){
			arr[i]=arr[i-1];
		}
		arr[index]=e;
		size++;
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
	public void addFirst(E e) {
		add(0,e);
	}

	@Override
	public void addLast(E e) {
		add(size,e);
	}

	@Override
	public E get(int index) {
		
		return arr[index];
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return arr[0];
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return arr[size-1];
	}

	@Override
	public E remove(int index) {
		if(index<0||index>size){
			throw new IllegalArgumentException("角标异常");
		}
		E e=arr[index];
		for(int i=index;i<size-1;i++){
			arr[i]=arr[i+1];
		}
		size--;
		return e;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return remove(0);
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return remove(size-1);
	}

	@Override
	public void set(int index, E e) {
		arr[index]=e;
	}

	@Override
	public boolean contains(E e) {
		
		return find(e)!=-1?true:false;
	}

	@Override
	public int find(E e) {
		for(int i=0;i<size;i++){
			if(arr[i].equals(e)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public void removeElement(E e) {
		remove(find(e));
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		arr=(E[])new Object[DEFAULT_CAPACITY];
		size=0;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return arr.length;
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if(isEmpty()){
			sb.append(String.format("ArrayList:[] %d/%d \n",size,arr.length));
		}else{
			sb.append(String.format("ArrayList:["));
			for(int i=0;i<size;i++){
				if(i==size-1){
					sb.append(arr[i]);
				}else{
					sb.append(arr[i]+",");
				}
			}
			sb.append(String.format("] %d/%d \n", size,arr.length));
		}
		return sb.toString();
		
	}
}
