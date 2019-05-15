package dyarray;

public interface MyStack<E> {
	public void push(E e);//进栈
	public E pop();//出栈
	public boolean isEmpty();//判断栈是否为空
	public E peek();//获取当前栈顶元素，不去除
	public int getSize();//栈内元素的数量
	public void clear();//清空栈
}
