package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import javax.management.Query;


public class ShortestPath {
	private Graph g;//图
	private boolean[] visited;//是否已经过
	private int[] from;//上一结点
	private int[] level;//层数
	private int s;//开始
	public ShortestPath(Graph g,int s) {
		this.g=g;
		if(s<0||s>g.V()){
			throw new IllegalArgumentException(s+"不存在");
		}
		visited=new boolean[g.V()];
		from=new int[g.V()];
		level=new int[g.V()];
		for(int i=0;i<g.V();i++){
			from[i]=-1;
			level[i]=-1;
			visited[i]=false;
		}
		level[s]=0;
		Queue<Integer> queue=new LinkedList();
		queue.add(s);
		visited[s]=true;
		while(!queue.isEmpty()) {
			int v=queue.remove();
			for(Integer i:g.adj(v)){
				if(!visited[i]){
					from[i]=v;
					level[i]=level[v]+1;
					visited[i]=true;
					queue.add(i);
				}
				
			}
			
		}
	}
	public boolean hasPath(int w){
		if(w<0||w>g.V()){
			throw new IllegalArgumentException(w+"不存在");
		}
		return visited[w]&&level[w]!=-1;
	}
	public Vector<Integer> path(int w){
		if(w<0||w>g.V()){
			throw new IllegalArgumentException(w+"不存在");
		}
		Stack<Integer> stack=new Stack<>();
		Vector<Integer> vector=new Vector<Integer>();
		int q=w;
		while(q!=-1){
			stack.add(q);
			q=from[q];
		}
		while(!stack.isEmpty()){
			vector.add(stack.pop());
		}
		return vector;
	}
	public String showPath(int w){
		StringBuilder sb=new StringBuilder();
		Vector<Integer> vector=path(w);
		for(Integer i:vector){
			sb.append(i+"->");
		}
		return sb.toString();
	}

}
