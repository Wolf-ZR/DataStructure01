package heap;
import dyarray.MyArrayList;
public class MaxHeap<E extends Comparable<E>> {
	private MyArrayList<E> data;

	public MaxHeap() {
		data=new MyArrayList<>();
	}
	public MaxHeap(int capacity){
		data=new MyArrayList<>(capacity);
	}
	//heapify 将任意的数组整理为堆
	public MaxHeap(E[] arr){
		data=new MyArrayList<>(arr);
		for(int i=parent(data.getSize()-1);i>=0;i--){
			shiftDown(i);
		}
	}
	public int size(){
		return data.getSize();
	}
	public boolean isEmpty(){
		return data.isEmpty();
	}
	public int parent(int index){
		if(index==0){
			throw new IllegalArgumentException();
		}
		return (index-1)/2;
	}
	//左孩子
	public int leftChild(int index){
		return index*2+1;
	}
	//右孩子
	public int rightChild(int index){
		return index*2+2;
	}
	//添加元素
	public void add(E e){
		data.addLast(e);
		shiftUp(data.getSize()-1);
	}
	//上浮
	private void shiftUp(int i) {
		while(i>0&&data.get(parent(i)).compareTo(data.get(i))<0){
			data.swap(i,parent(i));
			i=parent(i);
		}
	}
	//获得最大值
	public E findMax(){
		if(data.isEmpty()){
			throw new IllegalArgumentException();
		}
		return data.get(0);
	}
	//删除最大值
	public E extractMax(){
		E e=findMax();
		data.swap(data.getSize()-1, 0);
		data.removeLast();
		shiftDown(0);
		return e;
	}
	//下沉
	private void shiftDown(int i) {
		while(leftChild(i)<data.getSize()){
			int k=leftChild(i);
			if(k+1<data.getSize()&&data.get(k+1).compareTo(data.get(k))>0){
				k=rightChild(i);
			}
			if(data.get(i).compareTo(data.get(k))<0){
				data.swap(i, k);
				i=k;
			}else{
				break;
			}
		}
	}
	//替换最大值
	public E replace(E e){
		E r=findMax();
		data.set(0, e);
		shiftDown(0);
		return r;
	}
	public void clear(){
		data.clear();
	}
}
