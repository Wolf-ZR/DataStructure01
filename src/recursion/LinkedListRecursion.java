package recursion;
/**
 * 递归实现链表
 * @author zhang
 *
 */
public class LinkedListRecursion {
	public static void main(String[] args) {
		LinkedListRecursion link=new LinkedListRecursion();
		link.add(1);
		link.add(2);
		link.add(3);
		System.out.println(link.toString());
		link.remove();
		link.remove();
		System.out.println(link.toString());
	}
	private Node head;
	private static class Node{
		int date;
		Node next;
	}
	public LinkedListRecursion(){
		head=new Node();
		head.date=0;
		head.next=null;
	}
	//删除链表最后一个元素
	public void remove(){
		remove(head);
	}
	private Node remove(Node head) {
		if(head.next==null){
			//最后一个节点返回为空
			return null;
		}else{
			//倒数第二个的吓一跳为空
			head.next=remove(head.next);
			return head;
		}
		
	}
	//递归尾插法
	public void add(int e){
		add(head,e);
	}
	private void add(Node head, int e) {
		if(head.next==null){
			Node n=new Node();
			n.date=e;
			n.next=head.next;
			head.next=n;
		}else{
			add(head.next,e);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		toString(head, sb);
		return sb.toString();
	}
	private void toString(Node head,StringBuilder sb){
		if(head.next==null){
			sb.append(head.date+"]");
		}else{
			sb.append(head.date+",");
			toString(head.next,sb);
		}
	}
}

