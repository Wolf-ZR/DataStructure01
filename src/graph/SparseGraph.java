package graph;

import java.util.Vector;

public class SparseGraph implements Graph{
	private int n;//结点数
	private int m;//边数
	private Vector<Integer>[] table;//邻接表
	private boolean directed;//是否双向
	public SparseGraph(int n,boolean directed) {
		this.n=n;
		m=0;
		table=(Vector<Integer>[]) new Vector[n];
		for(int i=0;i<n;i++){
			table[i]=new Vector<>();
		}
		this.directed=directed;
	}
	@Override
	public int V() {
		return n;
	}
	@Override
	public int E() {
		return m;
	}
	//添加边
	@Override
	public void addEdge(int v, int w) {
		if(v<0||v>=n){
			throw new IllegalArgumentException(v+"结点不存在");
		}
		if(w<0||w>=n){
			throw new IllegalArgumentException(w+"结点不存在");
		}
		if(table[v].contains(w)){
			return;
		}
		table[v].add(w);
		if(directed){
			table[w].add(v);
		}
		m++;
	}
	@Override
	public boolean hasEdge(int v, int w) {
		if(v<0||v>=n){
			throw new IllegalArgumentException(v+"结点不存在");
		}
		if(w<0||w>=n){
			throw new IllegalArgumentException(w+"结点不存在");
		}
		return table[v].contains(w);
	}
	//打印邻接表
	@Override
	public void show() {
		for(int i=0;i<table.length;i++){
			System.out.print(i+": ");
			for (Integer integer : table[i]) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
	@Override
	public Iterable<Integer> adj(int v) {
		if(v<0||v>=n){
			throw new IllegalArgumentException(v+"结点不存在");
		}
		return table[v];
	}
}
