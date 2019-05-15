package dylist;

import dyarray.MyList;

public class LinkedListSinglyCircular<E> implements MyList<E>{
	private Node head;
	private Node rear;
	private int size;
	public LinkedListSinglyCircular() {
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
			this.data=e;
			this.next=next;
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
		return rear==head?true:false;
	}
	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		if(index<0||index>size){
			throw new IllegalArgumentException();
		}
		Node n=new Node(e);
		if(index==0){
			n.next=head.next;
			head.next=n;
			if(isEmpty()){
				rear=n;
				rear.next=rear;
			}else{
				rear.next=head.next;
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
	}
	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		add(0,e);
	}
	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		add(size-1,e);
	}
	@Override
	public E get(int index) {
		int aim=0;
		if(index<0){
			aim=size+index%size;
		}else{
			aim=index%size;
		}
		Node p=head;
		for(int i=0;i<=aim;i++){
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
			Node p=head.next;
			e=p.data;
			head.next=p.next;
			rear.next=head.next;
			p=null;
		}else if(index==size-1){
			Node p=head;
			e=rear.data;
			while(p.next!=rear){
				p=p.next;
			}
			p.next=rear.next;
			rear=p;
		}else{
			Node p=head;
			for(int i=0;i<index;i++){
				p=p.next;
			}
			Node n=p.next;
			e=n.data;
			p.next=n.next;
			n=null;
		}
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
		Node p=head;
		for(int i=0;i<=index;i++){
			p=p.next;
		}
		p.data=e;
	}
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return find(e)==-1?false:true;
	}
	@Override
	public int find(E e) {
		Node p=head;
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
		size=0;
		rear=head;
	}
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
}
