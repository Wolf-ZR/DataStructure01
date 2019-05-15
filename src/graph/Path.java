package graph;

import java.util.Stack;
import java.util.Vector;

public class Path {
	private Graph g;
	private int s;//起点
	private int[] from;//前一结点
	private boolean[] visited;//是否已查看
	public Path(Graph g,int s) {
		from=new int[g.V()];
		visited=new boolean[g.V()];
		this.g=g;
		if(s<0||s>g.V()){
			throw new IllegalArgumentException(s+"不存在");
		}
		this.s=s;
		for(int i=0;i<g.V();i++){
			from[i]=-1;
			visited[i]=false;
		}
		dfs(s);
	}
	private void dfs(int v) {
		visited[v]=true;
		for (Integer i:g.adj(v)) {
			if(!visited[i]){
				from[i]=v;
				dfs(i);
			}
		}
	}
	//验证从v到w是否有路径
	public boolean hasPath(int w){
		if(w<0||w>g.V()){
			throw new IllegalArgumentException(s+"不存在");
		}
		return visited[w];
	}
	//返回从v-w的所经过节点的路径
	public Vector<Integer> path(int w){
		if(!hasPath(w)){
			throw new IllegalArgumentException("此路不通");
		}
		Stack<Integer> stack=new Stack<>();
		Vector<Integer> vect=new Vector<>();
		int p=w;
		while(p!=-1){
			stack.push(p);
			p=from[p];
		}
		while(!stack.isEmpty()) {
			vect.add(stack.pop());
		}
		return vect;
	}
	public void showPath(int w){
		for(Integer i:path(w)){
			System.out.print(i+"->");
		}
	}
}
