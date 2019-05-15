package dyarray;
public interface MyList<E> {
	public int getSize();//获取元素个数
	public boolean isEmpty();//判断是否为空
	public void add(int index,E e);//在指定index处添加元素e
	public void addFirst(E e);//在列表第一个位置添加元素
	public void addLast(E e);//在列表中最后一个位置添加元素
	public E get(int index);//获取index处的元素
	public E getFirst();//获取列表中第一个元素
	public E getLast();//获取列表中最后一个元素
	public E remove(int index);//删除指定位置的值
	public E removeFirst();//删除第一个元素
	public E removeLast();//删除最后一个元素
	public void set(int index,E e);//修改列表中指定角标元素为e
	public boolean contains(E e);//判断是否包含e
	public int find(E e);//在列表中查找e的角标
	public void removeElement(E e);//在列表中删除指定元素e
	public void clear();//清空列表
	public int getCapacity();//获取最大容量
	public String toString();
}
