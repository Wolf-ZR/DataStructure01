package reflect;

import dyarray.MyList;
import tree.Set;

public interface Map<K,V> {
	//添加
	public void add(K k,V v);
	//删除
	public V remove(K k);
	//是否包含
	public boolean contains(K k);
	//获得
	public V get(K k);
	//修改
	public void set(K k,V v);
	//返回键的集合
	public Set keys();
	//返回值的线性表
	public MyList<V> values();
	public int getSize();
	public boolean isEmpty();
}
