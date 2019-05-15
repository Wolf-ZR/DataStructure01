package tree;
//集合与映射
public interface Set<E> {
	public void add(E e);
	public void remove(E e);
	public boolean contains(E e);
	public int getSize();
	public boolean isEmpty();
}
