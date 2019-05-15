package dylist;

import dyarray.ArrayList;

/**
 * ArrayList
 * LinkedList
 * 
 * @author zhang
 *
 */
public class Main {
	public static void main(String[] args) {
		MyLinkedList<Integer> link=new MyLinkedList<>();
		link.addFirst(1);
		link.addFirst(2);
		link.addFirst(3);
		link.addFirst(4);
		link.addFirst(5);
		System.out.println(link);
		for(int i=0;i<5;i++){
			link.remove(0);
		}
		System.out.println(link);
		link.addLast(1);
		link.addLast(2);
		link.addLast(3);
		link.addLast(4);
		System.out.println(link);
		link.remove(2);
		System.out.println(link);
		System.out.println("-----------------------");
		ArrayList<Integer> arr=new ArrayList<>();
		arr.addFirst(1);
		arr.addFirst(2);
		arr.addFirst(3);
		arr.addFirst(4);
		arr.addFirst(1);
		arr.addFirst(2);
		arr.addFirst(3);
		arr.addFirst(4);
		arr.addFirst(1);
		arr.addFirst(2);
		arr.addFirst(3);
		arr.addFirst(4);
		System.out.println(arr);
		System.out.println("----------------");
		LinkedList<Integer> linklist=new LinkedList<>();
		System.out.println(linklist);
		linklist.addFirst(1);
		linklist.addFirst(2);
		linklist.addFirst(3);
		System.out.println(linklist);
		linklist.removeFirst();
		System.out.println(linklist);
		linklist.removeLast();
		System.out.println(linklist);
		
	}
}
