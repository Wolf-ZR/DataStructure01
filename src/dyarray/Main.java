package dyarray;

public class Main {
	public static void main(String[] args) {
		MyArrayList<Integer> a=new MyArrayList<>();
		System.out.println(a);
		for(int i=1;i<15;i++){
			a.addLast(i);
		}
		System.out.println(a);
		a.remove(3);
		System.out.println(a);
		MyArrayStack<Integer> stack=new MyArrayStack<>();
		System.out.println(stack);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.peek());
		for(int i=0;i<16;i++){
			stack.push(6);
		}
		System.out.println(stack);
		System.out.println("-------------------------");
		ArrayStackDoubleEnd as=new ArrayStackDoubleEnd<>();
		System.out.println(as);
		as.push(ArrayStackDoubleEnd.L, 1);
		as.push(ArrayStackDoubleEnd.L, 2);
		as.push(ArrayStackDoubleEnd.L, 3);
		System.out.println(as);
		as.push(ArrayStackDoubleEnd.R, 9);
		as.push(ArrayStackDoubleEnd.R, 8);
		as.push(ArrayStackDoubleEnd.R, 7);
		System.out.println(as);
		System.out.println("---------------------------");
		ArrayQueueLoop lop=new ArrayQueueLoop<>();
		System.out.println(lop);
		lop.enqueue(1);
		lop.enqueue(2);
		lop.enqueue(3);
		lop.enqueue(4);
		System.out.println(lop);
		lop.dequeue();
		lop.dequeue();
		lop.dequeue();
		System.out.println(lop);
	}
}
