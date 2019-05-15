package dyarray;

public class MyArrayList<E> implements MyList<E>{
	private E[] arr;
	private int size;//当前列表中的个数
	private static final int DEFAULT_CAPACITY=10;
	public MyArrayList(){
		this(DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity){
		if(capacity<0){
			System.out.println("传参错误，默认10");
			capacity=DEFAULT_CAPACITY;
		}
		arr=(E[])new Object[capacity];
		this.size=0;
	}
	public MyArrayList(E[] arr){
		this.arr=(E[])new Object[arr.length];
		for(int i=0;i<this.arr.length;i++){
			this.arr[i]=arr[i];
		}
		size=this.arr.length;
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
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		if(index<0||index>size){
			throw new IllegalArgumentException("角标非法！");
		}
		if(size==arr.length){
			//扩容
			resize();//重置容量
		}
		for(int i=size-1;i>=index;i--){
			arr[i+1]=arr[i];
		}
		arr[index]=e;
		size++;
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		add(0,e);
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		add(size,e);
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=arr.length){
			throw new IllegalArgumentException("角标越界");
		}
		return arr[index];
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return get(0);
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return get(size-1);
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=size){
			throw new IllegalArgumentException("角标非法！");
		}
		E temp=arr[index];
		for(int i=index;i<size-1;i++){
			arr[i]=arr[i+1];
		}
		size--;
		resize();
		return temp;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		E temp=arr[0];
		remove(0);
		return temp;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		E t=arr[size-1];
		remove(size-1);
		return t;
	}

	@Override
	public void set(int index, E e) {
		// TODO Auto-generated method stub
		if(index<0||index>=arr.length){
			throw new IllegalArgumentException("角标越界");
		}
		arr[index]=e;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		
		return (find(e)==-1)?false:true;
	}

	@Override
	public int find(E e) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			if(arr[i]==e){
				return i;
			}
		}
		return -1;
	}

	@Override
	public void removeElement(E e) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			if(arr[i]==e){
				remove(i);
			}
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		arr=(E[])new Object[DEFAULT_CAPACITY];
		size=0;
	}
	
	private void resize() {
		// TODO Auto-generated method stub
		
		if(size==arr.length){
			E[] newArr=(E[])new Object[getCapacity()*2];
			for (int i=0;i<size;i++) {
				newArr[i]=arr[i];
			}
			arr=newArr;
		}else if(size<=arr.length/4&&arr.length>DEFAULT_CAPACITY){
			E[] newArr=(E[])new Object[getCapacity()/2];
			for(int i=0;i<newArr.length;i++){
				newArr[i]=arr[i];
			}
			arr=newArr;
		}
	}
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return arr.length;
	}
	public void swap(int i,int j){
		if(i<0||i>=size||j<0||j>=size){
			throw new IllegalArgumentException();
		}
		E temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	@Override
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
