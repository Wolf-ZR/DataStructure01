package reflect;
import tree.LinkedSet;
import tree.Set;
import dyarray.MyList;
import dylist.LinkedList;

public class LinkedMap<K,V> implements Map<K, V> {
	private class Node{
		public K k;
		public V v;
		public Node next;
		public Node(K k,V v){
			this.k=k;
			this.v=v;
			next=null;
		}
		public Node(){
			this(null,null);
		}
		@Override
		public String toString() {
			
			return k+":"+v;
		}
	}
	private Node head;
	private int size;
	public LinkedMap() {
		head=new Node();
		size=0;
	}
	//辅助函数
	private Node getNode(K k){
		/*迭代
		 * Node p=head.next;
		while(p!=null){
			if(p.k.equals(k)){
				return p;
			}
			p=p.next;
		}
		return p;*/
		return getNode(head.next,k);
	}
	private Node getNode(Node node, K k) {
		if(node==null){
			return null;
		}
		if(node.k.equals(k)){
			return node;
		}else{
			return getNode(node.next,k);
		}
	}
	@Override
	public void add(K k, V v) {
		Node n=getNode(k);
		if(n==null){
			n=new Node(k,v);
			n.next=head.next;
			head.next=n;
			size++;
		}else{
			n.v=v;
		}
	}

	@Override
	public V remove(K k) {
		Node p=head;
		V re=null;
		while(p.next!=null){
			if(p.next.k.equals(k)){
				
				break;
			}
			p=p.next;
		}
		if(p.next!=null){
			Node n=p.next;
			re=n.v;
			p.next=p.next.next;
			n=null;
			size--;
		}
		return re;
	}

	@Override
	public boolean contains(K k) {
		return getNode(k)!=null;
	}

	@Override
	public V get(K k) {
		Node n=getNode(k);
		return n==null?null:n.v;
	}

	@Override
	public void set(K k, V v) {
		Node n=getNode(k);
		if(n==null){
			throw new IllegalArgumentException();
		}
		n.v=v;
	}

	@Override
	public Set keys() {
		Set<K> set=new LinkedSet<>();
		Node cur=head.next;
		while(cur!=null){
			set.add(cur.k);
		}
		return set;
	}

	@Override
	public MyList<V> values() {
		MyList<V> list=new LinkedList<>();
		Node cur=head.next;
		while(cur!=null){
			list.addLast(cur.v);
		}
		return list;
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
	public String toString() {
		StringBuilder sb=new StringBuilder();
		Node n=head.next;
		while(n!=null){
			sb.append(n.k+":"+n.v+"\n");
			n=n.next;
		}
		return sb.toString();
	}
}
