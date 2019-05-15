package dylist;

import dyarray.MyList;

public class LinkedList<E> implements MyList<E> {
	private Node head;
	private Node rear;
	private int size;
	public LinkedList(){
		head=new Node();
		rear=head;
		size=0;
	}
	private class Node{
		E data;
		Node next;
		public Node(){
			this(null,null);
		}
		public Node(E e){
			this(null,e);
		}
		public Node(Node next,E e){
			this.next=next;
			this.data=e;
		}
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
		Node n=new Node(e);
		if(index==0){
			n.next=head.next;
			head.next=n;
			if(isEmpty()){
				rear=n;
			}
		}else if(index==size){
			n.next=rear.next;
			rear.next=n;
			rear=n;
		}else{
			Node p=head;
			for(int i=0;i<index;i++){
				p=p.next;
			}
			n.next=p.next;
			p.next=n;
		}
		size++;
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
		Node p=head;
		for(int i=0;i<=index;i++){
			p=p.next;
		}
		return p.data;
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
		if(index<0||index>=size){
			throw new IllegalArgumentException("角标异常");
		}
		E e;
		if(index==0){
			e=head.next.data;
			head.next=head.next.next;
			
		}else if(index==size-1){
			Node p=head;
			for(int i=0;i<index;i++){
				p=p.next;
			}
			e=rear.data;
			p.next=rear.next;
			rear=p;
		}else{
			Node p=head;
			for(int i=0;i<index;i++){
				p=p.next;
			}
			e=p.next.data;
			p.next=p.next.next;
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
		if(index<0||index>=size){
			throw new IllegalArgumentException("角标异常");
		}
		Node p=head;
		for(int i=0;i<index;i++){
			p=p.next;
		}
		p.next.data=e;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return find(e)!=-1?true:false;
	}

	@Override
	public int find(E e) {
		// TODO Auto-generated method stub
		Node p=head;
		int index=0;
		for(int i=0;i<size;i++){
			p=p.next;
			if(p.data.equals(e)){
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
		head=new Node();
		head=rear;
		size=0;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		Node p=head;
		StringBuilder sb=new StringBuilder();
		if(isEmpty()){
			sb.append("[]");
		}else{
			sb.append("[");
			while(p.next!=rear){
				p=p.next;
				sb.append(p.data+",");
			}
			sb.append(p.next.data+"]");
		}
		
		return sb.toString();
	}
}
