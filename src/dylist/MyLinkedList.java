package dylist;

import dyarray.MyList;
/**
 * 动态链表实现线性表-单向链表
 * @author zhang
 *
 * @param <E>
 */
public class MyLinkedList<E> implements MyList<E>{
	private Node head;//头指针
	private Node rear;//尾指针
	private int size;//元素个数
	public MyLinkedList(){
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
		public Node(E data){
			this(data,null);
		}
		public Node(E data,Node next){
			this.data=data;
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
		if(index<0||index>size){
			throw new IllegalArgumentException("角标异常");
		}
		Node p=head;
		Node n=new Node(e);
		if(index==0){
			if(head.next==null){
				rear=n;
			}
			n.next=head.next;
			head.next=n;
		}else if(size==index){
			n.next=rear.next;
			rear.next=n;
			rear=n;
		}else{
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
		if(index<0||index>=size){
			throw new IllegalArgumentException("角标异常");
		}
		if(index==0){
			return head.next.data;
		}else if(index==size-1){
			return rear.data;
		}else{
			Node p=head;
			for(int i=0;i<=index;i++){
				p=p.next;
			}
			return p.data;
		}
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
		E res;
		if(index==0){
			Node n=head.next;
			res=n.data;
			head.next=n.next;
			n=null;
			if(size==1){
				rear=head;
			}
		}else if(index==size-1){
			Node p=head;
			while(p.next!=rear){
				p=p.next;
			}
			res=rear.data;
			p.next=rear.next;
			rear=p;
			
		}else{
			Node p=head;
			for(int i=0;i<index;i++){
				p=p.next;
			}
			Node n=p.next;
			res=n.data;
			p.next=n.next;
			n=null;
		}
		size--;
		return res;
	}
	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return remove(0);
	}
	@Override
	public E removeLast() {
		return remove(size-1);
	}
	@Override
	public void set(int index, E e) {
		if(index<0||index>=size){
			throw new IllegalArgumentException("角标异常");
		}
		Node p=head;
		for(int i=0;i<=index;i++){
			p=p.next;
		}
		p.data=e;
	}
	@Override
	public boolean contains(E e) {
		return find(e)!=-1;
	}
	@Override
	public int find(E e) {
		if(isEmpty()){
			return -1;
		}
		int index=-1;
		Node p=head;
		while(p.next!=null){
			index++;
			p=p.next;
			if(p.data.equals(e)){
				return index;
			}
		}
		return -1;
	}
	@Override
	public void removeElement(E e) {
		int index=find(e);
		if(index!=-1){
			remove(index);
		}
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.next=null;
		rear=head;
		size=0;
	}
	@Override
	public int getCapacity() {
		return -1;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		if(isEmpty()){
			sb.append("[]");
		}else{
			sb.append("[");
			Node p=head;
			while(true){
				p=p.next;
				if(p==rear){
					sb.append(p.data+"]");
					break;
				}else{
					sb.append(p.data+",");
				}
			}
		}
		return sb.toString();
	}
}
