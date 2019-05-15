package dyarray;

public interface MyQueue<E> {
	public int getSize();//获取队列中元素的个数
	public boolean isEmpty();
	public void enqueue(E e);//入队
	public E dequeue();//出队
	public E getFront();//获得队头元素
	public E getRear();//获得队尾元素
	public void clear();//清空队列
}
