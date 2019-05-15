package hash;
import java.util.TreeMap;

public class HashTable<K,V> {
	private TreeMap<K,V>[] table;
	private int size;//元素个数
	private int C;//hash表当前当前大小
	private static int capacityIndex=0;//初始大小53
	private static final int upperTol=10;//平均冲突不能超过10个
	private static final int lowerTol=2;//平均冲突不能小于2个
	private static final int[] capacity={//hash表大小
		53,97,193,389,769,1543,3079,6151,12289,24593,
		49157,98317,196613,393241,768433,1572869,3145739,6291469,
		12582917,25165843,50331653,100663319,201326611,402653189,805306457,1610612741
		};

	public HashTable(){
		C=capacity[capacityIndex];
		table=new TreeMap[C];
		size=0;
		for(int i=0;i<table.length;i++){
			table[i]=new TreeMap<>();
		}
	}
	//计算元素的hash值
	private int hash(K key){
		return key.hashCode()&0x7FFFFFFF%C;//&0x7FFFFFFF是取绝对值
	}
	public int getSize(){
		return size;
	}
	//添加元素
	public void add(K k,V v){
		TreeMap<K,V> map=table[hash(k)];
		if(map.containsKey(k)){
			map.put(k, v);
		}else{
			map.put(k, v);
			size++;
			if(size>upperTol*C&&capacityIndex<capacity.length){
				resize(capacity[capacityIndex++]);
			}
		}
	}
	//重新创建一个hash表
	private void resize(int c) {
		TreeMap<K,V>[] newTable=new TreeMap[c];
		for(int i=0;i<c;i++){
			newTable[i]=new TreeMap<>();
		}
		for(int i=0;i<table.length;i++){
			TreeMap<K,V> tree=table[i];
			for(K k:tree.keySet()){
				newTable[hash(k)].put(k,tree.get(k));//将每个元素重新计算hash值重新添加
			}
		}
		table=newTable;
		C=c;
	}
	//删除元素
	public V remove(K k){
		TreeMap<K,V> map=table[hash(k)];
		V re=map.get(k);
		if(map.containsKey(k)){
			map.remove(k);
			size--;
			if(size<lowerTol*C&&capacityIndex>0){
				resize(capacity[capacityIndex]);
			}
		}
		return re;
	}
	//修改元素
	public void set(K k,V v){
		TreeMap<K,V> map=table[hash(k)];
		if(!map.containsKey(k)){
			throw new IllegalArgumentException("key不存在");
		}
		map.put(k, v);
	}
	public boolean contains(K k){
		TreeMap<K,V> map=table[hash(k)];
		return map.containsKey(k);
	}
	public V get(K k){
		TreeMap<K,V> map=table[hash(k)];
		return map.get(k);
	}
}
