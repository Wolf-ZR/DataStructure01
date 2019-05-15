package graph;

import java.util.Vector;

public class DenseGraph implements Graph{
	private int n;//结点数
	private int m;//边数
	private boolean directed;//是否双向
	private boolean[][] status;//邻接矩阵
	public DenseGraph(int n,boolean directed){
		//表示双向
		directed=true;
		
		status=new boolean[n][n];
		this.n=n;
		m=0;
	}
	@Override
	public int V() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public int E() {
		// TODO Auto-generated method stub
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
		//如果该边已经存在
		if(hasEdge(v, w)){
			return;
		}
		status[v][w]=true;
		//如果是双向
		if(directed){
			status[w][v]=true;
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
		return status[v][w];
	}
	//将邻接矩阵打印出来
	@Override
	public void show() {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print((status[i][j]?1:0)+" ");
			}
			System.out.println();
		}
	}
	//返回一个结点的所有边
	@Override
	public Iterable<Integer> adj(int v) {
		if(v<0||v>=n){
			throw new IllegalArgumentException("越界");
		}
		Vector<Integer> vector=new Vector<>();
		for(int i=0;i<n;i++){
			if(status[v][i]){
				vector.add(i);
			}
		}
		return vector;
	}
	
}
